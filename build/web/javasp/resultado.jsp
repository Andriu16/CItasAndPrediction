<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gráfico, Velocímetro y Termómetro</title>
        <link rel="stylesheet" href="progress.css">
        <link rel="stylesheet" href="speedometer.css">
        <!--<link rel="stylesheet" href="thermomether.css">-->
        <link rel="stylesheet" href="styles.css"> <!-- Archivo para el diseño -->

        <style>


            @import url('https://fonts.googleapis.com/css?family=Jaldi&display=swap');

            body {
                display: flex;
                height: 100vh;
                margin: 0;
                background-image: url('https://i.pinimg.com/736x/cc/ae/3b/ccae3b1b81bf8fe32603efd7c4c0b3df.jpg'); /* Reemplaza con la ruta de tu imagen */
                background-size: cover; /* Hace que la imagen cubra todo el fondo */
                background-position: center; /* Centra la imagen */
                background-repeat: no-repeat; /* Evita que la imagen se repita */
                font-family: 'Jaldi', sans-serif;
                font-size: 14px;
                color: white;
            }

            #wrapper {
                margin: auto;
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            #termometer {
                width: 100px;
                background: #3b3b3b;
                height: 400px;
                position: relative;
                border: 9px solid #313135;
                border-radius: 20px;
                margin-bottom: 50px;
            }

            #termometer:before,
            #termometer:after {
                position: absolute;
                content: "";
                border-radius: 50%;
            }

            #termometer:before {
                width: 100%;
                height: calc(50px / 2 + 9px);
                bottom: 9px;
                background: #3b3b3b;
            }

            #termometer:after {
                transform: translateX(-50%);
                width: 100px;
                height: 100px;
                background-color: #3dcadf;
                bottom: -50px;
                border: 9px solid #313135;
                left: 50%;
            }

            #graduations {
                height: 50%;
                top: 10%;
                width: 50%;
                position: absolute;
                border-top: 3px solid rgba(0, 0, 0, 0.5);
                border-bottom: 3px solid rgba(0, 0, 0, 0.5);
            }

            #temperature {
                position: absolute;
                bottom: 0;
                width: 100%;
                border-radius: 20px;
                transform-origin: bottom;
                transition: height 0.2s ease-in-out, background 0.2s ease-in-out; /* Suaviza el cambio de degradado */
            }


            #temperature:before {
                content: attr(data-value);
                background: rgba(0, 0, 0, 0.7);
                color: white;
                position: absolute;
                z-index: 2;
                padding: 5px 12px;
                border-radius: 5px;
                font-size: 1em;
                transform: translateY(50%);
                left: 110%;
                top: -10%;
            }

            #playground {
                font-size: 1.1em;
            }

            #range {
                display: flex;
                justify-content: center;
                align-items: center;
            }

            input[type="range"] {
                width: 200px;
                margin: 0 10px;
            }

            input[type="text"] {
                width: 3em;
                text-align: center;
                background: transparent;
                border: none;
                color: inherit;
                font: inherit;
                margin: 0 5px;
                padding: 0px 5px;
                border-bottom: 2px solid transparent;
                transition: all 0.2s ease-in-out;
            }

            input[type="text"]:focus {
                border-color: #3dcadf;
                outline: none;
            }

            h1 {
                margin: 20px 0;
                font-size: 24px;
                color: #fff;
            }

            .dashboard {
                display: grid;
                grid-template-columns: repeat(2, 1fr);
                gap: 20px;
                width: 90%;
                max-width: 1200px;
                height: auto;
            }

            .card {
                background: #1c1a1c;
                border-radius: 70px;
                padding: 20px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
            }

            .card h2 {
                font-size: 20px;
                margin: 10px 0;
            }

            .rectangle-horizontal {
                grid-column: span 2; /* Abarca dos columnas */
                background: #1c1a1c;
                border-radius: 20px;
                padding: 25px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
            }

            .rectangle-horizontal h2 {
                font-size: 20px;
                margin: 10px 0;
            }

            .rectangle-vertical {
                grid-row: span 2; /* Abarca dos filas */
                background: #1c1a1c;
                border-radius: 70px;
                padding: 20px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
            }

            .rectangle-vertical h2 {
                font-size: 20px;
                margin: 10px 0;
            }

            .rectangle-vertical p {
                text-align: center;
                font-size: 16px;
                margin: 5px 0;
            }





        </style>
    </head>
    <body>
        <h1 style="color: #ffffff">Resultado de Predicción de Enfermedades Cardiovasculares</h1>
        <div style="color: #fdf300; font-size: 35px; font-weight: bold;" class="resultado ${resultado.contains('bajo') ? 'sano' : 'enfermo'}">
            ${resultado}
        </div>
        <div class="dashboard">
            <!-- Rectángulo horizontal (Métricas + Estado General) -->
            <div class="rectangle-horizontal">
                <h2 style="font-size: 30px;">Colesterol Del Paciente es ${chol} mg/dl </h2>
                <!-- Gráfico de barras -->
                <div class="progress-container">
                    <div class="markers">
                        <div class="marker"><span>10%</span><div class="dot"></div></div>
                        <div class="marker"><span>20%</span><div class="dot"></div></div>
                        <div class="marker"><span>30%</span><div class="dot"></div></div>
                        <div class="marker"><span>40%</span><div class="dot"></div></div>
                        <div class="marker"><span>50%</span><div class="dot"></div></div>
                        <div class="marker"><span>60%</span><div class="dot"></div></div>
                        <div class="marker"><span>70%</span><div class="dot"></div></div>
                        <div class="marker"><span>80%</span><div class="dot"></div></div>
                        <div class="marker"><span>90%</span><div class="dot"></div></div>
                        <div class="marker"><span>100%</span><div class="dot"></div></div>
                    </div>
                    <div class="progress-bar-background">
                        <div></div>
                        <div></div>
                        <div></div>
                        <div></div>
                        <div></div>
                        <div></div>
                        <div></div>
                        <div></div>
                        <div></div>
                    </div>


                    <div class="progress" style="width: ${progressValue}%;">
                        <div class="progress-indicator">${chol}</div>
                    </div>

                </div>
            </div>

            <!-- Rectángulo vertical (Resultado + Indicador) -->
            <div class="rectangle-vertical">
                <h2 style="font-size: 30px;">Frecuencia Cardiaca del Paciente</h2>
                <div id="wrapper">
                    <div id="termometer">
                        <div id="graduations"></div>
                        <!-- Ajusta la altura dinámicamente -->
                        <div id="temperature" style="height: ${heightPercentage}%; background: linear-gradient(to top, #3dcadf, #ff0000);" data-value="${thalach}"></div>
                    </div>
                    <p style="font-size: 20px;" id="range-info">Frecuencia Cardiaca máxima alcanzada: ${thalach} bpm</p>
                </div>

            </div>

            <!-- Card adicional -->
            <div class="card">
                <h2 style="font-size: 30px;">Glucemia ${glucemiaScore} a 120 mg/dl</h2>
                <div class="speedometer-row">
                    <div class="speedometer medium">
                        <div class="needle" style="--score:${glucemiaValoRate}" data-type="Glucemia">
                            <span class="score">${fbs}</span>

                        </div>

                    </div>
                </div>
            </div>

            <!-- Card adicional -->
            <div class="card">

                <h2 style="font-size: 30px;">Tension Arterial Del Paciente es ${trestbps} </h2>
                <div class="speedometer-row">
                    <div class="speedometer medium">
                        <div class="needle" style="--score:${trestbpsScore}" data-type="Tensión Arterial">
                            <span class="score">${trestbps}</span>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>

    <script src="script_1.js"></script>


</html>
