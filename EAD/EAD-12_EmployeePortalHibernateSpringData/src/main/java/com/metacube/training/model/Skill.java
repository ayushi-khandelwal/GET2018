package com.metacube.training.model;

import javax.persistence.*;

@Entity
@Table(name="skill_master")
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="skill_id")
	private long skillId;
	
	@Column(name="skill_name")
	private String skillName;
	
	
	public long getSkillId() {
		return skillId;
	}

	public void setSkillId(long skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
}
