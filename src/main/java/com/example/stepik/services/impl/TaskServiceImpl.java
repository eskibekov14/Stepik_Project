package com.example.stepik.services.impl;

import com.example.stepik.auth.AuthenticationRequest;
import com.example.stepik.auth.AuthenticationService;
import com.example.stepik.entities.Status;
import com.example.stepik.entities.Task;
import com.example.stepik.entities.Users;
import com.example.stepik.entitiesDTO.TaskDto;
import com.example.stepik.jwt.JwtAuthenticationFilter;
import com.example.stepik.jwt.JwtService;
import com.example.stepik.mappers.TaskMapper;
import com.example.stepik.mappers.UsersMapper;
import com.example.stepik.repositories.StatusRepository;
import com.example.stepik.repositories.TaskRepository;
import com.example.stepik.repositories.UsersRepository;
import com.example.stepik.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UsersRepository usersRepository;



    @Override
    public List<TaskDto> getTaskByUser(Long userId) {
        Users user = usersRepository.findAllById(userId);
        if(user!=null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentEmail = authentication.getName();
            if(!user.getEmail().equals(currentEmail)){
                return null;
            }
        }
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
