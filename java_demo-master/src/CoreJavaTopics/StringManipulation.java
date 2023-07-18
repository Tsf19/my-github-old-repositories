package CoreJavaTopics;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringManipulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String str1 = " This  is ; a  paragraph  It contains .words,  .and.    sentences, and.separators.";
		String temp1 = "";
		String temp2 = "";
		String[] tempArr = null;
		
		
		/** ACTUAL RAW STRING */
		System.out.println("SOP1 :"+str1);
		//-This--is-;-a--paragraph--It-contains-.words,--.and.----sentences,-and.separators.
		
		/** CONVERT TO LOWER CASE */
		str1 = str1.toLowerCase();
		System.out.println("SOP2 :"+str1);
		//-this--is-;-a--paragraph--it-contains-.words,--.and.----sentences,-and.separators.
		
		/** REPLACING . ; , */
		str1 = str1.replaceAll("\\.|\\;|\\," , " ");
		System.out.println("SOP3 :"+str1);
		//-this--is---a--paragraph--it-contains--words----and-----sentences--and-separators-
		
		/** REMOVING EXTRA SPACES */
		
//		To eliminate spaces at the beginning and at the end of the String, use String.trim() method
		String str2 = str1.trim().replaceAll("\\s +" , " ");
		str2 = str1.trim().replaceAll(" +" , " ");
		str2 = str1.trim().replaceAll("( )+" , " ");
		System.out.println("SOP4 :"+str2);
		//this-is-a-paragraph-it-contains-words-and-sentences-and-separators
		
		
		/** REMOVING EXTRA SPACES WITHOUT TRIM() */

//		^_+		:	any sequence of spaces at the beginning of the string
//		_+$		:	any sequence of spaces at the end of the string
//		(_)+	:	any sequence of spaces that matches none of the above, meaning it's in the middle
//		$1		:	The replacement string $1 means "group 1" (the first group made by a set of brackets).
		
		String str3 = str1.replaceAll("^ +| +$|( )+" , " ");
		System.out.println("SOP5 :"+str3);
		//-this-is-a-paragraph-it-contains-words-and-sentences-and-separators-
		
		str3 = str1.replaceAll("^ +| +$|( )+" , "$1");
		System.out.println("SOP6 :"+str3+" <--CORRECT");
		//this-is-a-paragraph-it-contains-words-and-sentences-and-separators
	
	
		str3 = str1.trim().replaceAll("\\s{2,}" , " ");
		System.out.println("SOP7 :"+str3+" <--CORRECT");
		
		/**To extract the first digits of a String and return it as a string, return empty string if it doesn't start with digits.*/
		String str4 = "01Aa1b2c3";
		temp1 = str4.replaceAll("^(\\d*).*","$1");
		temp2 = str4.replaceAll("\\D.*", "");
		//This regex matches from the first non-digit encountered to the end and just deletes it (replaces with nothing).
		System.out.println();
		
//		A character class such as [abc] means "match one character that is either a OR b or c.
//		Note that it doesn't mean "match one character that is a AND b AND c, that would not make any sense.

//		A negated character class such as [^abc] means "match one character that is neither a nor b nor c,
//		in other words it is not a AND not b AND not c.
//		Notice that number 1 is all about OR, and that number 2 is all about AND.

