package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;

public interface SkillDAO {

	Skill getSkillById(int id);

	List<Skill> getAllSkills();

	boolean deleteSkill(Skill skill);

	boolean updateSkill(Skill skill);

	boolean createSkill(Skill skill);
}
