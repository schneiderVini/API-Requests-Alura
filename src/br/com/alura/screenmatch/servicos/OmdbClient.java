package br.com.alura.screenmatch.servicos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OmdbClient {
    private static final String API_KEY = "a54e5e15";
    private static final String BASE_URL = "https://www.omdbapi.com/?t=%s&apikey=%s";

    public String search(String title ) throws IOException, InterruptedException {
        String url = String.format(BASE_URL, title.replace(" ", "+"),API_KEY);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }

}
