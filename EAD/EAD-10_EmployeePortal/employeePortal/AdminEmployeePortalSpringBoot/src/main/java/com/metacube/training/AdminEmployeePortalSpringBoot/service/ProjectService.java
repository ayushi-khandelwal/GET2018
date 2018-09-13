package com.metacube.training.AdminEmployeePortalSpringBoot.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalSpringBoot.model.Project;

public interface ProjectService
{

    Project getById(int id);

    List<Project> getAll();

    boolean delete(int id);

    boolean update(Project project);

    boolean create(Project project);

}
