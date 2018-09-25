package com.metacube.training.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.Project;

@Repository
@Transactional
public interface ProjectRepository<P> extends JpaRepository<Project, Integer> {
	
	@Modifying
	@Query("update Project set  description = :description, startDate = :startDate, endDate = :endDate "
			+ "where id = :id")
	int updateProject(
			@Param("description") String description,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,
			@Param("id") int id
		);
	
}
