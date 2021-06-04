package MKStudio.GestionUsuarios.model.dto;

import MKStudio.GestionReservas.model.dto.ReservaDTO;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.time.LocalDate;

public class UsuarioDTO {

    private IntegerProperty id;
    private StringProperty nombre;
    private StringProperty password;
    private StringProperty email;
    private ObjectProperty<LocalDate> fecha_nacimiento;
    private IntegerProperty telefono;
    private StringProperty rol;

    public UsuarioDTO() {
    }

    public UsuarioDTO(StringProperty nombre, StringProperty password, StringProperty email, ObjectProperty<LocalDate> fecha_nacimiento, IntegerProperty telefono, StringProperty rol) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
        this.telefono = telefono;
        this.rol = rol;
    }

    public UsuarioDTO(String nombre, String password, String email, LocalDate fecha_nacimiento, int telefono, String rol) {
        this.id = new SimpleIntegerProperty((int) Math.abs(System.currentTimeMillis() / 10000));
        this.nombre = new SimpleStringProperty(nombre);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.fecha_nacimiento = new SimpleObjectProperty<LocalDate>(fecha_nacimiento);
        this.telefono = new SimpleIntegerProperty(telefono);
        this.rol = new SimpleStringProperty(rol);
    }

    public UsuarioDTO(int id, String nombre, String password, String email, LocalDate fecha_nacimiento, int telefono, String rol) {
        this.id = new SimpleIntegerProperty(id);
        this.nombre = new SimpleStringProperty(nombre);
        this.password = new SimpleStringProperty(password);
        this.email = new SimpleStringProperty(email);
        this.fecha_nacimiento = new SimpleObjectProperty<LocalDate>(fecha_nacimiento);
        this.telefono = new SimpleIntegerProperty(telefono);
        this.rol = new SimpleStringProperty(rol);
    }

    public int getId() {
        return id.getValue();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getNombre() {
        return nombre.getValue();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public StringProperty nombreProperty() {
        return nombre;
    }

    public String getPassword() {
        return password.getValue();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public String getEmail() {
        return email.getValue();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public LocalDate getFecha_nacimiento() {
        return fecha_nacimiento.getValue();
    }

    public void setFecha_nacimiento(LocalDate fecha_nacimiento) {
        this.fecha_nacimiento.set(fecha_nacimiento);
    }

    public ObjectProperty<LocalDate> fecha_nacimientoProperty() {
        return fecha_nacimiento;
    }

    public int getTelefono() {
        return telefono.getValue();
    }

    public void setTelefono(int telefono) {
        this.telefono.set(telefono);
    }

    public IntegerProperty telefonoProperty() {
        return telefono;
    }

    public String getRol() {
        return rol.getValue();
    }

    public void setRol(String rol) {
        this.rol.set(rol);
    }

    public StringProperty rolProperty() {
        return rol;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" +
                "id=" + id +
                "\n, nombre=" + nombre +
                "\n, password=" + password +
                "\n, email=" + email +
                "\n, fecha_nacimiento=" + fecha_nacimiento +
                "\n, telefono=" + telefono +
                "\n, rol=" + rol +
                '}';
    }
}
