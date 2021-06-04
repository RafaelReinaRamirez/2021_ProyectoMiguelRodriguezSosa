package MKStudio.GestionMateriales.ui;

import MKStudio.GestionMateriales.controller.MaterialesController;
import MKStudio.GestionMateriales.repository.ListaMaterial;
import MKStudio.GestionUsuarios.controller.AdminController;
import MKStudio.GestionUsuarios.controller.UserController;
import MKStudio.GestionUsuarios.model.Conversor;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.Shared.controllers.VistaInicioControlador;
import MKStudio.Shared.view.VentanaHomeVista;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class VentanaMaterialVista {

    private Stage stageppal;
    AdminController adminController;
    UserController userController;
    UsuarioVO currentUsuario;
    Conversor conversor;

    public VentanaMaterialVista() {
    }

    public VentanaMaterialVista(AdminController adminController, Stage stageppal, UsuarioVO currentUsuario) {
        this.adminController=adminController;
        this.stageppal = stageppal;
        this.currentUsuario=currentUsuario;
    }
    public VentanaMaterialVista(UserController userController, Stage stageppal, UsuarioVO currentUsuario) {
        this.userController=userController;
        this.stageppal = stageppal;
        this.currentUsuario=currentUsuario;

    }

    /**
     * @throws IOException
     */
    public void loadMaterialView() throws IOException {

        URL url = new File("src/main/java/MKStudio/GestionMateriales/ui/VistaGestionMateriales.fxml").toURI().toURL();
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
        stageppal.setTitle("Gestion de materiales");
        stageppal.show();
        MaterialesController materialescontrol = loader.getController();
        materialescontrol.setVista(this, stageppal,conversor.voToDto(currentUsuario));
        materialescontrol.iniciarMateriales();
    }

    public void loadMaterialVer() throws IOException {

        URL url = new File("src/main/java/MKStudio/GestionMateriales/ui/VistaVerMateriales.fxml").toURI().toURL();
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
        stageppal.setTitle("Gestion de materiales");
        stageppal.show();
        MaterialesController materialescontrol = loader.getController();
        materialescontrol.setVista(this, stageppal,conversor.voToDto(currentUsuario));
        materialescontrol.iniciarMateriales();
    }
}
