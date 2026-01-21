package br.com.kelvindev.taskbroker.service;

import br.com.kelvindev.taskbroker.dto.GenerateDTO;
import br.com.kelvindev.taskbroker.dto.IssueGeneratedDTO;
import br.com.kelvindev.taskbroker.enums.AIType;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService implements GenerateAI {
    @Override
    public AIType getType() {
        return AIType.OPEN_AI;
    }

    @Override
    public IssueGeneratedDTO process(GenerateDTO dto) {
        return null;
    }
}
