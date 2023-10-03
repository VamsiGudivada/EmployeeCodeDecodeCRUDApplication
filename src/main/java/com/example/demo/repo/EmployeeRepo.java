package com.example.demo.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Employee;


@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{
	
	
	
	
}