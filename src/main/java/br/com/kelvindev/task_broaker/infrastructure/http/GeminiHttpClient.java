package br.com.kelvindev.task_broaker.infrastructure.http;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Slf4j
@Component
public class GeminiHttpClient {

    private static final String URL =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-3-flash-preview:generateContent";

    private static final String API_KEY = "SUA_API_KEY";

    private final HttpClient httpClient;

    public GeminiHttpClient() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    public String post(String jsonPayload) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("Content-Type", "application/json")
                    .header("X-goog-api-key", API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                    .build();

            HttpResponse<String> response =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                log.error("Erro Gemini {} - {}", response.statusCode(), response.body());
                throw new RuntimeException("Erro ao chamar Gemini");
            }

            return response.body();

        } catch (Exception e) {
            throw new RuntimeException("Erro na comunicação HTTP com Gemini", e);
        }
    }
}
