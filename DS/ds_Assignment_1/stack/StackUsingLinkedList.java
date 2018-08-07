package ds_Assignment_1.stack;

class Node {
	int data;
	Node next;
	
	public Node(int data) {
		this.data = data;
	}
}

public class StackUsingLinkedList implements Stack
{
	Node top;
	
	public StackUsingLinkedList() {
		top = null;
	}

	@Override
	public boolean push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		return true;
	} 

	@Override
	public int pop() {
		if(isEmpty()) 
			return -1;

		int poppedValue = top.data;
		top = top.next;
		return poppedValue;
	}

	@Override
	public int peek() {
		if(isEmpty())
			throw new AssertionError();
		else
			return top.data;		
	}

	@Override
	public boolean isEmpty() {
		return(top == null);
	}
}
