package com.metacube.training.adminEmployeePortal.dao;

import java.util.List;

import com.metacube.training.adminEmployeePortal.model.Employee;

public interface EmployeeDAO
{
    Employee getById(int id);

    List<Employee> getAll();

    boolean delete(Employee employee);

    boolean update(Employee employee);

    boolean create(Employee employee);
}
