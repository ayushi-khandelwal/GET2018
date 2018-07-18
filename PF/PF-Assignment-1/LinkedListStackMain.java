import java.util.*;
class Node
{
	int data;
	Node next;	
	public Node(int data)
	{
		this.data = data;
	}
}
class LinkListStack
{
	Node top = null;
	public void push(int data)
	{
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	public void pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack underflow");
		}
		else
		{
			Node deletedNode = top;
			top=top.next;
			System.out.println("Popped item is: " + deletedNode.data);
		}
	}
	public void top()
	{
		if(isEmpty())
			System.out.println("List is empty!");
		else
			System.out.println("Value on top is: " + top.data);		
	}
	public void display()
	{
		if(isEmpty())
			System.out.println("List is empty!");
		else
		{
			Node current = top;
			while(current != null)
			{
				System.out.println("Values stack contains: " + current.data + " ");
				current = current.next;
			}
		}
	}
	public boolean isEmpty()
	{
		return(top == null);
	}
}
public class LinkListStackMain
{
	public static void main(String args[])
	{
		LinkListStack stack = new LinkListStack();
		Scanner sc = new Scanner(System.in);
		char ch;
		do
		{
			System.out.println("--STACK OPERATIONS--");
			System.out.println("1.Push");
			System.out.println("2.Pop");
			System.out.println("3.Display the top");
			System.out.println("4.Display the stack");
			System.out.println("5.Check stack is empty or not?");
			System.out.println("6.Exit");			
			System.out.print("Enter your choice: ");
			int choice = sc.nextInt();
			switch(choice)
			{
				case 1: System.out.print("Enter what value to be pushed: ");
						stack.push(sc.nextInt()); break;
				case 2: stack.pop(); break;
				case 3: stack.top(); break;
				case 4: stack.display(); break;	
				case 5: System.out.println("List is empty: " + stack.isEmpty()); break;
				case 6: return;
				default: System.out.println("Invalid input");			
			}
			System.out.print("Press 'Y' for continue and 'N' for exit: ");
			ch=sc.next().charAt(0);
			while(!(ch=='Y' || ch=='y' || ch=='N' || ch=='n'))
			{
				System.out.println("Invalid input");
				System.out.print("Press 'Y' for continue and 'N' for exit: ");
				ch=sc.next().charAt(0);
			}	
			System.out.print("\n");
		}while(ch=='Y' || ch=='y');
	}
}
