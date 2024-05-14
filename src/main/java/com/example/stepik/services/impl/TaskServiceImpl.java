package com.example.stepik.services.impl;

import com.example.stepik.entities.Status;
import com.example.stepik.entities.Task;
import com.example.stepik.entitiesDTO.TaskDto;
import com.example.stepik.mappers.TaskMapper;
import com.example.stepik.mappers.UsersMapper;
import com.example.stepik.repositories.StatusRepository;
import com.example.stepik.repositories.TaskRepository;
import com.example.stepik.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getTaskByUser(Long userId) {
        return taskMapper.mapToTaskDtoList(taskRepository.findAllByUser_Id(userId));
    }

    @Override
    public TaskDto getTaskById(Long taskId) {
        Task task = taskRepository.findAllById(taskId);
        return taskMapper.mapToTaskDto(task);
    }

    @Override
    public TaskDto addTask(Task task) {
        return taskMapper.mapToTaskDto(
                taskRepository.save(task)
        );
    }

    @Override
    public TaskDto updateTask(Task task) {
        return taskMapper.mapToTaskDto(taskRepository.save(task));
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
