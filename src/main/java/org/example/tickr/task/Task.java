package org.example.tickr.task;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tickr.user.User;

import java.time.LocalDateTime;

@Entity
@Table(schema="public", name = "tasks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @NotNull
    private String taskName;
    @NotNull
    private String taskDescription;

    private boolean taskStatus;
    @NotNull
    private TaskPriority taskPriority;

    private LocalDateTime taskAtCreated;
    private LocalDateTime taskAtUpdate;
    private LocalDateTime taskDeadline;

    @ManyToOne
    private User user;

    @PrePersist
    public void createTask() {
        this.taskAtCreated = LocalDateTime.now();
        this.taskAtUpdate = LocalDateTime.now();
    }

    @PreUpdate
    public void updateTask() {
        this.taskAtCreated = LocalDateTime.now();
    }
}
