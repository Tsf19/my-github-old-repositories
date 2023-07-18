/**
 * 
 */
package JavaBrains._1_JUnit5Basics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * @author Tousif
 * 
 */

public class _7_NestedAnnotationTest {

	_1_MathUtils mathUtils;
	
	@BeforeEach
	void init() {
		mathUtils = new _1_MathUtils();
	}

	@Nested
	@DisplayName("addTest Methods")
	class AddTest {
		
		@Test
		void addTest() {
			
			boolean isServerUp = false; //OR true
			
			assumeTrue(isServerUp);
			
			int expected = 14;
			int actual = mathUtils.add(7, 7);
			assertEquals(expected, actual, "The add() method should add two numbers");
		}
		
		@Test
		@DisplayName("Adding Positive")
		void testAddPositive() {
			assertEquals(2, mathUtils.add(1, 1),"Should return sum");
		}
		
		@Test
		@DisplayName("Adding Negative")
		void testAddNegative() {
			assertEquals(-2, mathUtils.add(-1, -1),"Should return sum");
		}
		
	}
	
	@Test
	@DisabledOnOs(OS.WINDOWS)
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0),"Divide by zero throws ArithmeticException");
	}
	
	
	@Test
	@EnabledOnOs(OS.LINUX)
	void testComputeCircleArea() {
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return circle area");
	}
	
}
