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
public class _8_Filter {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(12,20,35,46,55,68,75);
		
		System.out.println(values.stream().filter(i -> i%5 == 0).reduce(0, Integer::sum));
		
		
		//Filter takes the Object of Predicate
//		Predicate<Integer> p = 	new Predicate<Integer>() {
//			
//			@Override
//			public boolean test(Integer i) {
//				
//				return i%5 == 0;
//				
//			}
//		}; 
		
		Predicate<Integer> p = 	i -> (i%5 == 0);
		
//		IntPredicate p = 	i -> (i%5 == 0);
		
		System.out.println(values.stream().filter(p).reduce(0, Integer::sum));
		
		System.out.println(values.stream().filter(i -> (i%5 == 0)).reduce(0, Integer::sum));
		
	}
	

}
