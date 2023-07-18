/**
 * 
 */
package TutorialsPoint.JUnit4._1_Basics;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author Tousif
 *
 */

public class TestRunner {
   
	public static void main(String[] args) {
	   
      Result result = JUnitCore.runClasses(TestJunit.class);
		
      for (Failure failure : result.getFailures()) {
         System.out.println(failure.toString());
      }
		
      System.out.println(result.wasSuccessful());
   }
}  