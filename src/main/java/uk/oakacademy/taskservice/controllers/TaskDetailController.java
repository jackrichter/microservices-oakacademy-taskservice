package uk.oakacademy.taskservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.oakacademy.taskservice.dto.TaskDetailDTO;
import uk.oakacademy.taskservice.services.TaskDetailService;

@RestController
@RequestMapping("/taskdetail")
@RequiredArgsConstructor
public class TaskDetailController {

    private final TaskDetailService taskDetailService;

    @PostMapping
    public ResponseEntity<TaskDetailDTO> addTaskDetail(@RequestBody TaskDetailDTO taskDetailDTO) {
        return new ResponseEntity<TaskDetailDTO>(taskDetailService.save(taskDetailDTO), HttpStatus.CREATED);
    }
}
