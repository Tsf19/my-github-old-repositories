/**
 * 
 */
package JavaBrains._6_ThisReferenceInLambdas;

/**
 * @author Tousif
 *
 */
interface Process5{
	void process(int i);
}

public class _3_ThisReferenceOutsideStaticContext {
	
	public void doProcess(int i, Process5 p) {
		p.process(i);
	}
	
	public void execute() {
		System.out.println(this);//This "this" and "this" inside lambda is same
		doProcess(10, i ->	{ 
			System.out.println("Value of i is "+10);
			System.out.println(this);//NO ERROR : Not inside static context
			/**
			 * This time its not inside static context, but still "this reference" hasn't been overridden,
			 * Its same as outside of the lambda expression, means referring to an instance of the object
			 * in whic this execute() method is been called 
			 * 
			 */
	});	
	}
	
	public static void main(String[] args) {

//		System.out.println(this); //ERROR : Cannot use this in a static context
		
		_3_ThisReferenceOutsideStaticContext classObj = new _3_ThisReferenceOutsideStaticContext();
		int a = 10;

		classObj.doProcess(a, i ->	{ 
				System.out.println("Value of i is "+a);
//				System.out.println(this);//ERROR : Cannot use this in a static context
		});
		
		classObj.execute();
		
	}
}
