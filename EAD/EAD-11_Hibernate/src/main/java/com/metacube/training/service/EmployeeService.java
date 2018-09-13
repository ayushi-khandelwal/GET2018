package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeService {

	Employee getEmployeeById(int id);
	
	List<Employee> getAllEmployee();
	
	boolean deleteEmployee(int id);
	
	boolean updateEmployee(Employee employee);
	
	boolean createEmployee(Employee employee);
}
