/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import datos.Cliente;
import datos.cargo;
import java.util.List;

/**
 *
 * @author andri
 */
public interface Usuario {
    
    int getIDPaciente();
    
    
    
    int getIDdoctor();

    String getCorreo();

    void setCorreo(String correo);

    String getContrasena();

    void setContrasena(String contrasena);

    cargo getCargo();

    void setCargo(cargo cargo);
}
