
<!doctype html>
<html class="no-js" lang="zxx">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Docmed</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- <link rel="manifest" href="site.webmanifest"> -->

        <!-- Place favicon.ico in the root directory -->

        <!-- CSS here -->

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
        <link rel="stylesheet" href="csss/stylee.css">
        <!-- Agrega las siguientes líneas a tu sección head para incluir jQuery y jQuery UI -->
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <!-- <link rel="stylesheet" href="css/responsive.css"> -->
    </head>



    <body>
        <div class="bradcam_area breadcam_bg_2 bradcam_overlay">
            <div class="container">
                <div class="row">
                    <div class="col-xl-12">
                        <div class="bradcam_text">
                            <h3>Doctors</h3>
                            <p><a href="index.html">Home /</a> Doctors</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- expert_doctors_area_start -->


        <!-- Modal -->


        <div class="modal-content">
            <!-- Formulario con campos de fecha y hora -->
            <h2>Registrar Cita</h2>
            <form action="HorarioControl" method="post">
                <input type="hidden" name="idPaciente" value="${sessionScope.idPaciente}">
                <input type="hidden" name="idDoctor" value="${doctor.getIDdoctor()}">
                <input type="hidden" name="idEspecialidad" value="${doctor.getEspecialidad().getCodigo()}">

                <label for="fecha">Fecha:</label>
                <input type="text" id="fecha" name="fecha" required>

                <label for="hora">Hora:</label>
                <input type="time" id="hora" name="hora" required>

                <button type="submit">Enviar</button>
            </form>
            <!-- Fin del formulario -->
            <button onclick="cerrarModal()">Cerrar</button>
        </div>

    </body>

</html>