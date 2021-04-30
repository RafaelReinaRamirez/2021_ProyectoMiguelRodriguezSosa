package com.mkStudio.MKStudio.Chat.Dominio.DTO;

import lombok.*;

/**
 * Clase ChatDTO
 */
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@AllArgsConstructor
public class ChatDTO {
    /**
     * id tipo int
     */
    private int id;

    /**
     * nombre tipo String
     */
    private String nombre;

    /**
     * puerto tipo int
     */
    private int puerto;

    /**
     * Constructor de ChatDTO
     *
     * @param nombre
     * @param puerto
     */
    public ChatDTO(String nombre, int puerto) {
        this.nombre = nombre;
        this.puerto = puerto;
    }
}
