package Java8_features.java67;

import java.util.Arrays;

/**
 * @author DOMAIN\md.tousif
 *
 */
public class _1_StringJoinerDemo {

	public static void main(String[] args) {

		// Joining arbitrary number of String
		String combined = String.join(" and ", "LinkedIn", "Microsoft");
		System.out.println("string joined by and : " + combined);

		// joining elements from a list of String
		String joined = String.join("|", Arrays.asList("Java", "Android", "Oracle"));
		System.out.println("String joined by pipe from list : " + joined);

		// joining String elements of an array
		String[] biggies = { "Apple", "Google", "Amazon" };
		String fromArray = String.join(",", biggies);
		System.out.println("String joined by comma from array: " + fromArray);


	}

}
