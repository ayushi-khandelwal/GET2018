package com.metacube.training.dao;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobDAO {

	Job getJobTitleById(Long id);
	
	List<Job> getAllJobTitles();
	
	boolean deleteJobTitle(Job jobTitle);
	
	boolean updateJobTitle(Job jobTitle);
	
	boolean createJobTitle(Job jobTitle);
}
