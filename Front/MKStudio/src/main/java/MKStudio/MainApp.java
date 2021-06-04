package MKStudio;

import MKStudio.Shared.view.VentanaRootVista;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    private VentanaRootVista ventanaRoot;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        ventanaRoot = new VentanaRootVista();
        ventanaRoot.inicioStage(primaryStage);
    }
}
