package ds_Assignment_3.virtualCMD;

public interface Queue {
    public boolean isEmpty();
    public boolean enqueue(String item, int priority);
    public String dequeueHighestPriorityItem();
    public int getHighestPriority();
    public String getHighestPriorityItem();
}