<%-- 
    Document   : Doctores
    Created on : 22 nov. 2023, 16:33:11
    Author     : andri
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="datos.Cliente" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="csss/bootstrap.min.css">
        <link rel="stylesheet" href="csss/owl.carousel.min.css">
        <link rel="stylesheet" href="csss/magnific-popup.css">
        <link rel="stylesheet" href="csss/font-awesome.min.css">
        <link rel="stylesheet" href="csss/themify-icons.css">
        <link rel="stylesheet" href="csss/nice-select.css">
        <link rel="stylesheet" href="csss/flaticon.css">
        <link rel="stylesheet" href="csss/gijgo.css">
        <link rel="stylesheet" href="csss/animate.css">
        <link rel="stylesheet" href="csss/slicknav.css">
        <link rel="stylesheet" href="csss/style.css">
        <!-- Agrega estos enlaces en la sección head de tu HTML -->
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    </head>
    <style>
        input[type="radio"] {
            display: none; /* Oculta los radios por defecto */
        }

        input[type="radio"] + label {
            padding: 5px 10px;
            border: 1px solid #ccc;
            margin: 5px;
            cursor: pointer;
            display: inline-block;
        }

        input[type="radio"]:checked + label {
            background-color: #87CEEB; /* Estilo cuando está seleccionado */
            color: white;
        }
    </style>
    <style>
        .single_expert {
            /* Define el tamaño del contenedor que incluirá la imagen y el cuadro blanco */
            width: 250px;  /* Ajusta el ancho según tus necesidades */
            height: 350px;  /* Ajusta la altura según tus necesidades */
            background-color: white;  /* Fondo blanco para el cuadro */
            border-radius: 10px;  /* Esquinas redondeadas para el cuadro */
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);  /* Añade una sombra suave */
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin: 20px auto; /* Centra los cuadros */
        }

        .expert_thumb img {
            width: 250px;  /* Tamaño fijo para las imágenes */
            height: 350px; /* Ajusta la altura para mantener las proporciones */
            object-fit: cover;  /* Asegura que la imagen ocupe todo el espacio sin deformarse */
            border-radius: 50%;  /* Imagen redonda */
            border: 5px solid #fff; /* Opcional: Borde blanco alrededor de la imagen */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);  /* Sombra alrededor de la imagen */
        }

        .experts_name {
            background-color: #87CEEB;  /* Fondo celeste */
            color: white;  /* Texto blanco */
            padding: 10px;  /* Espaciado alrededor del texto */
            border-radius: 5px;  /* Bordes redondeados */
            text-align: center;  /* Asegura que el texto esté centrado */
            width: 100%;  /* Asegura que el fondo celeste cubra todo el ancho del cuadro */
            margin-top: 15px;
        }

        .experts_name h3 {
            margin: 0;  /* Elimina los márgenes por defecto de los <h3> */
        }
    </style>




    <style>
        /* Estilo para el modal */
        .modal {
            display: none;
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
        }

        /* Estilo para el contenido del modal */
        .modal-content {
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            padding: 20px;
            width: 500px; /* Ajusta el ancho del rectángulo según sea necesario */
            height: 500px; /* Ajusta la altura del rectángulo según sea necesario */
            background-color: white;
            border-radius: 10px; /* Añade bordes redondeados */
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3); /* Añade sombra al rectángulo */
        }

        /* Estilo para el formulario dentro del modal */
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100%;
        }

        label {
            margin-bottom: 10px;
        }

        input {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 10px;
            background-color: #87CEEB; /* Celeste claro */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;



        }
    </style>


    <body>
        <div class="bradcam_area breadcam_bg_2 bradcam_overlay">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="bradcam_text">
                            <h3>Doctores Especializados</h3>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- expert_doctors_area_start -->
        <div class="expert_doctors_area doctor_page">
            <div class="container">
                <div class="row">
                    <c:forEach var="doctor" items="${listaDoctores}">
                        <div class="col-md-6 col-lg-3">
                            <button class="single_expert mb-40" onclick="abrirModal('${doctor.getNombre()}')">
                                <div class="expert_thumb">
                                    <img src="ControllerImg?accion=imgDoc&id=${doctor.getIDdoctor()}" alt="">
                                </div>
                                <div class="experts_name text-center">
                                    <h3>${doctor.getNombre()}</h3>
                                    <h3>${doctor.getApellidos()}</h3>
                                </div>
                            </button>
                        </div>

                    </c:forEach>
                </div>
            </div>
        </div>

        <!-- Modal -->
        <div id="miModal" class="modal">
            <c:forEach var="doctor" items="${listaDoctores}">
                <div class="modal-content">
                    <!-- Formulario con campos de fecha y hora -->
                    <h2>Registrar Cita</h2>
                    <form action="HorarioControl" method="post">
                        <input type="hidden" name="idPaciente" value="${sessionScope.idPaciente}">
                        <input type="hidden" name="idDoctor" value="${doctor.getIDdoctor()}">
                        <input type="hidden" name="idEspecialidad" value="${doctor.getEspecialidad().getCodigo()}">



                        <label for="fecha">Fecha:</label>
                        <input type="date" id="fecha" name="fecha" required>



                        <!--
                                                <div>
                                                    <label>Horas:</label>
                                                    <div>
                        <c:forEach var="horaDisponible" items="${horasDisponibles}">
                            <input type="radio" name="hora" id="hora-${horaDisponible}" value="${horaDisponible}">
                            <label for="hora-${horaDisponible}">${horaDisponible}</label>
                        </c:forEach>
                    </div>
                </div> -->

                        <div>
                            <label>Horas:</label>
                            <div>
                                <c:forEach var="horaDisponible" items="${horasDisponibles}">
                                    <input type="radio" name="hora" id="hora-${doctor.getIDdoctor()}-${horaDisponible}" value="${horaDisponible}">
                                    <label for="hora-${doctor.getIDdoctor()}-${horaDisponible}">${horaDisponible}</label>
                                </c:forEach>
                            </div>
                        </div>


                        <button type="submit">Enviar</button>
                    </form>
                    <!-- Fin del formulario -->
                    <button onclick="cerrarModal()">Cerrar</button>
                </div>
            </c:forEach>
        </div>


        <script>
            function abrirModal(nombreDoctor) {
                // Muestra el modal
                document.getElementById('miModal').style.display = 'block';

                // Puedes personalizar el mensaje del formulario aquí
                var mensaje = "Hola, soy " + nombreDoctor + ". ¿Cómo puedo ayudarte?";
                // También puedes manipular los elementos del formulario aquí si es necesario
                document.getElementById('nombre').value = nombreDoctor;
            }

            $(function () {
                $("#fecha").datepicker();

            });

            function enviarFormulario() {
                // Obtén los valores de fecha y hora del formulario
                var fecha = $("#fecha").val();
                var hora = $("#hora").val();

                // Formatea la fecha antes de mostrarla (por ejemplo, a "dd/mm/yyyy")
                var fechaFormateada = formatearFecha(fecha);

                // Muestra los datos
                alert("Fecha: " + fechaFormateada + "\nHora: " + hora);
            }

            function formatearFecha(fecha) {
                // Formatea la fecha como desees (por ejemplo, a "dd/mm/yyyy")
                var partes = fecha.split("/");
                return partes[0] + "/" + partes[1] + "/" + partes[2];
            }

            function cerrarModal() {
                // Cierra el modal
                document.getElementById('miModal').style.display = 'none';
            }
        </script>
        <%
Boolean showAceppt = (Boolean) request.getAttribute("showAceppt");
if (showAceppt != null && showAceppt) {
        %>
        <script>
            alert("<%= request.getAttribute("error") %>");
        </script>
        <% } %>

    </body>
</html>
