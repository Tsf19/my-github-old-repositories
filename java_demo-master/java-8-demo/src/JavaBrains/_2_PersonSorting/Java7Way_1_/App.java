/**
 * 
 */
package JavaBrains._2_PersonSorting.Java7Way_1_;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

	private static void printLastNameBeginningWithC(List<Person> persons) {
		for( Person person : persons) {
			if(person.getLastName().toLowerCase().startsWith("c"))
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
		Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareToIgnoreCase(o2.getLastName());
			}
		});

		// Step 2: Print all elements in the list
		System.out.println("\nPrint all elements in the list sorted by last name ");
		printAllPerson(persons);

		// Step 3: Print all persons that have last name begin with 'C'
		System.out.println("\nPrint all persons that have last name begin with 'C' ");
		printLastNameBeginningWithC(persons);

	}


}
