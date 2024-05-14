package com.example.stepik.services;

import com.example.stepik.entities.Task;
import com.example.stepik.entitiesDTO.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTaskByUser(Long id);
    TaskDto getTaskById(Long taskId);
    TaskDto addTask(Task task);
    TaskDto updateTask(Task task);
    void deleteTask(Long id);
}
