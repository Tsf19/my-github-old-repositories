/**
 * 
 */
package JavaBrains._4_ExceptionHandlingInLambdas;

import java.util.function.BiConsumer;

/**
 * @author Tousif
 *
 */
public class _2_AnExceptionHandlingApproach {

	public static void main(String[] args) {
		int [] someNumbers = {1,2,3,4};
		int key = 0;
		/**
		process(someNumbers, key, //Code is Ugly Now
				(v, k) -> {
					try {
						System.out.println(v/k);
					}catch(ArithmeticException e) { System.out.println("An ArithmeticException Happened");}
				});
		 */
//		process(someNumbers, key, (v, k) -> System.out.println(v/k) )
		//Instead of writing 5 lines of lambdas, we can wrap lambda inside an lambda
		process(someNumbers, key, wrapperLambda((v, k) -> System.out.println(v/k)) );
	}
	
	public static void process(int [] someNumbers,int key, BiConsumer<Integer, Integer> consumer){
		
		for(int i : someNumbers) {
			System.out.println("inside process.for.accept("+i+", "+key+")");
			consumer.accept(i, key);
		}
	}
	
	public static BiConsumer<Integer, Integer> wrapperLambda(BiConsumer<Integer, Integer> consumer) {
		return (v, k) ->{ 
			try {
				System.out.println("inside wrapperLambda.try.consumer("+v+", "+k+")");
				consumer.accept(v, k);
			}catch (ArithmeticException e) {
				System.out.println("An ArithmeticException Happened");
			}
		};
	}
}
