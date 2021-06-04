package MKStudio.GestionChat.model.vo;


/**
 * CanalVO
 */

import java.io.Serializable;

public class CanalVO implements Serializable {

    private int id;
    private String nombre;
    private Integer puerto;

    /**
     * @param id
     * @param nombre
     */
    public CanalVO(int id, String nombre, Integer puerto) {
        this.id = id;
        this.nombre = nombre;
        this.puerto = puerto;
    }

    public CanalVO() {
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

    public Integer getPuerto() {
        return puerto;
    }

    public void setPuerto(Integer puerto) {
        this.puerto = puerto;
    }

    @Override
    public String toString() {
        return "CanalVO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", historial=" +
                '}';
    }
}
