/**
 * 
 */
package JavaBrains._1_JUnit5Basics;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author Tousif
 *
 */
public class _4_DisplayNameAndDisabledTest {

	
	_1_MathUtils mathUtils;
	
	@BeforeEach
	void init() {
		mathUtils = new _1_MathUtils();
	}

	/**
	 * @DisplayName is used to declare a custom display name for the annotated test class or test method.
	 */
	@Test
	@DisplayName("Addition Method") 
	void testAdd() {
		int expected = 14;
		int actual = mathUtils.add(7, 7);
		assertEquals(expected, actual, "The add() method should add two numbers");
	}
	
	/**
	 * @Disabled is used to signal that the annotated test class or test method is currently disabled 
	 * and should not be executed.
	 * When applied at the class level, all test methods within that class are automatically disabled as well.
	 */
	@Test
	@Disabled
	@DisplayName("Disabled Method") 
	void testDisabled() {
		fail("This Test Should be Disabled");
	}
	
	@Test
	@DisplayName("Division Method") 
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),"Divide by zero throws ArithmeticException");
	}
	
	
	@Test
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
	}
	
}
