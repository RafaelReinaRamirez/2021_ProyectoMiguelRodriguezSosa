package com.mkStudio.MKStudio.Material.Dominio;

import com.mkStudio.MKStudio.Reserva.Dominio.ReservaVO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase EventoVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name = "Espacio")
public class MaterialVO {

    /**
     * id tipo int el cual es el Id en la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * nombre tipo String
     */
    @Column(length = 500)
    private String nombre;

    /**
     * descripcion tipo String
     */
    @Column(length = 500)
    private String descripcion;

    /**
     * reservas tipo List<ReservaVO>
     */
    @OneToMany(mappedBy = "idreserva", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "RESERVA_ID_FK"))
    private List<ReservaVO> reservas = new ArrayList<>();

    /**
     * Constructor de MaterialVO
     * @param nombre
     * @param descripcion
     */
    public MaterialVO(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}