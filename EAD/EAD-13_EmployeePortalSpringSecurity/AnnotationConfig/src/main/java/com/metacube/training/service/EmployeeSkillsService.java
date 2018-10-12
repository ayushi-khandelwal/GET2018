package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.model.SkillMaster;

public interface EmployeeSkillsService {

	List<SkillMaster> getEmployeeSkillsOfEmployee(String employeeCode);

	List<EmployeeSkills> getAllEmployeeSkills();

	boolean deleteEmployeeSkill(int id);

	boolean updateEmployeeSkill(EmployeeSkills employeeSkill);

	boolean createEmployeeSkill(EmployeeSkills employeeSkill);
	
}
