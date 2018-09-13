package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Skill;

@Service
public class SkillServiceImpl implements SkillService{
	/*
	@Autowired
	private SkillDAO skillDAO;

	public Skill getSkillById(Long id) {
		return skillDAO.getSkillById(id);
	}

	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}

	public boolean deleteSkill(Long id) {
		Skill skill = skillDAO.getSkillById(id);
		return skillDAO.deleteSkill(skill);
	}

	public boolean updateSkill(Skill skill) {
		return skillDAO.updateSkill(skill);
	}

	public boolean createSkill(Skill skill) {
		return skillDAO.createSkill(skill);
	}
*/
    @Override
    public Skill getSkillById(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Skill> getAllSkills() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteSkill(Long id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean updateSkill(Skill skill) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean createSkill(Skill skill) {
        // TODO Auto-generated method stub
        return false;
    }
	
	
}
