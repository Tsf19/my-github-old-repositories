/**
 * 
 */
package Telusko._4_StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Tousif
 *
 */
public class _1_StreamAPI {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

		Integer result = 0;
		
		for(Integer i : values) {
			result = result + i; //MUTATION : EveryTime value of result is changing
		}
		
		System.out.println(result);

		//OR
		
		System.out.println(values.stream().reduce(0, (a,b) -> a+b));
		
		
	}
	

}
