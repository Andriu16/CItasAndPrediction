    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
     */
    package control;

    import datos.Especialidad;
    import datos.cargo;
    import funcionBD.MetodosEspecialidad;
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
    import java.util.HashSet;
    import java.util.Set;

    /**
     *
     * @author andri
     */
    @WebServlet(name = "ControllerEspecial", urlPatterns = {"/ControllerEspecial"})
    @MultipartConfig
    public class ControllerEspecial extends HttpServlet {
        Especialidad esp = new Especialidad();
        MetodosEspecialidad metEsp = new MetodosEspecialidad();

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

                    String Nombre = request.getParameter("txtNombre");
                    Boolean Estado = Boolean.parseBoolean(request.getParameter("txtEstado"));
                    Part part = request.getPart("fileFoto");
                    InputStream inputStream = part.getInputStream();


                    esp.setNombreEspecialidad(Nombre);
                    esp.setEstado(Estado);
                    esp.setImg(inputStream);
                    metEsp.add(esp);


                    response.sendRedirect("javasp/formularioAnadirEsp.jsp");

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
