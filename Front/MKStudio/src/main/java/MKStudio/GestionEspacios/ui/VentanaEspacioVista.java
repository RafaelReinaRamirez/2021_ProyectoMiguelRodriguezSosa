package MKStudio.GestionEspacios.ui;

import MKStudio.GestionEspacios.controller.EspaciosController;
import MKStudio.GestionUsuarios.controller.AdminController;
import MKStudio.GestionUsuarios.controller.UserController;
import MKStudio.GestionUsuarios.model.Conversor;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Clase la cual lanza el fxml en función de el tipo de usuario.
 */
public class VentanaEspacioVista {

    private Stage stageppal;
    AdminController adminController;
    UserController userController;
    UsuarioVO currentUsuario;
    Conversor conversor;

    public VentanaEspacioVista() {
    }

    public VentanaEspacioVista(AdminController adminController, Stage stageppal, UsuarioVO currentUsuario) {
        this.adminController=adminController;
        this.stageppal = stageppal;
        this.currentUsuario=currentUsuario;
    }
    public VentanaEspacioVista(UserController userController, Stage stageppal, UsuarioVO currentUsuario) {
        this.userController=userController;
        this.stageppal = stageppal;
        this.currentUsuario=currentUsuario;
    }

    /**
     * @throws IOException
     */
    public void loadEspacioView() throws IOException {
        URL url = new File("src/main/java/MKStudio/GestionEspacios/ui/VistaGestionEspacios.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane anchorPane1 = loader.load();
        Scene scene = new Scene(anchorPane1);
        stageppal.setScene(scene);
        stageppal.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

                stageppal.close();
            }
        });
        stageppal.setTitle("Gestion de espacios");
        stageppal.show();
        EspaciosController espaciosControl = loader.getController();
        espaciosControl.setVista(this, stageppal,conversor.voToDto(currentUsuario));
        espaciosControl.iniciarEspacios();
    }
    public void loadEspacioVer() throws IOException {
        URL url = new File("src/main/java/MKStudio/GestionEspacios/ui/VistaVerEspacios.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane anchorPane1 = loader.load();
        Scene scene = new Scene(anchorPane1);
        stageppal.setScene(scene);
        stageppal.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {

                stageppal.close();
            }
        });
        stageppal.setTitle("Gestion de espacios");
        stageppal.show();
        EspaciosController espaciosControl = loader.getController();
        espaciosControl.setVista(this, stageppal,conversor.voToDto(currentUsuario));
        espaciosControl.iniciarEspacios();
    }
    }
