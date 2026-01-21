package br.com.kelvindev.taskbroker.component;

import br.com.kelvindev.taskbroker.dto.GenerateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {

    @Autowired
    private PromptLoaderComponent promptLoader;

    public String build(GenerateDTO dto) {
        String template = promptLoader.load("breakdown_issues.txt");

        return template
                .replace("{{LEAD_TIME}}", String.valueOf(dto.getLeadtime()))
                .replace("{{DESCRICAO_DO_REQUISITO}}", dto.getInput());
    }
}
