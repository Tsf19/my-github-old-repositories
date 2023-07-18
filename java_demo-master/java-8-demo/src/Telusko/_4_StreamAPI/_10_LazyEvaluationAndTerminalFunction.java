/**
 * 
 */
package Telusko._4_StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Tousif
 *
 */
public class _10_LazyEvaluationAndTerminalFunction {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(12,20,35,46,55,68,75);
		
		System.out.println(values.stream().filter(i -> i%5 == 0).reduce(0, Integer::sum));
		
		//findFirst() returns first element if find which is true according to filter
		System.out.println(values.stream().filter(i -> i%5 == 0).findFirst().orElse(7));
		//orElse will return optional element if no findFirst found
	}
	

}
