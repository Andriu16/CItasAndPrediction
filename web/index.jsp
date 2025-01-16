
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <title>Login V3</title>



        <script>
            function validarFormulario() {
                const identificacion = document.getElementById("txtIdentificacion").value;
                const telefono = document.getElementById("txtTelf").value;
                const nombre = document.getElementById("txtNombre").value;
                const apellidos = document.getElementById("txtApellido").value;


                let errorMessages = []; // Array to collect all error messages

                // Validar identificación (exactamente 8 dígitos)
                const identificacionRegex = /^\d{8}$/;
                if (!identificacionRegex.test(identificacion)) {
                    errorMessages.push("La identificación debe tener exactamente 8 dígitos y solo contener números.");
                }

                // Validar número de teléfono (exactamente 9 dígitos)
                const telefonoRegex = /^\d{9}$/;
                if (!telefonoRegex.test(telefono)) {
                    errorMessages.push("El número de teléfono debe tener exactamente 9 dígitos y solo contener números.");
                }

                // Validar nombre (solo letras)
                const nombreRegex = /^[a-zA-Z]+$/;
                if (!nombreRegex.test(nombre)) {
                    errorMessages.push("El nombre solo debe contener letras.");
                }

                // Validar apellidos (solo letras)
                if (!nombreRegex.test(apellidos)) {
                    errorMessages.push("El apellido solo debe contener letras.");
                }

                // If there are any errors, display them and prevent form submission
                if (errorMessages.length > 0) {
                    Swal.fire({
                        icon: 'error',
                        title: 'Errores de validación',
                        html: '<ul style="text-align: left;">' + errorMessages.map(msg => `<li>${msg}</li>`).join('') + '</ul>',
                        confirmButtonText: 'Ok'
                    });
                    return false; // Prevenir envío del formulario
                }

                return true; // If no errors, allow form submission
            }

            document.getElementById('txtFechaNac').addEventListener('input', function () {
                var fechaNac = new Date(this.value);
                var fechaHoy = new Date();
                var edad = fechaHoy.getFullYear() - fechaNac.getFullYear();
                var m = fechaHoy.getMonth() - fechaNac.getMonth();

                if (m < 0 || (m === 0 && fechaHoy.getDate() < fechaNac.getDate())) {
                    edad--;  // Ajustar si aún no ha cumplido años este año
                }

                if (edad < 18) {
                    document.getElementById('errorFechaNac').innerText = "Debe tener al menos 18 años.";

                } else {
                    document.getElementById('errorFechaNac').innerText = "";
                }
            });


            }
        </script>



        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">



        <meta name="robots" content="noindex, follow">
    <body>

        <!-- Verifica si hay un mensaje de error -->
        <%
            String error = (String) request.getAttribute("error");
            if (error != null) {
        %>
        <script>
            Swal.fire({
                icon: 'error',
                title: 'Error',
                text: '<%= error %>',
                confirmButtonText: 'Cerrar'
            });
        </script>
        <%
            }
        %>


        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="registerUser" method="post">
                    <h1>Crear Cuenta</h1>

                    <div class="slider">

                        <input type="hidden" class="form-control"  id="txtIDCargo" name="txtIDCargo" value="1">


                        <!-- Nombre: solo letras, máximo 30 caracteres -->

                        <input type="text" id="txtNombre" name="txtNombre" pattern="[A-Za-z\s]{1,30}" placeholder="Nombre" required title="Solo se permiten letras , máximo 30 caracteres.">
                        <span id="errorNombre" style="color: red;"></span>


                        <!-- Apellido: solo letras, máximo 30 caracteres -->

                        <input type="text" id="txtApellido" name="txtApellido" pattern="[A-Za-z\s]{1,30}" placeholder="Apellido" required title="Solo se permiten letras, máximo 30 caracteres.">
                        <span id="errorApellido" style="color: red;"></span>


                        <!-- Dirección: solo letras y números, máximo 50 caracteres -->

                        <input type="text" id="txtDireccion" name="txtDireccion" 
                               pattern="[A-Za-z0-9\s\.\,]{1,50}" 
                               placeholder="Dirección" required 
                               title="Solo se permiten letras, máximo 50 caracteres.">
                        <span id="errorDireccion" style="color: red;"></span>


                        <!-- Correo: correo electrónico válido, máximo 50 caracteres -->

                        <input type="email" id="txtCorreo" name="txtCorreo" maxlength="50" placeholder="Correo" required title="Correo electrónico válido, máximo 50 caracteres.">
                        <span id="errorCorreo" style="color: red;"></span>


                        <input type="date" id="txtFechaNac" name="txtFechaNac" required title="Debe tener al menos 18 años."
                               min="<?php echo date('Y-m-d', strtotime('-18 years')); ?>" max="<?php echo date('Y-m-d'); ?>" />
                        <span id="errorFechaNac" style="color: red;"></span>



                        <!-- Identificación: solo números, exactamente 8 caracteres -->

                        <input type="text" id="txtIdentificacion" name="txtIdentificacion" pattern="\d{8}" placeholder="Identificación" required title="Debe ser solo números, exactamente 8 caracteres.">
                        <span id="errorIdentificacion" style="color: red;"></span>


                        <!-- Contraseña: mínimo 8 caracteres, incluyendo una letra mayúscula, un número y un carácter especial -->

                        <input type="password" id="txtContrasena" name="txtContrasena" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\W_]).{8,}" placeholder="Contraseña" required title="Debe tener mínimo 8 caracteres, incluyendo una mayúscula, un número y un carácter especial.">
                        <span id="errorContrasena" style="color: red;"></span>


                        <!-- Género: solo texto -->

                        <input type="text" id="txtGenero" name="txtGenero" pattern="^[MF]$" placeholder="Género" required title="Solo se permite un carácter: 'M' o 'F'.">
                        <span id="errorGenero" style="color: red;"></span>


                        <!-- Número de teléfono: solo números, exactamente 9 caracteres -->

                        <input type="text" id="txtTelf" name="txtTelf" pattern="\d{9}" placeholder="Número de Teléfono" required title="Debe ser solo números, exactamente 9 caracteres.">
                        <span id="errorTelf" style="color: red;"></span>


                    </div>
                    <button
                        type="submit" name="accion"  value="Guardar" >Guardar
                    </button>
                </form>
            </div>
            <div class="form-container sign-in-container">
                <form action="loginClients" method="post">
                    <h1>Login</h1>
                    <div class="social-container">

                    </div>
                    <% 
                                                               Cookie[] cookies=request.getCookies();
                                                               String valor ="";
                                                               for(Cookie c:cookies){
                                                                   if(c.getName().equals("usuario")){
                                                                   valor=c.getValue();
                                                                   }
                                                                   else{
                                                                   System.out.println("no encontrado");
                                                                   }
                        
                                                               }
                    
                    %>

                    <input type="email" id="txtCorreo" name="txtCorreo" placeholder="correo@example.com"  value="<%=valor%>" required/>

                    <input type="password" id="txtContrasena" name="txtContrasena" placeholder="Password" required/>

                    <button vtype="submit" name="accion" value="iniciar">Ingresar</button>
                    <td> <input name="ckbox" type="checkbox" checked="checked" >Recordar</input> </td>

                </form>
            </div>
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                        <h1>Bienvenido de nuevo!</h1>
                        <p>Inicia sesion con tus datos correctos.</p>
                        <button class="ghost" id="signIn">Login</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                        <h1>Hola, Bienvenido</h1>
                        <p>No tienes una cuenta?</p>
                        <button class="ghost" id="signUp">Registrarse</button>
                    </div>
                </div>
            </div>
        </div>

        <style>
            @import url('https://fonts.googleapis.com/css?family=Montserrat:400,800');

            * {
                box-sizing: border-box;
            }
            .slider {
                width: 100%;
                top: 0;
                height: 600px;
                overflow: auto;
            }

            .slider input {
                display: block;
                top: 40px;
                width: 100%;
                margin-bottom: 10px;
            }
            .slider button {
                bottom: 30px;
            }

            body {
                background-image: url('https://cdn.wallpapersafari.com/33/3/uJwBHK.jpg');
                background-size: cover;
                background-position: center;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-direction: column;
                font-family: 'Montserrat', sans-serif;
                height: 100vh;
                margin: -20px 0 50px;
            }

            h1 {
                font-weight: bold;
                margin: 0;
            }

            h2 {
                text-align: center;
            }

            p {
                font-size: 14px;
                font-weight: 100;
                line-height: 20px;
                letter-spacing: 0.5px;
                margin: 20px 0 30px;
            }

            span {
                font-size: 12px;
            }

            a {
                color: #333;
                font-size: 14px;
                text-decoration: none;
                margin: 15px 0;
            }

            button {
                border-radius: 20px;
                border: 1px solid #87CEEB;
                background-color: #87CEEB;
                color: #FFFFFF;
                font-size: 12px;
                font-weight: bold;
                padding: 12px 45px;
                letter-spacing: 1px;
                text-transform: uppercase;
                transition: transform 80ms ease-in;
            }

            button:active {
                transform: scale(0.95);
            }

            button:focus {
                outline: none;
            }

            button.ghost {
                background-color: transparent;
                border-color: #FFFFFF;
            }

            form {
                background-color: #FFFFFF;
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                padding: 0 50px;
                height: 100%;
                text-align: center;
            }

            input {
                background-color: #eee;
                border: none;
                padding: 12px 15px;
                margin: 8px 0;
                width: 100%;
            }

            .container {
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 14px 28px rgba(0, 0, 0, 0.25),
                    0 10px 10px rgba(0, 0, 0, 0.22);
                position: relative;
                overflow: hidden;
                width: 768px;
                max-width: 100%;
                min-height: 480px;
            }

            .form-container {
                position: absolute;
                top: 0;
                height: 100%;
                transition: all 0.6s ease-in-out;
            }

            .sign-in-container {
                left: 0;
                width: 50%;
                z-index: 2;
            }

            .container.right-panel-active .sign-in-container {
                transform: translateX(100%);
            }

            .sign-up-container {
                left: 0;
                width: 50%;
                opacity: 0;
                z-index: 1;
            }

            .container.right-panel-active .sign-up-container {
                transform: translateX(100%);
                opacity: 1;
                z-index: 5;
                animation: show 0.6s;
            }

            @keyframes show {

                0%,
                49.99% {
                    opacity: 0;
                    z-index: 1;
                }

                50%,
                100% {
                    opacity: 1;
                    z-index: 5;
                }
            }

            .overlay-container {
                position: absolute;
                top: 0;
                left: 50%;
                width: 50%;
                height: 100%;
                overflow: hidden;
                transition: transform 0.6s ease-in-out;
                z-index: 100;
            }

            .container.right-panel-active .overlay-container {
                transform: translateX(-100%);
            }

            .overlay {
                background:  #64B5F6;
                background: -webkit-linear-gradient(to right, #87CEEB, #64B5F6);
                background: linear-gradient(to right, #87CEEB, #64B5F6);
                background-repeat: no-repeat;
                background-size: cover;
                background-position: 0 0;
                color: #FFFFFF;
                position: relative;
                left: -100%;
                height: 100%;
                width: 200%;
                transform: translateX(0);
                transition: transform 0.6s ease-in-out;
            }

            .container.right-panel-active .overlay {
                transform: translateX(50%);
            }

            .overlay-panel {
                position: absolute;
                display: flex;
                align-items: center;
                justify-content: center;
                flex-direction: column;
                padding: 0 40px;
                text-align: center;
                top: 0;
                height: 100%;
                width: 50%;
                transform: translateX(0);
                transition: transform 0.6s ease-in-out;
            }

            .overlay-left {
                transform: translateX(-20%);
            }

            .container.right-panel-active .overlay-left {
                transform: translateX(0);
            }

            .overlay-right {
                right: 0;
                transform: translateX(0);
            }

            .container.right-panel-active .overlay-right {
                transform: translateX(20%);
            }

            .social-container {
                margin: 20px 0;
            }

            .social-container a {
                border: 1px solid #DDDDDD;
                border-radius: 50%;
                display: inline-flex;
                justify-content: center;
                align-items: center;
                margin: 0 5px;
                height: 40px;
                width: 40px;
            }

            footer {
                background-color: #222;
                color: #fff;
                font-size: 14px;
                bottom: 0;
                position: fixed;
                left: 0;
                right: 0;
                text-align: center;
                z-index: 999;
            }

            footer p {
                margin: 10px 0;
            }

            footer i {
                color: red;
            }

            footer a {
                color: #87CEEB;
                text-decoration: none;
            }
        </style>
        <script>
            const signUpButton = document.getElementById('signUp');
            const signInButton = document.getElementById('signIn');
            const container = document.getElementById('container');
            signUpButton.addEventListener('click', () => {
                container.classList.add("right-panel-active");
            });
            signInButton.addEventListener('click', () => {
                container.classList.remove("right-panel-active");
            });
        </script>

    </body>
</html>
