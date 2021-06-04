package MKStudio.GestionMateriales.repository;

import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import MKStudio.Shared.DataBase.Dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

/**
 *
 */
public class ListaMaterial {

    Dao dao;
    private ObservableList<MaterialDTO> listaMateriales = FXCollections.observableArrayList();
    private ObservableList <String> listaMat =  FXCollections.observableArrayList();

    public ListaMaterial(Dao dao) {
        this.dao = dao;
    }

    public ObservableList<MaterialDTO> recuperarMateriales() {
        listaMateriales=dao.recuperarMateriales();
        return listaMateriales;
    }

    public boolean añadirMaterial(MaterialDTO materialDTO) {
        dao.guardarMaterial(materialDTO);
        return true;
    }

    public void eliminarMaterial(MaterialDTO materialDTO) {
        dao.eliminarMaterial(materialDTO);
    }

    public void editarMaterial(MaterialDTO materialDTO) {
        dao.editarMaterial(materialDTO);
    }

    public void setListaMateriales() {
        dao.recuperarMateriales();
    }

    public ObservableList<MaterialDTO> getMateriales() {
        return listaMateriales;
    }

    public ObservableList<String> getMaterialesNombre() {
        listaMat = dao.recuperarMaterialesNombre();
        return listaMat;
    }
}
