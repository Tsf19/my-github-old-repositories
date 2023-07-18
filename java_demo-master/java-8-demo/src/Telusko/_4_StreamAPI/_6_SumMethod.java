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
public class _6_SumMethod {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

		
		Stream<Integer> s1 = values.stream(); //6
		
//		Stream<Integer> s2 = s1.map(	(i) -> i*2	); //4
		
		
//		Integer res = (Integer)s2.reduce(0, (Integer i, Integer j) -> { return i+j; }); //1
		
//		Integer res = s2.reduce(0, (i,j) -> i+j ); //2
		
//		System.out.println("res : "+s2.reduce(0, (i,j) -> i+j )); //3
		
//		System.out.println("res : "+s1.map(	(i) -> i*2	).reduce(0, (i,j) -> i+j )); //5
		
		System.out.println("res : "+values.stream().map(	(i) -> i*2	).reduce(0, (i,j) -> i+j ));
		
		System.out.println(values.stream().map(i -> i*2).reduce(0, (c,e) -> c+e));
		
		
	}
	

}
