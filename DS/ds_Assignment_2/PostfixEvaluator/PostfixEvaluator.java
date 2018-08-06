package ds_Assignment_2.Q1_PostfixEvaluator;

import ds_Assignment_1.stack.StackUsingArray;
import java.util.StringTokenizer;

/**
 * @author Ayushi Khandelwal
 *
 */
public class PostfixEvaluator {
	
	/**
	 * @param actualExpression
	 * @return evaluation of postfix expression
	 */
	public String evaluate(String actualExpression) {
		
		StringTokenizer stringTokenizer = new StringTokenizer(actualExpression, " ");	//stores tokens separated by space
		StackUsingArray stack = new StackUsingArray(stringTokenizer.countTokens());

		while(stringTokenizer.hasMoreTokens()){
			String str = stringTokenizer.nextToken();
			
			int number1, number2;
			if(!(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"))) {	//checks for an operator
				stack.push(Integer.parseInt(str));
			}
			
			else {
				switch(str) {
					case "+" : 
						if(stack.isEmpty())		
							return null;
						number1 = stack.pop();
						
						if(stack.isEmpty())
							return null;
						number2 = stack.pop();
						
						stack.push(number2 + number1);
						break;
				
					case "-" : 
						if(stack.isEmpty())
							return null;
						number1 = stack.pop();
						
						if(stack.isEmpty())
							return null;
						number2 = stack.pop();
						stack.push(number2 - number1);
						break;
			
					case "*" : 
						if(stack.isEmpty())
							return null;
						number1 = stack.pop();
						
						if(stack.isEmpty())
							return null;
						number2 = stack.pop();
						stack.push(number2 * number1);
						break;
		
					case "/" : 
						if(stack.isEmpty())
							return null;
						number1 = stack.pop();
						
						if(stack.isEmpty())
							return null;
						number2 = stack.pop();
						stack.push(number2 / number1);
						break;
				}
			}
		}
		if(stack.countElements() != 1)	//if stack contain more than one operand
			return null;		//invalid output
		
		int result = stack.pop();
		return (result + "");
	}
}
