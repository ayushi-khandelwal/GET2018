package ds_Assignment_3.priority_queue;

public interface Queue {
    public boolean enqueue(String item, int priority);
    public int getHighestPriority();
    public String dequeueHighestPriority();
    public String getHighestPriorityItem();
}
