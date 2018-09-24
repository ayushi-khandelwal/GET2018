package com.metacube.training.controller;

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
import com.metacube.training.model.EmployeeSkills;
import com.metacube.training.service.EmployeeService;
import com.metacube.training.service.EmployeeSkillsService;
import com.metacube.training.service.SkillMasterService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeSkillsService employeeSkillsService;

	@Autowired
	SkillMasterService skillMasterService;

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String login() {
	// return "employee/login";
	// }
	//
	// @PostMapping("/login")
	// public String login(@RequestParam(name = "username") String username,
	// @RequestParam(name = "password") String password,HttpServletRequest
	// request) {
	// Employee employee = employeeService.getEmployeeById(username);
	// HttpSession session = request.getSession();
	// String passwordFromDataBase = employee.getPassword();
	// if(password.equals(passwordFromDataBase)) {
	// session.setAttribute("employeeCode",username);
	// return "redirect:/employee/dashboard";
	// } else {
	// return "employee/login";
	// }
	// }

	@RequestMapping(path = "/dashboard", method = RequestMethod.GET)
	public String search(Model model, HttpServletRequest request) {
		request.getSession().setAttribute("employeeCode", "E18/1000");
		model.addAttribute("employee",employeeService.getEmployeeById(request.getSession().getAttribute("employeeCode").toString()));
		return "employee/dashboard";
	}

	/*@GetMapping(path = "/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "logout";
	}*/

	@GetMapping(path = "/changePassword")
	public String changePassword() {
		return "employee/changePassword";
	}

	@PostMapping(path = "/changePassword")
	public String updatePassword(
			@RequestParam("currentPassword") String currentPassword,
			@RequestParam("newPassword") String newPassword,
			@RequestParam("confirmPassword") String confirmPassword,
			HttpServletRequest request) {
		String employeeCode = request.getSession().getAttribute("employeeCode")
				.toString();
		Employee employee = employeeService.getEmployeeById(employeeCode);
		String passwordFromDataBase = employee.getPassword();
		if (currentPassword.equals(passwordFromDataBase)
				&& (newPassword.equals(confirmPassword))) {
			employee.setPassword(newPassword);
			employeeService.updateEmployee(employee);
			return "redirect:/employee/login";
		} else {
			return "employee/dashboard";
		}
	}

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
		employeeService.updateEmployee(employee);
		return "redirect:/employee/dashboard";
	}

	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "employee/forgotPassword";
	}

	@PostMapping(path = "/forgotPassword")
	public String forgotPassword(
			@RequestParam("employeeCode") String employeeCode,
			@RequestParam("dob") String dob,
			@RequestParam("newPassword") String newPassword) {
		Employee employee = employeeService.getEmployeeById(employeeCode);
		if ((employee != null) && ((employee.getDob().toString()).equals(dob))) {
			employee.setPassword(newPassword);
			employeeService.updateEmployee(employee);
		}
		return "redirect:/employee/login";
	}

	@GetMapping("/addSkills")
	public String addSkills(Model model, HttpServletRequest request) {
		String employeeCode = request.getSession().getAttribute("employeeCode")
				.toString();
		model.addAttribute("employeeSkill", (employeeSkillsService
				.getEmployeeSkillsOfEmployee(employeeCode)));
		model.addAttribute("skillList", skillMasterService.getAllSkills());
		return "employee/addSkills";
	}

	@PostMapping("/addSkills")
	public String addSkills(@RequestParam("skillId") int id,
			HttpServletRequest request) {
		EmployeeSkills employeeSkills = new EmployeeSkills();
		String employeeCode = request.getSession().getAttribute("employeeCode")
				.toString();
		employeeSkills.setSkillCode(id);
		employeeSkills.setEmployeeCode(employeeCode);
		employeeSkillsService.createEmployeeSkill(employeeSkills);
		return "redirect:/employee/addSkills";
	}
}
