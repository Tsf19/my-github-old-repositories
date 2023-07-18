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
public class _5_RemovingBoilerPlateCode {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

		
		System.out.println(values.stream().map(	(i) -> i*2	).reduce(0, (i,j) -> i+j ));
		
		System.out.println(values.stream().map(	(i) -> i*2	).reduce(0, (i,j) -> Integer.sum(i, j) ));
		
		System.out.println(values.stream().map(	(i) -> i*2	).reduce(0, Integer::sum ));
		
	}
	

}
