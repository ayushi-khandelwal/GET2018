import java.util.Scanner;
class Stack
{
	int top = -1;
	char arr[];
	Stack()				//default constructor
	{
		arr = new char[20];
	}
	
	public void push(char val)
	{
		arr[++top] = val;
	}
	public void pop(char val)
	{
		if(arr[top] == val && top != -1)
		{
			top--;
		}	
	}
	public void check()	//check all the strings except the single character string
	{
		if(top == -1)
		System.out.println("Palindrome!");
		else
		System.out.println("Not palindrome!");
 	}
 	public boolean checkSingleString()	//check a single character only
	{
		if(top == -1)
		{
			System.out.println("Palindrome!"); return true;
		}
		else return false;
 	}
	public boolean isEmpty()
	{
		if(top == -1)
		return true;
		else
		return false;
	}
}
class PalindromeUsingStack
{
	public static void main(String args[])
	{
		Stack stack=new Stack();
		char ch='a';
		do
		{
			System.out.println("Enter the string to check it a palindrome or not!");
			Scanner sc=new Scanner(System.in); 
			String str= sc.next();
			
			for(int i=0 ; i<(str.length())/2 ; i++)		//dividing the string in halves to push the first half
				stack.push(str.charAt(i));
			if(stack.checkSingleString() == true) continue; 	//	
			for(int i=(str.length()/2) ; i<str.length() ; i++)	//and pop the second half of the string
			{
				stack.pop(str.charAt(i));
			}	
			stack.check();
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
