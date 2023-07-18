package Java8_features.Lambda_Expressions_Basics;

/**
 * @author Tousif
 *
 */
public class LambdaExpressionsTester {
	
	interface MathOperation { //Declaring Interface
		int operation(int a, int b);
	}
	
	private int operate(int a, int b, MathOperation mathOperation) {
		return mathOperation.operation(a, b);
	}
	
	interface GreetingService {
		void sayMessage(String message);
	}
	

	public static void main(String[] args) {

		LambdaExpressionsTester tester = new LambdaExpressionsTester();
		
		//with type declaration
		MathOperation addition = (int a, int b) -> a + b; //Defining Interface

		//with out type declaration
		MathOperation subtraction = (a, b) -> a - b; //Defining Interface

		//with return statement along with curly braces
		MathOperation multiplication = (int a, int b) -> { return a * b; }; //Defining Interface

		//without return statement and without curly braces
		MathOperation division = (int a, int b) -> a / b;  //Defining Interface

		System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
		System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
		System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
		System.out.println("10 / 5 = " + tester.operate(10, 5, division));

		//without parenthesis
		GreetingService greetService1 = message ->
		System.out.println("Hello " + message);

		//with parenthesis
		GreetingService greetService2 = (message) ->
		System.out.println("Hello " + message);

		greetService1.sayMessage("Tousif1");
		greetService2.sayMessage("Tousif2");
	}



}
