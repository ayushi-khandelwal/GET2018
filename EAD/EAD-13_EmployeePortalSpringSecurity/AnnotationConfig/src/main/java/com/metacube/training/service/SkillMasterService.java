package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.SkillMaster;

/**
 * service interface for SkillMaster
 * created oN September 07, 2018
 */
public interface SkillMasterService {
	
	SkillMaster getSkillById(int id);

	List<SkillMaster> getAllSkills();

	boolean deleteSkill(int id);

	boolean updateSkill(SkillMaster skillMaster);

	boolean createSkill(SkillMaster skillMaster);

}
