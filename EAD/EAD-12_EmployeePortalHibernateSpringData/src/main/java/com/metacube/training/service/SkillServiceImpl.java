package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.repository.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService{

    @Autowired
    private SkillRepository<Skill> skillRepository;

	public Skill getSkillById(Long id) {
	    if(skillRepository.exists(id)) {
            return skillRepository.findOne(id);
        }
        return null;
		/*return skillDAO.getSkillById(id);*/
	}

	public List<Skill> getAllSkills() {
	    return skillRepository.findAll();
	    /*return skillDAO.getAllSkills();*/
	}

	public boolean deleteSkill(Long id) {
	    if(skillRepository.exists(id)) {
	        skillRepository.delete(id);
            return true;
        }
	    return false;
	    /*Skill skill = skillDAO.getSkillById(id);
		return skillDAO.deleteSkill(skill);*/
	}

	public boolean updateSkill(Skill skill) {
	    return (skillRepository.saveAndFlush(skill) != null);
	    /*return skillDAO.updateSkill(skill);*/
	}

	public boolean createSkill(Skill skill) {
	    if(skill != null) {
	        skillRepository.save(skill);
	        return true;
	    }
	    return false;
	    /*return skillDAO.createSkill(skill);*/
	}

}
