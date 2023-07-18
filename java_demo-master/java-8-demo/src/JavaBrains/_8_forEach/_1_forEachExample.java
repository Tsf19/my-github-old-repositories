/**
 * 
 */
package JavaBrains._8_forEach;

import java.util.Arrays;
import java.util.List;

import JavaBrains._2_PersonSorting.Java7Way_1_.Person;

/**
 * @author Tousif
 * 
 */

/**
 * void java.lang.Iterable.forEach(Consumer<? super Person> action)
 * 
 * Performs the given action for each element of the Iterable until all elements
 * have been processed or the action throws an exception.
 * Unless otherwise specified by the implementing class,actions are performed
 * in the order of iteration (if an iteration order is specified).
 * Exceptions thrown by the action are relayed to the caller.
 */
public class _1_forEachExample {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(

				new Person("firstName1","alastName1",11),
				new Person("firstName2","cblastName2",22),
				new Person("firstName3","calastName3",33),
				new Person("firstName4","CdlastName4",44),
				new Person("firstName5","blastName5",55)
				);
		/**
		 * forEach() doesn't care about sequence of execution,
		 * some part of the list can be get executed in this processor while
		 * other part of the list can be get executed in other processor.
		 * This makes it possible to have multithreading and parallelism. 
		 */
		persons.forEach(p -> System.out.println(p));
		//OR
		persons.forEach(System.out::println);
	}
}
