package com.metacube.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	/*@Autowired
	private ProjectDAO projectDAO;*/
	
	@Autowired
    private ProjectRepository<Project> projectRepository;

	
	
	@Override
	public Project getProjectById(Long id) {
		if(projectRepository.exists(id)) {
		    return projectRepository.findOne(id);
		}
		return null;//projectDAO.getProjectById(id);
	}

	@Override
	public List<Project> getAllProjects() {
		return projectRepository.findAll();
	}

	@Override
	public boolean deleteProject(Long id) {
	    if(projectRepository.exists(id)) {
	        projectRepository.delete(id);
	        return true;
	    }
		//Project project = projectDAO.getProjectById(id);
		return false;//projectDAO.deleteProject(project);
	}

	@Override
	public boolean updateProject(Project project) {
	    return (projectRepository.saveAndFlush(project) != null);
	    //projectDAO.updateProject(project);
	}

	@Override
	public boolean createProject(Project project) {
		projectRepository.save(project);
		return true;
	}

	
}
