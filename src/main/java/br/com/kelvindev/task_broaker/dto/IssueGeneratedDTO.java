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
public class IssueGeneratedDTO {
    private List<TaskDTO> issueGenerated;
}
