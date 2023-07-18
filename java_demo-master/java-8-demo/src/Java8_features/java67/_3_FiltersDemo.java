package Java8_features.java67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DOMAIN\md.tousif
 * The filter() method just setup couple of pointers and no data comparison is performed
 * until a terminal method e.g. forEach() or findFirst() is called.
 */
public class _3_FiltersDemo {

	public static void main(String[] args) {

		List<String> versions = new ArrayList<>();
        versions.add("Lollipop");
        versions.add("KitKat");
        versions.add("Jelly Bean");
        versions.add("Ice Cream Sandwidth");
        versions.add("Honeycomb");
        versions.add("Gingerbread");
        
/*####################################################################################################*/        
        
        // Using one filter() 
        // print all versions whose length is greater than 10 character
        System.out.println("All versions whose length greater than 10");
        versions.stream()
                .filter(s -> s.length() > 10)
                .forEach(System.out::println);
        
        
        
        System.out.println("first element which has letter 'e' ");
        String first = versions.stream()
                .filter(s -> s.contains("e"))
                .findFirst().get();
        System.out.println(first);
        
        
        
        // Using multiple filter
        System.out.println("Element whose length is > 5 and startswith G");
        versions.stream()
                .filter(s -> s.length() > 8)
                .filter(s -> s.startsWith("G"))
                .forEach(System.out::println);
        
        /*####################################################################################################*/        
        
        // Using count filter
        System.out.println("Count Elements whose length is > 6");
        Long count = versions.stream()
                .filter(s -> s.length() > 6)
                .count();
        System.out.printf("count is : %d \n",count);

        
        /*####################################################################################################*/
        
        
        // another example of filter() method in Java 8
        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 12, 18);
        Integer lcm = listOfNumbers.stream()
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                .findFirst().get();
        System.out.println("first number divisible by 2 and 3 in the list is : "+ lcm);
        
        
        
     // Create List of square of all distinct numbers
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream()
                                         .map(i -> i*i).distinct()
                                         .collect(Collectors.toList());
        System.out.printf("Original List : %s, \n Square Without duplicates : %s %n",
                                          numbers, distinct);
     
        int sum = numbers
        		.stream()
        		.mapToInt(i -> i)
        		.sum();
        System.out.println("sum is :" + sum);
        
        /*####################################################################################################*/        
        
        
        //Get count, min, max, sum, and average for numbers
        /**
         * Since this statistics operations are numeric in nature, it's important to call mapToInt() method.
         * After this, we call the summaryStatistics(), which returns an instance of an IntSummaryStatistics.
         * It is this object which provides us utility method like getMin(), getMax(), getSum() or getAverage().
         */
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream()
                                           .mapToInt(x -> x)
                                           .summaryStatistics();
        
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
        
        
        /*####################################################################################################*/
        
        
        //Convert String to uppercase and Join them with coma
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
        
        String G7Countries = G7.stream()
        		.map(x -> x.toUpperCase())
        		.collect(Collectors.joining(", "));
        System.out.println("G7Countries " + G7Countries);
	}

}
