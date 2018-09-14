package com.metacube.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.metacube.training.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;


    /**
     * goto employee login window
     * 
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * logs into employee dashboard
     * 
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam(value = "email") String email,
            @RequestParam(value = "password") String password) {
        if (!employeeService.isCredentialsValid(email, password)) {
            return new ModelAndView("login", "message", "Wrong credentials!"); 
        }
        return new ModelAndView("employee/dashboard", "message", ""); 
        /*return "redirect:/employee/dashboard";*/
    }

    /**
     * searches employee
     * 
     * @param id
     *            employee id
     * @param model
     * @return
     */
    @RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
    public String searchEmployee(@RequestParam(value = "empCode") long empCode, Model model) {
        if(model.addAttribute("employees", employeeService.getEmployeeById(empCode)) != null)
            return "employee/searchEmployee";
        else
            return "error";
    }

    /**
     * goto employee dashboard
     * 
     * @return
     */
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard() {
        return "employee/dashboard";
    }

    /**
     * logs out from employee dashboard
     * 
     * @return
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/";
    }

}
