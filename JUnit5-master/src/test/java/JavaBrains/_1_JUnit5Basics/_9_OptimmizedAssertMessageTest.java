/**
 * 
 */
package JavaBrains._1_JUnit5Basics;

import static org.junit.jupiter.api.Assertions.assertAll;
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

public class _9_OptimmizedAssertMessageTest {

	_1_MathUtils mathUtils;
	
	@BeforeEach
	void init() {
		mathUtils = new _1_MathUtils();
	}

	@Nested
	@DisplayName("addTest Methods")
	class AddTest {
		
		@Test
		@DisplayName("Adding")
		void testAdd1() {
			
			int expected = 5;
			int actual = mathUtils.add(2, 2);
			/**We are passing all 3 arguments to assertEquals() and then it's computed
			 * irrespective of whether test passes or fails, string is being created and 
			 * displayed when assertEquals() fails
			 * NOT EFFICIENT*/
			assertEquals(expected, actual ,"Should return sum " + expected + " but returned " + actual);
		}
		
		@Test
		@DisplayName("Adding")
		void testAdd2() {
			
			int expected = 5;
			int actual = mathUtils.add(2, 2);
			/**We can reduce String Computation using Lambdas,
			 * Instead of String we can pass a function which generates a string,
			 * if assertEquals() fails then only function will be called and String will be generated
			 * OPTIMIZED*/
			assertEquals(expected, actual , () -> "Should return sum " + expected + " but returned " + actual);
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
	@DisplayName("Multiply Method")
	void testMultiply() {
//		assertEquals(4, mathUtils.multiply(2, 2),"Should return product");
		
		assertAll(
				() -> assertEquals(4, mathUtils.multiply(2, 2),"Should return product"),
				() -> assertEquals(0, mathUtils.multiply(4, 0),"Should return product"),
				() -> assertEquals(-16, mathUtils.multiply(8, -2),"Should return product")
				);
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
