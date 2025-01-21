package uk.oakacademy.taskservice.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.oakacademy.taskservice.dto.TaskDTO;
import uk.oakacademy.taskservice.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable("id") String id) {
        return new ResponseEntity<TaskDTO>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        return new ResponseEntity<TaskDTO>(taskService.saveTask(taskDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/pagination/{pageNo}/{pageSize}")
    public ResponseEntity<List<TaskDTO>> taskPagination(@PathVariable int pageNo, @PathVariable int pageSize) {
        return ResponseEntity.ok(taskService.getTasksByPagination(pageNo, pageSize));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable String id, @RequestBody TaskDTO taskDTO) {
        TaskDTO checkDto = taskService.getTaskById(id);
        if (checkDto != null) {
            return ResponseEntity.ok(taskService.updateTask(id, taskDTO));
        } else {
            return new ResponseEntity<TaskDTO>(new TaskDTO() ,HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable("id") String id) {
        TaskDTO checkDto = taskService.getTaskById(id);
        if (checkDto != null) {
            taskService.deleteTaskById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
