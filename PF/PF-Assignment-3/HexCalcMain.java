import java.util.Scanner;
class HexCalc
{
	public String add(String hexNumber1, String hexNumber2)
	{
		int decimal1 = Integer.parseInt(hexNumber1, 16);
		int decimal2 = Integer.parseInt(hexNumber2, 16);
		int decAddition = decimal1 + decimal2;
		String hexAddition = Integer.toHexString(decAddition);
		return hexAddition;
	}
	public String subtract(String hexNumber1, String hexNumber2)
	{
		int decimal1 = Integer.parseInt(hexNumber1, 16);
		int decimal2 = Integer.parseInt(hexNumber2, 16);
		int decSubtract=0;
		String hexSubtract="";
		if(isLess(hexNumber1 , hexNumber2))
		{
			System.out.println("Can't subtract"); return null;
		}
		else
		{
			decSubtract = decimal1 - decimal2;
			hexSubtract = Integer.toHexString(decSubtract);
			return hexSubtract;
		}
	}
	public String multiply(String hexNumber1, String hexNumber2)
	{
		int decimal1 = Integer.parseInt(hexNumber1, 16);
		int decimal2 = Integer.parseInt(hexNumber2, 16);
		int decMultiply = decimal1 * decimal2;
		String hexMultiply = Integer.toHexString(decMultiply);
		return hexMultiply;
	}
	public String divide(String hexNumber1, String hexNumber2)
	{
		int decimal1 = Integer.parseInt(hexNumber1, 16);
		int decimal2 = Integer.parseInt(hexNumber2, 16);
		if(decimal2 == 0)
		{
			System.out.println("Can't divide!!");
			return "Invalid";
		}
		int decDivide = decimal1 / decimal2;
		String hexDivide = Integer.toHexString(decDivide);
		return hexDivide;
	}
	public boolean isEqual(String hexNumber1, String hexNumber2)
	{
		return(Integer.parseInt(hexNumber1, 16) == Integer.parseInt(hexNumber2, 16));
	}
	public boolean isLess(String hexNumber1, String hexNumber2)
	{
		return(Integer.parseInt(hexNumber1, 16) < Integer.parseInt(hexNumber2, 16));
	}
	public boolean isGreater(String hexNumber1, String hexNumber2)
	{
		return(Integer.parseInt(hexNumber1, 16) > Integer.parseInt(hexNumber2, 16));
	}
	
}
public class HexCalcMain
{
	public static void main(String args[])
	{
		HexCalc hexCalc = new HexCalc();
		Scanner scan = new Scanner(System.in);
		char proceed='a';
		do
		{
			System.out.println("--ARITHMETIC OPERATIONS--");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Exit");
			System.out.print("Enter your choice : ");
			int choice = scan.nextInt();
			while(!(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5))
			{
				System.out.print("Enter correct choice : ");
				choice = scan.nextInt();
			}
			System.out.println("Enter two hexadecimal numbers to perform the operations :-");
			System.out.print("Enter first number : ");
			String hexNumber1 = scan.next();
			System.out.print("Enter second number : ");		
			String hexNumber2 = scan.next();
			
			if(hexCalc.isEqual(hexNumber1 , hexNumber2))
				System.out.println("Given hexadecimal numbers " + hexNumber1 + " and " + hexNumber2 + " are equal");
			else if (hexCalc.isLess(hexNumber1 , hexNumber2))
				System.out.println("First hexadecimal number " + hexNumber1 + " is less than second " + hexNumber2);
			else if (hexCalc.isGreater(hexNumber1 , hexNumber2))
				System.out.println("First hexadecimal number " + hexNumber1 + " is greater than second " + hexNumber2);
			else
				System.out.println("Incomparable");
			switch(choice)
			{
				case 1: System.out.println("Addition is : " + hexCalc.add(hexNumber1 , hexNumber2)); break;
				case 2: System.out.println("Subtraction is : " + hexCalc.subtract(hexNumber1 , hexNumber2)); break;
				case 3: System.out.println("Multiplication is : " + hexCalc.multiply(hexNumber1 , hexNumber2)); break;
				case 4: System.out.println("Dvision is : " + hexCalc.divide(hexNumber1 , hexNumber2)); break;
				case 5: return;
				default: System.out.println("Invalid input"); break;
			}
			
			System.out.print("Press 'Y' for continue and 'N' for exit: ");
			proceed = scan.next().charAt(0);
			while(!(proceed=='Y' || proceed=='y' || proceed=='N' || proceed=='n'))
			{
				System.out.println("Invalid input");
				System.out.print("Press 'Y' for continue and 'N' for exit: ");
				proceed=scan.next().charAt(0);
			}	
			System.out.print("\n");
		}while(proceed=='Y' || proceed=='y');
	}
}
