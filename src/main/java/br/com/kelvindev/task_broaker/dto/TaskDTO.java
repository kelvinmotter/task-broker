package br.com.kelvindev.task_broaker.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {

    private Integer id;
    private String title;
    private String type;
    private int estimateDays;
    private String objective;
    private List<String> scope;
    private List<String> acceptanceCriteria;
    private List<String> testScenarios;
    private List<String> unitTests;
    private List<Integer> dependencies;

}
