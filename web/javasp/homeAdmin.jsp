<%-- 
    Document   : vista1
    Created on : 17/06/2022, 05:46:03 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">


        <title>Home Admin</title>

        <link href="CSS/boostrap-min.css" rel="stylesheet"  >
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">



        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }

            .b-example-divider {
                height: 3rem;
                background-color: rgba(0, 0, 0, .1);
                border: solid rgba(0, 0, 0, .15);
                border-width: 1px 0;
                box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em rgba(0, 0, 0, .15);
            }

            .b-example-vr {
                flex-shrink: 0;
                width: 1.5rem;
                height: 100vh;
            }

            .bi {
                vertical-align: -.125em;
                fill: currentColor;
            }

            .nav-scroller {
                position: relative;
                z-index: 2;
                height: 2.75rem;
                overflow-y: hidden;
            }

            .nav-scroller .nav {
                display: flex;
                flex-wrap: nowrap;
                padding-bottom: 1rem;
                margin-top: -1px;
                overflow-x: auto;
                text-align: center;
                white-space: nowrap;
                -webkit-overflow-scrolling: touch;
            }
        </style>


        <!-- Custom styles for this template -->
        <link href="CSS/homeC.css" rel="stylesheet">
    </head>
    <body  style="background: url('https://www.bbva.com/wp-content/uploads/2018/01/fondo-asset-management-chile-inversion-rentabilidad-bbva-1920x912.jpg') no-repeat;background-size: auto;">

        <header  class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-2 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-5 fs-6" style="color:cyan" >ADMINISTRADOR</a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <div><a href="index.jsp" onclick="return confirm('¿Seguro que deseas cerrar sesión?');">Cerrar sesión</a>
                    </div>
                </div>
            </div>
        </header>

        <div class="container-fluid" >
            <div class="row" >
                <nav style="background: url('https://www.bbva.com/wp-content/uploads/2018/01/fondo-asset-management-chile-inversion-rentabilidad-bbva-1920x912.jpg') no-repeat;background-size: auto;" id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                    <div class="position-sticky pt-3">
                        <ul class="nav flex-column" >
                            

                            <li class="nav-item">
                                <a class="btn btn-dark" aria-current="page" href="javasp/listaPacientes.jsp">
                                    <span data-feather="home" class="align-text-bottom"></span>
                                    List Usuarios
                                </a>
                            </li>

                            <br>
                            <li>

                                <form action="funck" >
                                    <div>

                                        <input class="btn btn-dark" type="submit" name="accion" value="ListDoctor">
                                    </div>
                                </form>



                            </li>
                            <br>
                            <li class="nav-item">

                                <a class="btn btn-dark" aria-current="page" href="javasp/formularioAnadirDoc.jsp">
                                    <span data-feather="file" class="align-text-bottom"></span>
                                    Añadir doctores

                                </a>
                            </li>
                            <br>
                            <li class="nav-item">

                                <a class="btn btn-dark" aria-current="page" href="javasp/formularioAnadirEsp.jsp">
                                    <span data-feather="file" class="align-text-bottom"></span>
                                    Añadir Especialidades

                                </a>
                            </li>
                            <br>
                           







                        </ul>



                    </div>
                </nav>





            </div>
        </div>


        <script src="/docs/5.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

        <script src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js" integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE" crossorigin="anonymous"></script><script src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js" integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha" crossorigin="anonymous"></script><script src="dashboard.js"></script>
    </body>
</html>
