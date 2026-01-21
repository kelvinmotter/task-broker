package br.com.kelvindev.taskbroker.component;

import br.com.kelvindev.taskbroker.record.GeminiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

@Component
public class GeminiResponseParser {

    @Autowired
    private ObjectMapper objectMapper;

    public String extractText(String responseBody) {
        try {
            GeminiResponse response =
                    objectMapper.readValue(responseBody, GeminiResponse.class);

            return response
                    .candidates()
                    .get(0)
                    .content()
                    .parts()
                    .get(0)
                    .text();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao processar resposta Gemini", e);
        }
    }
}
