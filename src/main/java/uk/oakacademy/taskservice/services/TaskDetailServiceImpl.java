package uk.oakacademy.taskservice.services;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import uk.oakacademy.taskservice.dto.TaskDetailDTO;
import uk.oakacademy.taskservice.entities.TaskDetail;
import uk.oakacademy.taskservice.repositories.TaskDetailRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        TaskDetail taskDetail = taskDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskDetail not found"));
        TaskDetailDTO taskDetailDTO = modelMapper.map(taskDetail, TaskDetailDTO.class);

        return taskDetailDTO;
    }

    @Override
    public List<TaskDetailDTO> getAllTaskDetails() {
        List<TaskDetail> taskDetailList = new ArrayList<>();
        taskDetailRepository.findAll().forEach(taskDetailList::add);
        List<TaskDetailDTO> taskDetailDTOList = taskDetailList
                .stream()
                .map(taskdetail -> modelMapper.map(taskdetail, TaskDetailDTO.class))
                .collect(Collectors.toList());

        return taskDetailDTOList;
    }

    @Override
    public TaskDetailDTO updateTaskDetail(TaskDetailDTO taskDetailDTO) {
        TaskDetail taskDetail = taskDetailRepository.findById(taskDetailDTO.getId())
                .orElseThrow(() -> new RuntimeException("TaskDetail not found"));

        taskDetail.setTaskTitle(taskDetailDTO.getTaskTitle());
        taskDetail.setTaskDescription(taskDetailDTO.getTaskDescription());
        taskDetail.setStatus(taskDetailDTO.getStatus());
        taskDetail.setPriority(taskDetailDTO.getPriority());
        taskDetail.setEmployeeId(taskDetailDTO.getEmployeeId());
        taskDetail.setEmployeeName(taskDetailDTO.getEmployeeName());
        taskDetail.setEmployeeSurname(taskDetailDTO.getEmployeeSurname());
        taskDetailRepository.save(taskDetail);

        return taskDetailDTO;
    }

    @Override
    public TaskDetailDTO deleteTaskDetail(String id) {
        TaskDetail taskDetail = taskDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TaskDetail not found"));
        TaskDetailDTO taskDetailDTO = modelMapper.map(taskDetail, TaskDetailDTO.class);
        taskDetailRepository.deleteById(id);

        return taskDetailDTO;
    }

    @Override
    public List<TaskDetailDTO> getWithContainDescription(String description) {
        List<TaskDetail> taskDetails = taskDetailRepository.findByTaskDescriptionContains(description);
        List<TaskDetailDTO> dtoList = taskDetails
                .stream()
                .map(taskDetail -> modelMapper.map(taskDetail, TaskDetailDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public List<TaskDetailDTO> getWithStartsName(String text) {
        List<TaskDetail> taskDetails = taskDetailRepository.findTaskDetailByEmployeeNameStartingWith(text);
        List<TaskDetailDTO> dtoList = taskDetails
                .stream()
                .map(taskDetail -> modelMapper.map(taskDetail, TaskDetailDTO.class))
                .collect((Collectors.toList()));

        return dtoList;
    }
}
