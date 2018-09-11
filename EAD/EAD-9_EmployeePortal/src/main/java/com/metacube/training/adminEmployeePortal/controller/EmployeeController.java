package com.metacube.training.adminEmployeePortal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/employee")
public class EmployeeController
{

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login()
    {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "email") String userName,
            @RequestParam(value = "password") String password)
    {
        return "redirect:/employee/dashboard";
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public String editEmployee()
    {
        return "employee/editEmployee";
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.POST)
    public String editEmployee(
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
        return "redirect:/employee/dashboard";
    }

    @RequestMapping(value = "/searchEmployee", method = RequestMethod.GET)
    public String searchEmployee()
    {
        return "employee/searchEmployee";
    }

    @RequestMapping(value = "/searchEmployee", method = RequestMethod.POST)
    public String searchEmployee(
            @RequestParam(value = "employeeName") String employeeName)
    {
        return "redirect:/admin/dashboard";
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String gotoDashboard()
    {
        return "employee/dashboard";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout()
    {
        return "home";
    }

}
