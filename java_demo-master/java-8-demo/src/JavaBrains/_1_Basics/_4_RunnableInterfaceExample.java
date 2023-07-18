/**
 * 
 */
package JavaBrains._1_Basics;

/**
 * @author Tousif
 *
 */
public class _4_RunnableInterfaceExample {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {

				System.out.println("Printing inside Runnable");
				
			}
		});
		
		thread1.run();
		
		Thread thread2 = new Thread( () -> System.out.println("Printing inside LambdaThread")); 
		thread2.run();
	}
	
}
