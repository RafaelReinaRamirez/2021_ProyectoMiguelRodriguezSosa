package MKStudio.GestionUsuarios.controller;

import MKStudio.GestionChat.ui.VentanaChatVista;
import MKStudio.GestionEspacios.ui.VentanaEspacioVista;
import MKStudio.GestionMateriales.ui.VentanaMaterialVista;
import MKStudio.GestionReservas.ui.VentanaReservaVista;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.GestionUsuarios.ui.VentanaPerfilVista;
import MKStudio.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Controlador del administrador que se encarga de manejar usuarios, peticiones, eventos y correos.
 */
public class AdminController {

    @FXML
    private Button botonConsultar, botonGestionMaterial, botonAddEspacio, botonVerificarReserva, botonChat;

    private Stage dialogStage;
    VentanaHomeVista ventanaHomeVista;
    private UsuarioVO userLogeado;

    public AdminController() {

    }

    public void setDialogStage(Stage dialogStage,  VentanaHomeVista ventanaHomeVista) {
        this.dialogStage = dialogStage;
        this.ventanaHomeVista=ventanaHomeVista;
        userLogeado=ventanaHomeVista.getUser();
    }

    @FXML
    public void abrirVistaMaterial() throws IOException {
       VentanaMaterialVista vistaMat =new VentanaMaterialVista(this,dialogStage,this.userLogeado);
       vistaMat.loadMaterialView();
    }

    @FXML
    public void abrirVistaEspacio() throws IOException {
        VentanaEspacioVista vistaMat =new VentanaEspacioVista(this,dialogStage,this.userLogeado);
        vistaMat.loadEspacioView();
    }

    @FXML
    public void abrirVistaPerfil() throws IOException {
        VentanaPerfilVista vistaPerfil =new VentanaPerfilVista(dialogStage, ventanaHomeVista);
        vistaPerfil.LaunchVistaPerfil(ventanaHomeVista.getUser());
    }

    @FXML
    public void abrirVistaReserva() throws IOException {
        VentanaReservaVista vistaMat =new VentanaReservaVista(this, dialogStage,this.userLogeado);
        vistaMat.loadReservaView();
    }

    @FXML
    public void abrirVistaChat() throws IOException {
        VentanaChatVista vistaMat =new VentanaChatVista(this, dialogStage,this.userLogeado);
        vistaMat.loadChatView();
    }

    @FXML
    public void volver() throws IOException {
        dialogStage.close();
    }
}
