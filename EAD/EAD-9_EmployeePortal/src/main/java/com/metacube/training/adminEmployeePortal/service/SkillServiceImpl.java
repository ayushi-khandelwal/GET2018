package com.metacube.training.adminEmployeePortal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.adminEmployeePortal.dao.SkillDAO;
import com.metacube.training.adminEmployeePortal.model.Skill;

@Service
public class SkillServiceImpl implements SkillService
{
    @Autowired
    private SkillDAO skillDAO;

    @Override
    public Skill getById(int id)
    {

        return skillDAO.getById(id);
    }

    @Override
    public List<Skill> getAll()
    {
        return skillDAO.getAll();
    }

    @Override
    public boolean delete(int id)
    {
        Skill skill = skillDAO.getById(id);
        return skillDAO.delete(skill);
    }

    @Override
    public boolean update(Skill skill)
    {
        return skillDAO.update(skill);
    }

    @Override
    public boolean create(Skill skill)
    {
        return skillDAO.create(skill);
    }
}
