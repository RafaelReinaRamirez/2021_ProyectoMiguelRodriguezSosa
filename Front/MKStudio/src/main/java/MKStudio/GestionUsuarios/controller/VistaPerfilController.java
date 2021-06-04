package MKStudio.GestionUsuarios.controller;

import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.GestionUsuarios.ui.VentanaPerfilVista;
import MKStudio.Shared.view.VentanaHomeVista;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 */
public class VistaPerfilController {
    private VentanaPerfilVista vista;
    private UsuarioVO userLogeado;
    private Stage dialogStage;
    private VentanaHomeVista ventanaHomeVista;

    @FXML
    private TextField campoNombre, campoEmail, campoTelefono;

    @FXML
    private DatePicker campoFechaNac;

    @FXML
    private Button botonVolver;

    public VistaPerfilController() {

    }

    public void setcampos() {
        if (userLogeado != null) {
            campoNombre.setText(ventanaHomeVista.getUser().getNombre());
            campoEmail.setText(ventanaHomeVista.getUser().getEmail());
            campoTelefono.setText(String.valueOf(ventanaHomeVista.getUser().getTelefono()));
            campoFechaNac.setValue(ventanaHomeVista.getUser().getFecha_nacimiento().toLocalDate());
        }
    }

    @FXML
    public void volver() throws IOException {
        ventanaHomeVista.LaunchHomeView();
        dialogStage.close();
    }

    public void setVentanahome(VentanaHomeVista ventanaHomeVista) {
        this.ventanaHomeVista = ventanaHomeVista;
    }

    public void setVista(VentanaPerfilVista vista, Stage dialogStage) {
        this.dialogStage = dialogStage;
        this.vista = vista;
    }

    public void setUserLogeado(UsuarioVO userLogeado) {
        this.userLogeado = userLogeado;
    }
}
