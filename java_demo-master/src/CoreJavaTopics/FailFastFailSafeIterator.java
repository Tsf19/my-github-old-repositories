package CoreJavaTopics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author DOMAIN\md.tousif
 * The major difference is fail-safe iterator doesn’t throw any Exception, contrary to fail-fast Iterator.
 * This is because they work on a clone of Collection instead of the original collection and that’s why
 * they are called as the fail-safe iterator.
 */
public class FailFastFailSafeIterator {

	public static void main(String[] args) {

		ArrayList<Integer> al = new ArrayList<>(); 
		al.add(1); 
		al.add(2); 
		al.add(3); 
		al.add(4); 
		al.add(5); 

		/**
		 * If you remove an element via Iterator remove() method, exception will not be thrown.
		 * However, in case of removing via a particular collection remove() method, ConcurrentModificationException will be thrown.
		 */
		Iterator<Integer> itr = al.iterator(); 
		while (itr.hasNext()) { 
			if (itr.next() == 3) { 
//				al.remove(3);  //will throw Exception on next call of next() method  
			} 
		} 

		System.out.println(al);
		
		
		/*======================================================================*/
		
		
		/**
		 * These iterators make a copy of the internal collection (object array) and iterates over the copied collection.
		 * Any structural modification done to the iterator affects the copied collection, not original collection.
		 * So, original collection remains structurally unchanged.
		 */
		itr = al.iterator();
		while (itr.hasNext()) { 
			if (itr.next() == 3) { 
				itr.remove(); //will not throw Exception 
			} 
		}

		System.out.println(al);

		
		/*======================================================================*/
		
		
		CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<Integer>(new Integer[] { 1, 3, 5, 8 }); 

		itr = list.iterator(); 
		while (itr.hasNext()) { 
			Integer n = itr.next(); 
			System.out.println(n); 
			if (n == 5) 
				list.add(14); //This 14 will not get printed, as its working on separate copy 
		} 
		System.out.println(list); //[1, 3, 5, 8, 14], Here it will get printed
		
		
		/*======================================================================*/
		//Example of Fail-Safe Iterator which does not create separate copy

		/**
		 * The iterators returned by ConcurrentHashMap is weakly consistent.
		 * This means that this iterator can tolerate concurrent modification,
		 * traverses elements as they existed when iterator was constructed and
		 * may (but not guaranteed to) reflect modifications to the collection
		 * after the construction of the iterator.
		 */
		
		ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<String, Integer>(); 
		map.put("ONE", 1); 
		map.put("TWO", 2); 
		map.put("THREE", 3); 
		map.put("FOUR", 4); 

		// Getting an Iterator from map 
		Iterator<String> itr2 = map.keySet().iterator(); 

		System.out.println(map.keySet());
		
		while (itr2.hasNext()) { 
			String key = itr2.next(); 
			System.out.println(key + " : " + map.get(key));//This will get reflected in iterator. as it has not created separate copy 
			map.put("SEVEN", 7); 
		} 

		System.out.println(map.keySet());
	}
}