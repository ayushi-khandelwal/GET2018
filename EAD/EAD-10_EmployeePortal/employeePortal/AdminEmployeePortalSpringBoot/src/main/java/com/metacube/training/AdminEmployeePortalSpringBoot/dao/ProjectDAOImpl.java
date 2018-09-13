package com.metacube.training.AdminEmployeePortalSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.AdminEmployeePortalSpringBoot.mappers.ProjectMapper;
import com.metacube.training.AdminEmployeePortalSpringBoot.model.Project;

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

    /**
     * returns project by id
     */
    public Project getById(int id)
    {
        return jdbcTemplate.queryForObject(SQL_FIND_PROJECT,
                new Object[] { id }, new ProjectMapper());
    }

    /**
     * returns list of all projects
     */
    public List<Project> getAll()
    {
        return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
    }

    /**
     * deletes project
     */
    public boolean delete(Project project)
    {
        try
        {
            return jdbcTemplate.update(SQL_DELETE_PROJECT, project.getId()) > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * updates project
     */
    public boolean update(Project project)
    {
        try
        {
            return jdbcTemplate.update(SQL_UPDATE_PROJECT, project.getName(),
                    project.getDescription(), project.getStartDate(),
                    project.getEndDate(), project.getId()) > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * adds project
     */
    public boolean create(Project project)
    {
        try
        {
            return jdbcTemplate.update(SQL_INSERT_PROJECT, project.getName(),
                    project.getDescription(), project.getStartDate(),
                    project.getEndDate()) > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

}