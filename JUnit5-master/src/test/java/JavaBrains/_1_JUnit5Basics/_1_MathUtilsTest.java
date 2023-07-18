/**
 * 
 */
package JavaBrains._1_JUnit5Basics;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

/**
 * @author Tousif
 *
 */
class _1_MathUtilsTest {

	/**
	 * Test method for {@link JavaBrains._1_JUnit5Basics._1_MathUtils#add(int, int)}.
	 */
	@Test
	void testAdd() {
		_1_MathUtils mathUtils = new _1_MathUtils();
		int expected = 14;
		int actual = mathUtils.add(7, 7);

//		assertEquals(expected, actual);
		/** Adding 3rd argument i.e, message :
		 *  Messgae will be thrown when assertEquals() fails */ 
		assertEquals(expected, actual, "The add() method should add two numbers");
		
	}
	
	/**BEFORE JUnit5*/
//	@org.junit.Test(expected = ArithmeticException.class)
//	void testDivide() {
//		_1_MathUtils mathUtils = new _1_MathUtils();
//		mathUtils.divide(1, 0);
//	}
	
	/**Using Anonymous class Implementing Executable execute() method*/
//	@Test
//	void testDivide() {
//		_1_MathUtils mathUtils = new _1_MathUtils();
//	
//		assertThrows(ArithmeticException.class, new Executable() {
//			@Override
//			public void execute() throws Throwable {
//				mathUtils.divide(1, 0);
//			}
//			
//		},"Divide by zero throws ArithmeticException");
//	}
	
	/**Using Lambda Expression Implementing Executable execute() method*/
	@Test
	void testDivide() {
		_1_MathUtils mathUtils = new _1_MathUtils();
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),"Divide by zero throws ArithmeticException");
	}
	
	
	@Test
	void testComputeCircleArea() {
		_1_MathUtils mathUtils = new _1_MathUtils();
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
	}

}
