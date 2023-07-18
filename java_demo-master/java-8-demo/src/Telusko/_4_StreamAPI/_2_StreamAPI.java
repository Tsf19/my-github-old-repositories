/**
 * 
 */
package Telusko._4_StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Tousif
 *
 */
public class _2_StreamAPI {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

		Integer result = 0;
		
		for(Integer i : values) {
			result = result + i*2; //MUTATION : EveryTime value of result is changing
		}
		
		System.out.println(result);

//		OR
		
		System.out.println(values.stream().map(i -> i*2).reduce(0, (a,b) -> a+b));
		
		
		
	}
	

}
