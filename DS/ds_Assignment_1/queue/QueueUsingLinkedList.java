package ds_Assignment_1.queue;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}

public class QueueUsingLinkedList implements Queue{
	Node front, rear;
	
	public QueueUsingLinkedList() {
		front = null;
		rear = null;
	}

	@Override
	public boolean enqueue(int value) {
		Node newNode = new Node(value);
		
		if(front == null || rear == null) {
			front = newNode;
			rear = newNode;
			newNode.next = null;
			return true;
		} 
		else {
			rear.next = newNode;
			rear = rear.next;
		}
		
		newNode.next = null;
		return true;
	}

	@Override
	public int dequeue() {
		if(isEmpty()) 
			return -1;
		
		int item = front.data;
		front = front.next;
		return item;
	}

	@Override
	public int peek() {
		if (front == null) {
            return -1;
        } else {
            return front.data;
        }
	}

	public boolean isEmpty() {
		return (front == null);
	}
}
