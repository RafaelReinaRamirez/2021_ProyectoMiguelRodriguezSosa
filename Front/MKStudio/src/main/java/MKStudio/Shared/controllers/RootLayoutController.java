package MKStudio.Shared.controllers;

import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.GestionUsuarios.repository.ListaUsuario;
import MKStudio.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

public class RootLayoutController {

    // Reference to the main application
    private MainApp mainApp;
    private ListaUsuario listaUsuario;
    ObservableList<UsuarioVO> lista;

    public void setListaUsuario(ListaUsuario listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    public ObservableList<UsuarioVO> recuperarUsuarios() {
        lista=listaUsuario.recuperarUsuarios();
        return lista;
    }
    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }


    /**
     * Saves the file to the person file that is currently open. If there is no open
     * file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {

    }


    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
}
