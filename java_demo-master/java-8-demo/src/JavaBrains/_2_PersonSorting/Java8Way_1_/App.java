/**
 * 
 */
package JavaBrains._2_PersonSorting.Java8Way_1_;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Tousif
 *
 */
public class App {

	public static void printAllPerson(List<Person> persons){
		for( Person person : persons) {
			System.out.println(person);
		}

	}

	private static void printConditionally(List<Person> persons, Condition condition) {
		for( Person person : persons) {
			if(condition.test(person))
				System.out.println(person);
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

		// Step 1: Sort list by last name
//		Collections.sort(persons, new Comparator<Person>() {
//			@Override
//			public int compare(Person o1, Person o2) {
//				return o1.getLastName().compareToIgnoreCase(o2.getLastName());
//			}
//		});
		Collections.sort(persons,
				(Person p1, Person p2) -> p1.getLastName().compareToIgnoreCase(p2.getLastName())
				);

		// Step 2: Print all elements in the list
		System.out.println("\nPrint all elements in the list sorted by last name ");
		printAllPerson(persons);

		// Step 3: Print all persons that have last name begin with 'C'
		System.out.println("\nPrint all persons that have last name begin with 'C' ");
		/**
		printLastNameBeginningConditionally(persons, new Condition() {
			@Override
			public Boolean test(Person person) {
				return person.getLastName().toLowerCase().startsWith("c");
			}
		});
		 */

		printConditionally(persons, person -> person.getLastName().toLowerCase().startsWith("c") );

	}


}
