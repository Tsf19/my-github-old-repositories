package Java8_features.java67;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author DOMAIN\md.tousif
 * We can use the flatMap() to flatten a Stream of Stream of values into just a Stream of values.
 * 
 * [[3,7],[23],[2,3,7]]. If we want to flatten this stream of a stream into a stream of values,
 * we can use the flatMap() which will finally return [3,7,2,3,2,3,7].
 * This is only called as flattening of stream
 * 
 * If you use a function which returns a list of values in map() operation you get a Stream of Stream
 * and by using flatMap you can convert that to Stream of values.
 * In short, you can combine several small lists of values into a big list of values using flatMap().
 * It's called flatMap() because it flattens the Stream.
 */
public class _2_FlatMapDemo {

	public static void main(String[] args) {

        List<String> teamIndia = Arrays.asList("Virat", "Dhoni", "Jadeja");
        List<String> teamAustralia = Arrays.asList("Warner", "Watson", "Smith");
        List<String> teamEngland = Arrays.asList("Alex", "Bell", "Broad");
        List<String> teamNewZeland = Arrays.asList("Kane", "Nathan", "Vettori");
        List<String> teamSouthAfrica = Arrays.asList("AB", "Amla", "Faf");
        List<String> teamWestIndies = Arrays.asList("Sammy", "Gayle", "Narine");
        List<String> teamSriLanka = Arrays.asList("Mahela", "Sanga", "Dilshan");
        List<String> teamPakistan = Arrays.asList("Misbah", "Afridi", "Shehzad");
        
        List<List<String>> playersInWorldCup2019 = new ArrayList<>();
        playersInWorldCup2019.add(teamIndia);
        playersInWorldCup2019.add(teamAustralia);
        playersInWorldCup2019.add(teamEngland);
        playersInWorldCup2019.add(teamNewZeland);
        playersInWorldCup2019.add(teamSouthAfrica);
        playersInWorldCup2019.add(teamWestIndies);
        playersInWorldCup2019.add(teamSriLanka);
        playersInWorldCup2019.add(teamPakistan);
        
        // Let's print all players before Java 8
        List<String> listOfAllPlayers = new ArrayList<>();
        
        for(List<String> team : playersInWorldCup2019) {
        	for(String player : team) {
        		listOfAllPlayers.add(player);
        	}
        }
        
        System.out.println("Players playing in world cup 2016");
        System.out.println(listOfAllPlayers);
        
        // Now let's do this in Java 8 using FlatMap
        List<String> flatMapList = playersInWorldCup2019
        		.stream()
        		.flatMap(
        				pList -> pList.stream())
        		.collect(
        				Collectors.toList());
		
        System.out.println("List of all Players using Java 8");
        System.out.println(flatMapList);
	}

}
