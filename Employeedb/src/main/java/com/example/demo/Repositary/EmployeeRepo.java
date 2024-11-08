package com.example.demo.Repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Entity;

public interface EmployeeRepo extends JpaRepository<Entity, Integer> {

}
