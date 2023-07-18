/**
 * 
 */
package JavaBrains._1_Basics;

/**
 * @author Tousif
 *
 */

interface MyAdd2 {
	int add(int x, int y);
}

public class _2_InterfaceImplementationUsingAnonymousClass {

	public static void main(String[] args) {
		
		int a = 2;
		int b = 3;
		
		MyAdd2 myAdd2Impl = new MyAdd2() {
			
			@Override
			public int add(int x, int y) {
				return x + y;
			}
		};
		
		System.out.println(myAdd2Impl.add(a, b));
		
	}
	
	
}
