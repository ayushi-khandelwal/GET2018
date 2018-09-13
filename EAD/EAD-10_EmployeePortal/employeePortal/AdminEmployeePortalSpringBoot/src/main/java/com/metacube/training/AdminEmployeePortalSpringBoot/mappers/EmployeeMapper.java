package com.metacube.training.AdminEmployeePortalSpringBoot.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.AdminEmployeePortalSpringBoot.model.Employee;

public class EmployeeMapper implements RowMapper<Employee>
{
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException
    {

        Employee employee = new Employee();
        employee.setId(resultSet.getInt("emp_code"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setMiddleName(resultSet.getString("middle_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDateOfBirth(resultSet.getDate("dob"));
        employee.setGender(resultSet.getString("gender"));
        employee.setEmail(resultSet.getString("email_id"));
        employee.setPassword(resultSet.getString("password"));
        return employee;
    }
}
