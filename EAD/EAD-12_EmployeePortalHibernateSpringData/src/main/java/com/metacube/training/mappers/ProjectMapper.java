package com.metacube.training.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.model.Project;

public class ProjectMapper implements RowMapper<Project>
{

    public Project mapRow(ResultSet resultSet, int i) throws SQLException
    {

        Project project = new Project();
        project.setProject_id(resultSet.getLong("project_id"));
        project.setDescription(resultSet.getString("description"));
        project.setStartDate(resultSet.getDate("start_date"));
        project.setEndDate(resultSet.getDate("end_date"));
        return project;
    }
}
