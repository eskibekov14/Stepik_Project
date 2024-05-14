package com.example.stepik.mappers;

import com.example.stepik.entities.Users;
import com.example.stepik.entitiesDTO.UsersDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    UsersDto mapToUserDto(Users users);

    List<UsersDto> mapToUserDtoList(List<Users> userList);
}
