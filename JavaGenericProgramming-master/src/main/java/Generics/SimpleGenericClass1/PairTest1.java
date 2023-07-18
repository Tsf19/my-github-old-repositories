package Generics.SimpleGenericClass1;

public class PairTest1 {

	public static void main(String[] args) {

		String[] words = { "Mary", "had", "a", "little", "lamb" };
		
		Pair<String> mm = ArrayAlg.minmax(words);
		
		System.out.println("min = " + mm.getFirst());
		System.out.println("max = " + mm.getSecond());
		System.out.println("middle = " + ArrayAlg.<String>getMiddle(words));
		System.out.println("middle = " + ArrayAlg.getMiddle(words)); //you can omit the <String> type parameter
		
		System.out.println("middle = " + ArrayAlg.getMiddle(314, 1729, 10));
		
		System.out.println("middle = " + ArrayAlg.getMiddle(3.14, 1729, 10)); //No Need to cast
		
		Integer middleInt = ArrayAlg.getMiddle(314, 1729, 10);
		System.out.println(middleInt);
		
		Double middleDouble = ArrayAlg.getMiddle(3.14, Double.valueOf(1729) , Double.valueOf(10)); //Casting is needed
		System.out.println(middleDouble);
	}

}

class ArrayAlg {

/**
 * Gets the minimum and maximum of an array of strings.
 * @param a an array of strings
 * @return a pair with the min and max value, or null if a is null or empty
 */
	
	public static Pair<String> minmax(String[] a){
		
		if (a == null || a.length == 0)
			return null;
		
		String min = a[0];
		String max = a[0];
		
		for (int i = 1; i < a.length; i++) {
			
			if (min.compareTo(a[i]) > 0)
				min = a[i];
			
			if (max.compareTo(a[i]) < 0)
				max = a[i];
		}
		return new Pair<>(min, max);
	}

/**
 * GENERIC_METHODS
 * You can also define a single method with type parameters.
 * This method is defined inside an ordinary class, not inside a generic class. However, it is a generic
 * method, as you can see from the angle brackets and the type variable. Note that the type variables are
 * inserted after the modifiers ( public static , in our case) and before the return type.
 * You can define generic methods both inside ordinary classes and inside generic classes.
 * When you call a generic method, you can place the actual types, enclosed in angle brackets, before
 * the method name:
 * 
 * String middle = ArrayAlg.<String>getMiddle("John", "Q.", "Public");
 * 
 * In this case (and indeed in most cases), you can omit the <String> type parameter from the methodcall.
 * The compiler has enough information to infer the method that you want. It matches the type of
 * names (that is, String[] ) against the generic type T[] and deduces that T must be String . That is,
 * you can simply call
 * 
 * String middle = ArrayAlg.getMiddle("John", "Q.", "Public");
 * 
 * In almost all cases, type inference for generic methods works smoothly. Occasionally, the compiler
 * gets it wrong, and you’ll need to decipher an error report.	
 * 
 * Consider this example:
 * 
 * double middle = ArrayAlg.getMiddle(3.14, 1729, 0);
 * 
 * the compiler autoboxed
 * the parameters into a Double and two Integer objects, and then it tried to find a common supertype
 * of these classes. It actually found two: Number and the Comparable interface, which is itself a
 * generic type. In this case, the remedy is to write all parameters as double values.
 * 
 */	
	public static <T> T getMiddle(T... a) {
		return a[a.length / 2];
	}

}
