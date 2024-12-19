public class ConversionRatesData {
    public double COP;
    public double MXN;
    public double ARS;
    public double EUR;
    public double PEN;
    // Agrega aquí todos los demás campos de moneda que necesitas, según la respuesta JSON de la API.

    //Getters para cada moneda
    public double getCOP() { return COP; }
    public double getMXN() { return MXN; }
    public double getARS() { return ARS; }
    public double getEUR() { return EUR; }
    public double getPEN() { return PEN; }
    // ... y así sucesivamente para todas las monedas en la respuesta JSON
}