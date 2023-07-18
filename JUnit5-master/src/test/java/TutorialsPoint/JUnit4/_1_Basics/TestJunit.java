/**
 * 
 */
package TutorialsPoint.JUnit4._1_Basics;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author Tousif
 *
 */

public class TestJunit {

	@Test
	public void testAdd() {
		String str = "Junit is working fine";
		assertEquals("Junit is working fine",str);
	}
}
