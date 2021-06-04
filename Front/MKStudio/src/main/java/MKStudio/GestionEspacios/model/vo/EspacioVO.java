package MKStudio.GestionEspacios.model.vo;

import java.io.Serializable;

/**
 * Tipo VO de la entidad Espacio. Es el tipo de dato que se utiliza para persistir en la BBDD.
 */
public class EspacioVO implements Serializable {

    private int id;
    private String nombre;
    private String descripcion;

    public EspacioVO() {
    }

    /**
     * @param id
     * @param nombre
     * @param descripcion
     */
    public EspacioVO(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "EspacioVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
