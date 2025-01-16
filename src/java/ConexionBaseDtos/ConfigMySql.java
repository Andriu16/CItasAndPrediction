/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ConexionBaseDtos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author andri
 */

//"jdbc:mysql://localhost/tele_medicina?useSSL=false&allowPublicKeyRetrieval=true";
public class ConfigMySql {
    public static String url = "jdbc:mysql://34.56.218.140/sys_B7m2Lj?useSSL=false&allowPublicKeyRetrieval=true";
    
    // jdbc:mysql://34.56.218.140/sys_B7m2Lj?useSSL=false&allowPublicKeyRetrieval=true";
    public static String usuario = "root";
    public static String contraseña = "123456";

 
    public static Connection conectar() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.print("conexion establecida \n");
            
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);

        }
        return conexion;
    }

}
