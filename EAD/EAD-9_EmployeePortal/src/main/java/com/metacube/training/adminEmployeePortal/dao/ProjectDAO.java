package com.metacube.training.adminEmployeePortal.dao;

import java.util.List;

import com.metacube.training.adminEmployeePortal.model.Project;

public interface ProjectDAO
{

    Project getById(int id);

    List<Project> getAll();

    boolean delete(Project project);

    boolean update(Project project);

    boolean create(Project project);
}
