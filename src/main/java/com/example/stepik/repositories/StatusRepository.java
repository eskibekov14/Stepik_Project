package com.example.stepik.repositories;

import com.example.stepik.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface StatusRepository extends JpaRepository<Status, Long> {
    Status findAllById(Long id);
}
