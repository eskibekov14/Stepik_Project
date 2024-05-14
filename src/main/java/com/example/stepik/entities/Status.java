package com.example.stepik.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "statuses")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
}
