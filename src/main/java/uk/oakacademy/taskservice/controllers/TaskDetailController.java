package uk.oakacademy.taskservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.oakacademy.taskservice.dto.TaskDetailDTO;
import uk.oakacademy.taskservice.services.TaskDetailService;

import java.util.List;

@RestController
@RequestMapping("/taskdetail")
@RequiredArgsConstructor
public class TaskDetailController {

    private final TaskDetailService taskDetailService;

    @PostMapping
    public ResponseEntity<TaskDetailDTO> addTaskDetail(@RequestBody TaskDetailDTO taskDetailDTO) {
        return new ResponseEntity<TaskDetailDTO>(taskDetailService.save(taskDetailDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<List<TaskDetailDTO>> getAllTaskDetails() {
        return ResponseEntity.ok(taskDetailService.getAllTaskDetails());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDetailDTO> getTaskDetailById(@PathVariable("id") String id) {
        return ResponseEntity.ok(taskDetailService.getTaskDetailById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDetailDTO> updateTaskDetail(@PathVariable String id, @RequestBody TaskDetailDTO taskDetailDTO) {
        TaskDetailDTO checkDto = taskDetailService.getTaskDetailById(id);

        if (checkDto != null) {
            taskDetailDTO.setId(id);
            return ResponseEntity.ok(taskDetailService.updateTaskDetail(taskDetailDTO));
        }
        else {
            return new ResponseEntity<>(new TaskDetailDTO(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TaskDetailDTO> deleteTaskDetail(@PathVariable String id) {
        return ResponseEntity.ok(taskDetailService.deleteTaskDetail(id));
    }

    @GetMapping("/description/{description}")
    public ResponseEntity<List<TaskDetailDTO>> getByDescription(@PathVariable String description) {
        return ResponseEntity.ok(taskDetailService.getWithContainDescription(description));
    }

    @GetMapping("/name/{text}")
    public ResponseEntity<List<TaskDetailDTO>> getByStartsWithName(@PathVariable String text) {
        return ResponseEntity.ok(taskDetailService.getWithStartsName(text));
    }
}
