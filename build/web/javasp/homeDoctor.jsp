<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <title>Home Doctor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
              crossorigin="anonymous">
        <link href="CSS/homeC.css" rel="stylesheet">
        <style>
            /* Agregado estilo personalizado aquí si es necesario */
            .table th, .table td {
                text-align: center;
                vertical-align: middle;
            }

            .table th {
                height: 80px;
            }

            .navbar-brand {
                color: cyan;
            }

            .navbar-nav .nav-link {
                color: white;
            }
        </style>
    </head>

    <body>

        <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-2 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-5 fs-6" >Bienvenido Doctor</a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse"
                    data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <li class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3"  href="javasp/formpredic.jsp" style="color: #009DFF"> Prediccion Cardiaca</a>
                </div>
                
            </li>
            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3" href=".">Salir</a>
                </div>
            </div>
        </header>


        <div class="container-fluid">
            <div class="row">
                <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                    <!-- Contenido del menú lateral aquí -->
                </nav>
            </div>
        </div>

        <div class="container">
            <center>
                <h2>Lista de Horarios del Doctor</h2>
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead class="table-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>Apellidos</th>
                                <th>Identificacion</th>
                                <th>Fecha</th>
                                <th>Hora</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="dato" items="${horariosDoctor}">
                                <tr>
                                    <td>${dato.getCliente().getNombre()}</td>
                                    <td>${dato.getCliente().getApellidos()}</td>
                                    <td>${dato.getCliente().getIdentificacion()}</td>
                                    <td>${dato.getFecha()}</td>
                                    <td>${dato.getHora()}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </center>
        </div>

        <script src="/docs/5.2/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
                integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
                integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
        crossorigin="anonymous"></script>
        <script src="dashboard.js"></script>
    </body>

</html>
