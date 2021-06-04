package MKStudio.Shared.controllers;

import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.GestionUsuarios.repository.ListaUsuario;
import MKStudio.GestionUsuarios.ui.VentanaPerfilVista;
import MKStudio.Shared.view.VentanaHomeVista;
import MKStudio.Shared.view.VentanaRootVista;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Controlador de la
 */
public class VistaHomeControlador {

    /**
     *
     */
    @FXML
    public Button btnConfig, btnAyuda, btnGestionArchivos, btnNuevoCanal, btnNuevoEvento, btnConfigEventos;
    /**
     *
     */
    @FXML
    private Stage dialogStage;
    private UsuarioVO userLogeado;
    private VentanaHomeVista vista;
    private SplitPane pane;
    private ListaUsuario listaUsuario;
    private VistaHomeControlador controladorHome;

    @FXML
    private Button botonConsultar, botonVerMaterial,botonVerEspacio,botonSolicitarReserva,botonVerReserva,botonChat;

    /**
     * @param vista
     * @param dialogStage
     */
    public void setVista(VentanaHomeVista vista, Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.vista = vista;
    }

    public UsuarioVO getUsuarioLogeado() {
        return userLogeado;
    }

    public void setUsuario(UsuarioVO user) {
        this.userLogeado = user;
    }

    /**
     * Método para salir de la aplicación (Log-out)
     *
     * @throws IOException
     */
    @FXML
    public void Logout() throws IOException {
        VentanaRootVista ventanaRoot = new VentanaRootVista();
        ventanaRoot.inicioStage(new Stage());
        dialogStage.close();
    }

    public void setControladores(VistaHomeControlador controlador) {
        this.controladorHome = controlador;
    }

    /**
     * *Método que carga la vista del consultar perfil.
     *
     * @throws IOException
     */
    @FXML
    public void LaunchPerfil() throws IOException {
        VentanaPerfilVista ventanavista = new VentanaPerfilVista(dialogStage, vista);
        ventanavista.LaunchVistaPerfil(userLogeado);
    }

    public void setlistaUsuarios(ListaUsuario listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
}
