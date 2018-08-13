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
       for(int employeeListIterator1 = 0; employeeListIterator1 < employeeList.size()-1; employeeListIterator1++) 
           for(int employeeListIterator2 = 0; employeeListIterator2 < employeeList.size()-employeeListIterator1 - 1; employeeListIterator2++) 
               if(employeeList.get(employeeListIterator2).getId().compareTo(employeeList.get(employeeListIterator2 + 1).getId()) > 0) {
                   Employee temp = employeeList.get(employeeListIterator2);
                   employeeList.set(employeeListIterator2, employeeList.get(employeeListIterator2 + 1));
                   employeeList.set(employeeListIterator2 + 1, temp);
               }
       return employeeList;
    }

    /**
     * @return list of employee after sorting it on the basis of employee name
     */
    public List<Employee> sortByName() {
        for(int employeeListIterator1 = 0; employeeListIterator1 < employeeList.size()-1; employeeListIterator1++) 
            for(int employeeListIterator2 = 0; employeeListIterator2 < employeeList.size()- employeeListIterator1 - 1; employeeListIterator2++) 
                if(employeeList.get(employeeListIterator2).getName().compareTo(employeeList.get(employeeListIterator2+1).getName()) > 0) {
                    Employee temp = employeeList.get(employeeListIterator2);
                    employeeList.set(employeeListIterator2, employeeList.get(employeeListIterator2+1));
                    employeeList.set(employeeListIterator2+1, temp);
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