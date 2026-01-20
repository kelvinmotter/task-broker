package br.com.kelvindev.task_broaker.service;

import br.com.kelvindev.task_broaker.dto.IssueGeneratedDTO;
import br.com.kelvindev.task_broaker.enums.AIType;
import org.springframework.stereotype.Service;

@Service
public class OpenAIService implements GenerateAI {
    @Override
    public AIType getType() {
        return AIType.OPEN_AI;
    }

    @Override
    public IssueGeneratedDTO process(String input) {
        return null;
    }
}
