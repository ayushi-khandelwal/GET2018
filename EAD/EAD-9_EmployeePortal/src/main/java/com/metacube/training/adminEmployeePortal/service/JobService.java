package com.metacube.training.adminEmployeePortal.service;

import java.util.List;

import com.metacube.training.adminEmployeePortal.model.Job;

public interface JobService
{
    Job getById(int id);

    List<Job> getAll();

    boolean delete(int id);

    boolean update(Job job);

    boolean create(Job job);
}
