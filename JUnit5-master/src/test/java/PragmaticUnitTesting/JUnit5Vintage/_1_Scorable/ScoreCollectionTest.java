package PragmaticUnitTesting.JUnit5Vintage._1_Scorable;

import org.junit.Test;

import PragmaticUnitTesting.JUnit5Vintage._1_Scorable.ScoreCollection;

//import static org.junit.Assert.*;
//import org.junit.Ignore;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;


/**
 * @author Tousif
 *
 */
public class ScoreCollectionTest {

	@Test
//	@Ignore("Don't forget me")
	public void answersArithmeticMeanOfTwoNumbers() {
	
		ScoreCollection collection = new ScoreCollection();
		
		// Arrange
		collection.add(() -> 5);
		collection.add(() -> 7);

		//Act
		int actualResult = collection.arithmeticMean();
		
		//Assert
		/**
		 * To use the equalTo matcher, make sure you use a
		 * static import for org.ham-crest.CoreMatchers 
		 */
		assertThat(actualResult, equalTo(6));
		
	}

}