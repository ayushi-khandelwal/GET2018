package com.metacube.training.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.metacube.training.model.Employee;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.SkillMasterService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	SkillMasterService skillMasterService;


	@RequestMapping(path = "/dashboard", method = RequestMethod.GET)
    public String search(Model model, HttpServletRequest request, Principal principal) {
        request.getSession().setAttribute("employeeCode", principal.getName());
        model.addAttribute("employee",employeeService.getEmployeeById(principal.getName()));
        return "employee/dashboard";
    }
	/*@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "logout";
	}*/

	

	@GetMapping(path = "/editProfile")
	public String editProfile(Model model, HttpServletRequest request) {
		String employeeCode = request.getSession().getAttribute("employeeCode")
				.toString();
		Employee employee = employeeService.getEmployeeById(employeeCode);
		model.addAttribute(employee);
		return "employee/editProfile";
	}

	@PostMapping("/editProfile")
	public String saveEmployeeDetails(
			@ModelAttribute("employee") Employee employee) {
	    if(employee.getEmailId().equals(null) || employee.getDob().equals(null))
	        return "redirect:/";
	    
		employeeService.updateEmployee(employee);
		return "redirect:/employee/dashboard";
	}
	
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        return "redirect:/";
    }

}
