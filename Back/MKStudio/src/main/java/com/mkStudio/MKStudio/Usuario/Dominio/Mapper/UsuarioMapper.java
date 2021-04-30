package com.mkStudio.MKStudio.Usuario.Dominio.Mapper;

import com.mkStudio.MKStudio.Usuario.Dominio.DTO.UsuarioDTO;
import com.mkStudio.MKStudio.Usuario.Dominio.UsuarioVO;

/**
 * Clase Mapper la cual tiene los conversores
 */
public class UsuarioMapper {

    /**
     * Conversor de UsuarioVO a UsuarioDTO
     * @param vo
     * @return
     */
    public static UsuarioDTO toDTO(UsuarioVO vo) {
        return new UsuarioDTO()
                .withId(vo.getId())
                .withNombre(vo.getNombre())
                .withPassword(vo.getPassword())
                .withEmail(vo.getEmail())
                .withFecha_nacimiento(vo.getFecha_nacimiento())
                .withRol(vo.getRol());
    }

    /**
     * Conversor de UsuarioDTO a UsuarioVO
     * @param dto
     * @return
     */
    public static UsuarioVO fromDTO(UsuarioDTO dto) {
        return new UsuarioVO()
                .withId(dto.getId())
                .withNombre(dto.getNombre())
                .withPassword(dto.getPassword())
                .withEmail(dto.getEmail())
                .withFecha_nacimiento(dto.getFecha_nacimiento())
                .withRol(dto.getRol());
    }
}
