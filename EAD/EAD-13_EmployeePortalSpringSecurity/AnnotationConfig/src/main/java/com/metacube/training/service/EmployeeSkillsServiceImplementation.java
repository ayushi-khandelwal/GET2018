package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.SkillMaster;
import com.metacube.training.repository.EmployeeSkillsRepository;
import com.metacube.training.repository.SkillMasterRepository;

@Service
public class EmployeeSkillsServiceImplementation implements EmployeeSkillsService{

	@Autowired
	private EmployeeSkillsRepository employeeSkillsRepository;
	
	@Autowired
	private SkillMasterRepository<SkillMaster> skillMasterRepository;
	
	@Override
	public List<SkillMaster> getEmployeeSkillsOfEmployee(String employeeCode) {
		List<EmployeeSkills> skillIdList = employeeSkillsRepository.getEmployeeSkillsOfEmployee(employeeCode);
		List<SkillMaster> skillTitleList = new ArrayList<SkillMaster>();
		for(EmployeeSkills val : skillIdList) {
			skillTitleList.add(skillMasterRepository.findOne(val.getSkillCode()));
		}
		return skillTitleList;
	}

	@Override
	public List<EmployeeSkills> getAllEmployeeSkills() {
		return null;
	}

	@Override
	public boolean deleteEmployeeSkill(int id) {
		employeeSkillsRepository.delete(id);
		return true;
	}

	@Override
	public boolean updateEmployeeSkill(EmployeeSkills employeeSkill) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createEmployeeSkill(EmployeeSkills employeeSkill) {
		employeeSkillsRepository.save(employeeSkill);
		return true;
	}

}
