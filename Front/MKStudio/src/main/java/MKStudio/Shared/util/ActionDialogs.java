package MKStudio.Shared.util;

import javafx.scene.control.Alert;

/**
 *
 */
public class ActionDialogs {


    /**
     * @param title
     * @param msg
     */
    public static void info(String title, String msg) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(title);
        alerta.setHeaderText(null);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }


    /**
     * @param title
     * @param errorMsg
     */
    public static void error(String title, String errorMsg) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle(title);
        alerta.setHeaderText(null);
        alerta.setContentText(errorMsg);
        alerta.showAndWait();
    }


}
