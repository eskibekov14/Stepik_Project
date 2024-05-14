package com.example.stepik;

import com.example.stepik.auth.AuthenticationService;
import com.example.stepik.entities.Status;
import com.example.stepik.entities.Task;
import com.example.stepik.entitiesDTO.TaskDto;
import com.example.stepik.entitiesDTO.UsersDto;
import com.example.stepik.mappers.TaskMapper;
import com.example.stepik.mappers.UsersMapper;
import com.example.stepik.repositories.TaskRepository;
import com.example.stepik.repositories.UsersRepository;
import com.example.stepik.services.TaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StepikApplicationTests {

	@Autowired
	private TaskService taskService;

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private TaskMapper taskMapper;


	@Test
	void contextLoads() {
	}

	@Test
	void getTaskByUser(){
		List<TaskDto> tasks = taskService.getTaskByUser(1L);
		Assertions.assertNotNull(tasks);
	}

	@Test
	void getTask(){
		TaskDto testTask = taskService.getTaskById(1L);
		Task currentTask = taskRepository.findAllById(1L);
		Assertions.assertEquals(testTask,
				taskMapper.mapToTaskDto(currentTask));
	}

	@Test
	public void addTask(){
		Task task = Task.builder()
				.name("testTask")
				.status(new Status(1L,"New"))
				.user(usersRepository.findAllById(1L))
				.build();
		TaskDto taskDto = taskService.addTask(task);
		List<Task> tasks = taskRepository.findAll();
		TaskDto checkTask = taskMapper.mapToTaskDto(tasks.get(tasks.size() - 1));
		Assertions.assertEquals(taskDto,checkTask);
	}
}
