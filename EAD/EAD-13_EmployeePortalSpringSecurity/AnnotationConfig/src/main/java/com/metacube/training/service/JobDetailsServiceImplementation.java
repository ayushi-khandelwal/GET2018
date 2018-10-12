package com.metacube.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.repository.JobDetailsRepository;

@Service
public class JobDetailsServiceImplementation implements JobDetailsService{

	@Autowired
	private JobDetailsRepository<JobDetails> jobDetailsRepository;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Override
	public JobDetails getJobDetailsById(int id) {
		return jobDetailsRepository.findOne(id);
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		return jobDetailsRepository.findAll();
	}

	@Override
	public boolean deleteJobDetails(JobDetails jobDetails) {
		jobDetailsRepository.delete(jobDetails.getJobDetailId());
		return true;
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		return jobDetailsRepository.updateJobDetails (
					jobDetails.getEmployeeCode(), 
					jobDetails.getJobCode(), 
					jobDetails.getReportingManager(),
					jobDetails.getTeamLead(),
					jobDetails.getCurrentProjectId(), 
					jobDetails.getJobDetailId()
				)>0;
	}

	@Override
	public boolean createJobDetails(JobDetails jobDetails) {
		jobDetailsRepository.save(jobDetails);
		return true;
	}

	@Override
	public JobDetails getJobDetailsOfEmployee(String employeeCode) {
		JobDetails jobDetails = null;
		try {
			jobDetails = jobDetailsRepository.findJobDetailsOfEmployee(employeeCode);
			if(jobDetails==null){
				jobDetails = new JobDetails();
				jobDetails.setEmployeeCode(employeeCode);
			}
		} catch(IllegalStateException e) {
			
		}
		return jobDetails;
	}

	@Override
	public List<Employee> findEmployeeForProject(int projectId) {
		List<JobDetails> jobDetailsList = jobDetailsRepository.findEmployeeForProject(projectId);
		List<Employee> employeeList = new ArrayList<Employee>();
		for(JobDetails val : jobDetailsList) {
			employeeList.add(employeeService.getEmployeeById(val.getEmployeeCode()));
		}
		return employeeList;
	}

	

}
