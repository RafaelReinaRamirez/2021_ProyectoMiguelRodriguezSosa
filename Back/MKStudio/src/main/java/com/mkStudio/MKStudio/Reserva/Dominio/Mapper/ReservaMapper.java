package com.mkStudio.MKStudio.Reserva.Dominio.Mapper;

import com.mkStudio.MKStudio.Reserva.Dominio.DTO.ReservaDTO;
import com.mkStudio.MKStudio.Reserva.Dominio.ReservaVO;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class ReservaMapper {

    /**
     * Conversor de ReservaVO a ReservaDTO
     * @param vo
     * @return
     */
    public static ReservaDTO toDTO(ReservaVO vo) {
        return new ReservaDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withFecha(vo.getFecha())
                .withDescripcion(vo.getDescripcion());
    }

    /**
     * Conversor de ReservaDTO a ReservaVO
     * @param dto
     * @return
     */
    public static ReservaVO fromDTO(ReservaDTO dto) {
        return new ReservaVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withFecha(dto.getFecha())
                .withDescripcion(dto.getDescripcion());
    }
}
