package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.JobTitleMaster;
import com.metacube.training.repository.JobTitleMasterRepository;

/**
 * class containing method implementation of interface
 * cretaed on September 07, 2018
 */
@Service
public class JobTitleMasterServiceImplementation implements JobTitleMasterService {

	@Autowired
	private JobTitleMasterRepository jobTitleMasterRepository;
	
	@Override
	public JobTitleMaster getJobTitleMaterById(int id) {
		return jobTitleMasterRepository.findOne(id);
	}

	@Override
	public List<JobTitleMaster> getAllJobTitleMaster() {
		return jobTitleMasterRepository.findAll();
	}

	@Override
	public boolean createJobTitleMaster(JobTitleMaster jobTitleMaster) {
		jobTitleMasterRepository.save(jobTitleMaster);
		return true;
	}

	
	
}
