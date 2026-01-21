package br.com.kelvindev.taskbroker.service;


import br.com.kelvindev.taskbroker.component.GeminiPayloadBuilder;
import br.com.kelvindev.taskbroker.component.GeminiResponseParser;
import br.com.kelvindev.taskbroker.component.PromptBuilder;
import br.com.kelvindev.taskbroker.dto.GenerateDTO;
import br.com.kelvindev.taskbroker.dto.IssueGeneratedDTO;
import br.com.kelvindev.taskbroker.enums.AIType;
import br.com.kelvindev.taskbroker.infrastructure.http.GeminiHttpClient;
import br.com.kelvindev.taskbroker.utils.JsonUtil;
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
    public IssueGeneratedDTO process(GenerateDTO dto) {
        String prompt = promptBuilder.build(dto);
        String payload = JsonUtil.toJson(payloadBuilder.build(prompt));

        String responseBody = httpClient.post(payload);
        String text = responseParser.extractText(responseBody);

        return JsonUtil.fromJson(text, IssueGeneratedDTO.class);
    }


}
