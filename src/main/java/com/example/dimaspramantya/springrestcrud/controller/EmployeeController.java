package com.example.dimaspramantya.springrestcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dimaspramantya.springrestcrud.dao.EmployeeDao;
import com.example.dimaspramantya.springrestcrud.entity.Employee;
import com.example.dimaspramantya.springrestcrud.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/")
	public List<Employee> getAllEmployee(){
		return employeeService.findAll();
	}
	
	@GetMapping("/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		return employeeService.findById(employeeId);
	}
}
