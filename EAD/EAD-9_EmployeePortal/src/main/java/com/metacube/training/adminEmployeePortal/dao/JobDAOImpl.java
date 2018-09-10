package com.metacube.training.adminEmployeePortal.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.adminEmployeePortal.mappers.JobMapper;
import com.metacube.training.adminEmployeePortal.mappers.SkillMapper;
import com.metacube.training.adminEmployeePortal.model.Job;
import com.metacube.training.adminEmployeePortal.model.Skill;

@Repository
public class JobDAOImpl implements JobDAO
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JobDAOImpl(DataSource dataSource)
    {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private final String SQL_FIND_JOB = "select * from job_title_master where job_code = ?";
    private final String SQL_DELETE_JOB = "delete from job_title_master where job_code = ?";
    private final String SQL_UPDATE_JOB = "update job_title_master set job_title = ?";
    private final String SQL_GET_ALL = "select * from job_title_master";
    private final String SQL_INSERT_JOB = "insert into job_title_master(job_title) values(?)";

    public Job getById(int id)
    {
        return jdbcTemplate.queryForObject(SQL_FIND_JOB, new Object[] { id }, new JobMapper());
    }

    public List<Job> getAll()
    {
        return jdbcTemplate.query(SQL_GET_ALL, new JobMapper());
    }

    public boolean delete(Job job)
    {
        return jdbcTemplate.update(SQL_DELETE_JOB, job.getId()) > 0;
    }

    public boolean update(Job job)
    {
        return jdbcTemplate.update(SQL_UPDATE_JOB, job.getTitle(), job.getId()) > 0;
    }

    public boolean create(Job job)
    {
        return jdbcTemplate.update(SQL_INSERT_JOB, job.getTitle()) > 0;
    }
}
