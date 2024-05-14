package com.example.stepik.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Status status;
    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Users user;
}
