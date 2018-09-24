package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.EmployeeSkills;

@Repository
@Transactional
public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkills, Integer>{
	
	@Query("FROM EmployeeSkills WHERE employeeCode = :employeeCode")
	List<EmployeeSkills> getEmployeeSkillsOfEmployee(@Param("employeeCode") String employeeCode);
	
}
