package MKStudio.Shared.DataBase;

import MKStudio.GestionEspacios.model.dto.EspacioDTO;
import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.GestionReservas.model.dto.ReservaDTO;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import javafx.collections.ObservableList;

public interface Dao {
    boolean registrarUsuarios(UsuarioVO usuarioVO);
    ObservableList<UsuarioVO> recuperarUsuarios();
    UsuarioVO recuperarUsuario();

    boolean guardarMaterial(MaterialDTO materialVO);
    void eliminarMaterial(MaterialDTO materialVO);
    void editarMaterial( MaterialDTO materialVO);
    ObservableList<MaterialDTO> recuperarMateriales();
    ObservableList<String> recuperarMaterialesNombre();


    boolean guardarEspacio(EspacioDTO espacioDTO);
    void eliminarEspacio(EspacioDTO espacioDTO);
    void editarEspacio(EspacioDTO espacioDTO);
    ObservableList<EspacioDTO> recuperarEspacios();
    ObservableList<String> recuperarEspaciosNombre();

    boolean guardarReserva(ReservaDTO reservaDTO);
    void eliminarReserva(ReservaDTO reservaDTO);
    void editarReserva(ReservaDTO reservaDTO);
    ObservableList<ReservaDTO> recuperarReservas();
    ObservableList<ReservaDTO> recuperarReservasUser(UsuarioDTO usuarioDTO);

}
