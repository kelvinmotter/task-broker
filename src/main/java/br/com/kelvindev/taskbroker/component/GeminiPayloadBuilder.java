package br.com.kelvindev.taskbroker.component;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class GeminiPayloadBuilder {

    public Map<String, Object> build(String prompt) {
        return Map.of(
                "contents", List.of(
                        Map.of(
                                "parts", List.of(
                                        Map.of("text", prompt)
                                )
                        )
                )
        );
    }
}
