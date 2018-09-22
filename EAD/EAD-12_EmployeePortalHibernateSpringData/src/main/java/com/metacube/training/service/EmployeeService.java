package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Employee;

public interface EmployeeService {

	Employee getEmployeeById(Long id);
	
	List<Employee> getAllEmployee();
	
	boolean deleteEmployee(Long id);
	
	boolean updateEmployee(Employee employee);
	
	boolean createEmployee(Employee employee);

    boolean isCredentialsValid(String email, String password);
}
