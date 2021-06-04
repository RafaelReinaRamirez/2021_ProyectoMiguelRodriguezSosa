package MKStudio.GestionMateriales.model.dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Tipo DTO de la entidad Material. Es el tipo de dato que maneja la aplicación desde el front.
 */
public class MaterialDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty descripcion;
    private StringProperty marca;

    public MaterialDTO() {
    }

    /**
     * @param nombre
     * @param descripcion
     * @param marca
     */
    public MaterialDTO(StringProperty nombre, StringProperty descripcion, StringProperty marca) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
    }

    public MaterialDTO(String nombre, String descripcion,String marca) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.marca = new SimpleStringProperty(marca);
    }

    public MaterialDTO(int id, String nombre, String descripcion,String marca) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.marca = new SimpleStringProperty(marca);
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

    public String getMarca() {
        return marca.get();
    }

    public void setMarca(String marca) {
        this.marca.set(marca);
    }

    public StringProperty marcaProperty() {
        return marca;
    }

    @Override
    public String toString() {
        return "MaterialDTO{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", descripcion=" + descripcion +
                ", marca=" + marca +
                '}';
    }
}
