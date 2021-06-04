package MKStudio.GestionMateriales.model.vo;

import java.io.Serializable;

/**
 * Tipo VO de la entidad Material. Es el tipo de dato que se utiliza para persistir en la BBDD.
 */
public class MaterialVO implements Serializable {

    private int id;
    private String nombre;
    private String descripcion;
    private String marca;

    public MaterialVO() {
    }

    /**
     * @param id
     * @param nombre
     * @param descripcion
     * @param marca
     */
    public MaterialVO(int id, String nombre, String descripcion,String marca) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public MaterialVO(String nombre, String descripcion,String marca) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "MaterialVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }
}
