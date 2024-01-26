package com.example.dimaspramantya.springrestcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dimaspramantya.springrestcrud.dao.EmployeeDao;
import com.example.dimaspramantya.springrestcrud.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}
	
	@Override
	public Employee findById(Integer employeeId) {
		return employeeDao.findById(employeeId);
	}
	
	@Override
	@Transactional
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}
	
	@Override
	@Transactional
	public Employee update(Employee employee) {
		return employeeDao.update(employee);
	}
	
	@Override
	@Transactional
	public void delete(Integer employeeId) {
		employeeDao.delete(employeeId);
	}
}
