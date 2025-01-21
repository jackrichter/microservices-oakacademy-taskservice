package uk.oakacademy.taskservice.services;

import uk.oakacademy.taskservice.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    public TaskDTO saveTask(TaskDTO taskDTO);
    public TaskDTO updateTask(String id, TaskDTO taskDTO);
    public TaskDTO getTaskById(String id);
    public TaskDTO deleteTaskById(String id);
    public List<TaskDTO> getAllTasks();
    public List<TaskDTO> getTasksByPagination(int pageNo, int pageSize);
}
