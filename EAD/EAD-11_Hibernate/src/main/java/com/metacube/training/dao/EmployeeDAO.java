package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeDAO {

	Employee getEmployeeById(Long id);
	
	List<Employee> getAllEmployees();
	
	boolean deleteEmployee(Employee employee);
	
	boolean updateEmployee(Employee employee);
	
	boolean createEmployee(Employee employee);
	
}
