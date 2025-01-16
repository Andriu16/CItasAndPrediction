

const units = {
  Celsius: "°C",
  Fahrenheit: "°F"
};

const config = {
  minTemp: -20,
  maxTemp: 50,
  unit: "Celsius"
};

const tempValueInputs = document.querySelectorAll("input[type='text']");
const rangeInput = document.getElementById("tempRange");
const temperature = document.getElementById("temperature");
const unitToggle = document.getElementById("unit");

// Actualiza los límites de temperatura
tempValueInputs.forEach((input) => {
  input.addEventListener("change", (event) => {
    const newValue = parseInt(event.target.value);
    if (isNaN(newValue)) return;
    config[event.target.id] = newValue;
    rangeInput.min = config.minTemp;
    rangeInput.max = config.maxTemp;
    updateTemperature();
  });
});

// Cambia entre Celsius y Fahrenheit
unitToggle.addEventListener("click", () => {
  config.unit = config.unit === "Celsius" ? "Fahrenheit" : "Celsius";
  unitToggle.textContent = `${config.unit} ${units[config.unit]}`;
  updateTemperature();
});

// Actualiza la altura y el texto del termómetro
function updateTemperature() {
  const value = rangeInput.value;

  // Calcula el porcentaje del nivel del mercurio
  const percentage = ((value - config.minTemp) / (config.maxTemp - config.minTemp)) * 100;

  // El degradado va de azul (abajo) a rojo (arriba)
  const gradient = `linear-gradient(to top, rgb(61, 202, 223), rgba(255, 0, 0, ${percentage / 100}))`;

  // Aplica la altura y el degradado
  temperature.style.height = `${percentage}%`;
  temperature.style.background = gradient;
  temperature.dataset.value = `${value} ${units[config.unit]}`;
}




// Detecta cambios en el rango
rangeInput.addEventListener("input", updateTemperature);

// Inicializa
updateTemperature();


