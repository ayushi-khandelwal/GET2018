package com.metacube.training.AdminEmployeePortalSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.AdminEmployeePortalSpringBoot.mappers.JobMapper;
import com.metacube.training.AdminEmployeePortalSpringBoot.model.Job;

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
    private final String SQL_UPDATE_JOB = "update job_title_master set job_title = ? where job_code = ?";
    private final String SQL_GET_ALL = "select * from job_title_master";
    private final String SQL_INSERT_JOB = "insert into job_title_master(job_title) values(?)";

    /**
     * returns job by id
     */
    public Job getById(int id)
    {
        return jdbcTemplate.queryForObject(SQL_FIND_JOB, new Object[] { id },
                new JobMapper());
    }

    /**
     * returns list of all jobs
     */
    public List<Job> getAll()
    {
        return jdbcTemplate.query(SQL_GET_ALL, new JobMapper());
    }

    /**
     * deletes job
     */
    public boolean delete(Job job)
    {
        try
        {
            return jdbcTemplate.update(SQL_DELETE_JOB, job.getId()) > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * updates job
     */
    public boolean update(Job job)
    {
        try
        {
            return jdbcTemplate.update(SQL_UPDATE_JOB, job.getTitle(),
                    job.getId()) > 0;
        } catch (Exception e)
        {
            return false;
        }

    }

    /**
     * adds job
     */
    public boolean create(Job job)
    {
        try
        {
            return jdbcTemplate.update(SQL_INSERT_JOB, job.getTitle()) > 0;
        } catch (Exception e)
        {
            return false;
        }

    }
}
