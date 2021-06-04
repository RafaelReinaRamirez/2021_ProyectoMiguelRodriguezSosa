package MKStudio.GestionReservas.controller;

import MKStudio.GestionEspacios.model.dto.EspacioDTO;
import MKStudio.GestionEspacios.repository.ListaEspacio;
import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.GestionMateriales.repository.ListaMaterial;
import MKStudio.GestionReservas.model.dto.ReservaDTO;
import MKStudio.GestionReservas.repository.ListaReserva;
import MKStudio.GestionReservas.ui.VentanaReservaVista;
import MKStudio.GestionUsuarios.model.Conversor;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.repository.ListaUsuario;
import MKStudio.Shared.DataBase.MKStudioJDBC;
import MKStudio.Shared.util.ActionDialogs;
import MKStudio.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;


/**
 * Controlador de la vista de los reservas que crea el administrador.
 */
public class ReservasController {

    /**
     * Columna de la tabla de reservas que visualizará el listado de reservas.
     */
    @FXML
    TableColumn<ReservaDTO, String> colReserva;
    private Stage dialogStage;
    private VentanaHomeVista ventanaHome;
    private VentanaReservaVista vista;
    private ListaUsuario listaUsuario;
    private ListaReserva listaReserva;
    private ListaMaterial listaMaterial;
    private ListaEspacio listaEspacio;
    private UsuarioDTO currentUsuario;
    private ReservaDTO currentReserva;
    private MKStudioJDBC mkstudiojdbc = new MKStudioJDBC();
    Conversor conver;

    /**
     * Tabla que muestra todos los reservas de la plataforma
     */
    @FXML
    private TableView<ReservaDTO> reservas;
    /**
     * Campos para visualizar el nombre
     */
    @FXML
    private TextField campoNombreReserva;

    /**
     * Campo con la fecha
     */
    @FXML
    private DatePicker campoFechaReserva;

    /**
     * Campo con la descripción
     */
    @FXML
    private TextArea campoDescripcionReserva;

    /**
     * Campo con el espacio
     */
    @FXML
    private ChoiceBox <String> campoEspacioReservaChoice;
    @FXML
    private TextField campoEspacioReserva;

    /**
     * Campo con el material
     */
    @FXML
    private ChoiceBox <String> campoMaterialReservaChoice;
    @FXML
    private TextField campoMaterialReserva;

    /**
     * Campo con la verificación
     */
    @FXML
    private TextField campoVerificadoReserva;
    /**
     * Botones para editar o eliminar el material seleccionado. Otro para volver a la
     * vista anterior.
     */
    @FXML
    private Button botonAddReserva, botonEliminarReserva, botonVolver;


    public ReservasController() throws IOException {

    }

    public void setVentanahome(VentanaHomeVista ventanaHome) {
        setListaUsuario();
        listaUsuario.recuperarUsuarios();
        ventanaHome = new VentanaHomeVista(dialogStage,conver.dtoToVo(currentUsuario),listaUsuario);
        this.ventanaHome = ventanaHome;
    }

    /**
     * @throws IOException
     */
    @FXML
    public void volver() throws IOException {
        setVentanahome(ventanaHome);
        ventanaHome.LaunchHomeView();
        dialogStage.close();
    }

    /**
     * @param vista
     * @param dialog
     * @param currentUsuario
     */
    public void setVista(VentanaReservaVista vista, Stage dialog, UsuarioDTO currentUsuario) {
        this.dialogStage = dialog;
        this.vista = vista;
        this.currentUsuario = currentUsuario;
    }

    public void setListaMaterial() {
        listaMaterial = new ListaMaterial(mkstudiojdbc);
    }
    public void setListaEspacio() {
        listaEspacio = new ListaEspacio(mkstudiojdbc);
    }
    public void setListaReserva() {
        listaReserva = new ListaReserva(mkstudiojdbc);
    }
    public void setListaUsuario() {
        listaUsuario = new ListaUsuario(mkstudiojdbc);
    }

