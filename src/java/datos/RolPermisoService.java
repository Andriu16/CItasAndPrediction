/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import ConexionBaseDtos.ConfigMySql;
import jakarta.jms.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

/**
 *
 * @author andri
 */
public class RolPermisoService {

    ConfigMySql cn = new ConfigMySql();
    java.sql.Connection con = null;
    private Connection connection;

    

    public cargo obtenerRolConPermisos(int idCargo) throws SQLException {
        cargo rol = null;
        String sqlRol = "SELECT IDCargo, NombreCargo FROM t_H9Xz3 WHERE IDCargo = ?";
        String sqlPermisos = "SELECT p.IDPermiso, p.Nombre, p.Descripcion "
                + "FROM t_P6Tr9 p "
                + "INNER JOIN t_R7Kj8 rp ON p.IDPermiso = rp.IDPermiso "
                + "WHERE rp.IDCargo = ?";

        try (PreparedStatement psRol = cn.conectar().prepareStatement(sqlRol); PreparedStatement psPermisos = cn.conectar().prepareStatement(sqlPermisos)) {

            // Cargar información del rol
            psRol.setInt(1, idCargo);
            ResultSet rsRol = psRol.executeQuery();
            if (rsRol.next()) {
                rol = new cargo();
                rol.setCodigo(rsRol.getInt("IDCargo"));
                rol.setNombreCargo(rsRol.getString("Nombrecargo"));

                // Cargar permisos del rol
                psPermisos.setInt(1, idCargo);
                ResultSet rsPermisos = psPermisos.executeQuery();
                List<Permiso> permisos = new ArrayList<>();
                while (rsPermisos.next()) {
                    Permiso permiso = new Permiso();
                    permiso.setIdPermiso(rsPermisos.getInt("IDPermiso"));
                    permiso.setNombre(rsPermisos.getString("Nombre"));
                    permiso.setDescripcion(rsPermisos.getString("Descripcion"));
                    permisos.add(permiso);
                }
                rol.setPermisos(permisos);
            }
        }

        return rol;
    }

}
