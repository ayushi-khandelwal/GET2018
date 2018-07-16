import java.util.*;
class Node
{
	int data;
	Node next;
	
	public Node(int data)
	{
		this.data=data;
	}
}
class LinkListStack
{
	Node top=null;
	public void push(int data)
	{
		Node newNode=new Node(data);
		newNode.next=top;
		top=newNode;
	}
	public void pop()
	{
		if(isEmpty())
		{
			System.out.print("Stack underflow");
			System.out.print("\n");	
		}
		else
		{
			Node deletedNode=top;
			top=top.next;
			System.out.println("Popped item is: "+deletedNode.data);
		}
		
	}
	public void top()
	{
		if(isEmpty())
			System.out.println("List is empty!");
		else
			System.out.println("Value on top is: "+top.data);		
	}
	public void display()
	{
		if(isEmpty())
			System.out.println("List is empty!");
		else
		{
			Node current=top;
			while(current!=null)
			{
				System.out.print(current.data+" ");;
				current=current.next;
			}
		}
	}
	public boolean isEmpty()
	{
		return(top==null);
	}
}
class LinkListStackMain
{
	public static void main(String args[])
	{
		LinkListStack stack=new LinkListStack();
		Scanner sc=new Scanner(System.in);
		char ch;
		do
		{
			System.out.println("Enter your choice:\n 1.Push\n 2.Pop\n 3.Display the top\n 4.Display the stack\n 5.Check stack is empty or not?\n");
			int choice=sc.nextInt();
			switch(choice)
			{
				case 1: 
					System.out.println("Enter what value to be pushed");
					stack.push(sc.nextInt()); break;
				case 2: 
					stack.pop(); break;
				case 3: 
					stack.top(); break;
				case 4:
					stack.display(); break;	
				case 5: 
					System.out.println("List is empty: "+stack.isEmpty()); break;
				default: System.out.println("Invalid input");			
			}
			System.out.println("\n\nDo you want to continue (Y/N): ");
			ch=sc.next().charAt(0);	
		}while(ch=='Y' || ch=='y');
		
	}

}