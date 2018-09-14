package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metacube.training.model.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository<E> extends JpaRepository<Employee, Long> {



}
