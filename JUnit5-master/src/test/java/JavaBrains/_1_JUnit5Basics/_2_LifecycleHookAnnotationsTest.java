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

/**
 * @author Tousif
 *
 */
public class _2_LifecycleHookAnnotationsTest {

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
