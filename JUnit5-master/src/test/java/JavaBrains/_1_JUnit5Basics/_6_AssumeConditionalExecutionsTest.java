/**
 * 
 */
package JavaBrains._1_JUnit5Basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * @author Tousif
 * 
 */

public class _6_AssumeConditionalExecutionsTest {

	_1_MathUtils mathUtils;
	
	@BeforeEach
	void init() {
		mathUtils = new _1_MathUtils();
	}

	@Test
	void testAdd() {
		
		/**Some Mechanism to know server is up or down*/
		boolean isServerUp = false; //OR true
		
		/**Need Static Import
		 * TestAbortedException - if the assumption is not true
		 * But test case won't fail even if 'actual != expected' if assumption is not true
		 * This is used for external factors like server which is beyond our control */
		assumeTrue(isServerUp);
		
		int expected = 14;
		int actual = mathUtils.add(7, 7);
		assertEquals(expected, actual, "The add() method should add two numbers");
	}
	
	@Test
	@DisabledOnOs(OS.LINUX)
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),"Divide by zero throws ArithmeticException");
	}
	
	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
	}
	
}
