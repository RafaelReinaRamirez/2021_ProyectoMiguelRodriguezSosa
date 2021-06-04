package MKStudio.GestionReservas.model;

import MKStudio.GestionReservas.model.dto.ReservaDTO;
import MKStudio.GestionReservas.model.vo.ReservaVO;

import java.sql.Date;

/**
 * Clase conversor de la entidad Reserva. Convierte tipos VO a DTO y viceversa
 * según los datos que maneja la aplicación (DTO) y los que se persisten en la BBDD (VO).
 */
public class Conversor {

    public Conversor() {
    }

    /**
     * Convierte un objeto tipo ReservaDTO a ReservaVO
     *
     * @param reservaVO
     * @return reservaDTO
     */
    public ReservaDTO dtoToVo(ReservaVO reservaVO) {
        ReservaDTO reservaDTO = new ReservaDTO(reservaVO.getId(), reservaVO.getNombre(), reservaVO.getFecha(),reservaVO.getDescripcion(),reservaVO.getUsuario(),reservaVO.getEspacio(),reservaVO.getMaterial(),reservaVO.getAprobado());
        return reservaDTO;
    }

    /**
     * Convierte un objeto tipo ReservaVO a ReservaDTO
     *
     * @param reservaDTO
     * @return reservaVO
     */
    public ReservaVO voToDto(ReservaDTO reservaDTO) {
        ReservaVO reservaVO = new ReservaVO(reservaDTO.getId(),reservaDTO.getNombre(), reservaDTO.getFecha(),reservaDTO.getDescripcion(),reservaDTO.getUsuario(),reservaDTO.getEspacio(),reservaDTO.getMaterial(),reservaDTO.getAprobado());
        return reservaVO;
    }
}
