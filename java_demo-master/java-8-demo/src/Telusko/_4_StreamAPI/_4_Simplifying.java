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
public class _4_Simplifying {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);


		
		Stream<Integer> s1 = values.stream();
		
		
//		Function<Integer, Integer> f = new Function<Integer, Integer>() {
//			
//			public Integer apply(Integer i) {
//				return i*2;
//			}
//			
//		};
		
//		Stream s2 = s1.map(f);
		
		Stream<Integer> s2 = s1.map(new Function<Integer, Integer>() {
			
			public Integer apply(Integer i) {
				return i*2;
			}
			
		});
		
		
//		BinaryOperator<Integer> b = new BinaryOperator<Integer>() {
//			
//			@Override
//			public Integer apply(Integer i, Integer j) {
//				
//				return i+j;
//			}
//				
//			
//		};
		
		
//		Integer res = (Integer)s2.reduce(0, b);
		
		
		
		Integer res = (Integer)s2.reduce(0, new BinaryOperator<Integer>() {
			
			@Override
			public Integer apply(Integer i, Integer j) {
				
				return i+j;
			}
				
			
		});
		
		
		System.out.println("res : "+res);
		
		System.out.println(values.stream().map(i -> i*2).reduce(0, (c,e) -> c+e));
		
		
	}
	

}
