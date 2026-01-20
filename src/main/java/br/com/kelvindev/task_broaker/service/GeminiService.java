package br.com.kelvindev.task_broaker.service;


import br.com.kelvindev.task_broaker.component.GeminiPayloadBuilder;
import br.com.kelvindev.task_broaker.component.GeminiResponseParser;
import br.com.kelvindev.task_broaker.component.PromptBuilder;
import br.com.kelvindev.task_broaker.dto.IssueGeneratedDTO;
import br.com.kelvindev.task_broaker.enums.AIType;
import br.com.kelvindev.task_broaker.infrastructure.http.GeminiHttpClient;
import br.com.kelvindev.task_broaker.utils.JsonUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor(onConstructor_ = @Autowired)
public class GeminiService implements GenerateAI {

    private final PromptBuilder promptBuilder;
    private final GeminiPayloadBuilder payloadBuilder;
    private final GeminiResponseParser responseParser;
    private final GeminiHttpClient httpClient;

    @Override
    public AIType getType() {
        return AIType.GEMINI;
    }

    @Override
    public IssueGeneratedDTO process(String input) {
        String prompt = promptBuilder.build(input);
        String payload = JsonUtil.toJson(payloadBuilder.build(prompt));

        String responseBody = httpClient.post(payload);
        String text = responseParser.extractText(responseBody);

        return JsonUtil.fromJson(text, IssueGeneratedDTO.class);
    }


}
