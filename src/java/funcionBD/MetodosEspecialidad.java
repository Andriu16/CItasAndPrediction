/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionBD;

import ConexionBaseDtos.ConfigMySql;
//import static ConexionBaseDtos.ConfigMySql.url;
import datos.Doctor;
import datos.Especialidad;
import datos.cargo;
import interfaces.especilidadesF;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andri
 */
public class MetodosEspecialidad implements especilidadesF {

    Connection con;
    ConfigMySql cn = new ConfigMySql();
    PreparedStatement ps;
    Especialidad pr = new Especialidad();
    ResultSet rs;
    int r = 0;

    @Override
    public List listarEspecialidad() {
        List<Especialidad> lista = new ArrayList<>();
        String sql = "SELECT * FROM t_Y3Lp8";
        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Especialidad pr = new Especialidad();
                pr.setCodigo(rs.getInt(1));
                pr.setNombreEspecialidad(rs.getString(2));
                pr.setEstado(rs.getBoolean(3));
                pr.setImg(rs.getBinaryStream(4));

                lista.add(pr);

            }
        } catch (Exception e) {
            System.out.println("err");
        }
        return lista;
    }
//falt
    @Override
    public void listarIMG(int id, HttpServletResponse response) {
        String sql = "SELECT * FROM t_Y3Lp8 WHERE IDEspecialidad=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            outputStream = response.getOutputStream();

            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("img");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);

            }
        } catch (Exception e) {
        }
    }
    
    @Override
    public void add(Especialidad esp) {
        String sql = "CALL jk_O71V6 (?, ?, ?)";

        try {
            con = cn.conectar();
            ps = con.prepareStatement(sql);

            // Convertir los códigos a String si es necesario
            ps.setString(1, esp.getNombreEspecialidad());
            ps.setBoolean(2, esp.isEstado());

            ps.setBlob(3, esp.getImg());

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("error aqui en metodos: " + e);
        }

    }
//faltnosee
    @Override
    public void listarIMGDoc(int id, HttpServletResponse response) {
        String sql = "SELECT * FROM t_V5Ns2 WHERE IDdoctor=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            outputStream = response.getOutputStream();

            con = cn.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                inputStream = rs.getBinaryStream("img");
            }
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            int i = 0;
            while ((i = bufferedInputStream.read()) != -1) {
                bufferedOutputStream.write(i);

            }
        } catch (Exception e) {
        }

    }
//faltnose
    @Override
    public List<Doctor> obtenerDoctoresPorEspecialidad(int idEspecialidad) {
        List<Doctor> doctores = new ArrayList<>();

        String query = "SELECT * FROM t_V5Ns2 WHERE IDEspecialidad = ?";
        try (Connection con = ConfigMySql.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, idEspecialidad);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Doctor doctor = new Doctor();
                    
                    doctor.setIDdoctor(rs.getInt("IDdoctor"));
                    doctor.setCargo(new cargo());
                    doctor.getCargo().setCodigo(rs.getInt("IDCargo"));
                    doctor.setNombre(rs.getString("Nombre"));
                    doctor.setApellidos(rs.getString("Apellidos"));
                    doctor.setDireccion(rs.getString("Direccion"));
                    doctor.setCorreo(rs.getString("Correo"));
                    doctor.setFechaNac(rs.getString("FechaNac"));
                    doctor.setIdentificacion(rs.getString("Identificacion"));
                    doctor.setContrasena(rs.getString("Contrasena"));

                    doctor.setGenero(rs.getString("Genero"));
                    doctor.setNumeroTelf(rs.getInt("NumeroTelf"));

                    // Puedes configurar la especialidad si es necesario
                    Especialidad especialidad = new Especialidad();
                    especialidad.setCodigo(rs.getInt("IDEspecialidad"));
                    doctor.setEspecialidad(especialidad);

                    // Puedes configurar la imagen si es necesario
                    doctor.setImagen(rs.getBinaryStream("img"));

                    doctores.add(doctor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción de manera apropiada en tu aplicación
        }

        return doctores;

    }

    public List<String> obtenerHorasDisponiblesConIntervalo() {
        List<String> horas = new ArrayList<>();
        LocalTime horaInicio = LocalTime.of(8, 0);  // 8:00 AM
        LocalTime horaFin = LocalTime.of(17, 0);    // 5:00 PM

        while (!horaInicio.isAfter(horaFin)) {
            horas.add(horaInicio.format(DateTimeFormatter.ofPattern("HH:mm")));
            horaInicio = horaInicio.plusMinutes(30);
        }

        return horas;
    }

    public static void eliminarHorario(int idHorario) {
        String sql = "call kl_Q80J2 (?)";

        try (Connection con = ConfigMySql.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, idHorario);
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Se eliminó el horario con IDHorario: " + idHorario);
            } else {
                System.out.println("No se encontró un horario con IDHorario: " + idHorario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar excepciones según tus necesidades
        }
    }

}
