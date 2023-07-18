/**
 * 
 */
package JavaBrains._1_Basics;

/**
 * @author Tousif
 *
 */

@FunctionalInterface //So that no one else should add more methods to this interface
interface MyAdd3 {
	int add(int x, int y);
}

public class _3_InterfaceImplementationUsingLambdaExpression {


	public static void main(String[] args) {
		
		int a = 2;
		int b = 3;
		
		MyAdd3 myAdd3 = (x,y) -> x+y; //We are implementing just function, not class
		
		System.out.println(myAdd3);
		
		
	}
//	Functional Interface are the Interface which has only one method init
//	one should mark interface as an functional inerface annotation so that no one other should change it or 
//	Don't add an extra method , otherwise lambda won't be able to use it
//	implementation of lamda will fail 
	
}
