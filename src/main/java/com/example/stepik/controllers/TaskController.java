package com.example.stepik.controllers;

import com.example.stepik.entities.Task;
import com.example.stepik.entitiesDTO.TaskDto;
import com.example.stepik.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{userId}")
    public List<TaskDto> getTasksByUser(@PathVariable Long userId){
        return taskService.getTaskByUser(userId);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public TaskDto addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping
    public TaskDto updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @DeleteMapping(value = "/{taskId}")
    public void deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
    }
}
