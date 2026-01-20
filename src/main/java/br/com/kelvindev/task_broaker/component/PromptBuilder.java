package br.com.kelvindev.task_broaker.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {

    @Autowired
    private PromptLoaderComponent promptLoader;

    public String build(String description) {
        String template = promptLoader.load("breakdown_issues.txt");

        return template
                .replace("{{stack}}", "Java 17")
                .replace("{{leadTime}}", "3")
                .replace("{{requisito}}", description);
    }
}
