package com.DAO;

public class SQL_Queries {
    public static String addEmployee() {
        return "INSERT INTO EMPLOYEE values (?,?,?,?)";
    }
    
    public static String getEmployeeDetail() {
        return "SELECT * FROM employee where (employee_First_Name = ? OR employee_Last_Name = ?) OR (employee_First_Name = ? AND employee_Last_Name = ?)";
    }
                                                
    
    public static String getEmployeeFullDetail() {
        return "SELECT * FROM employee where employee_Email=?";
    }
                                                   

    public static String showAllEmployees() {
        return "SELECT employee_Email,employee_First_Name,employee_Last_Name,employee_age FROM employee";
    }
    
    public static String getEmailIdToUpdate(String email) {
        return "SELECT * FROM Employee WHERE employee_Email='" + email + "';";
    }

    public static String updateDetail() {
        return "UPDATE employee SET employee_First_Name=?, employee_Last_Name=?, Employee_age=? WHERE Employee_email=?;";
    }
     
}
