package com.mkStudio.MKStudio.Material.Dominio.Mapper;

import com.mkStudio.MKStudio.Material.Dominio.DTO.MaterialDTO;
import com.mkStudio.MKStudio.Material.Dominio.MaterialVO;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class MaterialMapper {

    /**
     * Conversor de MaterialVO a MaterialDTO
     * @param vo
     * @return
     */
    public static MaterialDTO toDTO(MaterialVO vo) {
        return new MaterialDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withDescripcion(vo.getDescripcion());
    }

    /**
     * Conversor de MaterialDTO a MaterialVO
     * @param dto
     * @return
     */
    public static MaterialVO fromDTO(MaterialDTO dto) {
        return new MaterialVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withDescripcion(dto.getDescripcion());
    }
}
