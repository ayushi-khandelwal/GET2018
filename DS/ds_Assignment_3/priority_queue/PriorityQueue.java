package ds_Assignment_3.priority_queue;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class PriorityQueue implements Queue {

    private HashMap< String, Integer> map;
    
    public PriorityQueue() {
        map = new HashMap<>();
    }
    
    @Override
    public boolean enqueue(String item, int priority) {
        if(priority < 0){
            return false;
        }
        
        map.put(item, priority);
        return true;
    }

    @Override
    public int getHighestPriority() {
        int largestPriority = -1;
        
        for (Object obj: map.entrySet() ) {
            Map.Entry entry = (Map.Entry) obj;
            if(largestPriority < (int) entry.getValue()) {
                largestPriority = (int) entry.getValue();
            }
        }
        return largestPriority;
    }

    @Override
    public String getHighestPriorityItem() {
        int largestPriority = getHighestPriority();
        
        for (Entry entry : map.entrySet()) { 
            if (Objects.equals(largestPriority, entry.getValue())) { 
                return (String) entry.getKey(); 
            } 
        } return null; 
    }
            
    @Override
    public String dequeueHighestPriority() {
        int largestPriority = getHighestPriority();
        for (Object obj: map.entrySet() ) {
            Map.Entry entry = (Map.Entry) obj;
            if(largestPriority == (int) entry.getValue()) {
                map.remove(entry.getKey());            
                System.out.println(entry.getKey() + " " + entry.getValue());
                return (String) entry.getKey();
            }
        }
        return null;
    }
    
    @SuppressWarnings("unchecked")
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
