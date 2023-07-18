package Generics.SupertypeBoundsForWildcards6;

/**
 * @author Tousif
 */

/**
 * Wildcard bounds are similar to type variable bounds, but they have an added capability—you can
 * specify a supertype bound, like this:
 * <? super Manager>
 * This wildcard is restricted to all supertypes of Manager .
 * 
 * Pair<? super Manager> has methods
 * 	•	void setFirst(? super Manager)
 * 	•	? super Manager getFirst()
 * 
 * The compiler doesn’t know the exact type of the setFirst method and therefore can’t call it with
 * an object of type Employee or Object , but only with type Manager or a subtype
 * 
 * Intuitively speaking, wildcards with supertype bounds let you write to a generic object, while
 * wildcards with subtype bounds let you read from a generic object.
 * 
 */
public class PairTest1 {

	public static void main(String[] args) {
		
		Manager m1 = new Manager();
		m1.setName("Manager1");
		
		Manager m2 = new Manager();
		m2.setName("Manager2");
		
		Pair<? super Manager > p1 = new Pair();
		p1.setFirst(m1); //void setFirst(? super Manager)
		p1.setSecond(m2);
		
		System.out.println(p1); //? super Manager getFirst()
		
		
		Employee e1 = new Employee();
		e1.setName("Employee1");

		Employee e2 = new Employee();
		e2.setName("Employee2");
		
		Pair<? super Manager> p2 = new Pair< >(e1,e2); // NO-ERRORR!!??
//		Pair<? super Manager> p2 = new Pair();
//		p2.setFirst(e1); // ✗ ERROR
//		p2.setSecond(e2); // ✗ ERROR
		System.out.println(p2);
		
	}
	
/**
 * 
 * You can even use wildcards with no bounds at all—for example, Pair<?> . At first glance, this
 * looks identical to the raw Pair type. Actually, the types are very different. The type Pair<?> has
 * methods such as
 * 	? getFirst()
 * 	void setFirst(?)
 * The return value of getFirst can only be assigned to an Object . The setFirst method can never
 * be called, not even with an Object . That’s the essential difference between Pair<?> and Pair : you
 * can call the setFirst method of the raw Pair class with any Object.
 * 
 * NOTE : You can call setFirst(null) .
 * Why would you ever want such a wimpy type? It is useful for very simple operations. For example,
 * the following method tests whether a pair contains a null reference. It never needs the actual type.
 * public static boolean hasNulls(Pair<?> p)
 * {
 *	 return p.getFirst() == null || p.getSecond() == null;
 * }
 * You could have avoided the wildcard type by turning hasNulls into a generic method:
 * public static <T> boolean hasNulls(Pair<T> p)
 * However, the version with the wildcard type seems easier to read.
 * 
 * A wildcard is not a type variable, so we can’t write code that uses ? as a type.
 *  
 */
}



