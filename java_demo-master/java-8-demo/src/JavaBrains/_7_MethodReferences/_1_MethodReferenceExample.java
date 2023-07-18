/**
 * 
 */
package JavaBrains._7_MethodReferences;

/**
 * @author Tousif
 * 
 * METHOD REFRENCES is an alternative way/syntax for writing lambdas.
 */

public class _1_MethodReferenceExample {
	
	public static void printMessage() {
		System.out.println("Printing Message");
	}
	
	public static void main(String[] args) {
		/**
		 * Here we need to pass an instance of runnable,
		 * rather than creating new runnable AnonymousInnerClass we are passing lambda
		 */
		Thread t1 = new Thread( () -> printMessage());
		t1.start();
		/**
		 * Here what this lambda expression is doing is its basically taking no input argument and its executing the method.
		 * So what this lambda expression is doing is method execution.
		 * 
		 * If there is no input argument and you are just executing a method
		 * OR
		 * If there are certain parameters and you are passing those parameters to the method,
		 * 
		 * Then there is a new syntax for that and that is method references.
		 * First Rule is you give the class name where you have the method.
		 * then two colons i.e, ::
		 * then followed with method name, just name i.e, without ()
		 */
		
		/**This is equivalent to lambda expression before*/
		Thread t2 = new Thread( _1_MethodReferenceExample::printMessage);
		t2.start();
		
	}
}
