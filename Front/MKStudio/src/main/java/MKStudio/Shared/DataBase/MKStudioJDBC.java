package MKStudio.Shared.DataBase;

import MKStudio.GestionEspacios.model.dto.EspacioDTO;
import MKStudio.GestionEspacios.model.vo.EspacioVO;
import MKStudio.GestionMateriales.model.dto.MaterialDTO;
import MKStudio.GestionMateriales.model.vo.MaterialVO;
import MKStudio.GestionReservas.model.dto.ReservaDTO;
import MKStudio.GestionReservas.model.vo.ReservaVO;
import MKStudio.GestionUsuarios.model.Conversor;
import MKStudio.GestionUsuarios.model.dto.UsuarioDTO;
import MKStudio.GestionUsuarios.model.vo.UsuarioVO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class MKStudioJDBC implements Dao {

    private static Connection conn = null;

    public MKStudioJDBC() throws IOException {
        conn = Conexion.ConexionJDBC();
    }

    @Override
    public boolean registrarUsuarios(UsuarioVO usuarioVO) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO usuario (nombre, password, email, fecha_nacimiento, telefono, rol) " +
                    "VALUES (?,?,?,?,?,?)");
            ps.setString(1, usuarioVO.getNombre());
            ps.setString(2, usuarioVO.getPassword());
            ps.setString(3, usuarioVO.getEmail());
            ps.setDate(4, usuarioVO.getFecha_nacimiento());
            ps.setInt(5, usuarioVO.getTelefono());
            ps.setString(6, usuarioVO.getRol());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo introducir el usuario.");
            alert.showAndWait();
            return false;
        }
    }

    @Override
    public ObservableList<UsuarioVO> recuperarUsuarios() {
        ObservableList<UsuarioVO> listaUsuarios = FXCollections.observableArrayList();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM usuario");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UsuarioVO usuarioVO = new UsuarioVO(resultSet.getInt("id"),resultSet.getString("nombre"), resultSet.getString("password"), resultSet.getString("email"), resultSet.getDate("fecha_nacimiento"), resultSet.getInt("telefono"), resultSet.getString("rol"));
                listaUsuarios.add(usuarioVO);
            }

        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
        }

        return listaUsuarios;
    }

    @Override
    public UsuarioVO recuperarUsuario() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        UsuarioVO usuarioVO = null;
        try {
            ps = conn.prepareStatement("select * from usuario");
            rs = ps.executeQuery();
            UsuarioDTO usuarioDTO = new UsuarioDTO(rs.getString("nombre"), rs.getString("password"), rs.getString("email"), (LocalDate) rs.getObject("fecha_nacimiento"), rs.getInt("telefono"), rs.getString("rol"));
            usuarioVO = Conversor.dtoToVo(usuarioDTO);
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
        }
        return usuarioVO;
    }

    @Override
    public boolean guardarMaterial(MaterialDTO materialDTO) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO material (nombre, descripcion, marca) " +
                    "VALUES (?,?,?)");
            ps.setString(1, materialDTO.getNombre());
            ps.setString(2, materialDTO.getDescripcion());
            ps.setString(3, materialDTO.getDescripcion());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo introducir el usuario.");
            alert.showAndWait();
            return false;
        }
    }

    @Override
    public void eliminarMaterial(MaterialDTO materialDTO) {
        Statement ps = null;

        try {
            ps = conn.createStatement();
            ps.executeUpdate("DELETE FROM material WHERE id= " + materialDTO.getId() + ";");
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo eliminar el material.");
            alert.showAndWait();
        }
    }

    @Override
    public void editarMaterial(MaterialDTO materialDTO) {
        Statement ps = null;

        try {
            ps = conn.createStatement();
            ps.executeUpdate("UPDATE material SET nombre= '" + materialDTO.getNombre() + "', descripcion= '" + materialDTO.getDescripcion() + "', marca= '" + materialDTO.getMarca() + "' WHERE id= " + materialDTO.getId() + ";");
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo editar el material.");
            alert.showAndWait();
        }
    }

    @Override
    public ObservableList<MaterialDTO> recuperarMateriales() {
        ObservableList<MaterialDTO> listaMateriales = FXCollections.observableArrayList();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM material");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MaterialDTO materialDTO = new MaterialDTO(resultSet.getInt("id"),resultSet.getString("nombre"), resultSet.getString("descripcion"), resultSet.getString("marca"));
                listaMateriales.add(materialDTO);
            }

        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
        }

        return listaMateriales;
    }

    public ObservableList<String> recuperarMaterialesNombre() {
        ObservableList<String> listaMateriales = FXCollections.observableArrayList();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement("SELECT nombre FROM material");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombre = new String(resultSet.getString("nombre"));
                listaMateriales.add(nombre);
            }

        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
        }

        return listaMateriales;
    }

    @Override
    public boolean guardarEspacio(EspacioDTO espacioDTO) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO espacio (nombre, descripcion) " +
                    "VALUES (?,?)");
            ps.setString(1, espacioDTO.getNombre());
            ps.setString(2, espacioDTO.getDescripcion());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo guardar el espacio.");
            alert.showAndWait();
            return false;
        }
    }

    @Override
    public void eliminarEspacio(EspacioDTO espacioDTO) {
        Statement ps = null;

        try {
            ps = conn.createStatement();
            ps.executeUpdate("DELETE FROM espacio WHERE id= " + espacioDTO.getId() + ";");
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo eliminar el espacio.");
            alert.showAndWait();
        }
    }

    @Override
    public void editarEspacio(EspacioDTO espacioDTO) {
        Statement ps = null;

        try {
            ps = conn.createStatement();
            ps.executeUpdate("UPDATE espacio SET nombre= '" + espacioDTO.getNombre() + "', descripcion= '" + espacioDTO.getDescripcion() + "' WHERE id= " + espacioDTO.getId() + ";");
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo editar el espacio.");
            alert.showAndWait();
        }
    }

    @Override
    public ObservableList<EspacioDTO> recuperarEspacios() {
        ObservableList<EspacioDTO> listaEspacios = FXCollections.observableArrayList();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM espacio");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                EspacioDTO espacioDTO = new EspacioDTO(resultSet.getInt("id"),resultSet.getString("nombre"), resultSet.getString("descripcion"));
                listaEspacios.add(espacioDTO);
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
        }
        return listaEspacios;
    }

    public ObservableList<String> recuperarEspaciosNombre() {
        ObservableList<String> listaEspacios = FXCollections.observableArrayList();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement("SELECT nombre FROM espacio");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String nombre = new String(resultSet.getString("nombre"));
                listaEspacios.add(nombre);
            }

        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
        }

        return listaEspacios;
    }

    @Override
    public boolean guardarReserva(ReservaDTO reservaDTO) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO reserva (nombre, fecha, descripcion, usuario, espacio, material, aprobado) " +
                    "VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, reservaDTO.getNombre());
            ps.setDate(2, reservaDTO.getFecha());
            ps.setString(3, reservaDTO.getDescripcion());
            ps.setInt(4, reservaDTO.getUsuario());
            ps.setInt(5, reservaDTO.getEspacio());
            ps.setInt(6, reservaDTO.getMaterial());
            ps.setBoolean(7, reservaDTO.getAprobado());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo solicitar la reserva.");
            alert.showAndWait();
            return false;
        }
    }

    @Override
    public void eliminarReserva(ReservaDTO reservaDTO) {
        Statement ps = null;

        try {
            ps = conn.createStatement();
            ps.executeUpdate("DELETE FROM reserva WHERE id= " + reservaDTO.getId() + ";");
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo denegar la reserva.");
            alert.showAndWait();
        }
    }

    @Override
    public void editarReserva(ReservaDTO reservaDTO) {
        Statement ps = null;
        try {
            ps = conn.createStatement();
            ps.executeUpdate("UPDATE reserva SET aprobado= 1 WHERE id= " + reservaDTO.getId() + ";");
            ps.close();
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Problem");
            alert.setHeaderText("No se pudo aprobar la reserva.");
            alert.showAndWait();
        }
    }

    @Override
    public ObservableList<ReservaDTO> recuperarReservas() {
        ObservableList<ReservaDTO> listaReservas = FXCollections.observableArrayList();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM reserva");
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ReservaDTO reservaDTO = new ReservaDTO(resultSet.getInt("id"),resultSet.getString("nombre"),  resultSet.getDate("fecha"), resultSet.getString("descripcion"),resultSet.getInt("usuario"),resultSet.getInt("espacio"),resultSet.getInt("material"),resultSet.getBoolean("aprobado"));
                listaReservas.add(reservaDTO);
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
        }
        return listaReservas;
    }

    @Override
    public ObservableList<ReservaDTO> recuperarReservasUser(UsuarioDTO usuarioDTO) {
        ObservableList<ReservaDTO> listaReservas = FXCollections.observableArrayList();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = conn.prepareStatement("SELECT * FROM reserva WHERE usuario = " + usuarioDTO.getId());
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ReservaDTO reserva = new ReservaDTO(resultSet.getInt("id"),resultSet.getString("nombre"),  resultSet.getDate("fecha"), resultSet.getString("descripcion"),resultSet.getInt("usuario"),resultSet.getInt("espacio"),resultSet.getInt("material"),resultSet.getBoolean("aprobado"));
                listaReservas.add(reserva);
            }
        } catch (SQLException e) {
            System.out.println("ERROR SQL --> Código: " + e.getErrorCode() + "Mensaje: " + e.getMessage());
        }
        return listaReservas;
    }
}
