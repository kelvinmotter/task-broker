package br.com.kelvindev.task_broaker.service;

import br.com.kelvindev.task_broaker.dto.IssueGeneratedDTO;
import br.com.kelvindev.task_broaker.enums.AIType;

public interface GenerateAI {

    AIType getType();
    IssueGeneratedDTO process(String input);

}
