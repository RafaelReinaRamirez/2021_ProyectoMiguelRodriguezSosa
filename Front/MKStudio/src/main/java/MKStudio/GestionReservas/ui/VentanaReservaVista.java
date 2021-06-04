package MKStudio.GestionReservas.ui;

import MKStudio.GestionEspacios.controller.EspaciosController;
import MKStudio.GestionReservas.controller.ReservasController;
import MKStudio.GestionReservas.repository.ListaReserva;
import MKStudio.GestionUsuarios.controller.AdminController;
import MKStudio.GestionUsuarios.controller.UserController;
import MKStudio.GestionUsuarios.model.Conversor;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
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

public class VentanaReservaVista {

    private Stage stageppal;
    AdminController adminController;
    UserController userController;
    UsuarioVO currentUsuario;
    Conversor conversor;

    public VentanaReservaVista(AdminController adminController, Stage stageppal, UsuarioVO currentUsuario) {
        this.adminController=adminController;
        this.stageppal = stageppal;
        this.currentUsuario=currentUsuario;
    }

    public VentanaReservaVista(UserController userController, Stage stageppal, UsuarioVO currentUsuario) {
        this.userController=userController;
        this.stageppal = stageppal;
        this.currentUsuario=currentUsuario;
    }
    /**
     * @throws IOException
     */
    public void loadReservaView() throws IOException {
        URL url = new File("src/main/java/MKStudio/GestionReservas/ui/VistaGestionReserva.fxml").toURI().toURL();
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
        stageppal.setTitle("Gestion de reservas");
        stageppal.show();
        ReservasController reservasController = loader.getController();
        reservasController.setVista(this, stageppal,conversor.voToDto(currentUsuario));
        reservasController.iniciarReservas();
    }
    public void loadReservaVer() throws IOException {
        URL url = new File("src/main/java/MKStudio/GestionReservas/ui/VistaVerReservas.fxml").toURI().toURL();
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
        stageppal.setTitle("Gestion de reservas");
        stageppal.show();
        ReservasController reservasController = loader.getController();
        reservasController.setVista(this, stageppal,conversor.voToDto(currentUsuario));
        reservasController.iniciarReservasUser();
    }

    public void loadReservaAdd() throws IOException {
        URL url = new File("src/main/java/MKStudio/GestionReservas/ui/VistaAddReservaDialog.fxml").toURI().toURL();
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
        stageppal.setTitle("Gestion de reservas");
        stageppal.show();
        ReservasController reservasController = loader.getController();
        reservasController.setVista(this, stageppal,conversor.voToDto(currentUsuario));
        reservasController.iniciarRecursos();
    }
}
