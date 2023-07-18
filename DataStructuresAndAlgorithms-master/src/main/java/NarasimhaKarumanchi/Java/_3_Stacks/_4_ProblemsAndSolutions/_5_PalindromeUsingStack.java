package NarasimhaKarumanchi.Java._3_Stacks._4_ProblemsAndSolutions;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class _5_PalindromeUsingStack {

	public static boolean isPalindrome(String string) throws Exception {
		
		StackService<Character> stack = new StackServiceImplementation<>();
		
		int i;
		for(i=0; i<string.length()/2; i++) {
			stack.push(string.charAt(i));
		}
		
		if(string.length()%2!=0)
			i++;
		
		while(i<string.length()) {
			if(stack.isEmpty()) return false;
			if(string.charAt(i) != stack.pop()) return false;
			i++;
		}
		
		return true;
	}
	
	public static void main(String[] args) throws Exception {

		System.out.println(isPalindrome("1123443211"));
		
	}
}
