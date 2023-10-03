package com.example.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDTO {
	
	private int id;
	
	@NotBlank(message="Name cannot be blank for an employee")
	private String name;
	
	@Min(20)
	@Max(100)
	private int age;
	
	@Email
	@NotBlank(message="Email cant be null")
	private String emailAddress;
	
	//@NotBlank(message="Project can't be null")
	private int projectId;
	

}