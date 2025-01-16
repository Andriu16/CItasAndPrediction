/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import datos.Cliente;
import datos.Doctor;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author andri
 */
public interface clienteInterfaz {
    
    public List<Cliente>list(int id);
    public List<Cliente> getPersonas();

    public List<Doctor> getDoctores();

    public void listarIMG(int id, HttpServletResponse response);

    public String add(Cliente clie);

    public boolean add(Doctor doc);

    public boolean buscarCorreoRepetido(String correo);

    public Object identificar(Usuario usuario);
    
    public List<Cliente> getPermisos(int userId, String userRole);
    
    
}
