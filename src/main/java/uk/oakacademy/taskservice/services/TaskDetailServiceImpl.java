package uk.oakacademy.taskservice.services;

import org.springframework.stereotype.Service;
import uk.oakacademy.taskservice.dto.TaskDetailDTO;

import java.util.List;

@Service
public class TaskDetailServiceImpl implements TaskDetailService {
    @Override
    public TaskDetailDTO save(TaskDetailDTO taskDetailDTO) {
        return null;
    }

    @Override
    public TaskDetailDTO getTaskDetailById(String id) {
        return null;
    }

    @Override
    public List<TaskDetailDTO> getAllTaskDetails() {
        return List.of();
    }

    @Override
    public TaskDetailDTO updateTaskDetail(TaskDetailDTO taskDetailDTO) {
        return null;
    }

    @Override
    public TaskDetailDTO deleteByTaskDetail(String id) {
        return null;
    }

    @Override
    public List<TaskDetailDTO> getWithContainDescription(String description) {
        return List.of();
    }
}
