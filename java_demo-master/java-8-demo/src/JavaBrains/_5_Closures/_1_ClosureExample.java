/**
 * 
 */
package JavaBrains._5_Closures;

/**
 * @author Tousif
 *
 */
interface Process1{
	void process(int i);
}

public class _1_ClosureExample {
	
	public static void doProcess(int i, Process2 p) {
		p.process(i);
	}
	
	public static void main(String[] args) {

		int a = 10;
//		final int b = 20; //Before Java8, we need to declare it final
		int b = 20; //But after Java8, it's called effectively final
		
		doProcess(a, new Process2() {

			@Override
			public void process(int j) {
//				b = 22; <--ERROR The variable 'b' has no scope in Process1.process(),
//				because method is getting executed inside ClosureExample.doProcess
				System.out.println(a+b); //<-- Here what's happening is JavaCompiler is skipping the track of value of 'b',
			}
			
		});
		
		
	}
}
