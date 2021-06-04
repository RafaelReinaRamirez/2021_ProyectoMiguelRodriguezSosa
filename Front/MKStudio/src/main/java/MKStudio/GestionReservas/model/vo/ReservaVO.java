package MKStudio.GestionReservas.model.vo;

import MKStudio.GestionEspacios.model.dto.EspacioDTO;
import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import java.io.Serializable;
import java.sql.Date;

/**
 * Tipo VO de la entidad Material. Es el tipo de dato que se utiliza para persistir en la BBDD.
 */
public class ReservaVO implements Serializable {

    private int id;
    private String nombre;
    private Date fecha;
    private String descripcion;
    private int usuario;
    private int espacio;
    private int material;
    private Boolean aprobado;

    public ReservaVO() {
    }

    public ReservaVO(int id, String nombre, Date fecha, String descripcion, int usuario, int espacio, int material, Boolean aprobado) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.espacio = espacio;
        this.material = material;
        this.aprobado = aprobado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getEspacio() {
        return espacio;
    }

    public void setEspacio(int espacio) {
        this.espacio = espacio;
    }

    public int getMaterial() {
        return material;
    }

    public void setMaterial(int material) {
        this.material = material;
    }

    public Boolean getAprobado() {
        return aprobado;
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado = aprobado;
    }

    @Override
    public String toString() {
        return "ReservaVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", descripcion='" + descripcion + '\'' +
                ", usuario=" + usuario +
                ", espacio=" + espacio +
                ", material=" + material +
                ", aprobado=" + aprobado +
                '}';
    }
}