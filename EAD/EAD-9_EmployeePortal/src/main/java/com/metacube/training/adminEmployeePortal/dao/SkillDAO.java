package com.metacube.training.adminEmployeePortal.dao;

import java.util.List;

import com.metacube.training.adminEmployeePortal.model.Skill;

public interface SkillDAO
{
    Skill getById(int id);

    List<Skill> getAll();

    boolean delete(Skill skill);

    boolean update(Skill skill);

    boolean create(Skill skill);
}
