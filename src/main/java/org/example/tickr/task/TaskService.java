package org.example.tickr.task;

import lombok.RequiredArgsConstructor;
import org.example.tickr.task.dto.TaskResponse;
import org.example.tickr.user.User;
import org.example.tickr.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskService {
    private UserRepository userRepository;
    private TaskRepository taskRepository;
    public void createTask(TaskResponse taskResponse) {
        User user = userRepository.findByUserId(taskResponse.getUserId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден! Пожалуйста войдите на аккаунт."));

        Task task = new Task();
        task.setTaskName(taskResponse.getTaskName());
        task.setTaskDescription(taskResponse.getTaskDescription());
        task.setTaskStatus(false);
        task.setTaskPriority(taskResponse.getTaskPriority());
        if (taskResponse.getTaskDeadline() != null) {
            task.setTaskDeadline(taskResponse.getTaskDeadline());
        }
        task.setUser(user);

        taskRepository.save(task);
    }
}
