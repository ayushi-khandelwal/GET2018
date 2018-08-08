/**
 * 
 */
package ds_Assignment_4.employee_management;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ayushi Khandelwal
 *
 */
public class EmployeeCollection {
    List<Employee> listOfEmployee;

    /**
     * @return the listOfEmployee
     */
    public List<Employee> getListOfEmployee() {
        return listOfEmployee;
    }

    public EmployeeCollection() {
        listOfEmployee = new ArrayList<Employee>();
    }

    public boolean isAlreadyEmployee(String id) {
        for (Employee emp : listOfEmployee) {
            if (id.equals(emp.getID())) {
                return true;
            }
        }
        return false;
    }

    public boolean addEmployee(Employee employee) {
        if (isAlreadyEmployee(employee.getID())) {
            return false;
        }

        listOfEmployee.add(employee);
        return true;
    }

    public void sortNaturalOrder() {
        for (int i = 0; i < listOfEmployee.size() - 1; i++) {
            for (int j = 0; j < listOfEmployee.size() - i - 1; j++) {
                if (listOfEmployee.get(j).getID()
                        .compareTo(listOfEmployee.get(j + 1).getID()) > 0) {
                    Employee tmp = listOfEmployee.get(j);
                    listOfEmployee.add(j, listOfEmployee.get(j + 1));
                    listOfEmployee.add(j + 1, tmp);
                }
            }
        }
    }

    public void sortByName() {
        for (int i = 0; i < listOfEmployee.size() - 1; i++) {
            for (int j = 0; j < listOfEmployee.size() - i - 1; j++) {
                String employee1Name = listOfEmployee.get(j).getName();
                String employee2Name = listOfEmployee.get(j + 1).getName();
                if (employee1Name.compareTo(employee2Name) > 0) {
                    Employee tmp = listOfEmployee.get(j);
                    Employee tmp2 = listOfEmployee.get(j + 1);
                    listOfEmployee.remove(j);
                    listOfEmployee.add(j, tmp2);
                    listOfEmployee.remove(j+1);
                    listOfEmployee.add(j + 1, tmp);
                }
            }
        }
    }
}
