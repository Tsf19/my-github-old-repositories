/**
 * 
 */
package JavaBrains._6_ThisReferenceInLambdas;

/**
 * @author Tousif
 *
 */
interface Process3{
	void process(int i);
}

public class _1_WithAnonymousClass {
	
	
	public void doProcess(int i, Process3 p) {
		p.process(i);
	}
	
	public static void main(String[] args) {

//		System.out.println(this); //ERROR : Cannot use this in a static context
		
		_1_WithAnonymousClass classObj = new _1_WithAnonymousClass();
		int a = 10;

		classObj.doProcess(a, new Process3() {
			
			@Override
			public void process(int i) {
				System.out.println("Value of i is "+a);
				System.out.println(this); //This will print object
			}
		} );
		
	}
}
