package com.metacube.training.AdminEmployeePortalSpringBoot.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalSpringBoot.model.Employee;

public interface EmployeeService
{
    Employee getByEmail(String email);

    Employee getById(int id);

    List<Employee> getAll();

    boolean delete(int id);

    boolean update(Employee employee);

    boolean create(Employee employee);
}
