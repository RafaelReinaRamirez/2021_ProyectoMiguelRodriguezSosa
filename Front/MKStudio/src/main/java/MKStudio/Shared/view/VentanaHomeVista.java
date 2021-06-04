package MKStudio.Shared.view;

import MKStudio.GestionUsuarios.controller.AdminController;
import MKStudio.GestionUsuarios.controller.UserController;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.GestionUsuarios.repository.ListaUsuario;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Clase que arranca
 */
public class VentanaHomeVista {

    private Stage stageppal;
    private ListaUsuario listaUsuario;
    private UsuarioVO user;
    private UserController controladorUser;
    private AdminController controladorAdmin;

    public VentanaHomeVista(Stage stageppal, UsuarioVO user) {
        this.stageppal = stageppal;
        this.user = user;
    }

    public VentanaHomeVista(Stage stageppal, UsuarioVO user, ListaUsuario listaUsuario) {
        this.stageppal = stageppal;
        this.user = user;
        this.listaUsuario = listaUsuario;
    }

    /**
     * @throws IOException
     */
    public void LaunchHomeView() throws IOException {
        if(user.getRol().equalsIgnoreCase("user")) {
            iniciarConUser();
        }else if(user.getRol().equalsIgnoreCase("admin")) {
            iniciarConAdmin();
        }

    }

    private void iniciarConAdmin() throws IOException {
        URL url = new File("src/main/java/MKStudio/Shared/view/VistaHomeAdmin.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane home = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        Scene scene = new Scene(home, 608, 190);
        dialogStage.setScene(scene);
        dialogStage.setTitle("Bienvenido " + user.getNombre());
        dialogStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                dialogStage.close();
            }
        });
            controladorAdmin = loader.getController();
            controladorAdmin.setDialogStage(dialogStage,this);
            dialogStage.show();
    }

    private void iniciarConUser() throws IOException {
        URL url = new File("src/main/java/MKStudio/Shared/view/VistaHomeUser.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane home = (AnchorPane) loader.load();
        Stage dialogStage = new Stage();
        Scene scene = new Scene(home, 608, 190);
        dialogStage.setScene(scene);
        dialogStage.setTitle("Bienvenido " + user.getNombre());
        dialogStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                dialogStage.close();
            }
        });
            controladorUser = loader.getController();
            controladorUser.setDialogStage(this, dialogStage);
            dialogStage.show();
    }

    public UsuarioVO getUser() {
        return user;
    }
}
