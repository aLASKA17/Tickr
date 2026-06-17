package org.example.tickr.task.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.tickr.task.TaskPriority;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
public class TaskResponse {
    private String taskName;
    private String taskDescription;
    private TaskPriority taskPriority;
    private LocalDateTime taskDeadline;
    private Long userId;
}
