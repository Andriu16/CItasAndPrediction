/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import datos.Cliente;
import datos.cargo;
import encryptHash.PasswordUtils;
import funcionBD.MetodosCliente;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

/**
 *
 * @author andri
 */
@WebServlet(name = "registerUser", urlPatterns = {"/registerUser"})
@MultipartConfig
public class registerUser extends HttpServlet {

    String hashedPassword;
    String inicio = "index.jsp";
    Cliente cl = new Cliente();
    cargo ca = new cargo();
    MetodosCliente dao = new MetodosCliente();

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
        // Obtener parámetros del formulario
        int IDCargo = Integer.parseInt(request.getParameter("txtIDCargo"));
        String Nombre = request.getParameter("txtNombre");
        String Apellidos = request.getParameter("txtApellido");
        String Direccion = request.getParameter("txtDireccion");
        String Correo = request.getParameter("txtCorreo");
        String FechaNac = request.getParameter("txtFechaNac");
        String Identificacion = request.getParameter("txtIdentificacion");
        String Contrasena = request.getParameter("txtContrasena");
        String Genero = request.getParameter("txtGenero");
        String telefonoStr = request.getParameter("txtTelf");
        //boolean estado = Boolean.parseBoolean(request.getParameter("txtEstado"));

        // Validar datos antes de continuar
        if (!validarContrasena(Contrasena)) {
            request.setAttribute("error", "Contraseña no válida. Debe tener al menos una mayúscula, un número y un carácter especial.");
            System.out.println("err contrasena invalida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        if (!validarEdad(FechaNac)) {
            request.setAttribute("error", "Debes tener al menos 18 años.");
            System.out.println("err fecha invalida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        if (!Identificacion.matches("\\d{8}")) {
            request.setAttribute("error", "La identificación debe tener exactamente 8 dígitos.");
            System.out.println("err identificacion invalida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        //Validar que el campo no sea nulo o vacío
        if (telefonoStr == null || telefonoStr.isEmpty()) {
            request.setAttribute("error", "El número de teléfono es obligatorio.");
            System.out.println("err telefono vacio o nulo");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        if (!telefonoStr.matches("\\d{9}")) {
            // Si no tiene 9 dígitos, marcar como error
            request.setAttribute("error", "El número de teléfono debe tener 9 dígitos.");
            System.out.println("err numero invalido: " + telefonoStr);  // Mostrar el teléfono inválido
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

//        if (dao.buscarCorreoRepetido(Correo)) {
//            request.setAttribute("error", "El correo ya esta registrado en el sistema. Por favor, utiliza otro correo.");
//            System.out.println("El correo ya esta registrado en el sistema. Por favor, utiliza otro correo");
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//            return;
//        }
//        if (!Nombre.matches("[a-zA-Z]+")) {
//            request.setAttribute("error", "El nombre solo debe contener letras.");
//            System.out.println("err nombre invalido");
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//            return;
//        }
//        if (!Apellidos.matches("[a-zA-Z]+")) {
//            request.setAttribute("error", "El apellido solo debe contener letras.");
//            System.out.println("err apellidos invalidos");
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//            return;
//        }
        int NumeroTelf = Integer.parseInt(telefonoStr);

        try {
            hashedPassword = PasswordUtils.generatePasswordHash(Contrasena);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(registerUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(registerUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Crear un nuevo cliente y establecer sus atributos
        cl.setCargo(new cargo());
        cl.getCargo().setCodigo(IDCargo);
        cl.setNombre(Nombre);
        cl.setApellidos(Apellidos);
        cl.setDireccion(Direccion);
        cl.setCorreo(Correo);
        cl.setFechaNac(FechaNac);
        cl.setIdentificacion(Identificacion);
        cl.setContrasena(hashedPassword);
        cl.setGenero(Genero);
        cl.setNumeroTelf(NumeroTelf);
        //cl.setEstado(estado);
        // Establecer otros atributos del cliente

        // Llamar al método add para insertar el nuevo cliente en la base de datos
        String mensaje = dao.add(cl);

        if (mensaje.equals("Inserción exitosa")) {
            // Si la inserción fue exitosa, redirigimos a la página de éxito
            System.out.println("good");
            response.sendRedirect("index.jsp");
        } else {
            // Si hubo un error (como correo repetido u otro), pasamos el mensaje de error
            
            request.setAttribute("error", mensaje);  // Pasamos el mensaje al request
            System.out.println("err insert");
            request.getRequestDispatcher("index.jsp").forward(request, response);  // Redirigimos a la vista de registro con el error
        }

    }

    private boolean validarContrasena(String contrasena) {
        // Expresión regular para validar la contraseña
        String regex = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=?<>]).{8,}$";
        return contrasena.matches(regex);
    }

    private boolean validarEdad(String fechaNacimiento) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fechaNac = sdf.parse(fechaNacimiento);
            Calendar calendar = Calendar.getInstance();
            int anioActual = calendar.get(Calendar.YEAR);
            int mesActual = calendar.get(Calendar.MONTH);
            int diaActual = calendar.get(Calendar.DAY_OF_MONTH);

            calendar.setTime(fechaNac);
            int anioNacimiento = calendar.get(Calendar.YEAR);
            int mesNacimiento = calendar.get(Calendar.MONTH);
            int diaNacimiento = calendar.get(Calendar.DAY_OF_MONTH);

            // Calcular la diferencia de años
            int edad = anioActual - anioNacimiento;

            // Ajustar si no ha cumplido años este año
            if (mesActual < mesNacimiento || (mesActual == mesNacimiento && diaActual < diaNacimiento)) {
                edad--;
            }

            return edad >= 18; // Debe ser mayor o igual a 18 años
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("err fecehanac");
            return false;
        }
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
