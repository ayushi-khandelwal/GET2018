package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.JobDAO;
import com.metacube.training.model.Job;

@Service
public class JobServiceImpl implements JobService{

	@Autowired
	private JobDAO jobTitleDAO;
	
	public Job getJobTitleById(Long id) {
		return jobTitleDAO.getJobTitleById(id);
	}

	public List<Job> getAllJobTitles() {
		return jobTitleDAO.getAllJobTitles();
	}

	public boolean deleteJobTitle(Long id) {
		Job jobTitle = jobTitleDAO.getJobTitleById(id);
		return jobTitleDAO.deleteJobTitle(jobTitle);
	}

	public boolean updateJobTitle(Job jobTitle) {
		return jobTitleDAO.updateJobTitle(jobTitle);
	}

	public boolean createJobTitle(Job jobTitle) {
		return jobTitleDAO.createJobTitle(jobTitle);
	}

    @Override
    public Job getJobTitleById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteJobTitle(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
