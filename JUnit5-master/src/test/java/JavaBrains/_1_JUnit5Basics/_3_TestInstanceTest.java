/**
 * 
 */
package JavaBrains._1_JUnit5Basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

/**
 * @author Tousif
 *
 */

/** When using this mode, a new test instance will be created for each test method,
 *  test factory method, or test template method.
 *  This method is By Default */
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)

/** When using this mode, a new test instance will be created once per test class*/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class _3_TestInstanceTest {
	
	
	/**Default Constructor to check number of Instance*/
	public _3_TestInstanceTest() {
		System.out.println("Instance");
	}
	
	_1_MathUtils mathUtils;
	
	@BeforeEach
	void init() {
		System.out.println("@BeforeEach - init()..");
		mathUtils = new _1_MathUtils();
	}
	
	@AfterEach
	void cleanUp() {
		System.out.println("@AfterEach - cleaning up..");
	}
	
	/**Doesn't need static if TestInstance.Lifecycle.PER_CLASS */
	@BeforeAll
	static void beforeAllinit() {
		System.out.println("@BeforeAll - beforeAllinit()..");
	}	
	
	/**
	 * BeforeAll works with static method because BeforeAll works before the class Initialization
	 */
	
	@Test
	void testAdd() {
		int expected = 14;
		int actual = mathUtils.add(7, 7);
		assertEquals(expected, actual, "The add() method should add two numbers");
	}
	
	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),"Divide by zero throws ArithmeticException");
	}
	
	
	@Test
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
	}
}
