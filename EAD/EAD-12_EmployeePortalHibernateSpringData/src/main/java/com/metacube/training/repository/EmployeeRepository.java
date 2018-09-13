package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Employee;

public interface EmployeeRepository<P> extends JpaRepository<Employee, Long> {

    Employee findOne(String email);

}
