package MKStudio.GestionChat.ui;

import MKStudio.GestionChat.controller.MultiChatUDP;
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

public class VentanaChatVista {

    private Stage stageppal;
    AdminController adminController;
    UserController userController;
    UsuarioVO currentUsuario;
    Conversor conversor;

    public VentanaChatVista() {
    }

    public VentanaChatVista(AdminController adminController, Stage stageppal, UsuarioVO currentUsuario) {
        this.adminController = adminController;
        this.stageppal = stageppal;
        this.currentUsuario = currentUsuario;
    }

    public VentanaChatVista(UserController userController, Stage stageppal, UsuarioVO currentUsuario) {
        this.userController = userController;
        this.stageppal = stageppal;
        this.currentUsuario = currentUsuario;
    }

    /**
     * @throws IOException
     */
    public void loadChatView() throws IOException {
        URL url = new File("src/main/java/MKStudio/GestionChat/ui/VistaChat.fxml").toURI().toURL();
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
        stageppal.setTitle("Chat");
        stageppal.show();
        MultiChatUDP control = loader.getController();
        control.setVista(this, stageppal, conversor.voToDto(currentUsuario));
        control.setChat();
    }
}
