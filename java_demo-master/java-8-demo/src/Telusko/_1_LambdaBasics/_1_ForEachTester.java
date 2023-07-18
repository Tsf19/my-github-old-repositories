/**
 * 
 */
package Telusko._1_LambdaBasics;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tousif
 *
 * @EXTERNAL_ITERATION
 *  When loops gets data from outside of the body
 *
 * @INTERNAL_ITERATION
 *  When loops gets data from inside of the body
 */
public class _1_ForEachTester {
	
	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		System.out.println(list);
		// O/P: 1,2,3,4,5,6
		
		//EXTERNAL ITERATION
		for(int i=0; i<=list.size()-1; i++) {
			System.out.println("for: "+list.get(i));
		}
		// O/P: 1,2,3,4,5,6
		
		Iterator<Integer> iterator = list.iterator();
		
		//EXTERNAL ITERATION
		while(iterator.hasNext()) {
			System.out.println("Iterator: "+iterator.next());
		}
		// O/P: 1,2,3,4,5,6
		
		//EXTERNAL ITERATION
		for(Integer i : list) {
			System.out.println("EnhanceFor: "+i);
		}
		
		//INTERNAL ITERATION(STREAMAPI)
		
//		list.forEach((Integer i) -> System.out.println("forEach: "+i));
//		OR
		list.forEach(i -> System.out.println("forEach: "+i));
		
		
	}

}
