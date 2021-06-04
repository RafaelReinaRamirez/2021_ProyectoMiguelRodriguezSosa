package MKStudio.GestionEspacios.model;

import MKStudio.GestionEspacios.model.dto.EspacioDTO;
import MKStudio.GestionEspacios.model.vo.EspacioVO;

/**
 * Clase conversor de la entidad Espacio. Convierte tipos VO a DTO y viceversa
 * según los datos que maneja la aplicación (DTO) y los que se persisten en la BBDD (VO).
 */
public class Conversor {

    public Conversor() {

    }

    /**
     * Convierte un objeto tipo EspacioDTO a EspacioVO
     *
     * @param espacioVO
     * @return
     */
    public EspacioDTO dtoToVo(EspacioVO espacioVO) {
        EspacioDTO espacioDTO = new EspacioDTO(espacioVO.getId(),espacioVO.getNombre(),espacioVO.getDescripcion());
        return espacioDTO;
    }

    /**
     * Convierte un objeto tipo EspacioVO a EspacioDTO
     *
     * @param espacioDTO
     * @return
     */
    public EspacioVO voToDto(EspacioDTO espacioDTO) {
        EspacioVO espacioVO = new EspacioVO(espacioDTO.getId(),espacioDTO.getNombre(),espacioDTO.getDescripcion());
        return espacioVO;
    }


}
