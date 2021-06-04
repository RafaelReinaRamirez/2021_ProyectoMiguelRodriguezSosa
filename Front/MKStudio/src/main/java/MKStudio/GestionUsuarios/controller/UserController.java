package MKStudio.GestionUsuarios.controller;

import MKStudio.GestionChat.ui.VentanaChatVista;
import MKStudio.GestionEspacios.ui.VentanaEspacioVista;
import MKStudio.GestionMateriales.controller.MaterialesController;
import MKStudio.GestionMateriales.ui.VentanaMaterialVista;
import MKStudio.GestionReservas.ui.VentanaReservaVista;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.GestionUsuarios.ui.VentanaPerfilVista;
import MKStudio.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class UserController {
    @FXML
    private Button botonConsultar, botonConsultarMaterial, botonSolicitarReserva, botonVerReserva, botonChat;

    VentanaHomeVista ventanaHomeVista;
    private Stage dialogStage;
    private UsuarioVO userLogeado;

    public UserController() {

    }

    public void setDialogStage(VentanaHomeVista ventanaHomeVista, Stage dialogStage) {
        this.ventanaHomeVista = ventanaHomeVista;
        this.dialogStage = dialogStage;
        userLogeado=ventanaHomeVista.getUser();
    }

    @FXML
    public void abrirVistaPerfil() throws IOException {
        VentanaPerfilVista vistaPerfil =new VentanaPerfilVista(dialogStage, ventanaHomeVista);
        vistaPerfil.LaunchVistaPerfil(ventanaHomeVista.getUser());
    }

    @FXML
    public void abrirVistaMaterial() throws IOException {
        VentanaMaterialVista vistaMat =new VentanaMaterialVista(this,dialogStage,this.userLogeado);
        vistaMat.loadMaterialVer();
    }

    @FXML
    public void abrirVistaEspacio() throws IOException {
        VentanaEspacioVista vistaMat =new VentanaEspacioVista(this,dialogStage,this.userLogeado);
        vistaMat.loadEspacioVer();
    }

    @FXML
    public void abrirVistaSolicitarReserva() throws IOException {
        VentanaReservaVista vistaMat =new VentanaReservaVista(this,dialogStage,this.userLogeado);
        vistaMat.loadReservaAdd();
    }

    @FXML
    public void abrirVistaVerReserva() throws IOException {
        VentanaReservaVista vistaMat =new VentanaReservaVista(this,dialogStage,this.userLogeado);
        vistaMat.loadReservaVer();
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
