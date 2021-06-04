package MKStudio.GestionUsuarios.repository;


import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.Shared.DataBase.Dao;
import MKStudio.Shared.controllers.VistaHomeControlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;


public class ListaUsuario {

    private VistaHomeControlador vistaHomeControlador;
    private UsuarioVO usuarioLogeado;
    Dao dao;
    ObservableList<UsuarioVO> listaUsuarios=FXCollections.observableArrayList();

    public ListaUsuario(Dao dao) {
        this.dao = dao;
    }

    public ObservableList<UsuarioVO> recuperarUsuarios() {
        listaUsuarios=dao.recuperarUsuarios();
        return listaUsuarios;
    }

    public boolean añadirUsuario(UsuarioVO usuarioVO) {
        dao.registrarUsuarios(usuarioVO);
        return true;
    }



    public void setlistaUsuarios() {
        dao.recuperarUsuarios();
    }

}
