package com.example.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.entities.Employee;
import com.example.demo.populator.EmployeePopulator;
import com.example.demo.repo.EmployeeRepo;



@Service
public class EmployeeServiceImpl {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	public List<Employee> getAllEMployees(){
	
		return employeeRepo.findAll();
	}
	
	public Employee saveEmployee(EmployeeDTO employeeDTO)
	{
		Employee e = EmployeePopulator.INSTANCE.populateEmployee(employeeDTO);
		e.setCreationDate(new Date());
		return employeeRepo.save(e);
	}
	

}
