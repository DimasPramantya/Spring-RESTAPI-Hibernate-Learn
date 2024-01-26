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
	@Transactional
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
		TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e"
				+ " Where e.id = :employeeId", Employee.class);
		query.setParameter("employeeId", employeeId);
		return query.getSingleResult();
	}
	
	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(Employee employee) {
		// TODO Auto-generated method stub
		
	}
}
