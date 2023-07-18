/**
 * 
 */
package Telusko._3_MethodReference;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Tousif
 *
 */
public class _2_MethodReference {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

		values.forEach(i -> doubleIt(i) );
		
		values.forEach(_2_MethodReference::doubleIt);
		
	}
	
	public static void doubleIt(Integer i) {
		
		System.out.println(i*2);
	}

}
