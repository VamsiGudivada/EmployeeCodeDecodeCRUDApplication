package com.example.demo.controller;


import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.entities.Employee;
import com.example.demo.service.EmployeeServiceImpl;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceImpl service; 
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> listOfEMployees = new ArrayList<>();
		listOfEMployees.addAll(service.getAllEMployees());
		
		return new ResponseEntity<>(listOfEMployees, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@Validated @RequestBody EmployeeDTO empDto){
		return new ResponseEntity<Employee>(service.saveEmployee(empDto), HttpStatus.CREATED);
		
	}
	
	
	

}
