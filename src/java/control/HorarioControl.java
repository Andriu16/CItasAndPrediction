/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import datos.Cliente;
import funcionBD.MetodosCliente;
import funcionBD.MetodosHorario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.mail.*;

import jakarta.mail.internet.*;
import java.util.Properties;
import java.util.List;
import datos.Cliente;
import funcionBD.MetodosCliente;
import funcionBD.MetodosHorario;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import datos.Cliente;
import funcionBD.MetodosCliente;
import funcionBD.MetodosHorario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 *
 * @author andri
 */
@WebServlet(name = "HorarioControl", urlPatterns = {"/HorarioControl"})
@MultipartConfig

public class HorarioControl extends HttpServlet {

    // String pacienteCorreo = obtenerCorreoPaciente()
    MetodosHorario metodosHorario = new MetodosHorario();
    MetodosCliente MetodCliente = new MetodosCliente();
    private static String emailFrom = "lokitoztony@gmail.com";
    private static String passwordFrom = "dvheoahpsdxvsacs";

    private Properties mProperties;
    private Session mSession;
    private MimeMessage mCorreo;

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
        HttpSession session = request.getSession();
        String previousPage = request.getHeader("Referer");
        String currentJSP = request.getRequestURI();

        int idPaciente = (int) session.getAttribute("idPaciente");
        int idDoctor = Integer.parseInt(request.getParameter("idDoctor"));
        int idEspecialidad = Integer.parseInt(request.getParameter("idEspecialidad"));

        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date fechaHora;
        try {
            fechaHora = dateFormat.parse(fecha + " " + hora);
        } catch (ParseException e) {
            // Maneja la excepción si ocurre un problema al parsear la fecha y la hora
            e.printStackTrace();
            return; // Puedes redirigir a una página de error si lo prefieres
        }

        boolean citaExistente = metodosHorario.citaExistente(fechaHora, idDoctor);

        if (citaExistente) {
            // La cita ya existe, puedes enviar una alerta o redirigir a una página de error
            request.setAttribute("showAlerta", true);
            request.setAttribute("erorde", "La cita no se registro porque ya existe");
            String acces = "ControllerCita?accion=error";
            response.sendRedirect(acces);
//            if (previousPage != null && !previousPage.isEmpty()) {
//                // Redirige a la página anterior
//                response.sendRedirect(previousPage);
//                System.out.println("aqui2");
//            } else {
//                // Si no hay información sobre la página anterior, redirige a una página predeterminada
//                response.sendRedirect("javasp/Doctores.jsp");
//                System.out.println("aqui3");
//            }

//            dispatcher.forward(request, response);
            System.out.println("AQUI 1");
        } else {
            // La cita no existe, puedes proceder a insertarla en la base de datos
            request.setAttribute("showAlert", true);
            request.setAttribute("error", "La cita se registro Correctamente.");
            metodosHorario.insertarHorario(idPaciente, idDoctor, idEspecialidad, fecha, hora);

            enviarCorreoConfirmacion(idPaciente, hora, fecha);

            //response.sendRedirect("javasp/Doctores.jsp");
            String acceszo = "ControllerCita?accion=InicConf";
            response.sendRedirect(acceszo);

        }

//        // Redirige a la página correspondiente o muestra un mensaje de éxito
//        if (previousPage != null && !previousPage.isEmpty()) {
//            // Redirige a la página anterior
//            response.sendRedirect(previousPage);
//            System.out.println("aqui2");
//        } else {
//            // Si no hay información sobre la página anterior, redirige a una página predeterminada
//            response.sendRedirect("javasp/Doctores.jsp");
//            System.out.println("aqui3");
//        }
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

    private void enviarCorreoConfirmacion(int idPaciente, String hora, String fecha) {
        List<Cliente> listaClientes = MetodCliente.list(idPaciente);
        if (!listaClientes.isEmpty()) {
            Cliente paciente = listaClientes.get(0);
            String correoPaciente = paciente.getCorreo();

            mProperties = new Properties();
            mProperties.put("mail.smtp.host", "smtp.gmail.com");
            mProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            mProperties.setProperty("mail.smtp.starttls.enable", "true");
            mProperties.setProperty("mail.smtp.port", "587");
            mProperties.setProperty("mail.smtp.user", emailFrom);
            mProperties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
            mProperties.setProperty("mail.smtp.auth", "true");

            mSession = Session.getDefaultInstance(mProperties, new jakarta.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(emailFrom, passwordFrom);
                }
            });

            try {
                MimeMessage mCorreo = new MimeMessage(mSession);
                mCorreo.setFrom(new InternetAddress(emailFrom));
                mCorreo.setRecipient(Message.RecipientType.TO, new InternetAddress(correoPaciente));
                mCorreo.setSubject("Reserva de cita");
                mCorreo.setText("Su cita se reservó a la hora: " + hora + " y fecha: " + fecha, "ISO-8859-1", "html");

                Transport mTransport = mSession.getTransport("smtp");
                mTransport.connect(emailFrom, passwordFrom);
                mTransport.sendMessage(mCorreo, mCorreo.getAllRecipients());
                mTransport.close();

                System.out.println("Correo enviado correctamente");

            } catch (MessagingException ex) {
                ex.printStackTrace();
                System.err.println("Error al enviar el correo electrónico");
            }
        } else {
            System.err.println("No se encontró el paciente con el ID proporcionado.");
        }
    }

}
