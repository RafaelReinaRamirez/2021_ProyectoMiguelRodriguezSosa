package MKStudio.GestionMateriales.model;

import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.GestionMateriales.model.vo.MaterialVO;

/**
 * Clase conversor de la entidad Material. Convierte tipos VO a DTO y viceversa
 * según los datos que maneja la aplicación (DTO) y los que se persisten en la BBDD (VO).
 */
public class Conversor {

    public Conversor() {
    }

    /**
     * Convierte un objeto tipo MaterialDTO a MaterialVO
     *
     * @param materialVO
     * @return materialDTO
     */
    public MaterialDTO dtoToVo(MaterialVO materialVO) {
        MaterialDTO materialDTO = new MaterialDTO(materialVO.getId(), materialVO.getNombre(), materialVO.getDescripcion(),materialVO.getMarca());
        return materialDTO;
    }

    /**
     * Convierte un objeto tipo MaterialVO a MaterialDTO
     *
     * @param materialDTO
     * @return materialVO
     */
    public MaterialVO voToDto(MaterialDTO materialDTO) {
        MaterialVO materialVO = new MaterialVO(materialDTO.getId(),materialDTO.getNombre(),materialDTO.getDescripcion(),materialDTO.getMarca());
        return materialVO;
    }
}
