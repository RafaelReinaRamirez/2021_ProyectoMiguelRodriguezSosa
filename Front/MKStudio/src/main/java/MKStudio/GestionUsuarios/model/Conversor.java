package MKStudio.GestionUsuarios.model;

import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;

import java.sql.Date;

/**
 * Clase conversor de la entidad Usuario. Convierte tipos VO a DTO y viceversa
 * * según los datos que maneja la aplicación (DTO) y los que se persisten en la BBDD (VO).
 */
public class Conversor {

    public Conversor() {
    }


    /**
     * Convierte un objeto tipo UsuarioDTO a UsuarioVO
     *
     * @param usuarioVO
     * @return
     */
    public static UsuarioDTO voToDto(UsuarioVO usuarioVO) {
        UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioVO.getId(), usuarioVO.getNombre(), usuarioVO.getPassword(), usuarioVO.getEmail(), usuarioVO.getFecha_nacimiento().toLocalDate(), usuarioVO.getTelefono(), usuarioVO.getRol());
        return usuarioDTO;
    }

    /**
     * Convierte un objeto tipo UsuarioVO a UsuarioDTO
     *
     * @param usuarioDTO
     * @return
     */
    public static UsuarioVO dtoToVo(UsuarioDTO usuarioDTO) {
        UsuarioVO usuarioVO = new UsuarioVO(usuarioDTO.getId(),usuarioDTO.getNombre(),usuarioDTO.getPassword(),usuarioDTO.getEmail(),Date.valueOf(usuarioDTO.getFecha_nacimiento()),usuarioDTO.getTelefono(),usuarioDTO.getRol());
        return usuarioVO;
    }
}
