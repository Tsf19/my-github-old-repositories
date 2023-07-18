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
public class _9_FindFirstOrElse {

	public static void main(String[] args) {

		List<Integer> values = Arrays.asList(12,20,35,46,55,68,75);
		
		System.out.println(values.stream()				
								.filter(_9_FindFirstOrElse::isDivisible)	// Lazy
								.map( _9_FindFirstOrElse::mapTwice)		// Lazy
								.findFirst()			// Eager/Terminal Method
								.orElse(7));			// 
		
	}
	
	public static Boolean isDivisible(Integer i) {
		
		System.out.println("In isDiv "+i);
		return i%5==0;
		
	}
	
	public static int mapTwice(Integer i) {
		System.out.println("In mapTwice "+i);
		return i*2;
	}
	

}
