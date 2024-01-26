package com.example.dimaspramantya.springrestcrud.service;

import java.util.List;

import com.example.dimaspramantya.springrestcrud.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(Integer employeeId);
}
