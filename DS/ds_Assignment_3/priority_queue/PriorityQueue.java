package ds_Assignment_3.priority_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

/**
 * @author Ayushi Khandelwal
 *
 */
public class PriorityQueue implements Queue {
    
    //HashMap is used to store item and its priority
    private HashMap< String, Integer> map;
    
    //default constructor to initialize HashMap
    public PriorityQueue() {
        map = new HashMap<>();
    }
    
    //inserts item and its priority in HashMap
    @Override
    public boolean enqueue(String item, int priority) {
        //if priority is negative then throws AssertionError
        if(priority < 0 || item == ""){
            throw new AssertionError();
        }
        
        map.put(item, priority);
        return true;
    }
    
    //delete item of highest priority from HashMap
    @SuppressWarnings("rawtypes")
    @Override
    public String dequeueHighestPriorityItem() {
        int largestPriority = getHighestPriority();
        
        for (Object obj: map.entrySet() ) {
            Map.Entry entry = (Map.Entry) obj;
            if(largestPriority == (int) entry.getValue()) {
                map.remove(entry.getKey());            
                return (String) entry.getKey();
            }
        }
        return null;
    }
    
    //gives highest priority among priorities of all items present in HashMap
    @SuppressWarnings("rawtypes")
    @Override
    public int getHighestPriority() {
        if(!isEmpty()) {
            int largestPriority = -1;
            
            //retrieve HashMap to get highest priority
            for (Object obj: map.entrySet() ) {
                Map.Entry entry = (Map.Entry) obj;
                if(largestPriority < (int) entry.getValue()) {
                    largestPriority = (int) entry.getValue();
                }
            }
            return largestPriority;
        }
        throw new AssertionError();
    }

    //gives item having highest priority among all the items present in HashMap
    @SuppressWarnings("rawtypes")
    @Override
    public String getHighestPriorityItem() {
        int largestPriority = getHighestPriority();
        
        //retrieves key from value
        for (Entry entry : map.entrySet()) { 
            if (Objects.equals(largestPriority, entry.getValue())) { 
                return (String) entry.getKey(); 
            } 
        } return null; 
    }
    
    @Override
    public boolean isEmpty() {
        if(map.isEmpty())
            return true;
        return false;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public String getItem() {
        int largestPriority = getHighestPriority();
        
        for (Entry entry : map.entrySet()) { 
            if (Objects.equals(largestPriority, entry.getValue())) { 
                entry.setValue((int)(entry.getValue()) - 1);
                return (String) entry.getKey(); 
            } 
        } return null; 
    }
}
