package com.metacube.training.adminEmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.adminEmployeePortal.mappers.EmployeeMapper;
import com.metacube.training.adminEmployeePortal.model.Employee;

@Repository
public class EmployeeeDAOImpl implements EmployeeDAO
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeeDAOImpl(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String SQL_FIND_EMPLOYEE = "select * from employee where emp_code = ?";
    private final String SQL_DELETE_EMPLOYEE = "delete from employee where emp_code = ?";
    private final String SQL_UPDATE_EMPLOYEE = "update employee set first_name = ?, middle_name = ?, last_name  = ?, dob  = ?, gender = ?, email_id = ?, password = ? where emp_code = ?";
    private final String SQL_GET_ALL = "select * from employee";
    private final String SQL_INSERT_EMPLOYEE = "insert into employee(first_name, middle_name, last_name, dob, gender, email_id, password) values(?,?,?,?,?,?,?)";

    public Employee getById(int id)
    {
        return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE, new Object[] { id }, new EmployeeMapper());
    }

    public List<Employee> getAll()
    {
        return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
    }

    public boolean delete(Employee employee)
    {
        return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, employee.getId()) > 0;
    }

    public boolean update(Employee employee)
    {
        return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE, employee.getFirstName(), employee.getMiddleName(),
                employee.getLastName(), employee.getDateOfBirth(), employee.getGender(), employee.getEmail(),
                employee.getPassword(), employee.getId()) > 0;
    }

    public boolean create(Employee employee)
    {
        return jdbcTemplate.update(SQL_INSERT_EMPLOYEE, employee.getFirstName(), employee.getMiddleName(),
                employee.getLastName(), employee.getDateOfBirth(), employee.getGender(), employee.getEmail(),
                employee.getPassword()) > 0;
    }
}
