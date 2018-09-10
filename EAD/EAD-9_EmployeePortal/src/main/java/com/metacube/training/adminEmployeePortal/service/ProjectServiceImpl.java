package com.metacube.training.adminEmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.adminEmployeePortal.dao.ProjectDAO;
import com.metacube.training.adminEmployeePortal.model.Project;

@Service
public class ProjectServiceImpl implements ProjectService
{

    @Autowired
    private ProjectDAO projectDAO;

    @Override
    public Project getById(int id)
    {
        return projectDAO.getById(id);
    }

    @Override
    public List<Project> getAll()
    {
        return projectDAO.getAll();
    }

    @Override
    public boolean delete(int id)
    {
        Project project = projectDAO.getById(id);
        return projectDAO.delete(project);
    }

    @Override
    public boolean update(Project project)
    {
        return projectDAO.update(project);
    }

    @Override
    public boolean create(Project project)
    {
        return projectDAO.create(project);
    }

}
