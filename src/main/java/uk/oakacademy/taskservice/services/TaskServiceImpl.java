package uk.oakacademy.taskservice.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uk.oakacademy.taskservice.dto.TaskDTO;
import uk.oakacademy.taskservice.entities.Task;
import uk.oakacademy.taskservice.repositories.TaskRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;

    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task task = modelMapper.map(taskDTO, Task.class);
        task = taskRepository.save(task);
        taskDTO.setId(task.getId());
        return taskDTO;
    }

    @Override
    public TaskDTO updateTask(String id, TaskDTO taskDTO) {
        taskDTO.setId(id);
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        task = modelMapper.map(taskDTO, Task.class);
        task = taskRepository.save(task);
        return modelMapper.map(task, TaskDTO.class);
    }

    @Override
    public TaskDTO getTaskById(String id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        TaskDTO taskDTO = modelMapper.map(task, TaskDTO.class);
        return taskDTO;
    }

    @Override
    public TaskDTO deleteTaskById(String id) {
        TaskDTO taskDTO = getTaskById(id);
        taskRepository.deleteById(id);
        return taskDTO;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOs = tasks.stream().map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
        return taskDTOs;
    }

    @Override
    public List<TaskDTO> getTasksByPagination(int pageNo, int pageSize) {
        Page<Task> tasks = taskRepository.findAll(PageRequest.of(pageNo, pageSize));
        List<TaskDTO> dtoList = tasks.stream().map(task -> modelMapper.map(task, TaskDTO.class))
                .collect(Collectors.toList());
        return dtoList;
    }
}
