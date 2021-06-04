package MKStudio.Shared.controllers;

import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.GestionUsuarios.repository.ListaUsuario;
import MKStudio.GestionUsuarios.ui.VentanaRegistroVista;
import MKStudio.Shared.DataBase.Dao;
import MKStudio.Shared.DataBase.MKStudioJDBC;
import MKStudio.Shared.exception.CustomException;
import MKStudio.Shared.util.ActionDialogs;
import MKStudio.Shared.view.VentanaHomeVista;
import MKStudio.Shared.view.VentanaInicioVista;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Clase controlador de la vista de acceso a la aplicación (Login).
 */
public class VistaInicioControlador {

    private VentanaInicioVista vista;
    private UsuarioVO usuarioLogeado = new UsuarioVO();
    private ListaUsuario listaUsuario;
    private VentanaRegistroVista ventanaRegistroVista;
    private MKStudioJDBC mkstudiojdbc = new MKStudioJDBC();

    @FXML
    private TextField campoUsuario;

    @FXML
    private PasswordField campoPass;

    @FXML
    private Button botonAceptar;

    private Stage stageinicio;
    private UsuarioVO usuarioVO;


    /**
     *
     */
    public VistaInicioControlador() throws IOException {

    }

    public void setVista(VentanaInicioVista vista, Stage stageinicio, ListaUsuario listaUsuario) {
        this.stageinicio = stageinicio;
        this.vista = vista;
        this.listaUsuario = listaUsuario;
    }

    public void setListaUsuario() {
        listaUsuario = new ListaUsuario(mkstudiojdbc);
    }
    public void getListaUsuario() {
        listaUsuario = new ListaUsuario(mkstudiojdbc);
    }

    public UsuarioVO getUsuarioLogeado() {
        return usuarioLogeado;
    }

    public void setUsuarioLogeado(UsuarioVO usuarioLogeado) {
        this.usuarioLogeado = usuarioLogeado;
    }

    /**
     * @throws IOException
     * @throws CustomException
     */
    public void Login() throws Exception, IOException {

        boolean correct = false;
        usuarioVO = new UsuarioVO();
        String username = campoUsuario.getText();
        String pass = campoPass.getText();
        listaUsuario.setlistaUsuarios();
        for (UsuarioVO user : listaUsuario.recuperarUsuarios()) {
            if (user.getNombre().equals(username) && user.getPassword().equals(pass)) {
                VentanaHomeVista home = new VentanaHomeVista(stageinicio, user, listaUsuario);
                home.LaunchHomeView();
                vista.getStageppal().close();
                correct = true;
                break;
            }
        }
        if (!correct) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error con las credenciales");
            alert.setHeaderText("Usuario/contraseña incorrectos.");
            alert.setContentText("Vuelva a intentarlo de nuevo.");
            alert.showAndWait();
        }
    }

    @FXML
    public void Loginenter(KeyEvent keyEvent) throws Exception {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            Login();
        }
    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleAceptar() throws Exception, IOException, CustomException {
        if (isInputValid()) {
            Login();
        }
    }

    public boolean isInputValid() {

        String errorMsg = "";

        if (campoUsuario == null || campoUsuario.getText().isEmpty()) {
            errorMsg += "Introduce un nombre de usuario válido.\n ";
        }
        if (campoPass == null || campoPass.getText().isEmpty()) {
            errorMsg += "Introduce una contraseña válida.";
        }
        if (errorMsg.isEmpty()) {
            return true;
        } else {
            ActionDialogs.error("Error en los campos.", errorMsg);
            return false;
        }
    }

    public void LaunchSignUpView(MouseEvent mouseEvent) throws IOException {
        ventanaRegistroVista = new VentanaRegistroVista(stageinicio, listaUsuario);
        ventanaRegistroVista.LaunchSignUpView();
        vista.getStageppal().close();
    }
}
