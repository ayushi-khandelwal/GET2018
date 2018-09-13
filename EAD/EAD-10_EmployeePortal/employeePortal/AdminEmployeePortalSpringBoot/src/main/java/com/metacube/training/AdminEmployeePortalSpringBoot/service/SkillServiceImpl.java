package com.metacube.training.AdminEmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.AdminEmployeePortalSpringBoot.dao.SkillDAO;
import com.metacube.training.AdminEmployeePortalSpringBoot.model.Skill;

@Service
public class SkillServiceImpl implements SkillService
{
    @Autowired
    private SkillDAO skillDAO;

    /**
     * returns skill by id
     */
    @Override
    public Skill getById(int id)
    {

        return skillDAO.getById(id);
    }

    /**
     * returns list of all skills
     */
    @Override
    public List<Skill> getAll()
    {
        return skillDAO.getAll();
    }

    /**
     * deletes skill
     */
    @Override
    public boolean delete(int id)
    {
        Skill skill = skillDAO.getById(id);
        return skillDAO.delete(skill);
    }

    /**
     * updates skill
     */
    @Override
    public boolean update(Skill skill)
    {
        return skillDAO.update(skill);
    }

    /**
     * adds skill
     */
    @Override
    public boolean create(Skill skill)
    {
        return skillDAO.create(skill);
    }
}
