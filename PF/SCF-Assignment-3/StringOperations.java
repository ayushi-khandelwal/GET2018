import java.util.*;
import java.io.*;

class StringMethods {
	public boolean compare(String string1, String string2) {	//returns true if string1 and string2 are equal, else false
		if (string1.length() == string2.length()) {
			for (int i = 0; i < string1.length(); i++) {
				if (string1.charAt(i) == string2.charAt(i));
				
				else {
					return false;
				}
			}
			return true;
		} 
		else {
			return false;
		}
	}

	public String reverse(String string) {	//returns string agter reversing the inputted string
		char tempArray[] = string.toCharArray();
		int i, j = string.length() - 1;
		
		for (i = 0; i < j; i++, j--) {
			char tempChar = tempArray[i];
			tempArray[i] = tempArray[j];
			tempArray[j] = tempChar;
		}
		String newString = new String(tempArray);
		return newString;
	}

	public String replaceCase(String string) {	//returns string by replacing lowercase to uppercase letters and vice versa
		char tempChar;
		String tempStr = "";
		
		for (int i = 0; i < string.length(); i++)
		{
			tempChar = string.charAt(i);
			if (tempChar >= 65 && tempChar <= 90) 
			{
				tempStr += (char) (tempChar + 32);
			}
			else if (tempChar >= 97 && tempChar <= 122)
			{
				tempStr += (char) (tempChar - 32);
			}
			else
            {
				tempStr += tempChar;
			}
		}
		return tempStr;
	}

	public String getLargestWord(String stringGet) {	//returns the largest word from the end in the inputted string
		StringBuilder largestWord = new StringBuilder();
		int intermediateWordLength = 0;
		int maxLength = 0;
		String intermediateWord ="";
		
		for (int i = 0; i < stringGet.length(); i++) {
			if (stringGet.charAt(i) != ' ') {
				intermediateWord = intermediateWord + (stringGet.charAt(i));
				intermediateWordLength++;
			} 
			else{
				intermediateWordLength = 0;
				intermediateWord = "";
			}
			if (maxLength <= intermediateWordLength){
				maxLength = intermediateWordLength;
				largestWord = new StringBuilder(intermediateWord);
			}
		}
		return largestWord.toString();
	}
}

public class StringOperations {
	public static void main(String args[])throws IOException 	{
		StringMethods stringMethods = new StringMethods();
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) 
		{
			System.out.println("--STRING OPERATIONS MENU--");
			System.out.println("1.Compare the strings");
			System.out.println("2.Reverse the string");
			System.out.println("3.Replace case in string");
			System.out.println("4.Find largest word");
			System.out.println("5.Exit");
			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(br.readLine());
			try {
                System.out.println("You've entered number: " + choice);
            } 
            catch (Exception e) {
                System.out.println("You've entered non-integer number");
                System.out.println("This caused " + e);
			}
			switch (choice) 
			{
				case 1:
					System.out.println("Enter strings to compare:-");
					System.out.print("Enter first string : ");
					String string1 = scan.next();
					System.out.print("Enter second string : ");
					String string2 = scan.next();
					if(stringMethods.compare(string1, string2)){
						System.out.println("Given strings are equal\n");
					}
					else{
						System.out.println("Given strings are not equal\n");
					}
					break;
	
				case 2:
					System.out.print("Enter the string to reverse : ");
					String stringRev = scan.next();
					System.out.println("Reversed string of the given string " + stringRev + " is " + stringMethods.reverse(stringRev) + "\n");
					break;
	
				case 3:
					System.out.print("Enter the string to replace case : ");
					String stringRep = scan.next();
					System.out.println("Replace case of the given string " + stringRep + " is " + stringMethods.replaceCase(stringRep) + "\n");
					break;
	
				case 4:
					System.out.print("Enter a line to get largest word : ");
					String stringGet = scan.nextLine();
					scan.nextLine();
					System.out.println("Largest word in the given string is " + stringMethods.getLargestWord(stringGet) + "\n");
					scan.nextLine();	//used to flush the buffer by using Scanner
					break;
	
				case 5:
					System.exit(0);
	
				default:
					System.out.println("Invalid input");
			}
			System.out.print("Enter any character to continue : ");
			scan.next();
		}	
	}
}