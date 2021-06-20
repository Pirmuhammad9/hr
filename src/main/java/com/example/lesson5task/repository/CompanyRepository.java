package com.example.lesson5task.repository;

import com.example.lesson5task.entity.Company;
import com.example.lesson5task.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {


}
