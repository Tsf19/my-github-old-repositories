/**
 * 
 */
package Collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tousif
 *
 */
public class ArrayList {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		System.out.println(list);
		// O/P: 1,2,3,4,5,6
		
		Iterator<Integer> iterator = list.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		// O/P: 1,2,3,4,5,6
		
		
		int[] intArr = {9,0,3,9,9,4,1,1,2,1};
		//PRINTING char intArr[] USING Arrays.toString(intArr) :
		System.out.println("PRINTING char intArr[] USING Arrays.toString(intArr) :");
		System.out.println(Arrays.toString(intArr));
	}

}
