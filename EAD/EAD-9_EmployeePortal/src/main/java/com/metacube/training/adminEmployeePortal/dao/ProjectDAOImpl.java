package com.metacube.training.adminEmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.adminEmployeePortal.mappers.ProjectMapper;
import com.metacube.training.adminEmployeePortal.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO
{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectDAOImpl(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String SQL_FIND_PROJECT = "select * from project_master where project_id = ?";
    private final String SQL_DELETE_PROJECT = "delete from project_master where project_id = ?";
    private final String SQL_UPDATE_PROJECT = "update project_master set project_name = ?, description = ?, start_date  = ?, end_date  = ? where project_id = ?";
    private final String SQL_GET_ALL = "select * from project_master";
    private final String SQL_INSERT_PROJECT = "insert into project_master(project_name, description, start_date, end_date) values(?,?,?,?)";

    public Project getById(int id)
    {
        return jdbcTemplate.queryForObject(SQL_FIND_PROJECT,
                new Object[] { id }, new ProjectMapper());
    }

    public List<Project> getAll()
    {
        return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
    }

    public boolean delete(Project person)
    {
        return jdbcTemplate.update(SQL_DELETE_PROJECT, person.getId()) > 0;
    }

    public boolean update(Project person)
    {
        return jdbcTemplate.update(SQL_UPDATE_PROJECT, person.getName(),
                person.getDescription(), person.getStartDate(),
                person.getEndDate(), person.getId()) > 0;
    }

    public boolean create(Project person)
    {
        return jdbcTemplate.update(SQL_INSERT_PROJECT, person.getName(),
                person.getDescription(), person.getStartDate(),
                person.getEndDate()) > 0;
    }

}