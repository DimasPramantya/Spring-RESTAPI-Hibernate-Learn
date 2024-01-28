package com.example.dimaspramantya.springrestcrud.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dimaspramantya.springrestcrud.dao.EmployeeRepository;
import com.example.dimaspramantya.springrestcrud.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee findById(Integer employeeId) {
		Optional<Employee> result = employeeRepository.findById(employeeId);
		
		if(!result.isPresent()) {
			throw new RuntimeException("Employee with id of - " + employeeId 
					+ " NOT FOUND!");
		}
		
		return result.get();
	}
	
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee update(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	@Override
	public void delete(Integer employeeId) {
		employeeRepository.deleteById(employeeId);
	}
}
