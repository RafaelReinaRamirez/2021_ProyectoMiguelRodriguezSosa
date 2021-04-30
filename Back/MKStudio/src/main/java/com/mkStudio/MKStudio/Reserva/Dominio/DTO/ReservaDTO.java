package com.mkStudio.MKStudio.Reserva.Dominio.DTO;

import com.mkStudio.MKStudio.Espacio.Dominio.DTO.EspacioDTO;
import com.mkStudio.MKStudio.Material.Dominio.DTO.MaterialDTO;
import com.mkStudio.MKStudio.Usuario.Dominio.DTO.UsuarioDTO;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase EventoDTO
 */
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@AllArgsConstructor
public class ReservaDTO {

    /**
     * id tipo int
     */
    private int id;

    /**
     * nombre tipo String
     */
    private String nombre;

    /**
     * fecha tipo Date
     */
    private Date fecha;

    /**
     * artistas tipo List<UsuarioDTO>
     */
    private List<UsuarioDTO> artistas = new ArrayList<>();

    /**
     * materiales tipo List<MaterialDTO>
     */
    private List<MaterialDTO> materiales = new ArrayList<>();

    /**
     * sala tipo EspacioDTO
     */
    private EspacioDTO sala;

    /**
     * descripcion tipo String
     */
    private String descripcion;

    /**
     * Constructor de ReservaDTO
     * @param nombre
     * @param fecha
     * @param descripcion
     */
    public ReservaDTO(String nombre, Date fecha, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}