    /**
     *
     */
    public void iniciarReservas() {
        setListaMaterial();
        listaMaterial.recuperarMateriales();
        setListaEspacio();
        listaEspacio.recuperarEspacios();
        setListaReserva();
        listaReserva.recuperarReservas();
        reservas.setItems(listaReserva.recuperarReservas());
        colReserva.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        reservas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showReservaDetails(newValue));
    }

    /**
     * @param reserva
     */
    public void showReservaDetails(ReservaDTO reserva) {
        setListaMaterial();
        listaMaterial.recuperarMateriales();
        setListaEspacio();
        listaEspacio.recuperarEspacios();
        if (reserva != null) {
            campoNombreReserva.setText(reserva.getNombre());
            campoFechaReserva.setValue(reserva.getFecha().toLocalDate());
            campoDescripcionReserva.setText(reserva.getDescripcion());
            for (EspacioDTO espacioDTO : listaEspacio.getEspacios()) {
                if (espacioDTO.getId()== reserva.getEspacio()) {
                    campoEspacioReserva.setText(espacioDTO.getNombre());
                }
            }
            for (MaterialDTO materialDTO : listaMaterial.getMateriales()) {
                if (materialDTO.getId()== reserva.getMaterial()) {
                    campoMaterialReserva.setText(materialDTO.getNombre());
                }
            }
            if (reserva.getAprobado()){
            campoVerificadoReserva.setText("Aprobado");
            } else{
                campoVerificadoReserva.setText("Esperando aprobación");
            }
            currentReserva = reserva;
        } else {
            campoNombreReserva.setText("");
            campoFechaReserva.setValue(LocalDate.now());
            campoDescripcionReserva.setText("");
            campoEspacioReserva.setText("");
            campoMaterialReserva.setText("");
        }
    }

    /**
     * Metodo para añadir un reserva
     */
    @FXML
    public void addReserva() {
        if (isInputValid()) {
            String nombre = campoNombreReserva.getText();
            Date fecha = Date.valueOf(campoFechaReserva.getValue());
            String descripcion = campoDescripcionReserva.getText();
            int usuario =currentUsuario.getId();
            int espacio=0;
            for (EspacioDTO espacioDTO : listaEspacio.getEspacios()) {
                if (espacioDTO.getNombre().equalsIgnoreCase(campoEspacioReservaChoice.getValue())) {
                    espacio =espacioDTO.getId() ;
                }
            }
            int material=0;
            for (MaterialDTO materialDTO : listaMaterial.getMateriales()) {
                if (materialDTO.getNombre().equalsIgnoreCase(campoMaterialReservaChoice.getValue())) {
                    material =materialDTO.getId() ;
                }
            }
            Boolean aprobado= false;
            ReservaDTO reserva = new ReservaDTO(nombre,fecha, descripcion,usuario,espacio,material,aprobado);
            setListaReserva();
            listaReserva.recuperarReservas();
            listaReserva.añadirReserva(reserva);
            ActionDialogs.info("Reserva añadida correctamente.", "Reserva añadida.\n" +
                    reserva.toString());
        }
    }

    /**
     * Metodo para eliminar un material
     */
    @FXML
    public void eliminarReserva() {
        boolean correct = false;
        for (ReservaDTO reserva : listaReserva.getReservas()) {
            if (reserva.equals(currentReserva)) {
                listaReserva.eliminarReserva(reserva);
                listaReserva.getReservas();
                iniciarReservas();
                currentReserva = null;
                campoNombreReserva.setText("");
                campoFechaReserva.setValue(LocalDate.now());
                campoDescripcionReserva.setText("");
                campoEspacioReserva.setText("");
                campoMaterialReserva.setText("");
                correct = true;
                ActionDialogs.info("Eliminado", "La reserva ha sido denegada y eliminada correctamente.");
                break;
            }
        }
        if (!correct) {
            ActionDialogs.error("Error", "Selecciona una reserva para poder eliminarla");
        }
    }

    /**
     * Metodo para editar un material
     */
    @FXML
    public void editarReserva() {
        if (currentReserva == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No has seleccionado ningun material a editar.");
            alert.setContentText("Vuelva a intentarlo de nuevo.");
            alert.showAndWait();
        } else {
            for (ReservaDTO reservaDTO : listaReserva.getReservas()) {
                if (reservaDTO.getId()==currentReserva.getId()) {
                    reservaDTO.setId(currentReserva.getId());
                    reservaDTO.setNombre(currentReserva.getNombre());
                    reservaDTO.setFecha(currentReserva.getFecha());
                    reservaDTO.setDescripcion(currentReserva.getDescripcion());
                    reservaDTO.setUsuario(currentReserva.getUsuario());
                    reservaDTO.setEspacio(currentReserva.getEspacio());
                    reservaDTO.setMaterial(currentReserva.getMaterial());
                    listaReserva.editarReserva(currentReserva);
                    listaReserva.getReservas();
                    iniciarReservas();
                    ActionDialogs.info("Editado", "La reserva ha sido aprobada correctamente.");
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
        if (campoNombreReserva == null || campoNombreReserva.getText().isEmpty()) {
            errorMsg += "Introduce un nombre de reserva válido.\n ";
        }
        if (campoFechaReserva == null) {
            errorMsg += "Introduce una fecha válida.";
        }
        if (campoDescripcionReserva == null || campoDescripcionReserva.getText().isEmpty()) {
            errorMsg += "Introduce una descripción válida.";
        }
        if (campoEspacioReservaChoice == null) {
            errorMsg += "Introduce un espacio válido.";
        }
        if (campoMaterialReservaChoice == null) {
            errorMsg += "Introduce un espacio válido.";
        }
        if (errorMsg.isEmpty()) {
            return true;
        } else {
            ActionDialogs.error("Error en los campos", errorMsg);
            return false;
        }
    }

    public void iniciarReservasUser() {
        setListaMaterial();
        listaMaterial.recuperarMateriales();
        setListaEspacio();
        listaEspacio.recuperarEspacios();
        setListaReserva();
        listaReserva.recuperarReservas();
        reservas.setItems(listaReserva.recuperarReservasUser(currentUsuario));
        colReserva.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        reservas.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showReservaDetails(newValue));
    }

    public void iniciarRecursos() {
        setListaMaterial();
        listaMaterial.recuperarMateriales();
        setListaEspacio();
        listaEspacio.recuperarEspacios();
        for (String material : listaMaterial.getMaterialesNombre()) {
        campoMaterialReservaChoice.getItems().add(material);
        }
        for (String espacio : listaEspacio.getEspaciosNombre()) {
            campoEspacioReservaChoice.getItems().add(espacio);
        }
    }
}
