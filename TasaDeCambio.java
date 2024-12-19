import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TasaDeCambio {
    private ApiResponse apiResponse;

    public ApiResponse obtenerTasasDeCambio() throws IOException, InterruptedException {
        if (apiResponse == null) {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/7e0b457bfd2f596d23591fcc/latest/USD"))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println("Respuesta JSON: " + response.body());

            Gson gson = new Gson();
            apiResponse = gson.fromJson(response.body(), ApiResponse.class);
        }
        return apiResponse;
    }

    public double getTasaCambio(String moneda) {
        if (apiResponse == null || apiResponse.conversion_rates == null) {
            try {
                obtenerTasasDeCambio();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
                return -1; // Indica un error
            }
        }
        if (apiResponse == null || apiResponse.conversion_rates == null) {
            return -1; // Maneja el caso donde la obtención de datos falló
        }
        switch (moneda) {
            case "COP": return apiResponse.conversion_rates.getCOP();
            case "MXN": return apiResponse.conversion_rates.getMXN();
            case "ARS": return apiResponse.conversion_rates.getARS();
            case "EUR": return apiResponse.conversion_rates.getEUR();
            case "PEN": return apiResponse.conversion_rates.getPEN();
            default: return -1; // Indica una moneda no encontrada
        }
    }
}
