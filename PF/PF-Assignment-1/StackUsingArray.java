import java.util.*;
class Stack
{	
		int arr[] = new int[20];
		int top = -1;
		int lengthStack = 0;
		public void push(int data)
		{
			if(top<20)
			{
				System.out.print("Element pushed in is "+data+"\n");
				arr[++top] = data;
				lengthStack++;
			}
			else 
				System.out.println("Stack overflow");
		}
		public void pop()
		{
			if(top != -1)
			{
				System.out.print("Element popped out is"+arr[top]+"\n");
				top--;
				lengthStack--;
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
		public int length()
		{
			return(lengthStack);
		}
		public boolean isEmpty()
		{
			return (top == -1);
		}
}
public class StackUsingArray
{
	public static void main(String args[])
	{
		Stack stack = new Stack();
		Scanner sc = new Scanner(System.in);
		char ch;
		do
		{
			System.out.println("--STACK OPERATIONS--");			
			System.out.println("1.Push");			
			System.out.println("2.Pop");			
			System.out.println("3.Display the top");			
			System.out.println("4.current length of the stack");			
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
				case 4: System.out.println("Currently stack length is: " + stack.length()); break;
				case 5: System.out.println("List is empty: " + stack.isEmpty()); break;
				case 6: return; 
				default: System.out.println("Invalid input");			
			}
			System.out.print("Press 'Y' for continue and 'N' for exit: ");
			ch = sc.next().charAt(0);
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
