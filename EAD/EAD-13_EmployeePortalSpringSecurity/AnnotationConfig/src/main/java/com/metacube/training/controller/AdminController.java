package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.model.Employee;
import com.metacube.training.model.JobDetails;
import com.metacube.training.model.JobTitleMaster;
import com.metacube.training.model.Project;
import com.metacube.training.model.SkillMaster;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.JobDetailsService;
import com.metacube.training.service.JobTitleMasterService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillMasterService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private SkillMasterService skillMasterService;
	
	@Autowired
	private JobTitleMasterService jobTitleMasterService;
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private JobDetailsService jobDetailsService;
	
	
	@GetMapping("/dashboard")
	public String login() {
		System.out.println("================Dashboard====================");
		return "admin/dashboard";
	}

	@RequestMapping(path = "/projects/add", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/editProject";
	}

	@RequestMapping(path = "projects", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if(project!= null && project.getId() == 0) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/projects";
	}

	@RequestMapping(path = "/projects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
	public String editproject(Model model, @RequestParam("id") int projectId) {
		model.addAttribute("project", projectService.getProjectById(projectId));
		return "admin/editProject";
	}

	@RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
	public String deleteproject(@RequestParam("id") int id) {
		projectService.deleteProject(id);
		return "redirect:/admin/projects";
	}
	
	@RequestMapping(path = "/skills/add", method = RequestMethod.GET)
	public String createSkill(Model model) {
		model.addAttribute("skillMaster", new SkillMaster());
		return "admin/editSkill";
	}
	
	@RequestMapping(path = "/skills/edit", method = RequestMethod.GET)
	public String editSkill(Model model, @RequestParam("skillId") int skillId) {
		model.addAttribute("skillMaster", skillMasterService.getSkillById(skillId));
		return "admin/editSkill";
	}
	
	@RequestMapping(path = "/skills", method = RequestMethod.POST)
	public String saveSkill(@ModelAttribute("skillMaster") SkillMaster skillMaster) {
		if(skillMaster!= null && skillMaster.getSkillId() == 0) {
			skillMasterService.createSkill(skillMaster);	
		}else {
			skillMasterService.updateSkill(skillMaster);
		}
		return "redirect:/admin/skills";
	}
	
	@RequestMapping(path = "/skills" , method = RequestMethod.GET)
	public String getAllSkills(Model model) {
		model.addAttribute("skillMaster",skillMasterService.getAllSkills());
		return "admin/skills";
	}
	
	@RequestMapping(path = "/skills/delete", method = RequestMethod.GET)
	public String deleteSkill(@RequestParam("skillId") int id) {
		skillMasterService.deleteSkill(id);
		return "redirect:/admin/skills";
	}

	@RequestMapping(path = "/JobTitles/add", method = RequestMethod.POST)
	public String createJobTitleMaster(@RequestParam("jobTitle") String jobTitle) {
		JobTitleMaster jobTitleMaster = new JobTitleMaster();
		jobTitleMaster.setJobTitle(jobTitle);
		jobTitleMasterService.createJobTitleMaster(jobTitleMaster);
		return "redirect:/admin/JobTitles";
	}
	
	@RequestMapping(path = "/JobTitles" , method = RequestMethod.GET)
	public String getAllJobTitleMaster(Model model) {
		model.addAttribute("jobTitleMaster",jobTitleMasterService.getAllJobTitleMaster());
		return "admin/JobTitles";
	}
	
	@RequestMapping(path="/allEmployee", method = RequestMethod.GET)
	public String getAllEmployee(Model model) {
		model.addAttribute("employee",employeeService.getAllEmployee());
		return "admin/employee";
	}
	
	@RequestMapping(path="/employee/add", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("employee",new Employee());
		return "admin/registerEmployee";
	}
	
	@RequestMapping(path="/employee", method=RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		if(employee!=null && employee.getEmployeeCode()==null) {
			employeeService.createEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return "redirect:/admin/allEmployee";
	}
	
	@RequestMapping(path="/createJobDetails", method = RequestMethod.GET)
	public String createJobDetails(Model model,@RequestParam("employeeCode") String employeeCode) {
		JobDetails jobDetails = new JobDetails();
		jobDetails.setEmployeeCode(employeeCode);
		model.addAttribute("jobDetails",jobDetails);
		return "admin/jobDetails";
	}
	
	@RequestMapping(path="/updateJobDetails", method = RequestMethod.GET)
	public String updateJobDetails(Model model,@RequestParam("employeeCode") String employeeCode) {
		model.addAttribute("jobDetails", jobDetailsService.getJobDetailsOfEmployee(employeeCode));
		return "admin/jobDetails";
	}
	
	@RequestMapping(path = "/updateJobDetails", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("jobDetails") JobDetails jobDetails) {
		if(jobDetails.getJobCode() == 0) {
			jobDetailsService.createJobDetails(jobDetails);	
		}else {
			jobDetailsService.updateJobDetails(jobDetails);
		}
		return "redirect:/admin/allEmployee";
	}
	
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String searchEmployee(Model model) {
	return "admin/search";
	}

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String search(@RequestParam(name = "search") int projectId,  Model model) {
	model.addAttribute("employee",jobDetailsService.findEmployeeForProject(projectId));
	return "admin/search";
	}
	
}
