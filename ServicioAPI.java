import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ServicioAPI {

    private final String apiKey = "20e598d33187bb013dd60ce9";

    public ModeloRespuesta obtenerTasas() {

        try {

            String url = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString()
            );

            Gson gson = new Gson();

            return gson.fromJson(response.body(), ModeloRespuesta.class);

        } catch (Exception e) {
            System.out.println("Error al consumir la API: " + e.getMessage());
            return null;
        }
    }
}
