package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.model.Skill;

public interface SkillRepository<P> extends JpaRepository<Skill, Long> {

}
