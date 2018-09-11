package com.metacube.training.adminEmployeePortal.service;

import java.util.List;

import com.metacube.training.adminEmployeePortal.model.Employee;

public interface EmployeeService
{
    Employee getById(int id);

    List<Employee> getAll();

    boolean delete(int id);

    boolean update(Employee employee);

    boolean create(Employee employee);
}
