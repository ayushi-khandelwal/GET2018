package com.metacube.training.AdminEmployeePortalSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.AdminEmployeePortalSpringBoot.mappers.EmployeeMapper;
import com.metacube.training.AdminEmployeePortalSpringBoot.model.Employee;

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
    private final String SQL_GET_EMPLOYEE_BY_EMAIL = "select * from employee where email_id = ?";

    /**
     * gets employee by email
     */
    public Employee getByEmail(String email)
    {
        try
        {
            return jdbcTemplate.queryForObject(SQL_GET_EMPLOYEE_BY_EMAIL,
                    new Object[] { email }, new EmployeeMapper());
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }
    }

    /**
     * gets employee employee id
     */
    public Employee getById(int id)
    {
        try
        {
            return jdbcTemplate.queryForObject(SQL_FIND_EMPLOYEE,
                    new Object[] { id }, new EmployeeMapper());
        } catch (EmptyResultDataAccessException e)
        {
            return null;
        }

    }

    /**
     * returns list of all employees
     */
    public List<Employee> getAll()
    {
        return jdbcTemplate.query(SQL_GET_ALL, new EmployeeMapper());
    }

    /**
     * deletes employee
     */
    public boolean delete(Employee employee)
    {
        try
        {
            return jdbcTemplate.update(SQL_DELETE_EMPLOYEE, employee.getId()) > 0;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * deletes employee
     */
    public boolean update(Employee employee)
    {
        try
        {
            return jdbcTemplate.update(SQL_UPDATE_EMPLOYEE,
                    employee.getFirstName(), employee.getMiddleName(),
                    employee.getLastName(), employee.getDateOfBirth(),
                    employee.getGender(), employee.getEmail(),
                    employee.getPassword(), employee.getId()) > 0;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * adds employee
     */
    public boolean create(Employee employee)
    {
        try
        {
            return jdbcTemplate.update(SQL_INSERT_EMPLOYEE,
                    employee.getFirstName(), employee.getMiddleName(),
                    employee.getLastName(), employee.getDateOfBirth(),
                    employee.getGender(), employee.getEmail(),
                    employee.getPassword()) > 0;
        } catch (Exception e)
        {
            return false;
        }
    }
}
