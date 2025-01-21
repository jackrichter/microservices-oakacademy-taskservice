package uk.oakacademy.taskservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.oakacademy.taskservice.entities.PriorityType;
import uk.oakacademy.taskservice.entities.TaskStatus;

import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
    private String id;
    private String taskTitle;
    private String taskDescription;
    private String notes;
    private String assignee;
    private Timestamp taskStartDate;
    private String taskStatus;
    private String priorityType;

    public void setId(String id) {
        this.id = id;
    }
}
