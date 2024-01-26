package com.example.dimaspramantya.springrestcrud.service;

import java.util.List;

import com.example.dimaspramantya.springrestcrud.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(Integer employeeId);
	Employee save(Employee employee);
	Employee update(Employee employee);
	void delete(Integer employeeId);
}
