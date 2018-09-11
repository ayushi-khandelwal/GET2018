package com.metacube.training.adminEmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.adminEmployeePortal.dao.JobDAO;
import com.metacube.training.adminEmployeePortal.model.Job;

@Service
public class JobServiceImpl implements JobService
{
    @Autowired
    private JobDAO jobDAO;

    @Override
    public Job getById(int id)
    {
        return jobDAO.getById(id);
    }

    @Override
    public List<Job> getAll()
    {
        return jobDAO.getAll();
    }

    @Override
    public boolean delete(int id)
    {
        Job job = jobDAO.getById(id);
        return jobDAO.delete(job);
    }

    @Override
    public boolean update(Job job)
    {
        return jobDAO.update(job);
    }

    @Override
    public boolean create(Job job)
    {
        return jobDAO.create(job);
    }
}
