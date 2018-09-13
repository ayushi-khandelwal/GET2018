package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.SkillDAO;
import com.metacube.training.model.Skill;

@Service
public class SkillServiceImpl implements SkillService{
	
	@Autowired
	private SkillDAO skillDAO;

	public Skill getSkillById(int id) {
		return skillDAO.getSkillById(id);
	}

	public List<Skill> getAllSkills() {
		return skillDAO.getAllSkills();
	}

	public boolean deleteSkill(int id) {
		Skill skill = skillDAO.getSkillById(id);
		return skillDAO.deleteSkill(skill);
	}

	public boolean updateSkill(Skill skill) {
		return skillDAO.updateSkill(skill);
	}

	public boolean createSkill(Skill skill) {
		return skillDAO.createSkill(skill);
	}
	
	
}
