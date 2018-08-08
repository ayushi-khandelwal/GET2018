package ds_Assignment_4.employee_management;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Ayushi Khandelwal
 *
 */
public class EmployeeCollectionTest {

    EmployeeCollection employeeCollection;
    
    @Before
    public void init() {
        employeeCollection = new EmployeeCollection();
        employeeCollection.addEmployee(new Employee("E18", "Ayushi", "34/447 Jaipur"));
        employeeCollection.addEmployee(new Employee("E12", "Sam", "34/44 Alwar"));
        employeeCollection.addEmployee(new Employee("E28", "John", "35/477 Ajmer"));
        employeeCollection.addEmployee(new Employee("E23", "Kim", "39/7 Udaipur"));
        employeeCollection.addEmployee(new Employee("E10", "Ania", "32/447 Agra"));
    }
    
     @Test
    public void test_addEmployee_WhenAddedWithUniqueID_ReturnTrue() {
        assertEquals(true, employeeCollection.addEmployee(new Employee("E20", "Ayushi", "40/447 Pratapnagar")));
    }
     
    @Test(expected = AssertionError.class)
    public void test_addEmployee_WhenAddedWithDuplicateID_ThrowAssertionError() {
        assertEquals("Duplicate employee should not be added!!", employeeCollection.addEmployee(new Employee("E18", "Rajesh", "34/488 Pratapnagar")));
    }
    
     @Test
    public void test_checkNaturalOrderSorting_When_CheckByNameOrID_Return_NameOrID() {
        employeeCollection.sortNaturalOrder();

        assertEquals("E10",employeeCollection.getEmployeeList().get(0).getId());
        assertEquals("Ania",employeeCollection.getEmployeeList().get(0).getName());

        assertEquals("E12",employeeCollection.getEmployeeList().get(1).getId());
        assertEquals("Sam",employeeCollection.getEmployeeList().get(1).getName());
        
        assertEquals("E18",employeeCollection.getEmployeeList().get(2).getId());
        assertEquals("Ayushi",employeeCollection.getEmployeeList().get(2).getName());

        assertEquals("E23",employeeCollection.getEmployeeList().get(3).getId());
        assertEquals("Kim",employeeCollection.getEmployeeList().get(3).getName());

        assertEquals("E28",employeeCollection.getEmployeeList().get(4).getId());
        assertEquals("John",employeeCollection.getEmployeeList().get(4).getName());
    }
    
     @Test
    public void test_checkSortingByName_When_CheckByNameOrID_Return_NameOrID() {
        employeeCollection.sortByName();      

        assertEquals("E10",employeeCollection.getEmployeeList().get(0).getId());
        assertEquals("Ania",employeeCollection.getEmployeeList().get(0).getName());

        assertEquals("E18",employeeCollection.getEmployeeList().get(1).getId());
        assertEquals("Ayushi",employeeCollection.getEmployeeList().get(1).getName());
        
        assertEquals("E28",employeeCollection.getEmployeeList().get(2).getId());
        assertEquals("John",employeeCollection.getEmployeeList().get(2).getName());

        assertEquals("E23",employeeCollection.getEmployeeList().get(3).getId());
        assertEquals("Kim",employeeCollection.getEmployeeList().get(3).getName());

        assertEquals("E12",employeeCollection.getEmployeeList().get(4).getId());
        assertEquals("Sam",employeeCollection.getEmployeeList().get(4).getName());
    }  
}
