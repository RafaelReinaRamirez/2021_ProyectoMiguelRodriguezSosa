package MKStudio.GestionEspacios.repository;

import MKStudio.GestionEspacios.model.dto.EspacioDTO;
import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.Shared.DataBase.Dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Clase lista espacio
 */
public class ListaEspacio {
    Dao dao;
    private ObservableList<EspacioDTO> listaEspacios = FXCollections.observableArrayList();
    private ObservableList <String> listaMat =  FXCollections.observableArrayList();


    public ListaEspacio(Dao dao) {
        this.dao = dao;
    }

    public ObservableList<EspacioDTO> recuperarEspacios() {
        listaEspacios=dao.recuperarEspacios();
        return listaEspacios;
    }

    public boolean añadirEspacios(EspacioDTO espacioDTO) {
        dao.guardarEspacio(espacioDTO);
        return true;
    }

    public void eliminarEspacio(EspacioDTO espacioDTO) {
        dao.eliminarEspacio(espacioDTO);
    }

    public void editarEspacio(EspacioDTO espacioDTO) {
        dao.editarEspacio(espacioDTO);
    }

    public ObservableList<EspacioDTO> getEspacios() {
        return listaEspacios;
    }

    public ObservableList<String> getEspaciosNombre() {
        listaMat = dao.recuperarEspaciosNombre();
        return listaMat;
    }
}
