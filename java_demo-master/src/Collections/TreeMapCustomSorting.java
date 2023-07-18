package Collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import CoreJavaTopics.Person;

public class TreeMapCustomSorting {

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
		
		TreeMap<Integer, Person> defaultSortedMap = new TreeMap<Integer, Person>();
		
		for(Person person : persons) {
			defaultSortedMap.put(person.getAge(), person);
		}
		System.out.println(defaultSortedMap);
		
		Comparator<Person> comparator = (Person p1, Person p2) -> p1.getAge().compareTo(p2.getAge());
		
//		@SuppressWarnings({ "rawtypes", "unchecked" })
//		SortedMap<Integer, Person> customSortedMap = new TreeMap<Integer, Person>(new Comparator<Person>() {
//			@Override
//			public int compare(Person p1, Person p2) {
//				return 0;
//			}
//        });
		
//		for(Person person : persons) {
//			customSortedMap.put(person.getAge(), (Person)person);
//		}
//		System.out.println(customSortedMap);
		
	}
}
