package MKStudio.Shared.DataBase;

import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {


    private static Connection conn = null;

    /* Constructor de la clase. Crea una nueva conexión del tipo JDBC, en nuestro
     * caso, utilizando el driver de mySQL.
     */
    public static Connection ConexionJDBC() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mkstudio", "root", "");
            } catch (SQLException e) {
                System.out.println(e);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText("Conexión local");
                alert.setContentText("Se ha producido un error con la conexión, será imposible iniciar la aplicación");
                alert.showAndWait();
                System.exit(0);

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return conn;
    }
}

