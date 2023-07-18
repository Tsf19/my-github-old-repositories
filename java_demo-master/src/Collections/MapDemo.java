package Collections;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {

		char[] chArr = {'T','O','U','U','I','F','M','E','M','O','N','S','H','E','K','H','A','N','I'};

		int[] intArr = {9,0,3,9,9,4,1,1,2,1};

		Map<Character, Integer> hm =new HashMap<>();
		for(char temp : chArr) {
			if(hm.containsKey(temp))
				hm.put(temp, hm.get(temp) + 1);
			else
				hm.put(temp, 1);
		}
		
		System.out.println();
	//PRINTING char chArr[] :
		System.out.println("PRINTING char ar[] :");

		System.out.println(chArr);  // char Array can be Directly Printed using Reference Variables 

		
		
		System.out.println();
	//PRINTING char intArr[] :
		System.out.println("PRINTING char intArr[] :");

		System.out.println(intArr);  // int Array can't be Directly Printed using Reference Variables 


		
		System.out.println();
	//PRINTING char intArr[] USING Arrays.toString(intArr) :
		System.out.println("PRINTING char intArr[] USING Arrays.toString(intArr) :");

		System.out.println(Arrays.toString(intArr));


		
		System.out.println();
	//PRINTING HashMap :
		System.out.println("PRINTING HashMap :");

		System.out.println("HashMap : "+hm);



		
		System.out.println();
	//PRINTING HashMap USING EntrySet and ITERATOR :
		System.out.println("PRINTING HashMap USING EntrySet and ITERATOR :");

		Set<Entry<Character, Integer>> es = hm.entrySet();
		Iterator<Entry<Character, Integer>> itr = es.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}



		System.out.println();
	//PRINTING KEYS :
		System.out.println("PRINTING KEYS :");

		Set<Character> s = hm.keySet();
		System.out.println("keySet : "+s);



		System.out.println();
	//PRINTING VALUES :
		System.out.println("PRINTING VALUES :");

		Collection<Integer> values = hm.values();
		System.out.println("values : "+values);



		System.out.println();
	//PRINTING VALUES USING ARRAYS :
		System.out.println("PRINTING VALUES USING ARRAYS :");

		Object[] objArr = hm.values().toArray();
		for(Object i : objArr) {

			System.out.println("Object[] : "+i);
		}


		
		System.out.println();
		/*
		String[] StrArr = hm.values().toArray(new String[0]);
		System.out.println("String[] : "+StrArr);	
		Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
		at java.util.AbstractCollection.toArray(Unknown Source)
		at Collections.Demo.main(Demo.java:32)

		 */		
		
		System.out.println();
	//PRINTING VALUES USING ITERATOR :
		System.out.println("PRINTING VALUES USING ITERATOR :");
		
		Iterator<Integer> itr1 = values.iterator();
		
		int countEven = 0;
		while(itr1.hasNext()) {
			int v = itr1.next();
			if(	v%2==0 )
				countEven++;
		}
		System.out.println("countEven : "+countEven);
		
//		while(itr1.hasNext()) {
//			if(	(itr1.next())%2==0 )
//				System.out.println((Integer)(itr1.next()));
//		}
		

		System.out.println("hm.get() : "+hm.get('U'));
		
		
////////TRY/////////////////////////////////////////////////////
		
		
		
//////////////////////////////////////////////////////////////////////		
	}
}
