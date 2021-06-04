package MKStudio.GestionEspacios.controller;

import MKStudio.GestionEspacios.model.dto.EspacioDTO;
import MKStudio.GestionEspacios.repository.ListaEspacio;
import MKStudio.GestionEspacios.ui.VentanaEspacioVista;
import MKStudio.GestionUsuarios.model.Conversor;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.Shared.DataBase.MKStudioJDBC;
import MKStudio.Shared.util.ActionDialogs;
import MKStudio.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Controlador de la vista de los espacios.
 */
public class EspaciosController {

    /**
     * Columna de la tabla de espacios que visualizará el listado de espacios.
     */
    @FXML
    TableColumn<EspacioDTO, String> colEspacio;
    private Stage dialogStage;
    private VentanaHomeVista ventanaHome;
    private VentanaEspacioVista vista;
    private ListaEspacio listaEspacio;
    private EspacioDTO currentEspacio;
    Conversor conver;
    private UsuarioDTO currentUsuario;
    private MKStudioJDBC mkstudiojdbc = new MKStudioJDBC();

    /**
     * Tabla que muestra todos los espacios de la plataforma
     */
    @FXML
    private TableView<EspacioDTO> espacios;
    /**
     * Campos para visualizar el nombre
     */
    @FXML
    private TextField campoNombreEspacio;
    /**
     * Campo con la descripción
     */
    @FXML
    private TextArea campoDescripcionEspacio;

    /**
     * Botones para editar o eliminar el espacio seleccionado. Otro para volver a la
     * vista anterior.
     */
    @FXML
    private Button botonAddEspacio, botonEditarEspacio, botonEliminarEspacio, botonVolver;


    public EspaciosController() throws IOException {

    }

    /**
     * @param vista
     * @param dialog
     */
    public void setVista(VentanaEspacioVista vista, Stage dialog, UsuarioDTO currentUsuario) {
        this.dialogStage = dialog;
        this.vista = vista;
        this.currentUsuario = currentUsuario;
    }

    public void setVentanahome(VentanaHomeVista ventanaHome) {
        ventanaHome = new VentanaHomeVista(dialogStage, conver.dtoToVo(currentUsuario));
        this.ventanaHome = ventanaHome;
    }

    public void setListaEspacios() {
        listaEspacio = new ListaEspacio(mkstudiojdbc);
    }

    /**
     * Inicializa los espacios
     */
    public void iniciarEspacios() {
        setListaEspacios();
        listaEspacio.recuperarEspacios();
        espacios.setItems(listaEspacio.getEspacios());
        colEspacio.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        espacios.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEspacioDetails(newValue));
    }

    /**
     * Muestra los detalles de el espacio seleccionado
     *
     * @param espacio
     */
    public void showEspacioDetails(EspacioDTO espacio) {
        if (espacio != null) {
            campoNombreEspacio.setText(espacio.getNombre());
            campoDescripcionEspacio.setText(espacio.getDescripcion());
            currentEspacio = espacio;
        } else {
            campoNombreEspacio.setText("");
            campoDescripcionEspacio.setText("");
        }
    }

    /**
     * Metodo para añadir un espacio
     */
    @FXML
    public void addEspacio() {
        if (isInputValid()) {
            String nombre = campoNombreEspacio.getText();
            String Descripcion = campoDescripcionEspacio.getText();
            EspacioDTO espacio = new EspacioDTO(nombre, Descripcion);
            listaEspacio.añadirEspacios(espacio);
            listaEspacio.getEspacios();
            iniciarEspacios();
            ActionDialogs.info("Espacio añadido correctamente.", "Espacio añadido.\n" +
                    espacio.toString());
        }
    }

    /**
     * Metodo para eliminar un espacio
     */
    @FXML
    public void eliminarEspacio() {
        boolean correct = false;
        for (EspacioDTO espacio : listaEspacio.getEspacios()) {
            if (espacio.equals(currentEspacio)) {
                listaEspacio.eliminarEspacio(espacio);
                listaEspacio.getEspacios();
                iniciarEspacios();
                currentEspacio = null;
                campoNombreEspacio.setText("");
                campoDescripcionEspacio.setText("");
                correct = true;
                ActionDialogs.info("Eliminado", "El espacio ha sido eliminado correctamente.");
                break;
            }
        }
        if (!correct) {
            ActionDialogs.error("Error", "Selecciona un espacio para poder eliminarlo");
        }
    }

    /**
     * Metodo para editar un espacio
     */
    @FXML
    public void editarEspacio() {
        String nombre = campoNombreEspacio.getText();
        String Descripcion = campoDescripcionEspacio.getText();
        if (currentEspacio == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No has seleccionado ningun espacio a editar.");
            alert.setContentText("Vuelva a intentarlo de nuevo.");
            alert.showAndWait();
        } else {
            for (EspacioDTO espacio : listaEspacio.getEspacios()) {
                if (espacio.equals(currentEspacio)) {
                    espacio.setId(currentEspacio.getId());
                    espacio.setNombre(nombre);
                    espacio.setDescripcion(Descripcion);
                    listaEspacio.editarEspacio(espacio);
                    listaEspacio.getEspacios();
                    iniciarEspacios();
                    ActionDialogs.info("Editado", "El espacio ha sido editado correctamente.");
                    break;
                }
            }
        }
    }

    /**
     * Metodo para controlar que los datos se han introducido correctamente.
     */
    public boolean isInputValid() {
        String errorMsg = "";
        if (campoNombreEspacio == null || campoNombreEspacio.getText().isEmpty()) {
            errorMsg += "Introduce un nombre de espacio válido.\n ";
        }
        if (campoDescripcionEspacio == null || campoDescripcionEspacio.getText().isEmpty()) {
            errorMsg += "Introduce una descripción válida.";
        }
        if (errorMsg.isEmpty()) {
            return true;
        } else {
            ActionDialogs.error("Error en los campos", errorMsg);
            return false;
        }
    }

    /**
     * Metodo para voler a la vista anterior.
     */
    @FXML
    public void volver() throws IOException {
        setVentanahome(ventanaHome);
        ventanaHome.LaunchHomeView();
        dialogStage.close();
    }
}
