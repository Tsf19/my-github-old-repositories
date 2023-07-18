package NarasimhaKarumanchi.Java._3_Stacks._4_ProblemsAndSolutions;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class _3_PostfixExpressionEvaluation {

	
	public static int postfixExpressionEvaluation(String postfix) throws Exception {
		
		StackService<Integer> stack = new StackServiceImplementation<>();

		for(int i=0; i<postfix.length(); i++) {
			
			char c = postfix.charAt(i);
			
			if(c == '+') {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = op2+op1;
				stack.push(res);
			}
			else if(c == '-') {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = op2-op1;
				stack.push(res);
			}
			else if(c == '*') {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = op2*op1;
				stack.push(res);
			}
			else if(c == '/') {
				int op1 = stack.pop();
				int op2 = stack.pop();
				int res = op2/op1;
				stack.push(res);
			}
			else {
				stack.push(Character.getNumericValue(c));
			}
			
		}
			
		return stack.pop();
	}
	
	
	public static void main(String[] args) throws Exception {
	
		String exp = "1-2*(3-4+5)+(6+7*8)-6";
		int i = 1-2*(3-4+5)+(6+7*8)-6;
		System.out.println("i :" + i);


		String postfix = _2_InfixToPostfix.infixToPostfix(exp);
		int result = _3_PostfixExpressionEvaluation.postfixExpressionEvaluation(postfix);
		System.out.println(result);
	
	}
	
}
