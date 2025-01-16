<%-- 
    Document   : agregarProducto
    Created on : 25/06/2022, 03:36:20 PM
    Author     : user
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="Orlando Ipaarraguirre">
        <title>Dashboard </title>
        <!-- Bootstrap core CSS --> 
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <meta name="theme-color" content="#7952b3">
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
        </style>
        <!-- <link href="../css/dashboard.css" rel="stylesheet">
         <link href="../css/valida.css" rel="stylesheet" type="text/css"/>  -->
    </head>
    <body class="text-center " style="background: url('https://th.bing.com/th/id/R.7ac961580a0c7ccd07fcf29dc1a9974c?rik=FPoBNorpwUwYxg&pid=ImgRaw&r=0') no-repeat;background-size: cover;">
        <header  class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-2 shadow">
            <a class="navbar-brand col-md-3 col-lg-2 me-0 px-5 fs-6" style="color:cyan" href="#">User</a>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="navbar-nav">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3"  style="color:white"  >Inicio</a>
                </div>
            </div>

        </header>

        <div class="container-fluid">

            <div class="row">


                <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">

                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="fw-bold" style="color:black">Registro de Usuario</h1>                       
                    </div>

                    <!-- <h2>Section title</h2>-->
                    
                    <form action="../registerUser" method="post">
                        <!-- <div  class="input-group mb-3" id="grupo__dni">
                             <span class="input-group-text" id="basic-addon1">IDuser</span>
                             <input type="text" class="form-control" autofocus placeholder="Idusuario" required id="txtIDuser" name="txtIDuser">
                         </div> -->
                        <div class="input-group mb-3">

                            <input type="hidden" class="form-control"  id="txtIDCargo" name="txtIDCargo" value="1">>


                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1" ><label class="fw-bold">Nombre</label></span>
                            <input type="text" class="form-control" placeholder="nombre" id="txtNombre" name="txtNombre" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><label class="fw-bold">Apellidos</label> </span>
                            <input type="text" class="form-control" placeholder="apellidos" id="txtApellido" name="txtApellido" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"> <label class="fw-bold">Direccion</label></span>
                            <input type="text" class="form-control" placeholder="direccion" id="txtDireccion" name="txtDireccion" required="">

                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"> <label class="fw-bold">Correo</label> </span>
                            <input type="text" class="form-control" placeholder="Correo" id="txtCorreo" name="txtCorreo" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><label class="fw-bold">Fecha de Nacimiento</label> </span>
                            <input type="text" class="form-control" placeholder="" id="txtFechaNac" name="txtFechaNac" required="">

                        </div>
                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><label class="fw-bold">Identificacion</label></span>
                            <input type="text" class="form-control" placeholder="DNI O CARNET" id="txtIdentificacion" name="txtIdentificacion" required="">

                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><label class="fw-bold">Contraseña</label></span>
                            <input type="text" class="form-control" placeholder="Contraseña" id="txtContrasena" name="txtContrasena" required="">

                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><label class="fw-bold">Genero</label></span>
                            <input type="text" class="form-control" placeholder="Masculino o Femenino" id="txtGenero" name="txtGenero" required="">

                        </div>

                        <div class="input-group mb-3">
                            <span class="input-group-text" id="basic-addon1"><label class="fw-bold">Numero de Telefono</label></span>
                            <input type="text" class="form-control" placeholder="999-999-999" id="txtTelf" name="txtTelf" required="">

                        </div
                        <div class="input-group mb-3">

                            


                        </div>


                        <div class="input-group" style="text-align:center">                            

                            <input type="submit"  class="btn btn-info" name="accion"  value="Guardar">                            
                        </div>  
                    </form>

                </main>
            </div>            
        </div>





    </body>

</html>


