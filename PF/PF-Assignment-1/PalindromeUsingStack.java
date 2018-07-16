import java.util.Scanner;
class Stack
{
	int top=-1;
	char arr[];
	Stack()
	{
		arr=new char[20];
	}
	
	void push(char val)
	{
		arr[++top]=val;
	}
	void pop(char val)
	{
		if(arr[top]==val && top!=-1)
		{
			top--;
		}	
	}
	void check()
	{
		if(top==-1)
		System.out.println("Palindrome!");
		else
		System.out.println("Not palindrome!");
	}
}
class PalindromeUsingStack
{
	public static void main(String args[])
	{
		Stack stack=new Stack();
		System.out.println("Enter the string to check it a palindrome or not!");
		Scanner sc=new Scanner(System.in); 
		String str= sc.next();
		
		for(int i=0;i<(str.length())/2;i++)
			stack.push(str.charAt(i));	
		for(int i=((str.length())/2); i<str.length();i++)
		{
			stack.pop(str.charAt(i));
		}	
		stack.check();
	}	
}