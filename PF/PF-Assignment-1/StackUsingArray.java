
import java.util.*;
class Stack
{	
		
		int arr[]=new int[5];
		int top=-1;
		
		public void push(int data)
		{
			if(top<5)
			{
				System.out.print("Element pushed in is"+data+"\n");
				arr[++top]=data;
			}
			else 
				System.out.println("Stack overflow");
		}
		public void pop()
		{
			if(top!=-1)
			{
				System.out.print("Element popped out is"+arr[top]+"\n");
				top--;
			}
			else
				System.out.println("Stack underflow");
		}
		public void top()
		{
			if(isEmpty())
				System.out.println("List is empty!");
			else	
				System.out.println("Element at the top is"+arr[top]);
		}
		public boolean isEmpty()
		{
			return (top==-1);
		}
	
}
public class StackUsingArray
{
	public static void main(String args[])
	{
		Stack stack=new Stack();
	
		Scanner sc=new Scanner(System.in);
		char ch;
		do
		{
			System.out.println("Enter your choice:\n 1.Push\n 2.Pop\n 3.Display the top\n 4.Check stack is empty or not?\n");
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
					System.out.println("Lis is empty: "+stack.isEmpty()); break;
				default: System.out.println("Invalid input");			
			}
			System.out.println("\n\nDo wyou want to continue? (Y/N): ");
			ch=sc.next().charAt(0);
			
		}while(ch=='Y' || ch=='y');
		
		
	
	}
}
