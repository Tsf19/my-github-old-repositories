package Other.MyCodes.Logics;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class CamelCaseToUnderscoreFormat {

	private static String convertCamelCaseToUnderscoreFormat(String text) {

		String result="";

		for (int i = 0; i < text.length(); i++) {
			if(Character.isUpperCase(text.charAt(i))){    
				String temp=""+text.charAt(i);
				result=result+"_"+temp.toLowerCase();
			}
			else
				result = result+text.charAt(i);
		}
		return result;
	}

	public static void main(String[] args) {

		System.out.println(convertCamelCaseToUnderscoreFormat("MohammedTousifShekhani"));

		String regex = "([a-z])([A-Z]+)";
		String replacement = "$1_$2";
		System.out.println("CustomLine"
				.replaceAll(regex, replacement)
				.toLowerCase());


	}

}
