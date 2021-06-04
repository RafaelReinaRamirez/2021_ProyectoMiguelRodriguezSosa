package MKStudio.GestionMateriales.controller;

import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.GestionMateriales.model.vo.MaterialVO;
import MKStudio.GestionMateriales.repository.ListaMaterial;
import MKStudio.GestionMateriales.ui.VentanaMaterialVista;
import MKStudio.GestionUsuarios.model.Conversor;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.repository.ListaUsuario;
import MKStudio.Shared.DataBase.MKStudioJDBC;
import MKStudio.Shared.util.ActionDialogs;
import MKStudio.Shared.view.VentanaHomeVista;
import MKStudio.Shared.view.VentanaRootVista;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Controlador de la vista de los materiales.
 */
public class MaterialesController {

    @FXML
    TableColumn<MaterialDTO, String> colMaterial;
    private Stage dialogStage;
    private VentanaHomeVista ventanaHome;
    private VentanaMaterialVista vista;
    private ListaMaterial listaMaterial;
    private MaterialDTO currentMaterial;
    private MKStudioJDBC mkstudiojdbc = new MKStudioJDBC();
    Conversor conver;
    private UsuarioDTO currentUsuario;

    /**
     * Tabla que muestra todos los materiales de la plataforma
     */
    @FXML
    private TableView<MaterialDTO> materiales;
    /**
     * Campos para visualizar el nombre,Campo con la marca
     */
    @FXML
    private TextField campoNombreMaterial,campoMarcaMaterial;
    /**
     * Campo con la descripción
     */
    @FXML
    private TextArea campoDescripcionMaterial;

    /**
     * Botones para editar o eliminar el material seleccionado. Otro para volver a la
     * vista anterior.
     */
    @FXML
    private Button botonAddMaterial, botonEliminarMaterial, botonVolver;


    public MaterialesController() throws IOException {

    }

    public void setVentanahome(VentanaHomeVista ventanaHome) {
        ventanaHome = new VentanaHomeVista(dialogStage,conver.dtoToVo(currentUsuario));
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
     */
    public void setVista(VentanaMaterialVista vista, Stage dialog, UsuarioDTO currentUsuario) {
        this.dialogStage = dialog;
        this.vista = vista;
        this.currentUsuario = currentUsuario;

    }

    public void setListaMaterial() {
        listaMaterial = new ListaMaterial(mkstudiojdbc);
    }

    /**
     *
     */
    public void iniciarMateriales() {
        setListaMaterial();
        listaMaterial.recuperarMateriales();
        materiales.setItems(listaMaterial.getMateriales());
        colMaterial.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        materiales.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showMaterialDetails(newValue));
    }

    /**
     * @param material
     */
    public void showMaterialDetails(MaterialDTO material) {
        if (material != null) {
            campoNombreMaterial.setText(material.getNombre());
            campoDescripcionMaterial.setText(material.getDescripcion());
            campoMarcaMaterial.setText(material.getMarca());
            currentMaterial = material;
        } else {
            campoNombreMaterial.setText("");
            campoDescripcionMaterial.setText("");
            campoMarcaMaterial.setText("");
        }
    }

    /**
     * Metodo para añadir un material
     */
    @FXML
    public void addMaterial() {
        if (isInputValid()) {
            String nombre = campoNombreMaterial.getText();
            String descripcion = campoDescripcionMaterial.getText();
            String marca = campoMarcaMaterial.getText();
            MaterialDTO material = new MaterialDTO(nombre, descripcion, marca);
            listaMaterial.añadirMaterial(material);
            listaMaterial.getMateriales();
            iniciarMateriales();
            ActionDialogs.info("Material añadido correctamente.", "Material añadido.\n" +
                    material.toString());
        }
    }

    /**
     * Metodo para eliminar un material
     */
    @FXML
    public void eliminarMaterial() {
        boolean correct = false;
        for (MaterialDTO material : listaMaterial.getMateriales()) {
            if (material.equals(currentMaterial)) {
                listaMaterial.eliminarMaterial(material);
                listaMaterial.getMateriales();
                iniciarMateriales();
                currentMaterial = null;
                campoNombreMaterial.setText("");
                campoDescripcionMaterial.setText("");
                campoMarcaMaterial.setText("");
                correct = true;
                ActionDialogs.info("Eliminado", "El material ha sido eliminado correctamente.");
                break;
            }
        }
        if (!correct) {
            ActionDialogs.error("Error", "Selecciona un material para poder eliminarlo");
        }
    }

    /**
     * Metodo para editar un material
     */
    @FXML
    public void editarMaterial() {
        String nombre = campoNombreMaterial.getText();
        String descripcion = campoDescripcionMaterial.getText();
        String marca = campoMarcaMaterial.getText();
        if (currentMaterial == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("No has seleccionado ningun material a editar.");
            alert.setContentText("Vuelva a intentarlo de nuevo.");
            alert.showAndWait();
        } else {
            for (MaterialDTO material : listaMaterial.getMateriales()) {
                if (material.equals(currentMaterial)) {
                    material.setId(currentMaterial.getId());
                    material.setNombre(nombre);
                    material.setDescripcion(descripcion);
                    material.setMarca(marca);
                    listaMaterial.editarMaterial(currentMaterial);
                    listaMaterial.getMateriales();
                    iniciarMateriales();
                    ActionDialogs.info("Editado", "El material ha sido editado correctamente.");
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
        if (campoNombreMaterial == null || campoNombreMaterial.getText().isEmpty()) {
            errorMsg += "Introduce un nombre de espacio válido.\n ";
        }
        if (campoDescripcionMaterial == null || campoDescripcionMaterial.getText().isEmpty()) {
            errorMsg += "Introduce una descripción válida.";
        }
        if (campoMarcaMaterial == null || campoMarcaMaterial.getText().isEmpty()) {
            errorMsg += "Introduce una marca válida.";
        }
        if (errorMsg.isEmpty()) {
            return true;
        } else {
            ActionDialogs.error("Error en los campos", errorMsg);
            return false;
        }
    }
}
