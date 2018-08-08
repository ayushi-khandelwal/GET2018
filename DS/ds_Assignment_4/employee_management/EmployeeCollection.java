package ds_Assignment_4.employee_management;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayushi Khandelwal
 *
 */
public class EmployeeCollection {
    List<Employee> employeeList;
    
    /**
     * default constructor
     */
    public EmployeeCollection() {
        employeeList = new ArrayList<>();
    }

    /**
     * @param employee
     * @return true if employee is successfully added
     * @return false if employee is not successfully added
     */
    public boolean addEmployee(Employee employee) {
        if(employeeList.contains(employee))
            throw new AssertionError("Duplicate employee should not be added!!");
        
        employeeList.add(employee);
        return true;
    }

    /**
     * @return list of employee after sorting it in natural order that is on the basis of employee ID
     */
    public List<Employee> sortNaturalOrder() {
       for(int i = 0; i < employeeList.size()-1; i++) 
           for(int j = 0; j < employeeList.size()-i-1; j++) 
               if(employeeList.get(j).getId().compareTo(employeeList.get(j+1).getId()) > 0) {
                   Employee temp = employeeList.get(j);
                   employeeList.set(j, employeeList.get(j+1));
                   employeeList.set(j+1, temp);
               }
       return employeeList;
    }

    /**
     * @return list of employee after sorting it on the basis of employee name
     */
    public List<Employee> sortByName() {
        for(int i = 0; i < employeeList.size()-1; i++) 
            for(int j = 0; j < employeeList.size()-i-1; j++) 
                if(employeeList.get(j).getName().compareTo(employeeList.get(j+1).getName()) > 0) {
                    Employee temp = employeeList.get(j);
                    employeeList.set(j, employeeList.get(j+1));
                    employeeList.set(j+1, temp);
                }
        return employeeList;
    }

    /**
     * @return list of employee
     */
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    
    
}
