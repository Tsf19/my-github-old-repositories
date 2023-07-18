/**
 * 
 */
package JavaBrains._9_Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import JavaBrains._2_PersonSorting.Java7Way_1_.Person;

/**
 * @author Tousif
 * 
 */

/**
 * STREAMS
 * A sequence of elements supporting sequential and parallel aggregate operations.
 */
public class _1_StreamExample {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(

				new Person("cfirstName1","alastName1",11),
				new Person("firstName2","cblastName2",22),
				new Person("firstName3","calastName3",33),
				new Person("cfirstName4","CdlastName4",44),
				new Person("firstName5","blastName5",55)
				);
		
		//STEP 1. Make a sub-list of persons whose lastName starts with c.
		//STEP 2. Printing persons whose lastName starts with c
		/**
		 * Iterating twice won't be efficient
		 * Now from Java8, every collections comes with a stream() method,
		 * 
		 * STREAM() : Returns a sequential Stream with this collection as its source.
		 * 
		 * FILTER(predicate) : Returns a stream consisting of the elements of this stream that match the given predicate
		 * 	If predicate says false, then those elements won't be processed further.
		 * 
		 *	* In the below stream(), we have "persons as the source"
		 *	* filter() as the operations, we can have many operations
		 *	* forEach() as the "Terminal Operation", the "End Condition", without it stream WON'T EVEN STARTS
		 *
		 * Using parallelStream(), we can have different portions of collections to get executed in different processors.
		 */
		persons.stream()
		.filter(p -> p.getLastName().startsWith("c")) 
		.forEach(p -> System.out.println(p.getLastName()));
		
		/**What we get back is view of this stream*/
		Stream<Person> stream = persons.stream()
								.filter(p -> p.getLastName().startsWith("c"));

		stream.forEach(p -> System.out.println(p.getLastName()));
		
		//PARALLEL_STREAM
		long count = persons.parallelStream()
							.filter(p -> p.getLastName().startsWith("c"))
							.count();
		System.out.println(count);
	}
}
