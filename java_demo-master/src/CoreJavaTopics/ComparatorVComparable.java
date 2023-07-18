package CoreJavaTopics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author DOMAIN\md.tousif
 * 
 * Comparator in Java is defined in java.util package
 * Comparable interface in Java is defined in java.lang package,
 * which very much says that Comparator should be used as an utility to sort objects which Comparable should be provided by default.
 * 
 * Comparator interface in Java has method public int compare (Object o1, Object o2) which returns a negative integer, zero, or a positive integer
 * as the first argument is less than, equal to, or greater than the second.
 *
 * Comparable interface has method public int compareTo(Object o) which returns a negative integer, zero, or a positive integer
 * as this object is less than, equal to, or greater than the specified object.
 * 
 * Difference between these two is Comparator in Java compare two objects provided to him,
 * while Comparable interface compares "this" reference with the object specified.
 * 
 * Comparable in Java is used to implement natural ordering of object.
 * In Java API String, Date and wrapper classes implements Comparable interface.
 * Its always good practice to override compareTo() for value objects.
 * 
 * If any class implement Comparable interface in Java then collection of that object either List or Array can be sorted automatically by using 
 * Collections.sort() or Arrays.sort() method and object will be sorted based on there natural order defined by CompareTo method.
 * 
 * Objects which implement Comparable in Java can be used as keys in a SortedMap like TreeMap or elements in a SortedSet
 * for example TreeSet, without specifying any Comparator
 * 
 * Summary if you want to sort objects based on natural order then use Comparable in Java and
 * if you want to sort on some other attribute of object then use Comparator in Java
 * 
 * 
 * For a Person class, sorting based on person_id can be treated as natural order sorting and sorting based on name field
 * can be implemented using Comparator interface.
 * To sort based on person_id we need to implement compareTo() method.
 *
 * 
 */

class FirstNameComparator implements Comparator<Person>
{ 
    public int compare(Person p1, Person p2) 
    { 
        return p1.getFirstName().compareTo(p2.getFirstName()); 
    } 
}

public class ComparatorVComparable {

	public static void main(String[] args) {
		
		List<Person> persons = Arrays.asList(
				new Person("firstName7","alastName2",20),
				new Person("firstName4","cblastName5",23),
				new Person("firstName3","calastName6",22),
				new Person("firstName1","CdlastName1",23),
				new Person("firstName6","blastName3",26),
				new Person("firstName5","blastName4",25),
				new Person("firstName2","blastName7",21)
				);
		
		System.out.println("Before Sorting...\n" + persons.toString());
		//Sorting based on Person's Age(NATURAL ORDERING)
		Collections.sort(persons);
		System.out.println("After Sorting using Comparable.compareTo()...\n" + persons.toString());	
	
		//Sorting based on Person's First Name
		FirstNameComparator comparator = new FirstNameComparator();
		Collections.sort(persons, comparator);
		System.out.println("After Sorting Person's First Name using Comparator.compare()...\n" + persons.toString());
		
		//Sorting based on Person's Last Name Using ANONYMOUS INNER CLASS
//		Collections.sort(persons, new Comparator<Person>() {
//		    public int compare(Person p1, Person p2) 
//		    { 
//		        return p1.getLastName().compareTo(p2.getLastName()); 
//		    } 
//		});
		
		//OR
		
		Collections.sort(persons,
				(Person p1, Person p2) -> p1.getLastName().compareTo(p2.getLastName())
				);
		
		System.out.println("After Sorting Person's Last Name using Comparator.compare() Using ANONYMOUS INNER CLASS...\n" + persons.toString());
	}

}
