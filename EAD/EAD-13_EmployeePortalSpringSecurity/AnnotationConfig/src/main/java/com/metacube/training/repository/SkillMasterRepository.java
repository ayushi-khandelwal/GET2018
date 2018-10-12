package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.SkillMaster;

@Repository
@Transactional
public interface SkillMasterRepository<p> extends JpaRepository<SkillMaster, Integer>{
	
	@Modifying
	@Query ("UPDATE SkillMaster SET skillName = :skillName WHERE skillId = :skillId")
	int updateSkillMaster(@Param("skillName") String skillName, @Param("skillId") int skillId);

	
}
