package br.com.kelvindev.taskbroker.service;

import br.com.kelvindev.taskbroker.dto.GenerateDTO;
import br.com.kelvindev.taskbroker.dto.IssueGeneratedDTO;
import br.com.kelvindev.taskbroker.enums.AIType;

public interface GenerateAI {

    AIType getType();
    IssueGeneratedDTO process(GenerateDTO dto);

}
