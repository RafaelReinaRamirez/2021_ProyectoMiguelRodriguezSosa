package com.mkStudio.MKStudio.Espacio.Dominio.Mapper;

import com.mkStudio.MKStudio.Espacio.Dominio.DTO.EspacioDTO;
import com.mkStudio.MKStudio.Espacio.Dominio.EspacioVO;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class EspacioMapper {

    /**
     * Conversor de EspacioVO a EspacioDTO
     * @param vo
     * @return
     */
    public static EspacioDTO toDTO(EspacioVO vo) {
        return new EspacioDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withDescripcion(vo.getDescripcion());
    }

    /**
     * Conversor de EspacioDTO a EspacioVO
     * @param dto
     * @return
     */
    public static EspacioVO fromDTO(EspacioDTO dto) {
        return new EspacioVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withDescripcion(dto.getDescripcion());
    }
}
