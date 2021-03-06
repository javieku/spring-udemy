package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	
	public Employee find(int id);
	
	public void save(Employee employee);
	
	public void delete(int id);
}
