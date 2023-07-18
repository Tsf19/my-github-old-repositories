/**
 * 
 */
package Telusko._2_DefaultKeyword;

/**
 * @author Tousif
 *
 */
public interface Actor {

	void act();
	void speak();
	
 //	Defining a method in an interface using DefaultKeyword
	default void comedy() {
		System.out.println("Actore comedy()");
	}
	
}
