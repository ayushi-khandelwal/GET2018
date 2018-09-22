package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobService {

	Job getJobTitleById(Long id);
	
	List<Job> getAllJobTitles();
	
	boolean deleteJobTitle(Long id);
	
	boolean updateJobTitle(Job jobTitle);
	
	boolean createJobTitle(Job jobTitle);
	
}
