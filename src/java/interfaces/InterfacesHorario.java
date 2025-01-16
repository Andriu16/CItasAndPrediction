/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import datos.Horario;
import jakarta.resource.cci.ResultSet;
import java.util.Date;
import java.util.List;

/**
 *
 * @author andri
 */
public interface InterfacesHorario {
        void insertarHorario(int idPaciente, int idDoctor, int idEspecialidad, String fecha, String hora);
        boolean citaExistente(Date fechaHora, int idDoctor);
        List<Horario> obtenerHorariosDoctor(int doctorID);
        public List<Horario> listHorario(int id);

}
