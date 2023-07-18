/**
 * 
 */
package Telusko._4_StreamAPI;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tousif
 *
 */
public class _7_Filter {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(12,20,35,46,55,68,75);
		
		int result = 0;
		for(Integer i : values) { //Imperative Coding : What to do + How to do
			if(i % 5 == 0) {
				result += i;
			}
		}
		System.out.println(result);

		//Only Focus on What to do :
		
		System.out.println(values.stream().filter(i -> i%5 == 0).reduce(0, Integer::sum));
		
		System.out.println(values.stream().filter(i -> i%5 == 0).reduce(0, (i,j) -> i+j));
		

		
	}
	

}
