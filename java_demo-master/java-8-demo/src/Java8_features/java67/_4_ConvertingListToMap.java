package Java8_features.java67;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import JavaBrains._2_PersonSorting.Java7Way_1_.Person;

public class _4_ConvertingListToMap {

	public static void main(String[] args) {

		List<Person> persons1 = Arrays.asList(
				new Person("firstName1","lastName1",11),
				new Person("firstName2","lastName2",22),
				new Person("firstName3","lastName3",33),
				new Person("firstName4","lastName4",44),
				new Person("firstName5","lastName5",55)
				);
		
		Map<Integer, Person> map1 = persons1
				.stream()
				.collect(
						Collectors.toMap(p -> p.getAge(), p -> p));
		
		//OR Replacing this lambda with a method reference.
		
		Map<Integer, Person> map2 = persons1
				.stream()
				.collect(
						Collectors.toMap(Person::getAge, p -> p));
		
		/**
		 * You can further remove the last remaining lambda expression from this code,
		 * where we are passing the object itself by using Function.identify() method in Java 8
		 * when the value of the Map is the object itself.
		 * 
		 * What does identify function do here? It's just a substitute of b ->b and you can use if you want to pass the object itself.
		 */
		Map<Integer, Person> map3 = persons1
				.stream()
				.collect(
						Collectors.toMap(Person::getAge, Function.identity()));
		
		
		/**########## @WHAT_IF_LIST_HAS_DUPLICATES ##########*/
		/**
		 * Map doesn't allow duplicate keys. What will happen if you try to convert a List with duplicate elements into a Map in Java 8?
		 * Well, the above method will throw @IllegalStateException
		 * 
		 *  Well, Java 8 has provided another overloaded version of Collectors.toMap() function which accepts a merge function 
		 *  to decide what to do in case of the duplicate key.
		 *  If you use that version, instead of throwing an exception, Collector will use that merge function to resolve a conflict.
		 *  
		 *  In the following example, I have used that version and instructed to use the first object in case of the duplicate key,
		 *  the lambda expression (e1, e2) -> e1 is suggesting that.
		 *  You can do whatever you want e.g. you can combine the keys or choose any one of them.
		 *  
		 */
		
		List<Person> persons2 = Arrays.asList(
				new Person("firstName1","lastName1",11),
				new Person("firstName2","lastName2",22),
				new Person("firstName3","lastName3",22),
				new Person("firstName4","lastName4",44),
				new Person("firstName5","lastName5",55)
				);
		
		Map<Integer, Person> map4 = persons2
				.stream()
				.collect(
						Collectors
						.toMap(Person::getAge, Function.identity(), (p1,p2) -> p1));
		
		
		/**########## @PRESERVE_ORDER_OF_ELEMENTS_WHILE_CONVERTING_A_LIST_TO_MAP ##########*/
		/**
		 *  Map doesn't guarantee the order of mappings,
		 *  If you really need elements in Map in the same order they were in the List, you can use another version of 
		 *  Collectors.toMap() method which accepts four parameters and the last one of them is to ask for a specific Map implementation 
		 *  e.g. HashMap or LinkedHaashMap.
		 *  Since LinkedHashMap maintains insertion order of elements, you can collection elements in the LinkedHashMap.
		 */

		Map<Integer, Person> map5 = persons2
				.stream()
				.collect(
						Collectors
						.toMap(Person::getAge, Function.identity(), (p1,p2) -> p1, LinkedHashMap<Integer, Person> :: new));

		System.out.println();
	}

}
