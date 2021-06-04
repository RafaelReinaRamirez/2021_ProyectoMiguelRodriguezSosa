package MKStudio.Shared.view;

import MKStudio.GestionUsuarios.repository.ListaUsuario;
import MKStudio.Shared.DataBase.MKStudioJDBC;
import MKStudio.Shared.controllers.RootLayoutController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Clase que muestra la ventana principal (raiz) de la aplicacion.
 */
public class VentanaRootVista {

    private Stage primaryStage;
    private BorderPane rootLayout;
    RootLayoutController controller;
    private ListaUsuario listaUsuario;
    private MKStudioJDBC mkstudiojdbc = new MKStudioJDBC();

    public VentanaRootVista() throws IOException {
    }

    public void inicioStage(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Bienvenido a MKStudio");
        URL url = new File("src/main/java/MKStudio/Shared/view/RootLayout.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(url);
        rootLayout = (BorderPane) loader.load();
        Scene scene = new Scene(rootLayout, 350, 600);
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                primaryStage.close();
            }
        });
        controller = loader.getController();
        listaUsuario = new ListaUsuario(mkstudiojdbc);
        controller.setListaUsuario(listaUsuario);
        controller.recuperarUsuarios();
        primaryStage.show();
        VentanaInicioVista inicio = new VentanaInicioVista(primaryStage, rootLayout, listaUsuario);
        inicio.LaunchInicio(listaUsuario);
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }
}
