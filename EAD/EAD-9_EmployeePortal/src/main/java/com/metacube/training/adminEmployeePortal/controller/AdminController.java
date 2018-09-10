package com.metacube.training.adminEmployeePortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.adminEmployeePortal.model.Employee;
import com.metacube.training.adminEmployeePortal.model.Job;
import com.metacube.training.adminEmployeePortal.model.Project;
import com.metacube.training.adminEmployeePortal.model.Skill;
import com.metacube.training.adminEmployeePortal.service.EmployeeService;
import com.metacube.training.adminEmployeePortal.service.JobService;
import com.metacube.training.adminEmployeePortal.service.ProjectService;
import com.metacube.training.adminEmployeePortal.service.SkillService;

@Controller
@RequestMapping("/admin")
public class AdminController
{

    @Autowired
    private ProjectService projectService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private JobService jobService;
    @Autowired
    private EmployeeService employeeService;
    
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "email") String userName, @RequestParam(value = "password") String password)
    {
        return "redirect:/admin/dashboard";
    }
    
    
    /*
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployee()
    {
        return "admin/addEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(
            @RequestParam(value = "firstName") String firstName,
            @RequestParam(value = "middleName") String middleName,
            @RequestParam(value = "lastName") String lastName,
            // @RequestParam(value="dateOfBirth") Date dateOfBirth,
            // @RequestParam(value="gender") String gender,
            // @RequestParam(value="dateOfJoining") Date dateOfJoining,
            // @RequestParam(value="reportingManager") String reportingManager,
            // @RequestParam(value="teamLead") String teamLead,
            // @RequestParam(value="projectId") String projectId,
            @RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password)
    {
        return "redirect:/admin/dashboard";
    }
    
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployee(@RequestParam(value = "id") String id)
    {
        employeeService.delete(Integer.parseInt(id));
        return "redirect:/admin/dashboard";
    }
    */
    /*
    @RequestMapping(value = "/updateProject", method = RequestMethod.GET)
    public String updateProject(@RequestParam(value="id") String projectId)
    {
        int id = Integer.parseInt(projectId);
        Project project = new Project();
        
        return "admin/addProject";
    }
*/
    
       
    @RequestMapping(value = "/addProject", method = RequestMethod.GET)
    public String addProject(Model model)
    {
        model.addAttribute("project", new Project());
        return "admin/addProject";
    }

    @RequestMapping(value = "/addProject", method = RequestMethod.POST)
    public String addProject(@ModelAttribute("project") Project project)
    {
        projectService.create(project);
        return "redirect:/admin/dashboard";
    }
    
    @RequestMapping(value = "/deleteProject", method = RequestMethod.POST)
    public String deleteProject(@RequestParam(value = "id") String id)
    {
        projectService.delete(Integer.parseInt(id));
        return "redirect:/admin/dashboard";
    }
    
    @RequestMapping(value = "/showAllProjects", method = RequestMethod.GET)
    public String showAllProjects(Model model)
    {
        model.addAttribute("projects", projectService.getAll());
        return "admin/projects";
    }
    
    @RequestMapping(value = "/updateProject", method = RequestMethod.GET)
    public String updateProject(@RequestParam(value="id") String projectId)
    {      
        return "admin/updateProject/"+projectId;
    }
    
    @RequestMapping(value = "/updateProject/{projectId}", method = RequestMethod.GET)
    public String updateProject(@PathVariable("projectID") int id)
    {
        System.out.println(id);
        return "redirect:/admin/dashboard";
    }
    
    
    
    @RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
    public String addEmployee(Model model)
    {
        model.addAttribute("employee", new Employee());
        return "admin/addEmployee";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee)
    {
        employeeService.create(employee);
        return "redirect:/admin/dashboard";
    }
    
    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.POST)
    public String deleteEmployee(@RequestParam(value = "id") String id)
    {
        employeeService.delete(Integer.parseInt(id));
        return "redirect:/admin/dashboard";
    }
    
    @RequestMapping(value = "/showAllEmployees", method = RequestMethod.GET)
    public String showAllEmployees(Model model)
    {
        model.addAttribute("employees", employeeService.getAll());
        return "admin/Employees";
    }
    
    

    @RequestMapping(value = "/addJob", method = RequestMethod.GET)
    public String addJob(Model model)
    {
        model.addAttribute("job", new Job());
        return "admin/addJob";
    }

    @RequestMapping(value = "/addJob", method = RequestMethod.POST)
    public String addJob(@ModelAttribute("job") Job job)
    {
        jobService.create(job);
        return "redirect:/admin/dashboard";
    }
    
    @RequestMapping(value = "/deleteJob", method = RequestMethod.POST)
    public String deleteJob(@RequestParam(value = "id") String id)
    {
        jobService.delete(Integer.parseInt(id));
        return "redirect:/admin/dashboard";
    }
    
    @RequestMapping(value = "/showAllJobs", method = RequestMethod.GET)
    public String showAllJobs(Model model)
    {
        model.addAttribute("jobs", jobService.getAll());
        return "admin/jobs";
    }
    
    
    

    @RequestMapping(value = "/addSkill", method = RequestMethod.GET)
    public String addSkill(Model model)
    {
        model.addAttribute("skill", new Skill());
        return "admin/addSkill";
    }

    @RequestMapping(value = "/addSkill", method = RequestMethod.POST)
    public String addSkill(@ModelAttribute("skill") Skill skill)
    {
        skillService.create(skill);
        return "redirect:/admin/dashboard";
    }
    
    @RequestMapping(value = "/deleteSkill", method = RequestMethod.POST)
    public String deleteSkill(@RequestParam(value = "id") String id)
    {
        skillService.delete(Integer.parseInt(id));
        return "redirect:/admin/dashboard";
    }
    
    @RequestMapping(value = "/showAllSkills", method = RequestMethod.GET)
    public String showAllSkills(Model model)
    {
        model.addAttribute("skills", skillService.getAll());
        return "admin/skills";
    }

    /*
    @RequestMapping(path = "/projects/add", method = RequestMethod.GET)
    public String createproject(Model model)
    {
        model.addAttribute("project", new Project());
        return "admin/editProject";
    }

    @RequestMapping(path = "projects", method = RequestMethod.POST)
    public String saveproject(@ModelAttribute("project") Project project)
    {
        if (project != null && project.getId() == 0)
        {
            projectService.createProject(project);
        } else
        {
            projectService.updateProject(project);
        }
        return "redirect:/admin/projects";
    }

    @RequestMapping(path = "/projects", method = RequestMethod.GET)
    public String getAllprojects(Model model)
    {
        model.addAttribute("projects", projectService.getAllProjects());
        return "admin/projects";
    }

    @RequestMapping(path = "/projects/edit", method = RequestMethod.GET)
    public String editproject(Model model, @RequestParam("id") Long id)
    {
        model.addAttribute("project", projectService.getProjectById(id));
        return "admin/editProject";
    }

    @RequestMapping(path = "/projects/delete", method = RequestMethod.GET)
    public String deleteproject(@RequestParam("id") Long id)
    {
        projectService.deleteProject(id);
        return "redirect:/admin/projects";
    }
    */
    
    
    
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard()
    {
        return "admin/dashboard";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        return "redirect:/";
    }

}
