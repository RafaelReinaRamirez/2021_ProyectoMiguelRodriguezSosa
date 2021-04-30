package com.mkStudio.MKStudio.Reserva.Dominio;

import com.mkStudio.MKStudio.Espacio.Dominio.EspacioVO;
import com.mkStudio.MKStudio.Material.Dominio.MaterialVO;
import com.mkStudio.MKStudio.Usuario.Dominio.UsuarioVO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase ReservaVO para trabajar con la base de datos
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@With
@EqualsAndHashCode
@Entity(name = "Reserva")
public class ReservaVO {

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
     * fecha tipo Date
     */
    @Column(length = 500)
    private Date fecha;

    /**
     * artistas tipo List<UsuarioVO>
     */
    @OneToMany(mappedBy = "idusuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "USUARIO_ID_FK"))
    private List<UsuarioVO> artistas = new ArrayList<>();

    /**
     * materiales tipo List<MaterialVO>
     */
    @OneToMany(mappedBy = "idusuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "MATERIAL_ID_FK"))
    private List<MaterialVO> materiales = new ArrayList<>();

    /**
     * sala tipo EspacioVO
     */
    @OneToOne(mappedBy = "idsala", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey(name = "SALA_ID_FK"))
    private EspacioVO sala;

    /**
     * descripcion tipo String
     */
    @Column(length = 500)
    private String descripcion;

    /**
     * Constructor de ReservaVO
     * @param nombre
     * @param fecha
     * @param descripcion
     */
    public ReservaVO(String nombre, Date fecha, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }
}