//		Therefore [^\d\s] means "match one character that is not a digit AND not a whitespace", while
//		[\D\S] means "match one character that is either a non-digit OR a non-whitespace"
		
		//https://www.tutorialspoint.com/html/html_url_encoding.htm
		try {
			
			System.out.println("\nString Before Encoding:Mohammed  Tou$if Shekhani%  ");
			//String Before Encoding:Mohammed  Tou$if Shekhani%  
			
			String encoded = URLEncoder.encode(" Mohammed  Tou$if Shekhani%  ", "UTF-8");	
			System.out.println("String After Encoding:"+encoded);
			//String After Encoding:+Mohammed++Tou%24if+Shekhani%25++
			
			String decoded = URLDecoder.decode(encoded, "UTF-8");
			System.out.println("String After Decoding:"+decoded);
			//String After Decoding: Mohammed  Tou$if Shekhani%  
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
		//split from digit and return a,b & c
		String str6 = "a1b2c3";
		String sarr[] = str6.split("\\d");
		
		String str8 = "I [need] this ]message () without (this[])";
		str8 = str8.replaceAll("[\\[\\]\\(\\)]", "");
		System.out.println("str8 :"+str8);
		
		String str9 = "I [need] this ]message () without (this[])".replaceAll("[()\\[\\]]", "");
		System.out.println("str9 :"+str9);
		
		String str10 = "[String]";
		str10 = str10.replaceAll("[\\[\\]]", ""); //The outer [] means: one of the inner symbols
		System.out.println("str10 :"+str10);
		
		String str11 = "[String]";
		str11 = str11.replaceAll("^\\[+|\\]+$", "");
		System.out.println("str11 :"+str11);
		
		String str12 = "[String]";
		str12 = str12.substring(1, str12.length()-1);
		System.out.println("str12 :"+str12);
		
		//String to chop hyphen, hash and space
		String str13 = "Semi-centrifugal clutch#clutchs";
		
		boolean contains1 = str13.contains("-");
		boolean contains2 = str13.contains("#");
		boolean contains3 = str13.contains(" ");
		
		String[] str13Array = str13.split("\\-|\\#|\\ ");
		for(String str : str13Array) {
			System.out.println(str);
		}
		
		
		String regex1 = "(.*[a-zA-Z].*)";
		String regex2 = "(.*[0-9].*)";
		
		List<String> strArr = Arrays.asList("7", "A", "a", "77", "AA", "A7", "7A", "AA77", "7AA7", "A77A", "AAa77", "7AaA7", "A7a7A");
		for(String str : strArr) {
			if((str.matches(regex1) && str.matches(regex2)))
				str = str.toLowerCase();
			System.out.println(str +"\t" + (str.matches(regex1) && str.matches(regex2)));
		}
		
		System.out.println();

		Pattern pattern = Pattern.compile("(([A-Z].*[0-9])|([0-9].*[A-Z]))");
		Matcher matcher = null;
		for(String str : strArr) {
			matcher = pattern.matcher(str);
			
			if(matcher.find())
				str = str.toLowerCase();
			
			System.out.println(str +"\t");
		}

		
//		if(alphaNumeri.matches("^[a-zA-Z0-9]*$"))
//			System.out.println("alphanumeric : " + alphaNumeri.toLowerCase());
		
//		("^{") && ("}+$")
		String s = "{\"customLine.id\":2}";
		if(s.startsWith("{") && s.endsWith("}")) {
			System.out.println("TRUE");
		}
		
//		postfixExpressionArrayList.contains("and")
//		&& !postfixExpressionArrayList.contains("AND") && !postfixExpressionArrayList.contains("&&");
		String andOr = " F1 and F2 F3  F4 F5 ";
		if(andOr.matches("(.*)(and|AND|&&)(.*)"))
			System.out.println("true");
		else 
			System.out.println("false");
		
		
//		if(filterValue.contains("-") || filterValue.contains("#") || filterValue.contains(" "))
		String temp = "F1F2F3F4";
		if(temp.matches("(.*)(-|#|&&| )(.*)"))
			System.out.println("true");
		else 
			System.out.println("false");

		temp = "F1F2F3F4";
		if(temp.matches("(.*)(-|#|&&| )(.*)"))
			System.out.println("true");
		else 
			System.out.println("false");
		
		
		temp = "-*a1b(c2d)h_e3f-g4h";
		if(temp.matches("(.*)[^a-zA-Z0-9](.*)"))
			System.out.println("true");
		else 
			System.out.println("false");

		temp = "a1bc2dh_e3fg4h";
		temp = "groceries|";
		if(temp.matches("(.*)[^\\w'](.*)"))
			System.out.println("true");
		else 
			System.out.println("false");
		
		//split underscore also
		tempArr = temp.split("[^a-zA-Z0-9]");
		
		// \w won't split underscore
		tempArr = temp.split("[^\\w']+");
		
		// \W = ^\w
		tempArr = temp.split("[\\W']+");
		System.out.println();
		
	}

}
