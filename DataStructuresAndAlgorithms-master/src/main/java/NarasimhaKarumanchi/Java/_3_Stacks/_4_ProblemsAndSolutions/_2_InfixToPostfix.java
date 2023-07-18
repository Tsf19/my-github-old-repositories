package NarasimhaKarumanchi.Java._3_Stacks._4_ProblemsAndSolutions;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class _2_InfixToPostfix {


	static int precedence(char ch) {
		switch(ch) {
		case '+' :
		case '-' :
			return 1;
		case '*' :
		case '/' :
			return 2;
		case '^' :
			return 3;
		}
		return -1;
	}
	
	@SuppressWarnings("unused")
	public static String infixToPostfix(String expression) throws Exception {

		String result = "";
		StackService<Character> stack = new StackServiceImplementation<>();

		for(int i=0; i<expression.length(); i++) {
			char c = expression.charAt(i); 	

			if(Character.isLetterOrDigit(c))
				result += c;

			else if(c == '(')
				stack.push(c);

			else if(c == ')') {
				while(!stack.isEmpty() && stack.top() != '(') {
					result += stack.pop();
				}
				
                if (!stack.isEmpty() && stack.top() != '(') 
                    return "Invalid Expression"; // invalid expression                 
                else
                    stack.pop(); 
			}
			else {
				while(!stack.isEmpty() && precedence(c) <= precedence(stack.top())) {
					result += stack.pop();
				}
				stack.push(c);
			}

		}
	       
        // pop all the operators from the stack 
        while (!stack.isEmpty()){ 
            if(stack.top() == '(') 
                return "Invalid Expression"; 
            result += stack.pop(); 
         } 
		return result;
	}


	public static void main(String[] args) throws Exception {

//		String exp = "a+b*(c^d-e)^(f+g*h)-i";
//		String exp = "a+b*c*d";
//		String exp = "((((a)+(b))-c)-(((d)-(e))+f))";
		String exp = "((a)+(b)))";
		System.out.println(infixToPostfix(exp)); 

	}

}
