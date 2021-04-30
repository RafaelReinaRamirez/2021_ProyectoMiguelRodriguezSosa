package com.mkStudio.MKStudio.Usuario.Dominio.DTO;

import com.mkStudio.MKStudio.Reserva.Dominio.DTO.ReservaDTO;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase UsuarioDTO
 */
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@AllArgsConstructor
public class UsuarioDTO implements Dto, Serializable {

    /**
     * id tipo int
     */
    private int id;

    /**
     * nombre tipo String
     */
    private String nombre;

    /**
     * password tipo String
     */
    private String password;

    /**
     * email tipo String
     */
    private String email;

    /**
     * fecha_nacimiento tipo Date
     */
    private Date fecha_nacimiento;

    /**
     * telefono tipo int
     */
    private int telefono;

    /**
     * rol tipo String
     */
    private String rol;

    /**
     * reservas tipo List<ReservaDTO>
     */
    private List<ReservaDTO> reservas = new ArrayList<>();

    /**
     * Constructor de UsuarioDTO
     * @param id
     * @param nombre
     * @param password
     * @param email
     * @param fecha_nacimiento
     * @param telefono
     * @param rol
     */
    public UsuarioDTO(int id, String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
    }

    /**
     * Constructor de UsuarioDTO
     * @param nombre
     * @param password
     * @param email
     * @param fecha_nacimiento
     * @param telefono
     * @param rol
     */
    public UsuarioDTO(String nombre, String password, String email, Date fecha_nacimiento, int telefono, String rol) {
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
    }
}
