package com.example.dimaspramantya.springrestcrud.dao;

import java.util.List;

import com.example.dimaspramantya.springrestcrud.entity.Employee;

public interface EmployeeDao {
	Employee save(Employee employee);
	
	Employee findById(Integer employeeId);
	
	List<Employee> findAll();
	
	void delete(Integer employeeId);
	
	Employee update(Employee employee);
}
