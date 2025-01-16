/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionBD;

import ConexionBaseDtos.ConfigMySql;
import jakarta.jms.Connection;
import ConexionBaseDtos.ConfigMySql;
//import com.mysql.cj.jdbc.CallableStatement;
import datos.Cliente;
import datos.Doctor;
import datos.Especialidad;
import datos.Horario;
import interfaces.InterfacesHorario;
import jakarta.jms.JMSException;
import jakarta.resource.cci.ResultSet;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class MetodosHorario implements interfaces.InterfacesHorario {

    Connection con = null;
    ConfigMySql cn = new ConfigMySql();
    java.sql.ResultSet resultado = null;
    PreparedStatement st = null;
    PreparedStatement ps;
    java.sql.ResultSet rs;

    @Override
    public void insertarHorario(int idPaciente, int idDoctor, int idEspecialidad, String fecha, String hora) {
        String sql = "CALL kl_I77Z5(?, ?, ?, ?, ?)";

        try {

            ps = cn.conectar().prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ps.setInt(2, idDoctor);
            ps.setInt(3, idEspecialidad);
            ps.setString(4, fecha);
            ps.setString(5, hora);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo apropiado de la excepción en tu aplicación
        }

    }

    @Override
    public boolean citaExistente(Date fechaHora, int idDoctor) {
        String sql = "CALL kl_M03B2(?, ?, ?, ?)"; // Llamada al procedimiento almacenado

        try ( // Usar try-with-resources para cerrar la conexión
                CallableStatement cs = cn.conectar().prepareCall(sql)) {

            cs.setDate(1, new java.sql.Date(fechaHora.getTime())); // Fecha
            cs.setTime(2, new java.sql.Time(fechaHora.getTime())); // Hora
            cs.setInt(3, idDoctor); // ID del doctor
            cs.registerOutParameter(4, java.sql.Types.BOOLEAN); // Registrar el parámetro de salida

            cs.executeUpdate();  // Ejecutar el procedimiento almacenado

            // Obtener el valor del parámetro OUT (p_Existe)
            boolean existe = cs.getBoolean(4);

            return existe;  // Retorna true si la cita ya existe, false si no
        } catch (SQLException e) {
            e.printStackTrace(); // Manejo de la excepción
        }

        return false; // Si ocurre algún error, retorna false
    }

//    @Override
//    public boolean citaExistente(Date fechaHora, int idDoctor) {
//        String sql = "SELECT COUNT(*) FROM t_M2Wq1 WHERE Fecha = ? AND Hora = ? AND IDdoctor = ?";
//
//        try {
//            ps = cn.conectar().prepareStatement(sql);
//            ps.setDate(1, new java.sql.Date(fechaHora.getTime()));
//            ps.setTime(2, new java.sql.Time(fechaHora.getTime()));
//            ps.setInt(3, idDoctor);
//
//            try (java.sql.ResultSet rs = ps.executeQuery()) {
//                if (rs.next()) {
//                    int count = rs.getInt(1);
//                    return count > 0; // Retorna true si ya existe al menos una cita en la misma fecha, hora e IDdoctor
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//
//    }
    @Override
    public List<Horario> obtenerHorariosDoctor(int doctorID) {
        // El SQL para llamar al procedimiento almacenado
        String sql = "{CALL kl_ZV32P(?)}";

        List<Horario> horarios = new ArrayList<>();

        try (// Asegúrate de cerrar la conexión correctamente
                CallableStatement cs = cn.conectar().prepareCall(sql)) {

            cs.setInt(1, doctorID); // Establecer el parámetro de entrada para el procedimiento almacenado

            try (java.sql.ResultSet rs = cs.executeQuery()) { // Ejecutar el procedimiento almacenado y obtener el resultado
                while (rs.next()) {
                    Horario horario = new Horario();
                    // Configurar el objeto Horario con los datos del ResultSet

                    horario.setCliente(new Cliente());
                    horario.getCliente().setNombre(rs.getString("Nombre"));
                    horario.getCliente().setApellidos(rs.getString("Apellidos"));
                    horario.getCliente().setIdentificacion(rs.getString("Identificacion"));
                    horario.setFecha(rs.getDate("Fecha"));
                    horario.setHora(rs.getTime("Hora"));

                    // Agregar el objeto Horario a la lista
                    horarios.add(horario);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones (lanzar o registrar, según sea necesario)
        }

        return horarios;
    }

//    @Override
//    public List<Horario> listHorario(int id) {
//        List<Horario> horario = new ArrayList<>();
//        String query = "select *from t_M2Wq1   WHERE IDPaciente= ?";
//        try (PreparedStatement ps = cn.conectar().prepareStatement(query)) {
//            ps.setInt(1, id);
//
//            try (java.sql.ResultSet rs = ps.executeQuery()) {
//                while (rs.next()) {
//                    Horario horarioC = new Horario();
//                    // Configurar el objeto Horario con los datos del ResultSet
//
//                    horarioC.setIDHorario(rs.getInt("IDHorario"));
//                    horarioC.setCliente(new Cliente());
//                    horarioC.getCliente().setIDPaciente(rs.getInt("IDPaciente"));
//                    horarioC.setDoctor(new Doctor());
//                    horarioC.getDoctor().setIDdoctor(rs.getInt("IDdoctor"));
//                    horarioC.setEspecialidad(new Especialidad());
//                    horarioC.getEspecialidad().setCodigo(rs.getInt("IDEspecialidad"));
//                    horarioC.setFecha(rs.getDate("Fecha"));
//                    horarioC.setHora(rs.getTime("Hora"));
//
//                    horario.add(horarioC);
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Manejo de excepciones (lanzar o registrar, según sea necesario)
//        }
//
//        return horario;
//
//    }

    @Override
    public List<Horario> listHorario(int id) {
        List<Horario> horarios = new ArrayList<>();
        // SQL para llamar al procedimiento almacenado
        String query = "{CALL kl_K83C1(?)}"; // Llamada al procedimiento almacenado

        try ( // Usar la conexión de ConfigMySql
                 CallableStatement cs = cn.conectar().prepareCall(query)) {

            cs.setInt(1, id); // Establecer el parámetro de entrada para el procedimiento almacenado

            try (java.sql.ResultSet rs = cs.executeQuery()) { // Ejecutar el procedimiento y obtener el ResultSet
                while (rs.next()) {
                    Horario horarioC = new Horario();
                    // Configurar el objeto Horario con los datos del ResultSet

                    horarioC.setIDHorario(rs.getInt("IDHorario"));
                    horarioC.setCliente(new Cliente());
                    horarioC.getCliente().setIDPaciente(rs.getInt("IDPaciente"));
                    horarioC.setDoctor(new Doctor());
                    horarioC.getDoctor().setIDdoctor(rs.getInt("IDdoctor"));
                    horarioC.setEspecialidad(new Especialidad());
                    horarioC.getEspecialidad().setCodigo(rs.getInt("IDEspecialidad"));
                    horarioC.setFecha(rs.getDate("Fecha"));
                    horarioC.setHora(rs.getTime("Hora"));

                    // Agregar el objeto Horario a la lista
                    horarios.add(horarioC);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones (lanzar o registrar según sea necesario)
        }

        return horarios; // Retorna la lista de horarios
    }

}
