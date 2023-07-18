package Other.MyCodes.Logics;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfix {

	static String infixToPostfix(String expression) {

		String result = "";
		String[] expressionArray = expression.split("\\s");
		
		if(expressionArray.length == 1) {
			return expressionArray[0];
		}
		
		Stack<String> stack = new Stack<>();
		
		for(String exp : expressionArray) {
			
			if(exp.equals("("))
				stack.push(exp);

			else if(exp.equals(")")) {

				while(!stack.isEmpty() && !stack.peek().equals("(")) {
					result += " "+stack.pop();
				}
				if (!stack.isEmpty() && !stack.peek().equals("(")) 
					return "Invalid Expression"; // invalid expression
				else if(stack.isEmpty())
					return "Invalid Expression"; // invalid expression
				else
					stack.pop(); 
			} 
			else if(exp.equals("&&") || exp.equals("||")) {
				while(!stack.isEmpty() && !stack.peek().equals("(")) {
					result += " "+stack.pop();
				}
				stack.push(exp);
			}
			else
				result += " "+exp;
		}
		
        // pop all the operators from the stack 
        while (!stack.isEmpty()){ 
            if(stack.peek().equals("(")) 
                return "Invalid Expression"; 
            result += " "+stack.pop(); 
         } 
		return result;
	}
	
	
	static String[] expressionVariables(String[] postfixExpressionArray) {
		String expressionVariables = "";
		
		for(String string : postfixExpressionArray) {
			if(!string.equals("&&") && !string.equals("||"))
				expressionVariables += " " + string;
		}
		
		return expressionVariables.trim().split("\\s");
	}
	
	public static void main(String[] args) throws Exception {

		String expression = "( ( ( ( F1 ) && ( F2 ) ) || F3 ) || ( ( ( F4 ) || ( F5 ) ) && F6 ) )";
//		String expression = "F1";
		
		
		String postfix = infixToPostfix(expression).trim();
		System.out.println(postfix);
		
		String[] postfixExpressionArray = postfix.split("\\s");
		System.out.println(Arrays.toString(postfixExpressionArray));
		
		String[] expressionVariables = expressionVariables(postfixExpressionArray);
		System.out.println(Arrays.toString(expressionVariables));
	}

}
