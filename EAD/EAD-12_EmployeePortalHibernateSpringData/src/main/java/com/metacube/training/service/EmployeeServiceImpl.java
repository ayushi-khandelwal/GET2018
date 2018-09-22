package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.repository.EmployeeRepository;


@Service("ClientService")
public class EmployeeServiceImpl implements EmployeeService{
	
	/*@Autowired
	private EmployeeDAO employeeDAO;*/

    @Autowired
    @Qualifier("employeeRepository")
    private EmployeeRepository<Employee> employeeRepository;

    @Override
    public Employee getEmployeeById(Long id) {
        if(employeeRepository.exists(id)) {
            return employeeRepository.findOne(id);
        }
        return null;
    }

	public List<Employee> getAllEmployee() {
	    return employeeRepository.findAll();
		/*return employeeDAO.getAllEmployees();*/
	}

	public boolean deleteEmployee(Long id) {
	    if(employeeRepository.exists(id)) {
            employeeRepository.delete(id);
            return true;
	    }
	    return false;
		/*Employee employee = employeeDAO.getEmployeeById(id);
		return employeeDAO.deleteEmployee(employee);*/
	}

	public boolean updateEmployee(Employee employee) {
	    if(employeeRepository.exists(employee.getEmpCode())){
	        employeeRepository.saveAndFlush(employee);
	        return true;
	    }
	        return false;
		/*return employeeDAO.updateEmployee(employee);*/
	}

	public boolean createEmployee(Employee employee) {
		return employeeRepository.save(employee) != null;
	}
    
    public boolean isCredentialsValid(String email, String password) {
        /*employeeRepository.exists(getIdByEmail(email));*/
        for(Employee employee : employeeRepository.findAll()) {
            if(employee.getEmail().equals(email) && employee.getPassword().equals(password))
                return true;
        }
        return false;
    }

}
