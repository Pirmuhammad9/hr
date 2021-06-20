package com.example.lesson5task.repository;

import com.example.lesson5task.entity.Role;
import com.example.lesson5task.entity.Turniket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TurniketRepository extends JpaRepository<Turniket, UUID> {
}
