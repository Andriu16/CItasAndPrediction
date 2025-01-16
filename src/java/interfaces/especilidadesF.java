/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import datos.Doctor;
import datos.Especialidad;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author andri
 */
public interface especilidadesF {
     public List listarEspecialidad();
     public void listarIMG(int id, HttpServletResponse response);
     public void add(Especialidad esp);
     public void listarIMGDoc(int id, HttpServletResponse response);
     public List<Doctor> obtenerDoctoresPorEspecialidad(int idEspecialidad);
    //buscando como funciona el listar img y donde y como aplicarlo
}
