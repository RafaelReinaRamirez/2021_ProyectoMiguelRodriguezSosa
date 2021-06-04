package MKStudio.GestionReservas.model.dto;

import MKStudio.GestionEspacios.model.dto.EspacioDTO;
import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import javafx.beans.property.*;

import java.sql.Date;
import java.time.LocalDate;

/**
 * Tipo DTO de la entidad Material. Es el tipo de dato que maneja la aplicación desde el front.
 */
public class ReservaDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private ObjectProperty<Date> fecha;
    private StringProperty descripcion;
    private IntegerProperty usuario;
    private IntegerProperty espacio;
    private IntegerProperty material;
    private BooleanProperty aprobado;

    public ReservaDTO() {
    }

    /**
     * @param nombre
     * @param fecha
     * @param descripcion
     * @param usuario
     * @param espacio
     * @param material
     * @param aprobado
     */
    public ReservaDTO(StringProperty nombre, ObjectProperty<Date> fecha, StringProperty descripcion, IntegerProperty usuario, IntegerProperty espacio, IntegerProperty material, BooleanProperty aprobado) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.espacio = espacio;
        this.material = material;
        this.aprobado = aprobado;
    }

    public ReservaDTO(String nombre, Date fecha, String descripcion, int usuario, int espacio, int material, Boolean aprobado) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.fecha = new SimpleObjectProperty<Date>(fecha);
        this.descripcion = new SimpleStringProperty(descripcion);
       this.usuario = new SimpleIntegerProperty(usuario);
        this.espacio = new SimpleIntegerProperty(espacio);
        this.material = new SimpleIntegerProperty(material);
        this.aprobado = new SimpleBooleanProperty(aprobado);
    }

    public ReservaDTO(int id, String nombre, Date fecha, String descripcion, int usuario, int espacio, int material, Boolean aprobado) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.fecha = new SimpleObjectProperty(fecha);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.usuario = new SimpleIntegerProperty(usuario);
        this.espacio = new SimpleIntegerProperty(espacio);
        this.material = new SimpleIntegerProperty(material);
        this.aprobado = new SimpleBooleanProperty(aprobado);
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

    public Date getFecha() {
        return fecha.get();
    }

    public ObjectProperty<Date> fechaProperty() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha.set(fecha);
    }

    public boolean isAprobado() {
        return aprobado.get();
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado.set(aprobado);
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

    public int getUsuario() {
        return usuario.getValue();
    }

    public void setUsuario(int usuario) {
        this.usuario.set(usuario);
    }

    public IntegerProperty usuarioProperty() {
        return usuario;
    }

    public int getEspacio() {
        return espacio.getValue();
    }

    public void setEspacio(int espacio) {
        this.espacio.set(espacio);
    }

    public IntegerProperty espacioProperty() {
        return espacio;
    }

    public int getMaterial() {
        return material.getValue();
    }

    public void setMaterial(int material) {
        this.material.set(material);
    }

    public IntegerProperty materialProperty() {
        return material;
    }

    public Boolean getAprobado() {
        return aprobado.get();
    }

    public void setAprobado(Boolean aprobado) {
        this.aprobado.set(aprobado);
    }

    public BooleanProperty aprobadoProperty() {
        return aprobado;
    }

    @Override
    public String toString() {
        return "ReservaDTO{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", fecha=" + fecha +
                ", descripcion=" + descripcion +
                ", usuario=" + usuario +
                ", espacio=" + espacio +
                ", material=" + material +
                ", aprobado=" + aprobado +
                '}';
    }
}
