<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Predicción de Enfermedades Cardiacas</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
        <style>
            @import url('https://fonts.googleapis.com/css?family=Montserrat:400,600&display=swap');
            body {
                font-family: 'Montserrat', sans-serif;
                background: #daf9fb;
                display: grid;
                place-items: center;
                height: 100vh;
                margin: 0;
            }

            .signup-container {
                display: grid;
                grid-template-areas: "left right";
                max-width: 900px;
                background: #daf9fb;
                border-radius: 15px;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
                overflow: hidden;
            }

            .left-container {
                background: #807182;
                padding: 40px;
                text-align: center;
                position: relative;
            }

            .left-container h1 {
                color: #fff;
                font-size: 24px;
            }

            .puppy img {
                width: 100%;
                
                margin-top: 100px;
            }

            .right-container {
                background: #70e8f0;
                padding: 40px;
                display: grid;
                grid-template-areas: "form";
            }

            .right-container h1 {
                font-size: 28px;
                color: #333;
            }

            .set {
                margin-bottom: 15px;
                display: flex;
                justify-content: space-between;
            }

            .set label {
                color: #333;
                margin-bottom: 5px;
            }

            .set input {
                border: 1px solid rgba(0, 0, 0, 0.1);
                border-radius: 4px;
                height: 38px;
                padding: 0 10px;
                width: 100%;
            }

            input[type="submit"] {
                background: #807182;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 20px;
                cursor: pointer;
                margin-top: 20px;
            }

            input[type="submit"]:hover {
                background: #5a4b6e;
            }

            .footer {
                margin-top: 20px;
                text-align: center;
            }

            .footer button {
                background: #333;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin: 5px;
            }

            .footer button:hover {
                background: #555;
            }

            /* Style for radio buttons */
            .radio-container {
                display: flex;
                gap: 20px;
                margin-bottom: 15px;
            }

            .radio-container input {
                margin-right: 5px;
            }

            .radio-container label {
                font-size: 16px;
            }

        </style>
    </head>
    <body>

        <div class="signup-container">
            <!-- Left Side -->
            <div class="left-container">
                <h1>Predicción de Enfermedades Cardiacas</h1>
                <div class="puppy">
                    <img src="https://i.pinimg.com/736x/28/7d/0b/287d0be5643810832bf89b2aee7e0205.jpg" alt="Health Prediction">
                </div>
            </div>

            <!-- Right Side (Form Section) -->
            <div class="right-container">
                <header>
                    <h1>Ingrese los Datos de Salud</h1>
                </header>

                <!-- Formulario -->
                <form action="../ControllerPredict" method="post">
                    <div class="set">
                        <label for="age">Edad (en años):</label>
                        <input type="number" id="age" name="age" required>
                    </div>

                    <!-- Gender Selection: Radio buttons for Male (1) and Female (0) -->
                    <div class="set">
                        <label>Sexo:</label>
                        <div class="radio-container">
                            <input type="radio" id="female" name="sex" value="0" required>
                            <label for="female">Femenino</label>
                            <input type="radio" id="male" name="sex" value="1" required>
                            <label for="male">Masculino</label>
                        </div>
                    </div>

                    <div class="set">
                        <label for="cp">Tipo de Dolor en el Pecho:</label>
                        <input type="number" id="cp" name="cp" required>
                    </div>

                    <div class="set">
                        <label for="trestbps">Presión Arterial en Reposo (mm Hg):</label>
                        <input type="number" id="trestbps" name="trestbps" required>
                    </div>

                    <div class="set">
                        <label for="chol">Nivel de Colesterol (mg/dl):</label>
                        <input type="number" id="chol" name="chol" required>
                    </div>

                    <div class="set">
                        <label for="fbs">Azúcar en Sangre en Ayunas (1 = >120 mg/dl, 0 = Normal):</label>
                        <input type="number" id="fbs" name="fbs" required>
                    </div>

                    <div class="set">
                        <label for="restecg">Resultados Electrocardiográficos:</label>
                        <input type="number" id="restecg" name="restecg" required>
                    </div>

                    <div class="set">
                        <label for="thalach">Frecuencia Cardíaca Máxima Alcanzada:</label>
                        <input type="number" id="thalach" name="thalach" required>
                    </div>

                    <div class="set">
                        <label for="exang">Angina Inducida por Ejercicio:</label>
                        <input type="number" id="exang" name="exang" required>
                    </div>

                    <div class="set">
                        <label for="oldpeak">Depresión ST Inducida por Ejercicio:</label>
                        <input type="number" id="oldpeak" name="oldpeak" step="0.1" required>
                    </div>

                    <div class="set">
                        <label for="slope">Pendiente del Segmento ST:</label>
                        <input type="number" id="slope" name="slope" required>
                    </div>

                    <div class="set">
                        <label for="ca">Número de Vasos Principales:</label>
                        <input type="number" id="ca" name="ca" required>
                    </div>

                    <div class="set">
                        <label for="thal">Thal:</label>
                        <input type="number" id="thal" name="thal" required>
                    </div>

                    <div class="set">
                        <input type="submit" value="Cancelar">
                        <input type="submit" value="Enviar">
                    </div>
                </form>
            </div>
        </div>

    </body>
</html>