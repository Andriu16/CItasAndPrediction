/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import datos.Admin;
import datos.Cliente;
import datos.Doctor;
import datos.cargo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import funcionBD.MetodosCliente;
import interfaces.Usuario;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author andri
 */
@WebServlet(name = "loginClients", urlPatterns = {"/loginClients"})
@MultipartConfig
public class loginClients extends HttpServlet {

    MetodosCliente DaoMetodos = new MetodosCliente();

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
        String accion = request.getParameter("accion");
        try {
            if (accion != null) {
                switch (accion) {

                    case "iniciar":

                        Verificar(request, response);

                        break;

                    default:
                        response.sendRedirect("vistaAdmin.jsp");
                        System.out.println("admin del default case");
                }

            } else {
                response.sendRedirect("vistaAdmin.jsp");
                System.out.println("admin del else del if");
            }

        } catch (Exception e) {
            System.out.println("ERR" + e);
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

    private void Verificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = obtenerUsuario(request);
        MetodosCliente DaoMetodos = new MetodosCliente();
        usuario = (Usuario) DaoMetodos.identificar(usuario);

        if (usuario == null) {
           
            request.setAttribute("msje", "Usuario no encontrado o datos incorrectos");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            System.out.println("error no hay user");
            return; 
        }
//cookies
        try {
            if (request.getParameter("ckbox").equals("on")) {
                Cookie cookie = new Cookie("usuario", usuario.getCorreo());
                cookie.setMaxAge(60 * 60 * 24);

                response.addCookie(cookie);
                System.out.println("cookie creada");
            }
        } catch (NullPointerException e) {
            System.out.println("ckbox vacio" + e);
        }

        HttpSession sesion;
        String acceso = "";

        if (usuario.getCargo() != null) {
            sesion = request.getSession();

            if (usuario.getCargo().getNombreCargo().equals("Admin")) {
                sesion.setAttribute("cliente", usuario);
                request.setAttribute("msje", "Bienvenido");
                acceso = "/javasp/homeAdmin.jsp";
                System.out.println("datos: " + usuario.getCargo().getNombreCargo());
                System.out.println("admin del verificar");
                this.getServletConfig().getServletContext().getRequestDispatcher(acceso).forward(request, response);
                return; 
            } else if (usuario.getCargo().getNombreCargo().equals("Paciente")) {
                sesion.setAttribute("Paciente", usuario);
                sesion.setAttribute("idPaciente", usuario.getIDPaciente());
                String acceszo = "ControllerCita?accion=Inic&idPaciente=" + usuario.getIDPaciente();

                response.sendRedirect(acceszo);
                System.out.println("datos: " + usuario.getCargo().getNombreCargo());
                System.out.println("paciente del verificar");
                return;
            } else if (usuario.getCargo().getNombreCargo().equals("Doctor")) {
                sesion.setAttribute("Doctor", usuario);

                int idDoctor = usuario.getIDdoctor();
                request.getSession().setAttribute("idDoctor", idDoctor);

                request.setAttribute("idDoctor", usuario.getIDdoctor());

                String accezo = "ControllerCita?accion=InicDoc";
                response.sendRedirect(accezo);
                System.out.println("datos: " + usuario.getCargo().getNombreCargo());
                System.out.println("doctor del verificar");
                return;
            }
        } else {
            request.setAttribute("msje", "DATA INCORRECTA");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            System.out.println("error datos servlet");
        }

        

    }

    private Usuario obtenerUsuario(HttpServletRequest request) {
        Usuario usuario = new Usuario() {
            private String correo;
            private String contrasena;
            private cargo cargo;
            private int IDPaciente, IDdoctor;

            @Override
            public String getCorreo() {
                return correo;
            }

            @Override
            public void setCorreo(String correo) {
                this.correo = correo;
            }

            @Override
            public String getContrasena() {
                return contrasena;
            }

            @Override
            public void setContrasena(String contrasena) {
                this.contrasena = contrasena;
            }

            @Override
            public cargo getCargo() {
                return cargo;
            }

            @Override
            public void setCargo(cargo cargo) {
                this.cargo = cargo;
            }

            @Override
            public int getIDPaciente() {
                return IDPaciente;
            }

            @Override
            public int getIDdoctor() {
                return IDdoctor;
            }

        };

        usuario.setCorreo(request.getParameter("txtCorreo"));
        usuario.setContrasena(request.getParameter("txtContrasena"));

        return usuario;
    }

}
