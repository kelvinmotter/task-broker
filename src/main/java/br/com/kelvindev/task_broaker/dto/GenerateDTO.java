package br.com.kelvindev.task_broaker.dto;

import br.com.kelvindev.task_broaker.enums.AIType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenerateDTO {

    private String token;
    private String input;
    private AIType type;

}
