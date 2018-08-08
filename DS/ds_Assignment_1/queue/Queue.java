package ds_Assignment_1.queue;

public interface Queue {
	public boolean enqueue(int value);
	public int dequeue();
	public int peek();
	public boolean isEmpty(); 
}