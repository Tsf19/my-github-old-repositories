/**
 * 
 */
package JavaBrains._1_Basics;

/**
 * @author Tousif
 *
 */

interface MyAdd1 {
	int add(int x, int y);
}

class MyAddImplementation1 implements MyAdd1 {

	@Override
	public int add(int x, int y) {
		return x + y;
	}
	
}

public class _1_InterfaceImplementationUsingClass {

	public static void main(String[] args) {
		
		int a = 2;
		int b = 3;
		
		MyAddImplementation1 myAddImplementation = new MyAddImplementation1 ();
		
		System.out.println(myAddImplementation.add(a,b));
	}
	
	
}
