package br.com.kelvindev.taskbroker.component;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class PromptLoaderComponent {

    public String load(String promptName) {
        try (InputStream input = getClass()
                .getClassLoader()
                .getResourceAsStream("prompts/" + promptName)) {

            if (input == null) {
                throw new IllegalArgumentException("Prompt não encontrado");
            }

            return new String(input.readAllBytes(), StandardCharsets.UTF_8);

        } catch (IOException e) {
            throw new IllegalArgumentException("Erro ao carregar prompt", e);
        }
    }

}
