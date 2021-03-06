package MKStudio.GestionUsuarios.controller;

import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.GestionUsuarios.repository.ListaUsuario;
import MKStudio.GestionUsuarios.ui.VentanaRegistroVista;
import MKStudio.Shared.util.ActionDialogs;
import MKStudio.Shared.view.VentanaInicioVista;
import MKStudio.Shared.view.VentanaRootVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class VistaRegistroControlador {

    private VentanaRegistroVista vista;
    private VentanaRootVista ventanaRootVista;
    private ListaUsuario listaUsuario;

    @FXML
    private TextField campoUsuario;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoPass;

    @FXML
    private DatePicker campoFechaNac;

    @FXML
    private TextField campoTele;

    @FXML
    private CheckBox checkBox = new CheckBox();

    @FXML
    private Button botonContinuar = new Button();

    @FXML
    private Button botonVolver = new Button();

    private Stage dialogStage;

    public VistaRegistroControlador() {
        if (checkBox.isSelected())
            botonContinuar.setDisable(false);
        else {
            botonContinuar.setDisable(true);
        }
    }

    public void setVista(VentanaRegistroVista vista, Stage dialogStage, ListaUsuario listaUsuario) {
        this.dialogStage = dialogStage;
        this.vista = vista;
        this.listaUsuario = listaUsuario;
    }

    /**
     * Se llama al metodo al pulsar el boton continuar.
     */
    @FXML
    private void pulsaContinuar() throws IOException {
        if (isInputValid()) {

            UsuarioVO usuarioVO = new UsuarioVO(
                    campoUsuario.getText(),
                    campoPass.getText(),
                    campoEmail.getText(),
                    Date.valueOf(campoFechaNac.getValue()),
                    Integer.parseInt(campoTele.getText()),
                    "user"
            );
            listaUsuario.a??adirUsuario(usuarioVO);



            ActionDialogs.info("Usuario registrado correctamente.", "Comience a disfrutar de los servicios de MKStudio.\n" +
                    "Nombre de usuario: " + usuarioVO.getNombre() + "\n" + "Password: " + usuarioVO.getPassword());

            campoUsuario.setText("");
            campoPass.setText("");
            campoEmail.setText("");
            campoFechaNac.setValue(LocalDate.now());
            campoTele.setText("");
            checkBox.setSelected(false);
            pulsaVolver();
        }
    }

    /**
     * Validaci??n de los campos.
     *
     * @return true si se introducen bien los campos.
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (campoUsuario.getText() == null || campoUsuario.getText().length() == 0) {
            errorMessage += "Nombre de usuario no v??lido!\n";
        }
        if (campoEmail.getText() == null || campoEmail.getText().length() == 0) {
            errorMessage += "Email no v??lido!\n";
        }
        if (campoPass.getText() == null || campoPass.getText().length() == 0) {
            errorMessage += "Contrase??a no v??lidos!\n";
        }
        if (campoFechaNac.getValue() == null) {
            errorMessage += "Fecha de nacimiento no v??lida!\n";
        }
        if ((campoTele.getText()) == null && (Integer.parseInt(campoTele.getText()) >= 0 && Integer.parseInt(campoTele.getText()) <= 999999999)) {
            errorMessage += "N??mero de tel??fono no v??lido!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            ActionDialogs.error("Error en los campos.", "Por favor, revisa alg??n dato que no est?? correcto.");
            return false;
        }
    }

    /**
     * Volver a la pantalla de inicio de la app.
     */
    @FXML
    public void pulsaVolver() throws IOException {
        ventanaRootVista = new VentanaRootVista();
        ventanaRootVista.inicioStage(dialogStage);
    }
}
