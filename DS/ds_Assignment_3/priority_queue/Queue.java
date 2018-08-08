package ds_Assignment_3.priority_queue;

public interface Queue {
    public boolean isEmpty();
    public boolean enqueue(String item, int priority);
    public String dequeueHighestPriorityItem();
    public int getHighestPriority();
    public String getHighestPriorityItem();
}
