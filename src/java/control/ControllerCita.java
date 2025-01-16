/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import datos.Cliente;
import datos.Especialidad;
import datos.Horario;
import funcionBD.MetodosCliente;
import funcionBD.MetodosEspecialidad;
import funcionBD.MetodosHorario;
import jakarta.resource.cci.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author andri
 */
@WebServlet(name = "ControllerCita", urlPatterns = {"/ControllerCita"})
@MultipartConfig
public class ControllerCita extends HttpServlet {

    MetodosEspecialidad metEsp = new MetodosEspecialidad();
    MetodosHorario metHor = new MetodosHorario();
    MetodosCliente metClie = new MetodosCliente();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String previousPage = request.getHeader("Referer");
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Inic":
                HttpSession sesion = request.getSession();
                int idPaciente = Integer.parseInt(request.getParameter("idPaciente"));

                List<Especialidad> lista = metEsp.listarEspecialidad();
                request.setAttribute("lista", lista);

                List<Cliente> listaCliente = metClie.list(idPaciente);
                request.setAttribute("listaCliente", listaCliente);

                request.getRequestDispatcher("/javasp/homePaciente.jsp").forward(request, response);

                break;
            case "InicConf":
                List<Especialidad> lista1 = metEsp.listarEspecialidad();
                request.setAttribute("lista", lista1);
                request.setAttribute("showAceppt", true);

                request.setAttribute("error", "La cita se registro Correctamente.");
                request.getRequestDispatcher("/javasp/homePaciente.jsp").forward(request, response);

                break;
            case "InicDoc":
                int idDoctor = (int) request.getSession().getAttribute("idDoctor");

                List<Horario> horariosDoctor = metHor.obtenerHorariosDoctor(idDoctor);
                request.setAttribute("horariosDoctor", horariosDoctor);
                request.getRequestDispatcher("/javasp/homeDoctor.jsp").forward(request, response);

                break;
            case "error":
                List<Especialidad> lista2 = metEsp.listarEspecialidad();
                request.setAttribute("lista", lista2);
                request.setAttribute("showAceppt", true);

                request.setAttribute("error", "La cita no se registro porque ya existe");
                request.getRequestDispatcher("/javasp/homePaciente.jsp").forward(request, response);

                break;

            case "ListHorUs":
                int id = Integer.parseInt(request.getParameter("id"));

                List<Horario> listaHoraCli = metHor.listHorario(id);
                request.setAttribute("listaHoraCli", listaHoraCli);

                request.getRequestDispatcher("/javasp/ListaHorariosCliente.jsp").forward(request, response);

                break;
            case "cancelarCita":
                int idH = Integer.parseInt(request.getParameter("idH"));

                
                
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
