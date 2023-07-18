package Generics.BoundsForTypeVariables2;

/**
 * Sometimes, a class or a method needs to place restrictions on type variables.
 * 
 * 
 * 	public static <T> T min(T[] a) {
 * 		-	-	-	-	-	-
 * 	}
 * 
 * Look inside the code of the min method. The variable smallest has type T ,
 * which means that it could be an object of an arbitrary class. How do we know that the class to which
 * T belongs has a compareTo method?
 * 
 * The solution is to restrict T to a class that implements the Comparable interface—a standard
 * interface with a single method, compareTo . You can achieve this by giving a bound for the type
 * variable T :
 * 
 * public static <T extends Comparable> T min(T[] a) . . .
 * 
 * Actually, the Comparable interface is itself a generic type. For now, we will ignore that
 * complexity and the warnings that the compiler generates.
 * 
 * Now, the generic min method can only be called with arrays of classes that implement the
 * Comparable interface, such as String , Date , and so on.
 * 
 * 
 * You may wonder why we use the extends keyword rather than the implements keyword in this
 * situation—after all, Comparable is an interface.
 * 
 * The notation :
 * 	<T extends BoundingType>
 * 
 * expresses that T should be a subtype of the bounding type. Both T and the bounding type can be
 * either a class or an interface. The extends keyword was chosen because it is a reasonable
 * approximation of the subtype concept, and the Java designers did not want to add a new keyword
 * (such as sub ) to the language.
 * A type variable or wildcard can have multiple bounds.
 * 
 * For example:
 * 	T extends Comparable & Serializable
 * 
 * The bounding types are separated by ampersands ( & ) because commas are used to separate type
 * variables.
 * As with Java inheritance, you can have as many interface supertypes as you like, but at most one of
 * the bounds can be a class. If you have a class as a bound, it must be the first one in the bounds list.
 * 	
 */
public class PairTest1 {

	public static void main(String[] args) {

		String[] words = { "Mary", "had", "a", "little", "lamb" };
		System.out.println(ArrayAlg.min(words));
	}

}

class ArrayAlg {

	public static <T extends Comparable> T min(T[] a) {
		
	if (a == null || a.length == 0)
		return null;
	
	T smallest = a[0];
	
	for (int i = 1; i < a.length; i++)
		if (smallest.compareTo(a[i]) > 0)
			smallest = a[i];
	
	return smallest;
	}

}
