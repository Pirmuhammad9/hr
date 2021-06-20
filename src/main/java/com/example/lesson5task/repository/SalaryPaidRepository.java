package com.example.lesson5task.repository;

import com.example.lesson5task.entity.SalaryPaid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SalaryPaidRepository extends JpaRepository<SalaryPaid, UUID> {
}
