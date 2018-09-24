package com.metacube.training.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * class for job details
 * created on September 10, 2018
 */
@Entity
@Table(name = "job_details")
public class JobDetails {
	@Id
	@Column(name = "job_detail_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobDetailId;
	
	@Column(name = "emp_code")
	private String employeeCode;
	
	@Column(name = "job_code")
	private int jobCode;
	
	@Column(name = "reporting_mgr")
	private String reportingManager;
	
	@Column(name = "team_lead")
	private String teamLead;
	
	@Column(name = "curr_proj_id")
	private int currentProjectId;
	
	public int getJobDetailId() {
		return jobDetailId;
	}
	
	public void setJobDetailId(int jobDetailId) {
		this.jobDetailId = jobDetailId;
	}
	
	public String getEmployeeCode() {
		return employeeCode;
	}
	
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	
	public int getJobCode() {
		return jobCode;
	}
	
	public void setJobCode(int jobCode) {
		this.jobCode = jobCode;
	}
	
	public String getReportingManager() {
		return reportingManager;
	}
	
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	
	public String getTeamLead() {
		return teamLead;
	}
	
	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}
	
	public int getCurrentProjectId() {
		return currentProjectId;
	}
	
	public void setCurrentProjectId(int currentProjectId) {
		this.currentProjectId = currentProjectId;
	}
	
	
}
