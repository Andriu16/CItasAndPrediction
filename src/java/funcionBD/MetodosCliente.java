/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package funcionBD;

import ConexionBaseDtos.ConfigMySql;
import datos.Admin;
import datos.Cliente;
import datos.Doctor;
import datos.Especialidad;
import datos.RolPermisoService;
import datos.cargo;
import encryptHash.PasswordUtils;
import interfaces.Usuario;
import interfaces.clienteInterfaz;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
public class MetodosCliente implements clienteInterfaz {

    ConfigMySql cn = new ConfigMySql();
    Connection con = null;
    ResultSet resultado = null;
    PreparedStatement st = null;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Cliente> getPersonas() {
        List<Cliente> personas = new ArrayList<>();
        String sql = "CALL sp_J9Kl2();";
        try {
            PreparedStatement ps = cn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cliente p = new Cliente();
                p.setIDPaciente(rs.getInt(1));

                p.setNombre(rs.getString(2));
                p.setApellidos(rs.getString(3));
                p.setDireccion(rs.getString(4));
                p.setCorreo(rs.getString(5));
                p.setFechaNac(rs.getString(6));
                p.setIdentificacion(rs.getString(7));
                p.setContrasena(rs.getString(8));
                p.setGenero(rs.getString(9));
                p.setNumeroTelf(rs.getInt(10));

                p.setCargo(new cargo());
                p.getCargo().setCodigo(rs.getInt("IDCargo"));
                p.getCargo().setNombreCargo(rs.getString("Nombrecargo"));

                //p.getCargo().setEstado(true);
                personas.add(p);

            }

        } catch (Exception e) {
            System.out.println("ERR" + e);
        }
        return personas;
    }
    
    @Override
