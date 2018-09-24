package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.SkillMaster;
import com.metacube.training.repository.SkillMasterRepository;

/**
 * class containing implementation of SkillMasterService interface
 * created on September 07, 2018
 */
@Service
public class SkillMasterServiceImplementation implements SkillMasterService{

	@Autowired
	private SkillMasterRepository<SkillMaster> skillMasterRepository;
	
	@Override
	public SkillMaster getSkillById(int id) {
		return skillMasterRepository.findOne(id);
	}

	@Override
	public List<SkillMaster> getAllSkills() {
		return skillMasterRepository.findAll();
	}

	@Override
	public boolean deleteSkill(int id) {
		skillMasterRepository.delete(id);
		return true;
	}

	@Override
	public boolean updateSkill(SkillMaster skillMaster) {
		skillMasterRepository.updateSkillMaster(skillMaster.getSkillName(), skillMaster.getSkillId());
		return true;
	}

	@Override
	public boolean createSkill(SkillMaster skillMaster) {
		skillMasterRepository.save(skillMaster);
		return true;
	}


}
