package Java8_features.java67;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class _6_SortMapByKeys {

	public static void main(String[] args) {

		// a Map with string keys and integer values
		Map<String, Integer> budget = new HashMap<>();
		budget.put("clothes", 120);
		budget.put("grocery", 150);
		budget.put("transportation", 100);
		budget.put("utility", 130);
		budget.put("rent", 1150);
		budget.put("miscellneous", 90);

		System.out.println("map before sorting: " + budget);

		// let's sort this map by keys first
		Map<String, Integer> sorted = budget
				.entrySet()
				.stream()
				.sorted(Map.Entry.comparingByKey())
				.collect(
						Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
								(e1, e2) -> e2, LinkedHashMap::new));

		// now let's sort the map in decreasing order of keys
		sorted = budget
				.entrySet()
				.stream()
				.sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
				.collect( Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

		System.out.println("map after sorting by keys in descending order: " + sorted);



	}

}
