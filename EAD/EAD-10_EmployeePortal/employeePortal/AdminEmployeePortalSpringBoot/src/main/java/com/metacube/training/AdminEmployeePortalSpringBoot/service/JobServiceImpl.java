package com.metacube.training.AdminEmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalSpringBoot.dao.JobDAO;
import com.metacube.training.AdminEmployeePortalSpringBoot.model.Job;

@Service
public class JobServiceImpl implements JobService
{
    @Autowired
    private JobDAO jobDAO;

    /**
     * returns job by id
     */
    @Override
    public Job getById(int id)
    {

        return jobDAO.getById(id);
    }

    /**
     * returns list of all jobs
     */
    @Override
    public List<Job> getAll()
    {
        return jobDAO.getAll();
    }

    /**
     * deletes job
     */
    @Override
    public boolean delete(int id)
    {
        Job job = jobDAO.getById(id);
        return jobDAO.delete(job);
    }

    /**
     * updates job
     */
    @Override
    public boolean update(Job job)
    {
        return jobDAO.update(job);
    }

    /**
     * adds job
     */
    @Override
    public boolean create(Job job)
    {
        return jobDAO.create(job);
    }
}
