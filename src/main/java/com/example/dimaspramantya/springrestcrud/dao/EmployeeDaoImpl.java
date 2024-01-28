package com.example.dimaspramantya.springrestcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.dimaspramantya.springrestcrud.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoImpl(EntityManager entityManager){
		this.entityManager = entityManager;
	}
	
	@Override
	public void delete(Integer employeeId) {
		Employee employee = findById(employeeId);
		entityManager.remove(employee);
	}
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e", 
				Employee.class);
		return query.getResultList();
	}
	
	@Override
	public Employee findById(Integer employeeId) {
		Employee employee = entityManager.find(Employee.class, employeeId);
		return employee;
	}
	
	@Override
	public Employee save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		return dbEmployee;
	}
	
	@Override
	public Employee update(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		return dbEmployee;
	}
	
	
}
