package JavaBrains._1_JUnit5Basics;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

/**
 * @author Tousif
 *
 * @TestInfo_and_TestReporter are Java Interfaces, but we can use this interfaces directly 
 */
public class _12_TestInfoAndTestReporterTest {

	_1_MathUtils mathUtils;
	
	/**So that they are available to all the members*/
	TestInfo testInfo;
	TestReporter testReporter;
	
	@BeforeEach
	void init(TestInfo testInfo, TestReporter testReporter) {
		
		this.testInfo = testInfo;
		this.testReporter = testReporter;
		
//		testInfo.getClass()
//		testInfo.getDisplayName()
//		testInfo.getTags()
//		testInfo.getTestMethod()
//		testInfo.getTestClass()
		
		mathUtils = new _1_MathUtils();
	
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
	
	}


	@Test
	@DisplayName("Addition Method")
	@Tag("Math")
	void testAdd() {
		
		System.out.println("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
		
		testReporter.publishEntry("Running " + testInfo.getDisplayName() + " with tags " + testInfo.getTags());
		
		int expected = 14;
		int actual = mathUtils.add(7, 7);
		assertEquals(expected, actual, "The add() method should add two numbers");
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
