/**
 * 
 */
package Telusko._1_LambdaBasics;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Tousif
 *
 */
public class _3_LambdaExpression {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

		//FunctionalInterface
//		Consumer<Integer> consumer = (Integer i) -> System.out.println(i);
//		OR
		Consumer<Integer> consumer = i -> System.out.println(" A "+i);

		values.forEach(consumer);
		
//		OR
		
		
		values.forEach(new Consumer<Integer>() {
			
			public void accept(Integer i) { 	//Boilerplate Code
				System.out.println(" B "+i);
			}
			
		});
		
//		OR
		
		values.forEach(
											// This code represents : new Consumer
			(Integer i) -> 					// accept(Integer i){----}
			{					
				System.out.println(" C "+i);
			}
			
		);
		
		
//		OR
		
		values.forEach(i -> System.out.println(" D "+i));
		
	}

}
