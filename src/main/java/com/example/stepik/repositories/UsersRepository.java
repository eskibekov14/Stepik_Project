package com.example.stepik.repositories;

import com.example.stepik.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UsersRepository extends JpaRepository<Users, Long> {
    Users findAllByEmail(String email);
    Users findAllById(Long id);
}
