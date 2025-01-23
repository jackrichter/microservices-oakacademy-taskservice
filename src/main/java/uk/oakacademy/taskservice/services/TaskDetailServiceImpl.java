package uk.oakacademy.taskservice.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uk.oakacademy.taskservice.dto.TaskDetailDTO;
import uk.oakacademy.taskservice.entities.TaskDetail;
import uk.oakacademy.taskservice.repositories.TaskDetailRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskDetailServiceImpl implements TaskDetailService {

    private final TaskDetailRepository taskDetailRepository;
    private final ModelMapper modelMapper;

    @Override
    public TaskDetailDTO save(TaskDetailDTO taskDetailDTO) {
        TaskDetail taskDetail = modelMapper.map(taskDetailDTO, TaskDetail.class);
        taskDetail = taskDetailRepository.save(taskDetail);
        taskDetailDTO = modelMapper.map(taskDetail, TaskDetailDTO.class);

        return taskDetailDTO;
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
