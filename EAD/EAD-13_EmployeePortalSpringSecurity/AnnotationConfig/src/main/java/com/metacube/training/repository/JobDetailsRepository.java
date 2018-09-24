package com.metacube.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.model.JobDetails;

@Repository
@Transactional
public interface JobDetailsRepository<P> extends JpaRepository<JobDetails, Integer> {
	
	@Modifying
	@Query("UPDATE JobDetails set "
			+ "employeeCode = :employeeCode, jobCode = :jobCode, reportingManager = :reportingManager, "
			+ "teamLead = :teamLead, currentProjectId = :currentProjectId where jobDetailId = :id")
	int updateJobDetails(
			@Param("employeeCode") String employeeCode,
			@Param("jobCode") int jobCode,
			@Param("reportingManager") String reportingManager,
			@Param("teamLead") String teamLead,
			@Param("currentProjectId") int currentProjectId,
			@Param("id") int id
		);
	
	@Query("From JobDetails where employeeCode = :employeeCode")
	JobDetails findJobDetailsOfEmployee(@Param("employeeCode") String employeeCode);
	
	@Query("From JobDetails where currentProjectId = :currentProjectId")
	List<JobDetails> findEmployeeForProject(@Param("currentProjectId") int currentProjectId);
	
}
