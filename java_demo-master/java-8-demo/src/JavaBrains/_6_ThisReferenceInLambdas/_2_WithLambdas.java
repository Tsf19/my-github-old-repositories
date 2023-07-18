/**
 * 
 */
package JavaBrains._6_ThisReferenceInLambdas;

/**
 * @author Tousif
 *
 */
interface Process4{
	void process(int i);
}

public class _2_WithLambdas {
	
	
	public void doProcess(int i, Process4 p) {
		p.process(i);
	}
	
	public static void main(String[] args) {

//		System.out.println(this); //ERROR : Cannot use this in a static context
		
		_2_WithLambdas classObj = new _2_WithLambdas();
		int a = 10;

		classObj.doProcess(a, i ->	{ 
				System.out.println("Value of i is "+a);
//				System.out.println(this);//ERROR : Cannot use this in a static context
				/**
				 * With Anonymous Inner Class, this is not giving an error
				 * We are not using this in "static void main()", but its still complaining because
				 * lambdas treats "this" in a slightly different way as compared to an Anonymous Inner Class.
				 * In the case of an Anonymous Inner Class, This refers to an instance of an Anonymous Inner Class
				 * In the case of an lambdas, "this reference" is untouched, inside lambdas "this reference" will be
				 * same as "this reference" outside the lambda expression, lambdas doesn't override "this reference"
				 * means "this reference" inside "static void main()"
				 */
				
		});
		
	}
}
