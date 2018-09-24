package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_skills")
public class EmployeeSkills {
	
	@Id
	@Column(name = "emp_skill_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeSkillId;
	
	@Column(name = "emp_code")
	private String employeeCode;
	
	@Column(name = "skill_code")
	private int skillCode;

	/*@OneToMany
	private Collection<SkillMaster> skillMaster = new ArrayList<SkillMaster>();*/
	
	public int getEmployeeSkillId() {
		return employeeSkillId;
	}

	public void setEmployeeSkillId(int employeeSkillId) {
		this.employeeSkillId = employeeSkillId;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public int getSkillCode() {
		return skillCode;
	}

	public void setSkillCode(int skillCode) {
		this.skillCode = skillCode;
	}

	/*public Collection<SkillMaster> getSkillMaster() {
		return skillMaster;
	}

	public void setSkillMaster(Collection<SkillMaster> skillMaster) {
		this.skillMaster = skillMaster;
	}
	*/
}
