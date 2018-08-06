package ds_Assignment_2.Q2_InfixToPostfix;

import java.util.StringTokenizer;

import ds_Assignment_2.Stack.StackImplementation;

/**
 * @author Ayushi Khandelwal
 *
 */
public class InfixToPostfix {

	StackImplementation stack = new StackImplementation();
	StringBuilder stringBuilder = new StringBuilder();

	/**
	 * @param actualExpression
	 * @return conversion of infix expression to postfix expression
	 */
	public String conversion(String actualExpression) {

		StringTokenizer stringTokenizer = new StringTokenizer(actualExpression, " ");	//stores tokens separated by space

		String operand = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";	//operands that are not to be push into stack
		
		while (stringTokenizer.hasMoreTokens()) {	
			String str = stringTokenizer.nextToken();

			if (operand.indexOf(str) >= 0) 	//check if token is operand
				stringBuilder.append(str + " ");	//if true then append to postfix expression

			else if (str.equals("(")) 
				stack.push(str);

			else if (str.equals(")")) {		
				while (!(stack.peek()).equals("(")) {	
					stringBuilder.append(stack.pop() + " ");	//pop all operators till '(' comes and append to postfix expression
				}
				
				stack.pop();	//pop '(' from stack
			}
			
			else {
				if (!(stack.isEmpty())) {
					if (checkPrecedence(str, stack.peek())) 	//checks precedence of token and operator on the top of stack
						stack.push(str);	//token has higher precedence then push it into stack
					
					else {
						stringBuilder.append(stack.pop() + " ");	//token has lower precedence then pop from stack and append it into postfix expression
						stack.push(str);	//then push that token into stack
					}
				}
				
				else 
					stack.push(str);	//when stack has nothing to compare for precedence
			}
		}

		while (!stack.isEmpty()) {
			stringBuilder.append(stack.pop() + " ");	//when there are no operands left 
		}
		
		return stringBuilder.toString().trim();
	}

	private boolean checkPrecedence(String s1, String s2) {		//checks precedence of token and element on top of stack
		if (getPrecedence(s1) > getPrecedence(s2)) 
			return true;
		
		return false;
	}

	public int getPrecedence(String operator) {		//gives precedence of an operator 
		if (operator.equals("||"))
			return 1;
		
		else if (operator.equals("&&"))
			return 2;
		
		else if (operator.equals("==") || operator.equals("!="))
			return 3;
		
		else if (operator.equals("<") || operator.equals(">") || operator.equals("<=") || operator.equals(">="))
			return 4;
		
		if (operator.equals("+") || operator.equals("-"))
			return 5;
		
		else if (operator.equals("*") || operator.equals("/"))
			return 6;
		
		else if (operator.equals("!"))
			return 7;
		
		else
			return -1;
	}
}