public List<Cliente> getPermisos(int userId, String userRole) {
    // Obtener el rol y los permisos del usuario
    RolPermisoService service = new RolPermisoService(); // Suponiendo que tienes un servicio para gestionar roles y permisos
    cargo rol = null;
        try {
            rol = service.obtenerRolConPermisos(userId);
        } catch (SQLException ex) {
            Logger.getLogger(MetodosCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    // Verificar si el rol es Administrador y si tiene el permiso de 'Ver_Clientes'
    if (rol != null && "Administrador".equals(userRole)) {
        boolean tienePermiso = rol.getPermisos().stream()
            .anyMatch(permiso -> "Ver_Pacientes_All".equals(permiso.getNombre()));

        if (tienePermiso) {
            // Ejecutar la lógica original de obtener clientes
            return getPersonas();
        } else {
            throw new SecurityException("No tienes permiso para realizar esta operación.");
        }
    } else {
        throw new SecurityException("Acceso denegado.");
    }
}

    
    
    

    @Override
    public String add(Cliente clie) {
        try (Connection conexion = ConfigMySql.conectar()) {

            // Query de inserción
            String query = "CALL sp_H00N1(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            // Crear la declaración preparada
            try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {

                // Setear los valores para la inserción
                preparedStatement.setInt(1, clie.getCargo().getCodigo());
                preparedStatement.setString(2, clie.getNombre());
                preparedStatement.setString(3, clie.getApellidos());
                preparedStatement.setString(4, clie.getDireccion());
                preparedStatement.setString(5, clie.getCorreo());
                preparedStatement.setString(6, clie.getFechaNac());
                preparedStatement.setString(7, clie.getIdentificacion());
                preparedStatement.setString(8, clie.getContrasena());
                preparedStatement.setString(9, clie.getGenero());
                preparedStatement.setInt(10, clie.getNumeroTelf());
                // preparedStatement.setBoolean(11, clie.isEstado());

                // Ejecutar la inserción
                int filasAfectadas = preparedStatement.executeUpdate();

                // Verificar si la inserción fue exitosa
                if (filasAfectadas > 0) {
                    return "Inserción exitosa";
                } else {
                    return "Error al insertar el cliente";
                }
            }
        } catch (SQLException e) {
            // Si es un error de duplicado (correo ya registrado)
            if (e.getErrorCode() == 1062) {  // Código de error de duplicado en MySQL
                return "Correo ya registrado";
            }
            // Si es otro tipo de error, retornar mensaje genérico
            return "Error al insertar el cliente: " + e.getMessage();
        }

    }

    @Override
    public boolean buscarCorreoRepetido(String correo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean existe = false;

        try {
            con = ConfigMySql.conectar();
            // Consulta con UNION para buscar en ambas tablas
            String sql = "SELECT COUNT(*) AS total FROM ("
                    + "SELECT Correo FROM t_Z4Tc7 WHERE Correo = ? "
                    + "UNION ALL "
                    + "SELECT Correo FROM t_V5Ns2 WHERE Correo = ?"
                    + ") AS correos";
            ps = con.prepareStatement(sql);
            ps.setString(1, correo);
            ps.setString(2, correo);
            rs = ps.executeQuery();

            if (rs.next()) {
                existe = rs.getInt("total") > 0; // Si hay al menos un resultado, el correo existe
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return existe;

    }

    @Override
    public Object identificar(Usuario usuario) {
        Object objetoUsuario = null;
        Connection con = null;
        ResultSet resultado = null;
        PreparedStatement st = null;

        try {
            String consulta = "CALL ma_S19L2(?)";

//                    "SELECT U.IDPaciente, C.Nombrecargo, U.Contrasena FROM t_Z4Tc7 U "
//                    + "INNER JOIN t_H9Xz3 C ON U.IDCargo=C.IDCargo "
//                    + "WHERE U.Correo=? "
//                    + "UNION "
//                    + "SELECT J.IDadmin, H.Nombrecargo, J.Contrasena FROM t_78KfG J "
//                    + "INNER JOIN t_H9Xz3 H ON J.IDCargo=H.IDCargo "
//                    + "WHERE J.Correo=? "
//                    + "UNION "
//                    + "SELECT F.IDdoctor, K.Nombrecargo, F.Contrasena FROM t_V5Ns2 F "
//                    + "INNER JOIN t_H9Xz3 K ON F.IDCargo=K.IDCargo "
//                    + "WHERE F.Correo=?;";
            con = cn.conectar();
            st = con.prepareStatement(consulta);

            st.setString(1, usuario.getCorreo());
            //st.setString(2, usuario.getContrasena());
            //#funcion del pasado//st.setString(2, usuario.getCorreo());
            //st.setString(4, usuario.getContrasena());
            //#funcion del pasado//st.setString(3, usuario.getCorreo());
            //st.setString(6, usuario.getContrasena());

            resultado = st.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt(1);  // La columna que contiene el ID
                String nombreCargo = resultado.getString(2);
                String storedHash = resultado.getString(3);

                if (PasswordUtils.verifyPassword(usuario.getContrasena(), storedHash)) {
                    switch (nombreCargo) {
                        case "Paciente":
                            Cliente paciente = new Cliente();
                            paciente.setIDPaciente(id);
                            paciente.setCorreo(usuario.getCorreo());
                            paciente.setCargo(new cargo());
                            paciente.getCargo().setNombreCargo(nombreCargo);
                            //paciente.setEstado(true);
                            System.err.println("datos de paciente bien");
                            usuario = paciente;
                            break;

                        case "Admin":
                            Admin admin = new Admin();
                            admin.setIDadmin(id);
                            admin.setCorreo(usuario.getCorreo());
                            admin.setCargo(new cargo());
                            admin.getCargo().setNombreCargo(nombreCargo);
                            System.err.println("datos de admin bien");

                            usuario = admin;
                            break;

                        case "Doctor":
                            Doctor doctor = new Doctor();
                            doctor.setIDdoctor(id);
                            doctor.setCorreo(usuario.getCorreo());
                            doctor.setCargo(new cargo());
                            doctor.getCargo().setNombreCargo(nombreCargo);
                            System.err.println("datos de doc bien");

                            usuario = doctor;
                            break;

                        default:
                            // Manejar otro tipo de cargo si es necesario
                            break;
                    }
                } else {

                    System.out.println("Contraseña incorrecta.");
                    usuario = null;
                }
            }
            if (usuario == null) {
                System.out.println("Usuario no encontrado o contraseña incorrecta.");
            }

        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            try {
                if (resultado != null) {
                    resultado.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return usuario;
    }

    @Override
    public boolean add(Doctor doc) {
        String sql = "CALL F_K1Kz3(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = cn.conectar(); PreparedStatement ps = con.prepareStatement(sql)) {

            // Convertir los códigos a String si es necesario
            String codigoCargo = String.valueOf(doc.getCargo().getCodigo());
            String codigoEspecialidad = String.valueOf(doc.getEspecialidad().getCodigo());

            ps.setString(1, codigoCargo);
            ps.setString(2, doc.getNombre());
            ps.setString(3, doc.getApellidos());
            ps.setString(4, doc.getDireccion());
            ps.setString(5, doc.getCorreo());
            ps.setString(6, doc.getFechaNac());
            ps.setString(7, doc.getIdentificacion());
            ps.setString(8, doc.getContrasena());
            ps.setString(9, doc.getGenero());
            ps.setInt(10, doc.getNumeroTelf());

            ps.setString(11, codigoEspecialidad);
            ps.setBlob(12, doc.getImagen());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("Error al agregar doctor: " + e.getMessage());
            return false;
        }
    }

    @Override
    public List<Doctor> getDoctores() {
        List<Doctor> doctores = new ArrayList<>();
        String sql = "CALL F_L0Px1";
        try {
            PreparedStatement ps = cn.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Doctor p = new Doctor();
                p.setIDdoctor(rs.getInt(1));

                p.setNombre(rs.getString(2));
                p.setApellidos(rs.getString(3));
                p.setDireccion(rs.getString(4));
                p.setCorreo(rs.getString(5));
                p.setFechaNac(rs.getString(6));
                p.setIdentificacion(rs.getString(7));
                p.setContrasena(rs.getString(8));
                p.setGenero(rs.getString(9));
                p.setNumeroTelf(rs.getInt(10));
                p.setEspecialidad(new Especialidad());
                p.getEspecialidad().setCodigo(rs.getInt(11));
                p.getEspecialidad().setNombreEspecialidad(rs.getString(12));
                p.setImagen(rs.getBinaryStream(13));
                p.setCargo(new cargo());
                p.getCargo().setCodigo(rs.getInt(14));
                p.getCargo().setNombreCargo(rs.getString(15));
                p.getCargo().setEstado(true);

                doctores.add(p);

            }

        } catch (Exception e) {
            System.out.println("ERR" + e);
        }
        return doctores;

    }

    @Override

    public void listarIMG(int id, HttpServletResponse response) {
        String sql = "CALL F_N5Zj3(" + id + ")";

//                SELECT * FROM t_V5Ns2 WHERE IDdoctor=" + id;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            // Validación básica de ID
            if (id <= 0) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "ID inválido");
                return;
            }

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

        } catch (IOException ex) {
            Logger.getLogger(MetodosCliente.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Cliente> list(int id
    ) {
        List<Cliente> cliente = new ArrayList<>();
        String query = "CALL sp_L11K3 (?)";
        try (Connection con = ConfigMySql.conectar(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cliente doctor = new Cliente();
                    // Configura los atributos del doctor según tu esquema
                    doctor.setIDPaciente(rs.getInt("IDPaciente"));
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
                    //doctor.setEstado(rs.getBoolean("Estado"));

                    cliente.add(doctor);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja la excepción de manera apropiada en tu aplicación
        }

        return cliente;
    }

}
