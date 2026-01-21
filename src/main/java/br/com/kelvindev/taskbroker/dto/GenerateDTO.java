package br.com.kelvindev.taskbroker.dto;

import br.com.kelvindev.taskbroker.enums.AIType;
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
    private int leadtime;

}
