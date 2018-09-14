package com.metacube.training.AdminEmployeePortalSpringBoot.service;

import java.util.List;

import com.metacube.training.AdminEmployeePortalSpringBoot.model.Skill;

public interface SkillService
{
    Skill getById(int id);

    List<Skill> getAll();

    boolean delete(int id);

    boolean update(Skill skill);

    boolean create(Skill skill);
}
