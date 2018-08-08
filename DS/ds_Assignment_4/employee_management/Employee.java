package ds_Assignment_4.employee_management;

/**
 * @author Ayushi Khandelwal
 *
 */
public class Employee {
    private final String ID;
    private String name;
    private String address;
    
    /**
     * @param id
     * @param name
     * @param address
     */
    public Employee(String id, String name, String address) {
        this.ID = id;
        this.name = name;
        this.address = address;
    }

    /**
     * @return id
     */
    public String getId() {
        return ID;
    }
   
    /**
     * @return name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }
}
