package NarasimhaKarumanchi.Java._3_Stacks._4_ProblemsAndSolutions;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class _4_SimplePalindrome {

	public static boolean isPalindrome(String string) {
		
		int i,j;
		for(i=0,j=string.length()-1; i<j && string.charAt(i) == string.charAt(j); i++, j--);
		
		if(i<j)
			return false;
		else
			return true;
		
	}
	
	public static void main(String[] args) {

		System.out.println(isPalindrome("12345iji54321"));
		
	}

}
