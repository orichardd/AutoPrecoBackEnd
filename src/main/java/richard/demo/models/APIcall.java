package richard.demo.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;

public class APIcall {

    //URL API "https://parallelum.com.br/fipe/api/v1/%s/marcas/%s/modelos/%s/anos/%s";

    Gson gson = new GsonBuilder().create();
    JsonElement brandsJson;


    public String requestAPI(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url.toURI())
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());

            brandsJson = gson.fromJson(response.body(), JsonElement.class);

            return response.body();

        } catch (Exception e) {
            System.out.println("Erro ao chamar API: " + e.getMessage());
            return null;
        }
    }
    //controller

    public String MostrarMarcas(String tipo){
        String url = "https://parallelum.com.br/fipe/api/v1/%s/marcas".formatted(tipo);
        return requestAPI(url);
    }

    public String MostrarModelos(String tipo, String codigoMarca){
        String url = "https://parallelum.com.br/fipe/api/v1/%s/marcas/%s/modelos".formatted(tipo, codigoMarca);
        return requestAPI(url);
    }

    public String MostrarAnos(String tipo, String codigoMarca, String codigoModelo) {
        String url = "https://parallelum.com.br/fipe/api/v1/%s/marcas/%s/modelos/%s/anos".formatted(tipo, codigoMarca ,codigoModelo);
        return requestAPI(url);
    }
    public String MostrarValor(String tipo, String codigoMarca, String codigoModelo, String codigoAno){
        String url = "https://parallelum.com.br/fipe/api/v1/%s/marcas/%s/modelos/%s/anos/%s".formatted(tipo, codigoMarca ,codigoModelo, codigoAno);
        return requestAPI(url);
    }
}
