package com.example.lesson5task.repository;

import com.example.lesson5task.entity.Role;
import com.example.lesson5task.entity.TurniketHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TurniketHistoryRepository extends JpaRepository<TurniketHistory, UUID> {
}
