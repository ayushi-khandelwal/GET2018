package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;

/**
 * class containing implementation of service interface method
 * created on September 08, 2018
 */
@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee getEmployeeById(String employeeCode) {
		return employeeRepository.findOne(employeeCode);
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		employeeRepository.updateEmployee(
				employee.getFirstName(), 
				employee.getLastName(), 
				employee.getDob(), 
				employee.getGender(),
				employee.getEmailId(),
				employee.getPassword(), 
				employee.isEnabled(), 
				employee.getEmployeeCode()
			);
		return true;
	}

	@Override
	public boolean createEmployee(Employee employee) {
		String employeeCode = getLatestEmployeeCode().getEmployeeCode();
		employeeRepository.save(employee);
		return true;
	}

	@Override
	public Employee getLatestEmployeeCode() {
		Employee employee = employeeRepository.getLatestEmployee().get(0);
		return employee;
	}

	
}