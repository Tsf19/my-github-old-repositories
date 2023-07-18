/**
 * 
 */
package JavaBrains._7_MethodReferences;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import JavaBrains._2_PersonSorting.Java7Way_1_.Person;

/**
 * @author Tousif
 * 
 */

public class _2_MethodReferenceWithAnInputArgument {
	
	private static void printConditionally(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
		for( Person person : persons) {
			if(predicate.test(person))
				consumer.accept(person);
		}		
	}
	
	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(

				new Person("firstName1","alastName1",11),
				new Person("firstName2","cblastName2",22),
				new Person("firstName3","calastName3",33),
				new Person("firstName4","CdlastName4",44),
				new Person("firstName5","blastName5",55)
				);
		//p -> System.out.println(p) //Given the value of p, pass this to SOP
		//Means execute the method for every value sent to it.
		printConditionally(persons, p -> true, p -> System.out.println(p));
		//OR
		/**
		 *  "System.out.println(p)"
		 *  This is not an static method, this is an instance method.
		 *  The System class contains several useful class fields and methods.It cannot be instantiated.
		 *  System is an static reference to get the "out" object, out is not static, its an instance
		 *  and we are calling println() method on "out" instance.
		 *  
		 *  so in order to replace "System.out.println(p)" with method reference,
		 *  we need to take instance::methodName i.e, "System.out::println"
		 *  compiler knows "System.out::println is in place of an consumer, and consumer takes an input argument"
		 *  
		 *  If method reference takes place of which doesn't take an input argument, compiler knows it doesn't
		 *  need input argument
		 *  However
		 *  If method reference takes place of which takes an input argument, compiler knows it need input argument.
		 *  so its basically "System.out::println" maps to  "p -> System.out.println(p)"
		 *  
		 *  "System.out::println" when compiler executes this, it realizes that it's in place of consumer
		 *  which means "println" takes an argument as an input
		 */
		printConditionally(persons, p -> true, System.out::println);
	}
}
