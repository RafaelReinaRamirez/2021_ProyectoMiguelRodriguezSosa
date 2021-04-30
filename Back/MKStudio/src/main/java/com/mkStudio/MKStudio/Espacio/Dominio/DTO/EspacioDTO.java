package com.mkStudio.MKStudio.Espacio.Dominio.DTO;

import com.mkStudio.MKStudio.Reserva.Dominio.DTO.ReservaDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase EspacioDTO
 */
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@AllArgsConstructor
public class EspacioDTO {

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
    public EspacioDTO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
