package com.example.dimaspramantya.springrestcrud.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dimaspramantya.springrestcrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//automatically implements basic crud methods
}
