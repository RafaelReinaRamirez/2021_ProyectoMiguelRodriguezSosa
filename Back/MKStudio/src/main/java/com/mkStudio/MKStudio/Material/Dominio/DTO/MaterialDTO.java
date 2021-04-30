package com.mkStudio.MKStudio.Material.Dominio.DTO;

import com.mkStudio.MKStudio.Reserva.Dominio.DTO.ReservaDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase MaterialDTO
 */
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@AllArgsConstructor
public class MaterialDTO {

    /**
     * id tipo int
     */
    private int id;

    /**
     * nombre tipo String
     */
    private String nombre;

    /**
     * descripcion tipo String
     */
    private String descripcion;

    /**
     * reservas tipo List<ReservaDTO>
     */
    private List<ReservaDTO> reservas = new ArrayList<>();

    /**
     * Constructor de EspacioDTO
     * @param nombre
     * @param descripcion
     */
    public MaterialDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
