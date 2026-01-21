package br.com.kelvindev.taskbroker.controller;

import br.com.kelvindev.taskbroker.component.AIServiceFactory;
import br.com.kelvindev.taskbroker.dto.GenerateDTO;
import br.com.kelvindev.taskbroker.dto.IssueGeneratedDTO;
import br.com.kelvindev.taskbroker.service.GenerateAI;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("api/generate/issues")
@AllArgsConstructor(onConstructor_ = @Autowired)
public class IssueController {

    private AIServiceFactory aiFactory;

    @PostMapping
    public ResponseEntity<IssueGeneratedDTO> generateIssues(@RequestBody GenerateDTO request) {
        GenerateAI ai = aiFactory.get(request.getType());
        IssueGeneratedDTO response = ai.process(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}
