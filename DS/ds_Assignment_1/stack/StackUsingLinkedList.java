package ds_Assignment_1.stack;

class Node
{
	int data;
	Node next;
	
	public Node(int data)
	{
		this.data = data;
	}
}

public class StackUsingLinkedList
{
	Node top;
	
	public StackUsingLinkedList() {
		top = null;
	}
	
	public boolean push(int data) {
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
		return true;
	} 
	
	public boolean pop() {
		if(isEmpty()) 
			return false;
		
		top = top.next;
		return true;
	}
	
	public Node peek() {
		if(isEmpty())
			return null;
		else
			return top;		
	}
	
	public boolean isEmpty() {
		return(top == null);
	}
}