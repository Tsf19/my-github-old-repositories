/*
 *  Program should contain 2 inputs:
 *  	1: Paragraph Containing few sentences
 *  	2: A positive Integer Number
 *  The Output Should only contains the words whose LENGTH is Equal to or greater than that Input 2
 *  AND
 *  whose OCCURRENCES is equal to or greater than Input 2,
 *  in the ascending order of the occurrences of the words.
 */

package Other.Tasks.SupaiInfotech;

import java.sql.Struct;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordFrequency {

	public static void main(String[] args) {
		String str1 = "This  is ; a paragraph. "
				+ "It contains words,  and    sentences, and separators."
				+ "This paragraph       has words and   it   contains three sentences.";

		
		String after1 = str1.replaceAll("\\s +"," ");
		String after2 = str1.trim().replaceAll("\\s +"," ");
		String after3 = str1.trim().replaceAll("\\s "," ");
		
		System.out.println(str1);
		System.out.println(after3);
		System.out.println(after1);
		System.out.println(after2);
		
		
//		String[] str2 = str1.split(" ");
//		String str3 = "";
//		for(String temp : str2) {
//		
//			temp.replaceAll("\\s"," ");
//			str3 = str3 + " "+temp;
//		}
//		System.out.println(str3);
		
/*
		
		str1 = str1.replaceAll("\\."," ");
		str1 = str1.replaceAll("\\,"," ");
		str1 = str1.replaceAll("\\;"," ");
		//str1 = str1.replaceAll("\\s"," ");
		str1 = str1.replaceAll("    "," ");
		str1 = str1.replaceAll("   "," ");
		str1 = str1.replaceAll("  "," ");
		System.out.println(str1);

		str1 = str1.toLowerCase();
		System.out.println(str1);

		String[] strarr = str1.split(" ");

		Map<String, Integer> hm = new HashMap<>();

		for(String temp1 : strarr) {

			if(hm.containsKey(temp1)) {
				hm.put(temp1, hm.get(temp1)+1);
			}
			else
				hm.put(temp1, 1);		
		}

		System.out.println(hm);

		List<Map.Entry<String, Integer> > list = new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
		System.out.println(list);

		Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
			public int compare(Map.Entry<String, Integer> obj1, Map.Entry<String, Integer> obj2) {
				return(obj1.getValue().compareTo(obj2.getValue()));
			}
		});

		System.out.println(list);

		int n = 2;
		for(Map.Entry<String, Integer> temp2 : list) {
			if(temp2.getValue() >= n) {
				System.out.println(temp2.getKey() + " " + temp2.getValue());
			}
		}
*/
	} //main()

} //
