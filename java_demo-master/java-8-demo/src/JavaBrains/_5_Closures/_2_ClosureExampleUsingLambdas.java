/**
 * 
 */
package JavaBrains._5_Closures;

/**
 * @author Tousif
 *
 */
interface Process2{
	void process(int i);
}

public class _2_ClosureExampleUsingLambdas {
	
	public static void doProcess(int i, Process2 p) {
		p.process(i);
	}
	
	public static void main(String[] args) {

		int a = 10;
		int b = 20;
//		b = 7; //ERROR : Local variable b defined in an enclosing scope must be final or effectively final
		
		doProcess(a, i -> System.out.println(a+b) ); //b is coming from closure "int b = 20;", compiler freeze the value of b at this moment
		
	}
}
