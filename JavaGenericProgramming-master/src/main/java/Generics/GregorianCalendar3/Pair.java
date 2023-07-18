package Generics.GregorianCalendar3;


/**
 * @author Tousif
 *
 * @param <T>
 * 
 * GENERIC_CLASS
 * 	A generic class is a class with one or more type variables.
 * 	The Pair class introduces a type variable T , enclosed in angle brackets < > , after the class name.
 * 	A generic class can have more than one type variable. For example, we could have defined the Pair
 * 	class with separate types for the first and second field:
 * 	public class Pair<T, U> { . . . }
 * 
 * 
 */
public class Pair<T> {
	
	private T first;
	private T second;

	public Pair() {
		super();
		first = null;
		second = null;
	}
	
	public Pair(T first, T second) {
		super();
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}

	public T getSecond() {
		return second;
	}
	public void setSecond(T second) {
		this.second = second;
	}
	
}
