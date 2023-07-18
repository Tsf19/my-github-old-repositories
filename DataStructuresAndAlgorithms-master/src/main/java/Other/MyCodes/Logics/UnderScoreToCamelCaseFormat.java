package Other.MyCodes.Logics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import org.apache.commons.lang.WordUtils;

public class UnderScoreToCamelCaseFormat {

//	private static final String SPACE = " ";
//	
//	public static String getVariableName(String displayName) {
//
//		System.out.println("displayName: " + displayName);
//		String displayNameTemp = new String(displayName);
//
//		displayNameTemp = displayNameTemp.replaceAll("[^a-zA-Z0-9]", SPACE);
//
//		Pattern ptn = Pattern.compile("\\s+");
//		Matcher mtch = ptn.matcher(displayNameTemp);
//		displayNameTemp = mtch.replaceAll(SPACE);
//
//		displayNameTemp = displayNameTemp.trim();
//		
//		String displayNameArrTemp[] = displayNameTemp.trim().split(SPACE);
//		
//		if(displayNameArrTemp.length == 1) {
//			
//			String firstChar = displayNameTemp.substring(0, 1).toLowerCase();
//			
//			if(displayNameTemp.length() > 1)
//				displayNameTemp = firstChar+displayNameTemp.substring(1);
//			else
//				displayNameTemp = firstChar;
//			
//			return displayNameTemp;
//			
//		}else {
//			
//			displayNameTemp = WordUtils.capitalizeFully(displayNameTemp);
//			String displayNameArr[] = displayNameTemp.trim().split(SPACE);
//
//			String variableName = "";
//
//			int count = 0;
//
//			for (String word : displayNameArr) {
//
//				if (count == 0) {
//					variableName = word.toLowerCase();
//				} else {
//					variableName = variableName + word;
//				}
//				count++;
//			}
//
//			System.out.println("variableName : " + variableName);
//
//			return variableName;
//			
//		}
//		
//	}
	

	public static String underscoreFormatToCamelCase(String underscoreFormat) {
		String camelCase = "";

		String[] strArray = underscoreFormat.split("_");
		if(strArray.length > 1) {
			StringBuffer temp = new StringBuffer();
			for (int i=1 ; i<strArray.length; i++) {
				temp.append(Character.toUpperCase(strArray[i].charAt(0)));
				if (strArray[i].length() > 1) {
					temp.append(strArray[i].substring(1, strArray[i].length()).toLowerCase());
				}
			}
			camelCase = strArray[0]+temp;
		}
		else
			camelCase = strArray[0];

		return camelCase;
	}


	public static void main(String[] args) {
		String underscoreFormat = "custom_line_table";

		System.out.println(underscoreFormatToCamelCase(underscoreFormat));

		
	}

}
