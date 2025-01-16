
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List" %>


<!DOCTYPE html>

<html class="wide wow-animation" lang="en">
    <head>
        <title>Home</title>
        <meta name="format-detection" content="telephone=no">
        <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta charset="utf-8">
        <link rel="icon" href="images/favicon.ico" type="image/x-icon">
        <!-- Stylesheets-->
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:100,300,300i,400,500,600,700,900%7CRaleway:500">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/fonts.css">
        <link rel="stylesheet" href="css/style.css">
        <!--[if lt IE 10]>
        <div style="background: #212121; padding: 10px 0; box-shadow: 3px 3px 5px 0 rgba(0,0,0,.3); clear: both; text-align:center; position: relative; z-index:1;"><a href="http://windows.microsoft.com/en-US/internet-explorer/"><img src="images/ie8-panel/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today."></a></div>
        <script src="js/html5shiv.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="preloader">
            <div class="wrapper-triangle">
                <div class="pen">
                    <div class="line-triangle">
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                    </div>
                    <div class="line-triangle">
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                    </div>
                    <div class="line-triangle">
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                        <div class="triangle"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="page">
            <!-- Top Banner-->
            <!-- Page Header-->
            <header class="section page-header">
                <!-- RD Navbar-->
                <div class="rd-navbar-wrap">
                    <nav class="rd-navbar rd-navbar-modern" data-layout="rd-navbar-fixed" data-sm-layout="rd-navbar-fixed" data-md-layout="rd-navbar-fixed" data-md-device-layout="rd-navbar-fixed" data-lg-layout="rd-navbar-static" data-lg-device-layout="rd-navbar-fixed" data-xl-layout="rd-navbar-static" data-xl-device-layout="rd-navbar-static" data-xxl-layout="rd-navbar-static" data-xxl-device-layout="rd-navbar-static" data-lg-stick-up-offset="56px" data-xl-stick-up-offset="56px" data-xxl-stick-up-offset="56px" data-lg-stick-up="true" data-xl-stick-up="true" data-xxl-stick-up="true">
                        <div class="rd-navbar-inner-outer">
                            <div class="rd-navbar-inner">
                                <!-- RD Navbar Panel-->
                                <div class="rd-navbar-panel">
                                    <!-- RD Navbar Toggle-->
                                    <button class="rd-navbar-toggle" data-rd-navbar-toggle=".rd-navbar-nav-wrap"><span></span></button>
                                    <!-- RD Navbar Brand-->
                                    <div class="rd-navbar-brand"><a class="brand " href="index.html"><img  class="brand-logo-dark" src="https://s3.amazonaws.com/documentos.api.gob.pe/5fth77cswkkqpyhum92d73z0jne2?response-content-disposition=inline%3B%20filename%3D%22logo.png%22%3B%20filename%2A%3DUTF-8%27%27logo.png&response-content-type=image%2Fpng&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAJREKOSPKMJFYJDAQ%2F20240519%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240519T033626Z&X-Amz-Expires=300&X-Amz-SignedHeaders=host&X-Amz-Signature=e2d25bb55470ba92f1057a1ee0de8841f9f20e457248ec7d8ce6f47d8c579637" alt="" width="198" height="66"/></a></div>
                                </div>
                                <div class="rd-navbar-right rd-navbar-nav-wrap">
                                    <div class="rd-navbar-aside">
                                        <ul class="rd-navbar-contacts-2">
                                            <li>
                                                <div class="unit unit-spacing-xs">
                                                    <div class="unit-left"><span class="icon mdi mdi-phone"></span></div>
                                                    <div class="unit-body"><a class="phone" href="tel:#">+51 945-103-208</a></div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="unit unit-spacing-xs">
                                                    <div class="unit-left"><span class="icon mdi mdi-map-marker"></span></div>
                                                    <div class="unit-body"><a class="address" href="#">Av. Pastor Sevilla Y 200 Millas, Villa El Salvador, Lima Region 15836</a></div>
                                                </div>
                                            </li>
                                        </ul>

                                    </div>
                                    <div class="rd-navbar-main">
                                        <!-- RD Navbar Nav-->
                                        <ul class="rd-navbar-nav">

                                            <li class="rd-nav-item active"><a class="rd-nav-link" href="index.html">Inicio</a></li>

                                           
                                            <!--<li class="rd-nav-item"><a class="rd-nav-link" href="contacts.html">nose</a></li>-->
                                        </ul>

                                    </div>
                                </div>
                                <div class="rd-navbar-project-hamburger rd-navbar-project-hamburger-open rd-navbar-fixed-element-1" data-multitoggle=".rd-navbar-inner" data-multitoggle-blur=".rd-navbar-wrap" data-multitoggle-isolate="data-multitoggle-isolate">
                                    <div class="project-hamburger"><span class="project-hamburger-arrow"></span><span class="project-hamburger-arrow"></span><span class="project-hamburger-arrow"></span>
                                    </div>
                                </div>
                                <div class="rd-navbar-project">
                                    <div class="rd-navbar-project-header">
                                        <h5 class="rd-navbar-project-title">Perfil</h5>
                                        <div class="rd-navbar-project-hamburger rd-navbar-project-hamburger-close" data-multitoggle=".rd-navbar-inner" data-multitoggle-blur=".rd-navbar-wrap" data-multitoggle-isolate="data-multitoggle-isolate">
                                            <div class="project-close"><span></span><span></span></div>
                                        </div>
                                    </div>
                                    <div class="rd-navbar-project-content rd-navbar-content">
                                        <div>
                                            <main class="form-signin w-100 m-auto">

                                                <!-- action="iniciarUsuario?accion=iniciar" -->


                                                <img src="https://cdn-icons-png.flaticon.com/512/1177/1177568.png" alt="" class="mb-4" width="200" height="200" />


                                                <c:forEach var="lstCli" items="${listaCliente}">
                                                    <div class="form-floating">
                                                        <h5 class="rd-navbar-project-title">Nombre: ${lstCli.getNombre()}</h5>
                                                        <label for="floatingInput"></label>
                                                    </div>
                                                    <div class="form-floating">
                                                        <h5 class="rd-navbar-project-title">Apellidos:${lstCli.getApellidos()} </h5>
                                                        <label for="floatingInput"></label>
                                                    </div>
                                                    <div class="form-floating">
                                                        <h5 class="rd-navbar-project-title">Correo: ${lstCli.getCorreo()}</h5>
                                                        <label for="floatingInput"></label>
                                                    </div>
                                                    <div class="form-floating">
                                                        <h5 class="rd-navbar-project-title">Telefono:${lstCli.getNumeroTelf()} </h5>
                                                        <label for="floatingInput"></label>
                                                    </div>



                                                    <div>
                                                        <a class="w-100 btn btn-lg btn-primary" href="ControllerCita?accion=ListHorUs&id=${lstCli.getIDPaciente()}" >Mis citas</a>



                                                    </div>
                                                    <div><a href="index.jsp" onclick="return confirm('¿Seguro que deseas cerrar sesión?');">Cerrar sesión</a>
                                                    </div>

                                                </c:forEach>


                                                <!--<div class="social-auth-links text-center">
                                                    <p>-Verificar Datos</p>
                                                    <a href="#" class="btn btn-block btn-social btn-facbook btn-flat"><i class="fa fa-info"></i>Mensaje: 
                                                
                                            </div>-->


                                            </main>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </nav>
                </div>
            </header>
            <!-- Swiper-->
            <section class="section swiper-container swiper-slider swiper-slider-2 swiper-slider-3" data-loop="true" data-autoplay="5000" data-simulate-touch="false" data-slide-effect="fade">
                <div class="swiper-wrapper text-sm-left">
                    <div class="swiper-slide context-dark" data-slide-bg="https://ves.org.pe/wp-content/uploads/2018/09/hospital-de-emergencias-de-villa-el-salvador.png">
                        <div class="swiper-slide-caption section-md">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-9 col-md-8 col-lg-7 col-xl-7 offset-lg-1 offset-xxl-0">
                                        <h1 class="oh swiper-title"><span class="d-inline-block" data-caption-animate="slideInUp" data-caption-delay="0" >   </span></h1>
                                        <p class="big swiper-text" data-caption-animate="fadeInLeft" data-caption-delay="300" style="color: black">Disponibilidad 24/7</p><a class="button button-lg button-primary button-winona button-shadow-2" href="#" data-caption-animate="fadeInUp" data-caption-delay="300">Reservar Cita</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="swiper-slide context-dark" data-slide-bg="https://nypost.com/wp-content/uploads/sites/2/2017/04/hospital.jpg?quality=90&strip=all">
                        <div class="swiper-slide-caption section-md">
                            <div class="container">
                                <div class="row">
                                    <div class="col-sm-8 col-lg-7 offset-lg-1 offset-xxl-0">
                                        <h1 class="oh swiper-title"><span class="d-inline-block" data-caption-animate="slideInDown" data-caption-delay="0">Atención de Calidad</span></h1>
                                        <p class="big swiper-text" data-caption-animate="fadeInRight" data-caption-delay="300"></p>
                                        <div class="button-wrap oh"><a class="button button-lg button-primary button-winona button-shadow-2" href="#" data-caption-animate="slideInUp" data-caption-delay="0">Reservar Cita</a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Swiper Pagination-->
                <div class="swiper-pagination" data-bullet-custom="true"></div>
                <!-- Swiper Navigation-->
                <div class="swiper-button-prev">
                    <div class="preview">
                        <div class="preview__img"></div>
                    </div>
                    <div class="swiper-button-arrow"></div>
                </div>
                <div class="swiper-button-next">
                    <div class="swiper-button-arrow"></div>
                    <div class="preview">
                        <div class="preview__img"></div>
                    </div>
                </div>
            </section>
            <!-- What We Offer-->


            <!-- Section CTA-->


            <!-- Our Shop-->
            <section class="section section-lg bg-default">

                <div class="container">
                    <h3 class="oh-desktop"><span class="d-inline-block wow slideInUp">Especialidades</span></h3>
                    <div class="row row-lg row-30">
                        <c:forEach var="dato" items="${lista}">
                            <div class="col-sm-6 col-lg-4 col-xl-3">
                                <!-- Product-->
                                <article class="product wow fadeInLeft" data-wow-delay=".15s">

                                    <div class="product-figure"><img src="ControllerImg?accion=imgPaciente&id=${dato.getCodigo()}" alt="" width="161" height="162"/>
                                    </div>


                                    <label>${dato.getNombreEspecialidad()}</label>
                                    <!--<label >${dato.getCodigo()}</label>-->

                                    <div class="product-button">
                                        <div class="button-wrap" ><a class="button button-xs button-primary button-winona" href="funck?accion=especialidad&idEspecialidad=${dato.getCodigo()}">Seleccionar</a></div>
                                        <!-- si se sleecciona alguna especialidad se lleva el dato de idespecialidad en la accion del boton -->
                                    </div>
                                </article>
                            </div>
                        </c:forEach>



                    </div>
                </div>
            </section>

            <!-- Section CTA-->




            <section class="section section-last bg-default">
                <div class="container-fluid container-inset-0 isotope-wrap">
                    <div class="row row-10 gutters-10 isotope" data-isotope-layout="masonry" data-isotope-group="gallery" data-lightgallery="group">
                        <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop">
                            <!-- Thumbnail Mary-->
                            <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInLeft"><a class="thumbnail-mary-figure" href="images/gallery-1-1200x800-original.jpg" data-lightgallery="item"><img src="images/prevencion (1).jpg" alt="" width="310" height="585"/></a>
                                <div class="thumbnail-mary-caption">
                                    <div>
                                        <h6 class="thumbnail-mary-title"><a >Charlas de prenvencion</a></h6>
                                        <div class="thumbnail-mary-location"></div>
                                    </div>
                                </div>
                            </article>
                        </div>
                        <div class="col-xs-6 col-sm-8 col-xl-4 isotope-item oh-desktop">
                            <!-- Thumbnail Mary-->
                            <article class="thumbnail thumbnail-mary thumbnail-mary-big wow slideInRight"><a class="thumbnail-mary-figure" href="images/gallery-2-1200x800-original.jpg" data-lightgallery="item"><img src="images/reuniones.jpg" alt="" width="631" height="587"/></a>
                                <div class="thumbnail-mary-caption">
                                    <div>
                                        <h6 class="thumbnail-mary-title"><a >Reunion con el Alcalde de Villa El Salvador</a></h6>
                                        <div class="thumbnail-mary-location"></div>
                                    </div>
                                </div>
                            </article>
                        </div>
                        <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop">
                            <!-- Thumbnail Mary-->
                            <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInDown"><a class="thumbnail-mary-figure" href="images/gallery-3-1200x800-original.jpg" data-lightgallery="item"><img src="images/pediatria.jpg" alt="" width="311" height="289"/></a>
                                <div class="thumbnail-mary-caption">
                                    <div>
                                        <h6 class="thumbnail-mary-title"><a >Pediatria 🐻</a></h6>
                                        <div class="thumbnail-mary-location"></div>
                                    </div>
                                </div>
                            </article>
                        </div>
                        <div class="col-xs-6 col-sm-8 col-xl-4 isotope-item oh-desktop">
                            <!-- Thumbnail Mary-->
                            <article class="thumbnail thumbnail-mary wow slideInUp"><a class="thumbnail-mary-figure" href="images/gallery-4-1200x800-original.jpg" data-lightgallery="item"><img src="images/diabetes.jpg" alt="" width="631" height="289"/></a>
                                <div class="thumbnail-mary-caption">
                                    <div>
                                        <h6 class="thumbnail-mary-title"><a >Día de la Lucha contra la Diabetes</a></h6>
                                        <div class="thumbnail-mary-title"></div>
                                    </div>
                                </div>
                            </article>
                        </div>
                        <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop">
                            <!-- Thumbnail Mary-->
                            <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInUp"><a class="thumbnail-mary-figure" href="images/gallery-5-1200x800-original.jpg" data-lightgallery="item"><img src="images/lavado (1).jpg" alt="" width="311" height="289"/></a>
                                <div class="thumbnail-mary-caption">
                                    <div>
                                        <h6 class="thumbnail-mary-title"><a>Promoviendo el lavado de manos</a></h6>
                                        <div class="thumbnail-mary-location"></div>
                                    </div>
                                </div>
                            </article>
                        </div>
                        <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop">
                            <!-- Thumbnail Mary-->
                            <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInRight"><a class="thumbnail-mary-figure" href="images/gallery-6-1200x800-original.jpg" data-lightgallery="item"><img src="images/cancer (1).jpg" alt="" width="311" height="289"/></a>
                                <div class="thumbnail-mary-caption">
                                    <div>
                                        <h6 class="thumbnail-mary-title"><a>Lucha contra el cancer</a></h6>
                                        <div class="thumbnail-mary-location"></div>
                                    </div>
                                </div>
                            </article>
                        </div>
                        <div class="col-xs-6 col-sm-4 col-xl-2 isotope-item oh-desktop">
                            <!-- Thumbnail Mary-->
                            <article class="thumbnail thumbnail-mary thumbnail-mary-2 wow slideInLeft"><a class="thumbnail-mary-figure" href="images/gallery-7-1200x800-original.jpg" data-lightgallery="item"><img src="images/visita.jpg" alt="" width="311" height="289"/></a>
                                <div class="thumbnail-mary-caption">
                                    <div>
                                        <h6 class="thumbnail-mary-title"><a>Visita del capellán </a></h6>
                                        <div class="thumbnail-mary-location"></div>
                                    </div>
                                </div>
                            </article>
                        </div>
                    </div>
                </div>
            </section>

            <!-- Tell-->


            <!-- Section Services  Last section-->
            <section class="section section-sm bg-default">
                <div class="container">
                    <div class="owl-carousel owl-style-11 dots-style-2" data-items="1" data-sm-items="1" data-lg-items="2" data-xl-items="3" data-margin="30" data-dots="true" data-mouse-drag="true" data-rtl="true">
                        <article class="box-icon-megan wow fadeInUp">
                            <div class="box-icon-megan-header">
                                <div class="box-icon-megan-icon linearicons-bag"></div>
                            </div>
                            <h5 class="box-icon-megan-title"><a href="#">Area de Farmacia</a></h5>
                            <p class="box-icon-megan-text">Disponibilidad de una gran variedad farmaceutica.</p>
                        </article>
                        <article class="box-icon-megan wow fadeInUp" data-wow-delay=".05s">
                            <div class="box-icon-megan-header">
                                <div class="box-icon-megan-icon linearicons-map2"></div>
                            </div>
                            <h5 class="box-icon-megan-title"><a href="#">Ubicación</a></h5>
                            <p class="box-icon-megan-text">Av. Pastor Sevilla Y 200 Millas, Villa El Salvador, Lima Region 15836</p>
                        </article>

                        <article class="box-icon-megan wow fadeInUp" data-wow-delay=".15s">
                            <div class="box-icon-megan-header">
                                <div class="box-icon-megan-icon linearicons-thumbs-up"></div>
                            </div>
                            <h5 class="box-icon-megan-title"><a href="#">Servicio seguro</a></h5>
                            <p class="box-icon-megan-text">El cliente es nuestra prioridad numero #1 </p>
                        </article>
                    </div>
                </div>
            </section>

            <!-- Page Footer-->
            <footer class="section footer-modern context-dark footer-modern-2">

                <div class="footer-modern-line-2">
                    <div class="container">
                        <div class="row row-30 align-items-center">
                            <div class="col-sm-6 col-md-7 col-lg-4 col-xl-4">
                                <div class="row row-30 align-items-center text-lg-center">
                                    <div class="col-md-7 col-xl-6"><a class="brand" href="#"><img src="https://inforlandperu.com/wp-content/uploads/2021/05/nuestros-clientes-hospital-de-emergencias-villa-el-salvador.png" alt="" width="198" height="66"/></a></div>

                                </div>
                            </div>
                            <div class="col-sm-6 col-md-12 col-lg-8 col-xl-8 oh-desktop">
                                <div class="group-xmd group-sm-justify">
                                    <div class="footer-modern-contacts wow slideInUp">
                                        <div class="unit unit-spacing-sm align-items-center">
                                            <div class="unit-left"><span class="icon icon-24 mdi mdi-phone"></span></div>
                                            <div class="unit-body"><a class="phone" href="tel:#">+51 945-103-208</a></div>
                                        </div>
                                    </div>
                                    <div class="footer-modern-contacts wow slideInDown">
                                        <div class="unit unit-spacing-sm align-items-center">
                                            <div class="unit-left"><span class="icon mdi mdi-email"></span></div>
                                            <div class="unit-body"><a class="mail" href="mailto:atencionvillaEmergencias@gmail.com">atencionvillaEmergencias@gmail.com</a></div>
                                        </div>
                                    </div>
                                    <div class="wow slideInRight">
                                        <ul class="list-inline footer-social-list footer-social-list-2 footer-social-list-3">
                                            <li><a class="icon mdi mdi-facebook" href="https://www.facebook.com/HevesOficial"></a></li>
                                            <li><a class="icon mdi mdi-twitter" href="https://twitter.com/HevesOficial"></a></li>
                                            <li><a class="icon mdi mdi-instagram" href="https://www.instagram.com/explore/locations/1723682567895379/hospital-de-emergencias-villa-el-salvador/"></a></li>
                                            <li><a class="icon mdi mdi-google-plus" href="mailto:atencionvillaEmergencias@gmail.com"></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="footer-modern-line-3">
                    <div class="container">
                        <div class="row row-10 justify-content-between">
                            <div class="col-md-6"><span></span></div>
                            <div class="col-md-auto">
                                <!-- Rights-->
                                <p class="rights"><span>&copy;&nbsp;</span><span class="copyright-year"></span><span></span><span>.&nbsp;</span><span></span></p>
                            </div>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
        <!-- Global Mailform Output-->
        <div class="snackbars" id="form-output-global"></div>
        <!-- Javascript-->
        <script src="js/core.min.js"></script>
        <script src="js/script.js"></script>
        <!-- coded by Himic-->
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