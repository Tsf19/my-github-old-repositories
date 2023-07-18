/**
 * 
 */
package JavaBrains._3_FunctionalInterfaces._2_ConsumerInterface;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Tousif
 *
 */
public class App {

	private static void printConditionally(List<Person> persons, Predicate<Person> predicate, Consumer<Person> consumer) {
		for( Person person : persons) {
			if(predicate.test(person))
				consumer.accept(person);
		}		
	}

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("firstName1","alastName1",11),
				new Person("dfirstName2","cblastName2",22),
				new Person("firstName3","calastName3",33),
				new Person("DfirstName4","CdlastName4",44),
				new Person("firstName5","blastName5",55)
				);

		// Step 1: Sort list by last name
		Collections.sort(persons,
				(Person p1, Person p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName())
				);

		// Step 2: Print all elements in the list
		System.out.println("\nPrint all elements in the list sorted by last name ");
		printConditionally(persons, person -> true, person -> System.out.println(person));

		// Step 3: Print all persons that have last name begin with 'C'
		System.out.println("\nPrint all persons that have last name begin with 'C' ");
		printConditionally(persons,
						person -> person.getLastName().toLowerCase().startsWith("c"),
						person -> System.out.println(person.getLastName()));

		// Step 4: Print all persons that have first name begin with 'D'
		System.out.println("\nPrint all persons that have first name begin with 'D' ");
		printConditionally(persons,
				person -> person.getFirstName().toLowerCase().startsWith("d"),
				person -> System.out.println(person.getFirstName()));
	}


}
