package NarasimhaKarumanchi.Java._3_Stacks._4_ProblemsAndSolutions;

public class _1_SymbolBalance {

	@SuppressWarnings("unused")
	public boolean isValidSymbolPattern(String pattern) throws Exception {

		StackService<Character> stack = new StackServiceImplementation<>();

		if(pattern == null || pattern.length() ==0)
			return true;

		for(int i = 0; i < pattern.length(); i++) {

			char c = pattern.charAt(i);
			System.out.println(c);
			
			if(pattern.charAt(i) == '(' || pattern.charAt(i) == '[' || pattern.charAt(i) == '{') {
				stack.push(pattern.charAt(i));
			}
			else if(pattern.charAt(i) == ')') {
				if(!stack.isEmpty() && stack.top() == '(')
					stack.pop();
				else
					return false;
			}
			else if(pattern.charAt(i) == ']') {
				if(!stack.isEmpty() && stack.top() == '[')
					stack.pop();
				else
					return false;

			}
			else if(pattern.charAt(i) == '}') {
				if(!stack.isEmpty() && stack.top() == '{')
					stack.pop();
				else
					return false;
			}
			String s = stack.toString();
			System.out.println(s);
		}

		if(stack.isEmpty())
			return true;
		else
			return false;
	}

	public static void main(String[] args) throws Exception {
		_1_SymbolBalance balance = new _1_SymbolBalance();
		boolean balanced = balance.isValidSymbolPattern("(([{(([]))[]}]))");
		System.out.println(balanced);
	}
}
