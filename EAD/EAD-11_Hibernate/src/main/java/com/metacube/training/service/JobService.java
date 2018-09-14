package com.metacube.training.service;

import java.util.List;

import com.metacube.training.model.Job;

public interface JobService {

	Job getJobTitleById(int id);
	
	List<Job> getAllJobTitles();
	
	boolean deleteJobTitle(int id);
	
	boolean updateJobTitle(Job jobTitle);
	
	boolean createJobTitle(Job jobTitle);
}
