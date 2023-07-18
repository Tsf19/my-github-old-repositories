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
public class _1_MethodReference {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

		values.forEach(i -> System.out.println(" A "+i));
		
		//foreach knows it need to take all the values from list then why using 'i' ?
//		values.forEach(println); // This means print(i) i.e, all the values of list, but what is print ?
		
//		values.forEach(out::println); // println is a "Method_Reference" of 'out' object
		
		//This is Call_By_Method i.e, Passing a method as a reference
		values.forEach(System.out::println);
		
	}

}
