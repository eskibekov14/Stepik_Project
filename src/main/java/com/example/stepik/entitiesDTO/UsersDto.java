package com.example.stepik.entitiesDTO;

import com.example.stepik.entities.Permission;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class UsersDto {
    private Long id;
    private String fullName;
    private String email;
    private List<Permission> roles;
}
