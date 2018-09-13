package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.Job;
import com.metacube.training.repository.EmployeeRepository;
import com.metacube.training.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{

/*	@Autowired
	private JobDAO jobTitleDAO;*/
	
    @Autowired
    private JobRepository<Job> jobRepository;
    
	public Job getJobTitleById(Long id) {
	    if(jobRepository.exists(id))
	        return jobRepository.findOne(id);
	    return null;
		/*return jobTitleDAO.getJobTitleById(id);*/
	}

	public List<Job> getAllJobTitles() {
	    return jobRepository.findAll();
		/*return jobTitleDAO.getAllJobTitles();*/
	}

	public boolean deleteJobTitle(Long id) {
	    if(jobRepository.exists(id)) {
            jobRepository.delete(id);
            return true;
	    }
	    return false;
		/*Job jobTitle = jobTitleDAO.getJobTitleById(id);
		return jobTitleDAO.deleteJobTitle(jobTitle);*/
	}

	public boolean updateJobTitle(Job jobTitle) {
	    if(jobRepository.exists(jobTitle.getJobCode())) {
            jobRepository.saveAndFlush(jobTitle);
            return true;
	    }
	    return false;
		/*return jobTitleDAO.updateJobTitle(jobTitle);*/
	}

	public boolean createJobTitle(Job jobTitle) {
	    if(!jobRepository.exists(jobTitle.getJobCode())) {
	        jobRepository.saveAndFlush(jobTitle);
	        return true;
	    }
	    return false;
		/*return jobTitleDAO.createJobTitle(jobTitle);*/
	}


}
