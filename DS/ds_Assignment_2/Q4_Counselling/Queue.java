package ds_Assignment_2.Q4_Counselling;


/**
 * This interface provides various methods on Queue
 * 
 * @author Ayushi Khandelwal
 *
 */
public interface Queue {

    public Student deQueue();
    public boolean enQueue(Student newStudent);
    public Student peek();
}
