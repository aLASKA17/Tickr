package org.example.tickr.task;

import lombok.AllArgsConstructor;
import org.example.tickr.task.dto.TaskResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@AllArgsConstructor
public class TaskController {

    private TaskService taskService;

    @PostMapping("/create")
    public void createTask(@RequestBody TaskResponse taskResponse) {
        taskService.createTask(taskResponse);
    }
}
