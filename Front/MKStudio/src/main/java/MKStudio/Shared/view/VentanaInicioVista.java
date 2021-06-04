package MKStudio.Shared.view;

import MKStudio.GestionUsuarios.repository.ListaUsuario;
import MKStudio.Shared.controllers.VistaInicioControlador;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *Clase que muestra en la ventana raiz la vista inicio, que permite hacer login en la aplicación, o bien
 * lleva a la de registro.
 */
public class VentanaInicioVista {

    private Stage stageppal;
    private BorderPane rootLayout;
    private ListaUsuario listaUsuario;

    public VentanaInicioVista(Stage stageppal, BorderPane rootLayout, ListaUsuario listaUsuario) {
        this.stageppal = stageppal;
        this.rootLayout = rootLayout;
        this.listaUsuario = listaUsuario;
    }

    /**
     * Vista de acceso o "logeo" a la aplicación. Se solicitan los datos nombre de usuario
     * y contraseña al usuario para poder acceder al resto de la aplicación, si esta registrado,
     * o en su defecto registrarse antes.
     *
     * @throws IOException
     */
    public void LaunchInicio(ListaUsuario listaUsuario) throws IOException {
        URL url = new File("src/main/java/MKStudio/Shared/view/VistaInicio.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        AnchorPane inicio = (AnchorPane) loader.load();
        rootLayout.setCenter(inicio);
        stageppal.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                stageppal.close();
            }
        });
        VistaInicioControlador controladorInicio = loader.getController();
        controladorInicio.setVista(this, stageppal, listaUsuario);
        controladorInicio.setListaUsuario();
    }
    public Stage getStageppal() {
        return stageppal;
    }
}
