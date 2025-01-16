/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import datos.Doctor;
import datos.Especialidad;
import datos.cargo;
import encryptHash.PasswordUtils;
import funcionBD.MetodosCliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andri
 */
@WebServlet(name = "registerMedico", urlPatterns = {"/registerMedico"})
@MultipartConfig
public class registerMedico extends HttpServlet {
     String hashedPassword;

    Doctor doc = new Doctor();
    MetodosCliente funciones = new MetodosCliente();

//    Cliente cl = new Cliente();
//    cargo ca = new cargo();
//    funcionCliente dao = new funcionCliente();
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

        switch (accion) {
            case "Confirmar":
                String acceso = "";
                int IDCargo = Integer.parseInt(request.getParameter("txtIDCargo"));
                String Nombre = request.getParameter("txtNombre");
                String Apellido = request.getParameter("txtApellido");
                String Direccion = request.getParameter("txtDireccion");
                String Correo = request.getParameter("txtCorreo");
                String FechaNac = request.getParameter("txtFechaNac");
                String Identificacion = request.getParameter("txtIdentificacion");
                String Contrasena = request.getParameter("txtContrasena");

                String Genero = request.getParameter("txtGenero");
                int Telefono = Integer.parseInt(request.getParameter("txtTelf"));

//                Boolean Estado =  Boolean.parseBoolean(request.getParameter("txtEstado"));
                int Especialidad = Integer.parseInt(request.getParameter("txtEspecialidad"));

                Part part = request.getPart("fileFoto");
                InputStream inputStream = part.getInputStream();

                try {
                    hashedPassword = PasswordUtils.generatePasswordHash(Contrasena);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(registerUser.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InvalidKeySpecException ex) {
                    Logger.getLogger(registerUser.class.getName()).log(Level.SEVERE, null, ex);
                }

                doc.setCargo(new cargo());
                doc.getCargo().setCodigo(IDCargo);
                doc.setNombre(Nombre);
                doc.setApellidos(Apellido);
                doc.setDireccion(Direccion);
                doc.setCorreo(Correo);
                doc.setFechaNac(FechaNac);
                doc.setIdentificacion(Identificacion);
                doc.setContrasena(hashedPassword);
                doc.setGenero(Genero);
                doc.setNumeroTelf(Telefono);

                doc.setEspecialidad(new Especialidad());
                doc.getEspecialidad().setCodigo(Especialidad);
                doc.setImagen(inputStream);
                funciones.add(doc);

                System.out.println(IDCargo);
                System.out.println(Nombre);
                System.out.println(Apellido);
                System.out.println(Direccion);
                System.out.println(Correo);
                System.out.println(FechaNac);
                System.out.println(Identificacion);
                System.out.println(hashedPassword);
                System.out.println(Genero);
                System.out.println(Telefono);

                System.out.println(Especialidad);
                //System.out.println("");

                response.sendRedirect("javasp/formularioAnadirDoc.jsp");

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
