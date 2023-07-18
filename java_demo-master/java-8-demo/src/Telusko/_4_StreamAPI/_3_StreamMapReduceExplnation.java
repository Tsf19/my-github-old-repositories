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
public class _3_StreamMapReduceExplnation {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(1,2,3,4,5,6,7);

		Integer result = 0;

		for(Integer i : values) {
			result = result + i*2; //MUTATION : EveryTime value of result is changing
		}

		System.out.println(result);

		//OR

		Stream<Integer> stream1 = values.stream();
		System.out.println("Stream object s : "+stream1);

		//Now we need to multiply every number by 2
		//For that we need to use map(), but map() take object of Function

		//Function take two type of value, Type of Value & Return Type
		Function<Integer, Integer> function = new Function<Integer, Integer>() {

			public Integer apply(Integer i) {
				return i*2;
			}

		};

		//The stream s2 will have all the values that is multiplied by 2
		Stream<Integer> stream2 = stream1.map(function);


		//reduce() take 2 parameters, initial value & Objects of Binary Operator
		//Integer result = s2.reduce(0, binaryOperator );

		BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {

			@Override
			public Integer apply(Integer i, Integer j) {

				return i+j;
			}


		};


		Integer res = stream2.reduce(0, binaryOperator);

		System.out.println("res : "+res);

		/**
		 * stream() will convert all the values of list into stream
		 * map() will take object of Function, using Lambda it implement apply() method and doubles the values
		 * reduce() take 2 parameters, initial value i.e, 0 & Objects of Binary Operator
		 * using Lambda we implement apply() method of BinaryOperator Interface
		 * 
		 */
		System.out.println(values.stream().map(i -> i*2).reduce(0, (a,b) -> a+b));


	}


}
