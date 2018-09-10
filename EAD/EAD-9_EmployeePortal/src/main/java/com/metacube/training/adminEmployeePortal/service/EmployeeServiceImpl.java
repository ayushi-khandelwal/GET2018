package com.metacube.training.adminEmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.adminEmployeePortal.dao.EmployeeDAO;
import com.metacube.training.adminEmployeePortal.dao.ProjectDAO;
import com.metacube.training.adminEmployeePortal.model.Employee;
import com.metacube.training.adminEmployeePortal.model.Project;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public Employee getById(int id)
    {
        return employeeDAO.getById(id);
    }

    @Override
    public List<Employee> getAll()
    {
        return employeeDAO.getAll();
    }

    @Override
    public boolean delete(int id)
    {
        Employee employee = employeeDAO.getById(id);
        return employeeDAO.delete(employee);
    }

    @Override
    public boolean update(Employee employee)
    {
        return employeeDAO.update(employee);
    }

    @Override
    public boolean create(Employee employee)
    {
        return employeeDAO.create(employee);
    }
}
