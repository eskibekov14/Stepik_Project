package com.example.stepik.mappers;

import com.example.stepik.entities.Task;
import com.example.stepik.entitiesDTO.TaskDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto mapToTaskDto(Task task);

    List<TaskDto> mapToTaskDtoList(List<Task> tasks);

}
