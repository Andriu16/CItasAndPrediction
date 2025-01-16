/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

/**
 *
 * @author andri
 */
@WebServlet(name = "ControllerPredict", urlPatterns = {"/ControllerPredict"})
@MultipartConfig
public class ControllerPredict extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final String API_URL = "http://c344-34-69-49-148.ngrok-free.app/predict";

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

        //COLESTEROL
        int valorMinChol = 126;
        int valorMaxChol = 564;

        //CARDIACO
        int minThalach = 71;
        int maxThalach = 202;

        // Glucemia
        String glucemiaScore;
        int glucemiaValoRate;

        // Tensión Arterial
        int trestbpsScore = 0;

        //oldpeak
        int oldScore = 0;

        // Recibir los datos del formulario
        int age = Integer.parseInt(request.getParameter("age"));
        int sex = Integer.parseInt(request.getParameter("sex"));
        int cp = Integer.parseInt(request.getParameter("cp"));
        int trestbps = Integer.parseInt(request.getParameter("trestbps"));
        int chol = Integer.parseInt(request.getParameter("chol"));
        int fbs = Integer.parseInt(request.getParameter("fbs"));
        int restecg = Integer.parseInt(request.getParameter("restecg"));
        int thalach = Integer.parseInt(request.getParameter("thalach"));
        int exang = Integer.parseInt(request.getParameter("exang"));
        double oldpeak = Double.parseDouble(request.getParameter("oldpeak"));
        int slope = Integer.parseInt(request.getParameter("slope"));
        int ca = Integer.parseInt(request.getParameter("ca"));
        int thal = Integer.parseInt(request.getParameter("thal"));

        try {
            // Crear un objeto JSON con los datos del formulario
            JSONObject json = new JSONObject();
            json.put("age", age);
            json.put("sex", sex);
            json.put("cp", cp);
            json.put("trestbps", trestbps);
            json.put("chol", chol);
            json.put("fbs", fbs);
            json.put("restecg", restecg);
            json.put("thalach", thalach);
            json.put("exang", exang);
            json.put("oldpeak", oldpeak);
            json.put("slope", slope);
            json.put("ca", ca);
            json.put("thal", thal);

            // Conectar con la API vía POST
            URL url = new URL(API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            // Enviar el JSON
            OutputStream os = conn.getOutputStream();
            os.write(json.toString().getBytes());
            os.flush();
            os.close();

            // Leer la respuesta de la API
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder responseContent = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();

            // Procesar la respuesta JSON
            JSONObject jsonResponse = new JSONObject(responseContent.toString());
            String prediccion = jsonResponse.getString("prediccion");

            // Formatear la respuesta basándose en la predicción
            String resultado;
            if (prediccion.equalsIgnoreCase("sano")) {
                resultado = "El paciente tiene un bajo riesgo de padecer una enfermedad cardiovascular.";
            } else if (prediccion.equalsIgnoreCase("enfermo")) {
                resultado = "Atención: Los resultados sugieren que el paciente esta en riesgo de desarrollar una enfermedad cardiovascular. Sugerir que se agende una cita para obtener un diagnóstico detallado";
            } else {
                resultado = "No se pudo determinar el riesgo. Inténtalo nuevamente o consulta con un médico.";
            }

            int progressValue = (int) (((double) (chol - valorMinChol) / (valorMaxChol - valorMinChol)) * 100);

            //valor del colesterol
            request.setAttribute("chol", chol);
            request.setAttribute("progressValue", progressValue);

            //valor de maximo cardiaco
            int heightPercentage = (int) (((double) (thalach - minThalach) / (maxThalach - minThalach)) * 100);
            request.setAttribute("heightPercentage", heightPercentage);
            request.setAttribute("thalach", thalach);

            //glucemia en ayunas
            if (fbs != 0) {
                glucemiaScore = "es mayor";
                glucemiaValoRate = -39;

            } else {
                glucemiaScore = "no es mayor";
                glucemiaValoRate = 37;
            }   

            request.setAttribute("glucemiaScore", glucemiaScore);
            request.setAttribute("glucemiaValoRate", glucemiaValoRate);
            request.setAttribute("fbs", fbs);

            //tensión arterial en reposo
            if (trestbps == 94) {
                trestbpsScore = 50;
            } else if (trestbps >= 95 && trestbps <= 100) {
                trestbpsScore = 40;
            } else if (trestbps >= 101 && trestbps <= 120) {
                trestbpsScore = 55;
            } else if (trestbps >= 121 && trestbps <= 140) {
                trestbpsScore = 35;
            } else if (trestbps >= 141 && trestbps <= 160) {
                trestbpsScore = 30;
            } else if (trestbps >= 161 && trestbps <= 180) {
                trestbpsScore = 10;
            } else if (trestbps >= 181 && trestbps <= 200) {
                trestbpsScore = -10;
            } else if (trestbps > 200) {
                trestbpsScore = -50;
            }

            request.setAttribute("trestbps", trestbps);
            request.setAttribute("trestbpsScore", trestbpsScore);

            //oldpeak depresión del ST inducida por el ejercicio
            if (oldpeak == 0.0) {
                oldScore = 50;
            } else if (oldpeak > 0.0 && oldpeak <= 0.5) {
                oldScore = 40;
            } else if (oldpeak > 0.5 && oldpeak <= 1.0) {
                oldScore = 35;
            } else if (oldpeak > 1.0 && oldpeak <= 1.5) {
                oldScore = 30;
            } else if (oldpeak > 1.5 && oldpeak <= 2.0) {
                oldScore = 20;
            } else if (oldpeak > 2.0 && oldpeak <= 2.5) {
                oldScore = 10;
            } else if (oldpeak > 2.5 && oldpeak <= 3.0) {
                oldScore = -15;
            } else if (oldpeak > 3.0 && oldpeak <= 3.5) {
                oldScore = -20;
            } else if (oldpeak > 3.5 && oldpeak <= 4.0) {
                oldScore = -25;
            } else if (oldpeak > 4.0 && oldpeak <= 4.5) {
                oldScore = -34;
            } else if (oldpeak > 4.5 && oldpeak <= 5.0) {
                oldScore = -38;
            } else if (oldpeak > 5.0 && oldpeak <= 5.5) {
                oldScore = -44;
            } else if (oldpeak > 5.5 && oldpeak <= 6.2) {
                oldScore = -48;
            }else if (oldpeak == 6.2) 
                oldScore = -50;

            request.setAttribute("oldpeak", oldpeak);
            request.setAttribute("oldScore", oldScore);
            // Devolver el resultado al JSP
            request.setAttribute("resultado", resultado);  // Pasamos la predicción al JSP
            request.getRequestDispatcher("javasp/resultado.jsp").forward(request, response);
//            request.setAttribute("resultado", responseContent.toString());
//            request.getRequestDispatcher("resultado.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().append("Error: ").append(e.getMessage());
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
