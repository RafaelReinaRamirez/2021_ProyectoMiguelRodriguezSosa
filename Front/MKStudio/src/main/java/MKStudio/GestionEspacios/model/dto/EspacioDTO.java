package MKStudio.GestionEspacios.model.dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Tipo DTO de la entidad Espacio. Es el tipo de dato que maneja la aplicación desde el front.
 */
public class EspacioDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty descripcion;

    public EspacioDTO() {
    }

    /**
     * @param nombre
     * @param descripcion
     */
    public EspacioDTO(StringProperty nombre, StringProperty descripcion) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public EspacioDTO(String nombre, String descripcion) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public EspacioDTO(int id, String nombre, String descripcion) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
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

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public StringProperty descripcionProperty() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "EspacioDTO{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                '}';
    }
}
