package br.com.kelvindev.task_broaker.component;

import br.com.kelvindev.task_broaker.enums.AIType;
import br.com.kelvindev.task_broaker.service.GenerateAI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class AIServiceFactory {

    private final Map<AIType, GenerateAI> strategies = new EnumMap<>(AIType.class);

    @Autowired
    public AIServiceFactory(List<GenerateAI> services) {
        for (GenerateAI service : services) {
            strategies.put(service.getType(), service);
        }
    }

    public GenerateAI get(AIType type) {
        GenerateAI strategy = strategies.get(type);

        if (strategy == null) {
            throw new IllegalArgumentException("IA não suportada: " + type);
        }

        return strategy;
    }
}
