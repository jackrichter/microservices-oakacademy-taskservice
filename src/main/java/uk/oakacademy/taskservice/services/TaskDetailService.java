package uk.oakacademy.taskservice.services;

import uk.oakacademy.taskservice.dto.TaskDetailDTO;

import java.util.List;

public interface TaskDetailService {
    public TaskDetailDTO save(TaskDetailDTO taskDetailDTO);
    public TaskDetailDTO getTaskDetailById(String id);
    public List<TaskDetailDTO> getAllTaskDetails();
    public TaskDetailDTO updateTaskDetail(TaskDetailDTO taskDetailDTO);
    public TaskDetailDTO deleteByTaskDetail(String id);
    public List<TaskDetailDTO> getWithContainDescription(String description);
}
