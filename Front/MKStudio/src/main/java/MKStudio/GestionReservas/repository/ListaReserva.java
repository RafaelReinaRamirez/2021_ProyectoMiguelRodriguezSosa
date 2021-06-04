package MKStudio.GestionReservas.repository;

import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.GestionReservas.model.dto.ReservaDTO;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.Shared.DataBase.Dao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaReserva {

    Dao dao;
    private ObservableList<ReservaDTO> listaReservas = FXCollections.observableArrayList();


    public ListaReserva(Dao dao) {
        this.dao = dao;
    }

    public ObservableList<ReservaDTO> recuperarReservas() {
        listaReservas=dao.recuperarReservas();
        return listaReservas;
    }

    public ObservableList<ReservaDTO> recuperarReservasUser(UsuarioDTO usuarioDTO) {
        listaReservas=dao.recuperarReservasUser(usuarioDTO);
        return listaReservas;
    }

    public boolean añadirReserva(ReservaDTO reservaDTO) {
        dao.guardarReserva(reservaDTO);
        return true;
    }

    public void eliminarReserva(ReservaDTO reservaDTO) {
        dao.eliminarReserva(reservaDTO);
    }

    public void editarReserva(ReservaDTO reservaDTO) {
        dao.editarReserva(reservaDTO);
    }

    public void setListaReservas() {
        dao.recuperarReservas();
    }

    public ObservableList<ReservaDTO> getReservas() {
        return listaReservas;
    }
}
