package com.metacube.training.adminEmployeePortal.service;

import java.util.List;

import com.metacube.training.adminEmployeePortal.model.Project;

public interface ProjectService
{

    Project getById(int id);

    List<Project> getAll();

    boolean delete(int id);

    boolean update(Project project);

    boolean create(Project project);

}
