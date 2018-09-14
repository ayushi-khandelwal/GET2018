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
import com.metacube.training.model.Job;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.JobService;
import com.metacube.training.service.ProjectService;
import com.metacube.training.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	
	@Autowired
	private ProjectService projectService;
	@Autowired
    private SkillService skillService;
    @Autowired
    private JobService jobService;
    @Autowired
    private EmployeeService employeeService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam(name = "email") String email,
			@RequestParam(name = "password") String password) {
	    
	    if (!employeeService.isCredentialsValid(email, password)) {
            return new ModelAndView("login", "message", "Wrong credentials!"); 
        }
        return new ModelAndView("admin/dashboard", "message", ""); 
	}



	@RequestMapping(path = "/addProject", method = RequestMethod.GET)
	public String createproject(Model model) {
		model.addAttribute("project", new Project());
		return "admin/addProject";
	}

	@RequestMapping(path = "addProject", method = RequestMethod.POST)
	public String saveproject(@ModelAttribute("project") Project project) {
		if(project!= null) {
			projectService.createProject(project);	
		}else {
			projectService.updateProject(project);
		}
		return "redirect:/admin/showAllProjects";
	}

	@RequestMapping(path = "/showAllProjects", method = RequestMethod.GET)
	public String getAllprojects(Model model) {
		model.addAttribute("projects", projectService.getAllProjects());
		return "admin/projects";
	}

	@RequestMapping(value = "/updateProject", method = RequestMethod.GET)
    public String updateProject(@RequestParam(value = "project_id") long projectId,
            Model model)
    {
        Project project = projectService.getProjectById(projectId);
        model.addAttribute("project", project);
        return "admin/addProject";
    }

	@RequestMapping(path = "/deleteProject", method = RequestMethod.POST)
	public String deleteproject(@RequestParam("project_id") long project_id) {
		projectService.deleteProject(project_id);
		return "redirect:/admin/projects";
	}


    /**
     * goto add employee form
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployee(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "admin/addEmployee";
    }

    /**
     * adds employee
     * 
     * @param employee
     * @return
     */
    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee)
    {
        if (employee.getEmpCode() == 0 && employee != null) {
            employeeService.createEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return "redirect:/admin/showAllEmployees";
    }

    /**
     * deletes employee
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployee(@RequestParam(value = "empCode") long empCode)
    {
        employeeService.deleteEmployee(empCode);
        return "redirect:/admin/showAllEmployees";
    }

    /**
     * shows all employees
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/showAllEmployees", method = RequestMethod.GET)
    public String showAllEmployees(Model model)
    {
        model.addAttribute("employees", employeeService.getAllEmployee());
        return "admin/employees";
    }

    /**
     * updates employee
     * 
     * @param employeeId
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateEmployee", method = RequestMethod.GET)
    public String updateEmployee(@RequestParam(value = "empCode") long empCode, Model model)
    {
        Employee employee = employeeService.getEmployeeById(empCode);
        model.addAttribute("employee", employee);
        return "admin/addEmployee";
    }

    /**
     * goto add job form
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/addJob", method = RequestMethod.GET)
    public String addJob(Model model)
    {
        model.addAttribute("job", new Job());
        return "admin/addJob";
    }

    /**
     * adds job
     * 
     * @param job
     * @return
     */
    @RequestMapping(value = "/addJob", method = RequestMethod.POST)
    public String addJob(@ModelAttribute("job") Job job)
    {
        if (job.getJobCode() == 0 && job != null) {
            jobService.createJobTitle(job);
        } else {
            jobService.updateJobTitle(job);
        }
        return "redirect:/admin/showAllJobs";
    }

    /**
     * deletes job
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteJob", method = RequestMethod.POST)
    public String deleteJob(@RequestParam(value = "jobCode") long jobCode)
    {
        jobService.deleteJobTitle(jobCode);
        return "redirect:/admin/showAllJobs";
    }

    /**
     * shows all jobs
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/showAllJobs", method = RequestMethod.GET)
    public String showAllJobs(Model model)
    {
        model.addAttribute("jobs", jobService.getAllJobTitles());
        return "admin/jobs";
    }

    /**
     * updates job
     * 
     * @param jobId
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateJob", method = RequestMethod.GET)
    public String updateJob(@RequestParam(value = "jobCode") long jobCode, Model model)
    {
        Job job = jobService.getJobTitleById(jobCode);
        if(jobCode > 0) {
            model.addAttribute("job", job);
            return "admin/addJob";
        }
        else
            return "redirect:/";
    }

    /**
     * goto add skill window
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/addSkill", method = RequestMethod.GET)
    public String addSkill(Model model)
    {
        model.addAttribute("skill", new Skill());
        return "admin/addSkill";
    }

    /**
     * adds skill
     * 
     * @param skill
     * @return
     */
    @RequestMapping(value = "/addSkill", method = RequestMethod.POST)
    public String addSkill(@ModelAttribute("skill") Skill skill)
    {
        if (skill.getSkillId() == 0 && skill != null)
        {
            skillService.createSkill(skill);
        } else
        {
            skillService.updateSkill(skill);
        }
        return "redirect:/admin/showAllSkills";
    }

    /**
     * deletes skill
     * 
     * @param id
     * @return
     */
    @RequestMapping(value = "/deleteSkill", method = RequestMethod.POST)
    public String deleteSkill(@RequestParam(value = "skillId") long skillId)
    {
        skillService.deleteSkill(skillId);
        return "redirect:/admin/showAllSkills";
    }

    /**
     * shows all skills
     * 
     * @param model
     * @return
     */
    @RequestMapping(value = "/showAllSkills", method = RequestMethod.GET)
    public String showAllSkills(Model model)
    {
        model.addAttribute("skills", skillService.getAllSkills());
        return "admin/skills";
    }

    /**
     * updates skill
     * 
     * @param skillId
     * @param model
     * @return
     */
    @RequestMapping(value = "/updateSkill", method = RequestMethod.GET)
    public String updateSkill(@RequestParam(value = "skillId") long skillId,
            Model model)
    {
        Skill skill = skillService.getSkillById(skillId);
        model.addAttribute("skill", skill);
        return "admin/addSkill";
    }

    /**
     * goto admin dashboard
     * 
     * @return
     */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard()
    {
        return "admin/dashboard";
    }

    /**
     * logs out from admin dashboard
     * 
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        return "redirect:/";
    }


    /**
     * goto forgot password page
     * 
     * @return
     */
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String forgotPassword() {
        return "forgotPassword";
    }

    /**
     * Sets default password and sends it to the email address
     * 
     * @param email
     * @return
     */
    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public ModelAndView forgotPassword(@RequestParam(value = "email") String email, ModelAndView modelAndView) {
        
            modelAndView.addObject("Can't do");

        return modelAndView;
    }
}

