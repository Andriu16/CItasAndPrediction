<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cardiovascular Prediction Dashboard</title>
        <link rel="stylesheet" href="styles.css">
        <link rel="stylesheet" href="progress.css">
        <link rel="stylesheet" href="speedometer.css">
        <!--<link rel="stylesheet" href="thermomether.css">-->
        
        <style>
            /* General Styles */
            body {
                margin: 0;
                padding: 0;
                background-color: #2e2e38;
                font-family: 'Arial', sans-serif;
                color: #fff;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: flex-start;
                height: 100vh;
            }

            h1 {
                margin: 20px 0;
                font-size: 24px;
                color: #fff;
            }

            .dashboard {
                display: grid;
                grid-template-columns: repeat(2, 1fr);
                grid-template-rows: repeat(2, 1fr);
                gap: 20px;
                width: 90%;
                max-width: 1200px;
                height: 80%;
            }

            .card {
                background: #3d3d44;
                border-radius: 10px;
                padding: 20px;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
            }

            .card h2 {
                font-size: 20px;
                margin-bottom: 10px;
            }

            .card p {
                margin-bottom: 10px;
                justify-content: center;
                flex-direction: column;
                align-items: center;
            }

            /* Gauge styles */
            .gauge-container {
                position: relative;
                width: 150px;
                height: 150px;
            }

            .gauge {
                width: 100%;
                height: 100%;
                border-radius: 50%;
                background: conic-gradient(
                    #ad309d 0% 60%,
                    #b968af 60% 80%,
                    #b18bac 80% 100%
                    );
                position: absolute;
            }

            .gauge .center {
                position: absolute;
                width: 60%;
                height: 60%;
                background: #2e2e38;
                border-radius: 50%;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .gauge .center span {
                font-size: 18px;
                font-weight: bold;
                color: #fff;
            }

            /* Bar Chart */
            .bar-chart {
                width: 100%;
            }

            .bar {
                background: #b18bac;
                height: 20px;
                margin: 5px 0;
                border-radius: 5px;
            }

            .bar span {
                position: relative;
                display: block;
                padding: 0 10px;
                color: #fff;
            }

            /* Pie Chart */
            .pie-container {
                position: relative;
                width: 150px;
                height: 150px;
            }

            .pie {
                width: 100%;
                height: 100%;
                border-radius: 50%;
                background: conic-gradient(
                    #ad309d 0% 60%,
                    #b968af 60% 80%,
                    #b18bac 80% 100%
                    );
            }

            .pie .center {
                position: absolute;
                width: 60%;
                height: 60%;
                background: #2e2e38;
                border-radius: 50%;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
                display: flex;
                align-items: center;
                justify-content: center;
            }

            .pie .center span {
                font-size: 18px;
                font-weight: bold;
                color: #fff;
            }

            #wrapper {
                margin: auto;
                display: flex;
                flex-direction: column;
                align-items: center;
            }

            #termometer {
                width: 70px;
                background: #3b3b3b;
                height: 240px;
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
                width: 70px;
                height: 70px;
                background-color: #b442a5;
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
        </style>
    </head>
    <body>
        <h1>Resultado de Predicción de Enfermedades Cardiovasculares</h1>
        <div class="resultado ${resultado.contains('bajo') ? 'sano' : 'enfermo'}">
            ${resultado}
        </div>
        <div class="dashboard">
            <!-- Card 1: Cost Performance -->


            <!-- Card 2: Performance Metrics -->
            <div class="card">
                <h2>Métricas de Rendimiento</h2>
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

            <div class="card">
                <h2>Estado General</h2>
                <p>Diagnosticó: Probabilidad alta de complicación cardiovascular inminente.</p>
                <p>Contacta con nuestro servicio.</p>
            </div>

            <!-- Card 3: Time vs Phases -->
            <div class="card">
                <h2>Fases del Proyecto</h2>
                <div class="pie-container">
                    <div class="pie">
                        <div class="center"><span>60%</span></div>
                    </div>
                </div>
            </div>

            <div class="card">
                <h2>Resultado del Análisis</h2>
                <div class="gauge-container">
                    <div class="gauge">
                        <div class="center"><span>48%</span></div>
                    </div>
                </div>
            </div>


            <!-- Card 5 -->
            <div class="card">
                <div id="wrapper">
                    <div id="termometer">
                        <div id="graduations"></div>
                        <div id="temperature" style="height: 20%; background: linear-gradient(to top, #3dcadf, #ff0000);" data-value="26"></div>
                    </div>
                    <p id="range-info">Frecuencia cardiaca máxima alcanzada: 20 bpm</p>
                </div>
            </div>

            <!-- Card 6 -->
            <div class="card">
                <div class="speedometers-container">
                    <div class="speedometer-row">
                        <div class="speedometer medium">
                            <div class="needle" style="--score:30">
                                <span class="score">30</span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="script_1.js"></script>
    </body>
</html>