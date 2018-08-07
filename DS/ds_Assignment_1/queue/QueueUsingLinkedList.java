package ds_Assignment_1.queue;

class Node {
	int data;
	Node next;
	
	public Node(int data)
	{
		this.data = data;
	}
}

public class QueueUsingLinkedList {
	Node start, end;
	
	public QueueUsingLinkedList() {
		start = null;
		end = null;
	}
	
	public boolean add(int data) {
		Node newNode = new Node(data);
		
		if(start == null)
			start = newNode;
		
		newNode.next = null;
		end = newNode;
		return true;
	}
	
	public boolean delete() {
		if(isEmpty()) 
			return false;
		
		start = start.next;
		return true;
	}
	
	public boolean isEmpty() {
		return (end == null);
	}

}