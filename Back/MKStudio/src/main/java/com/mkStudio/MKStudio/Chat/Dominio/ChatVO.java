package com.mkStudio.MKStudio.Chat.Dominio;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.With;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Clase ChatVO para trabajar con la base de datos
 */
@NoArgsConstructor
@Getter
@Setter
@With
@Entity(name = "Chat")
public class ChatVO implements Serializable {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * nombre tipo String
     */
    @Column(unique = true, nullable = false)
    private String nombre;

    /**
     * puerto tipo int
     */
    @Column(nullable = false)
    private int puerto;

    /**
     * Constructor de ChatVO
     * @param nombre
     * @param puerto
     */
    public ChatVO(String nombre, int puerto) {
        this.nombre = nombre;
        this.puerto = puerto;
    }

    /**
     * Constructor de ChatVO
     * @param id
     * @param nombre
     */
    public ChatVO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    /**
     * Constructor de ChatVO
     * @param id
     * @param nombre
     * @param puerto
     */
    public ChatVO(int id, String nombre, int puerto) {
        this.id = id;
        this.nombre = nombre;
        this.puerto = puerto;
    }

    /**
     * Equals de ChatVO
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatVO chatVO = (ChatVO) o;
        return id == chatVO.id && nombre.equals(chatVO.nombre);
    }

    /**
     * HashCode de ChatVO
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
