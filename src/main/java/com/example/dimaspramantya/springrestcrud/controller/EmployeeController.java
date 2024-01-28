package com.example.dimaspramantya.springrestcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dimaspramantya.springrestcrud.dao.EmployeeDao;
import com.example.dimaspramantya.springrestcrud.entity.Employee;
import com.example.dimaspramantya.springrestcrud.entity.ResEntity;
import com.example.dimaspramantya.springrestcrud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("")
	public List<Employee> getAllEmployee(){
		return employeeService.findAll();
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee employee =  employeeService.findById(employeeId);
		if(employee == null) {
			throw new RuntimeException("Employee id not found - "+employeeId);
		}
		return employee;
	}
	
	@PostMapping("")
	public Employee saveEmployee(@RequestBody Employee newEmployee) {
		newEmployee.setId(0);
		Employee dbEmployee = employeeService.save(newEmployee);
		return dbEmployee;
	}
	
	@PutMapping("/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee currentEmployee, 
			@PathVariable int employeeId) {
		currentEmployee.setId(employeeId);
		Employee dbEmployee = employeeService.update(currentEmployee);
		return dbEmployee;
	}
	
	@DeleteMapping("/{employeeId}")
	public ResponseEntity<ResEntity> deleteEmployee(@PathVariable int employeeId) {
		employeeService.delete(employeeId);
		ResEntity resJson = new ResEntity();
		
		resJson.setMessage("Succesfully delete employee with id - "+employeeId);
		resJson.setStatus("Success");
		resJson.setTimeStamps(System.currentTimeMillis());
		
		return new ResponseEntity<>(resJson, HttpStatus.ACCEPTED);
	}
}
