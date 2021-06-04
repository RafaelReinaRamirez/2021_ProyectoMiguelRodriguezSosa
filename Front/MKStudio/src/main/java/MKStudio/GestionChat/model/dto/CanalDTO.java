package MKStudio.GestionChat.model.dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Clase canal DTO
 */
public class CanalDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private IntegerProperty puerto;

    /**
     * @param nombre
     */
    public CanalDTO(String nombre, int puerto) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        ;
        this.nombre = new SimpleStringProperty(nombre);
        this.puerto = new SimpleIntegerProperty(puerto);
    }

    public CanalDTO(Integer id, String nombre, Integer puerto) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.puerto = new SimpleIntegerProperty(puerto);
    }

    public CanalDTO() {
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public int getPuerto() {
        return puerto.get();
    }

    public void setPuerto(int puerto) {
        this.puerto.set(puerto);
    }

    public IntegerProperty puertoProperty() {
        return puerto;
    }

    @Override
    public String toString() {
        return "CanalDTO{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", puerto=" + puerto +
                '}';
    }
}
