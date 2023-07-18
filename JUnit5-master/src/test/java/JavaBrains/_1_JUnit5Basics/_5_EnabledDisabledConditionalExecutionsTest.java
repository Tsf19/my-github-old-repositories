/**
 * 
 */
package JavaBrains._1_JUnit5Basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * @author Tousif
 * 
 * @EnabledOnOs is used to signal that the annotated test class or test method 
 * is only enabled on one or more specified operating systems. 
 *  
 * @DisabledOnOs is used to signal that the annotated test class or test method
 * is disabled on one or more specified operating systems.
 * 
 * @EnabledOnJre is used to signal that the annotated test class or test method is 
 * only enabled on one or more specified Java Runtime Environment (JRE) versions.
 * 
 * @DisabledOnJre is used to signal that the annotated test class or test method is
 *  disabled on one or more specified Java Runtime Environment (JRE) versions.
 *  
 * @EnabledIf is used to determine whether the annotated test class or test method 
 * is enabled by evaluating a script.
 *  
 * @EnabledIfSystemProperty is used to signal that the annotated test class or test 
 *  method is only enabled if the value of the specified system property matches the 
 *  specified regular expression.
 *  
 * @EnabledIfEnvironmentVariable is used to signal that the annotated test class or 
 * test method is only enabled if the value of the specified environment variable 
 * matches the specified regular expression.
 *  
 */

public class _5_EnabledDisabledConditionalExecutionsTest {

	_1_MathUtils mathUtils;
	
	@BeforeEach
	void init() {
		mathUtils = new _1_MathUtils();
	}

	/**
	 * @EnabledOnOs is used to signal that the annotated test class or test method 
	 * is only enabled on one or more specified operating systems. 
	 */	
	@Test
	@EnabledOnOs(OS.WINDOWS)
	void testAdd() {
		int expected = 14;
		int actual = mathUtils.add(7, 7);
		assertEquals(expected, actual, "The add() method should add two numbers");
	}
	
	/**
	 * @DisabledOnOs is used to signal that the annotated test class or test method
	 * is disabled on one or more specified operating systems.
	 */	
	@Test
	@DisabledOnOs(OS.LINUX)
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),"Divide by zero throws ArithmeticException");
	}
	
	
	@Test
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
	}
	
}
