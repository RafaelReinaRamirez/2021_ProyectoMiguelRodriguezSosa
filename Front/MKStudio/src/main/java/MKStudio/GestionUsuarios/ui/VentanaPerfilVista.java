package MKStudio.GestionUsuarios.ui;

import MKStudio.GestionUsuarios.controller.VistaPerfilController;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.Shared.view.VentanaHomeVista;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaPerfilVista {

    private Stage stageppal;
    private VentanaHomeVista ventanaHomeVista;

    public VentanaPerfilVista(Stage stageppal, VentanaHomeVista ventanaHomeVista) {
        this.stageppal = stageppal;
        this.ventanaHomeVista = ventanaHomeVista;
    }

    /**
     * @param usuarioVO
     * @throws IOException
     */
    public void LaunchVistaPerfil(UsuarioVO usuarioVO) throws IOException {
        URL url = new File("src/main/java/MKStudio/GestionUsuarios/ui/VistaPerfil.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane anchorPane = (AnchorPane) loader.load();
        Scene scene = new Scene(anchorPane, 275, 377);
        stageppal.setScene(scene);
        stageppal.setTitle("Consultar perfil");
        stageppal.show();
        VistaPerfilController controladorPerfil = loader.getController();
        controladorPerfil.setVista(this, stageppal);
        controladorPerfil.setUserLogeado(usuarioVO);
        controladorPerfil.setVentanahome(ventanaHomeVista);
        controladorPerfil.setcampos();
    }
    @FXML
    public void volver() throws IOException {
        stageppal.close();
    }

}
