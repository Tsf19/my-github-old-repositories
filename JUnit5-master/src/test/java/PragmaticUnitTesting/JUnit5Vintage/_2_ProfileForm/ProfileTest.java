/**
 * 
 */
package PragmaticUnitTesting.JUnit5Vintage._2_ProfileForm;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import PragmaticUnitTesting.JUnit5Vintage._2_ProfileForm.Answer;
import PragmaticUnitTesting.JUnit5Vintage._2_ProfileForm.Bool;
import PragmaticUnitTesting.JUnit5Vintage._2_ProfileForm.BooleanQuestion;
import PragmaticUnitTesting.JUnit5Vintage._2_ProfileForm.Criteria;
import PragmaticUnitTesting.JUnit5Vintage._2_ProfileForm.Criterion;
import PragmaticUnitTesting.JUnit5Vintage._2_ProfileForm.Profile;
import PragmaticUnitTesting.JUnit5Vintage._2_ProfileForm.Weight;


/**
 * @author Tousif
 *
 */
public class ProfileTest {

	private Profile profile;
	private BooleanQuestion question;
	private Criteria criteria;

	@Before
	public void create() {
		profile = new Profile("Tousif Memon");
		question = new BooleanQuestion(1, "Got bonuses?");
		criteria = new Criteria();
	}
	
	@Test
	public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {

		profile.add(new Answer(question, Bool.FALSE));
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		criteria.add(new Criterion(criteriaAnswer, Weight.MustMatch));

		boolean matches = profile.matches(criteria);
		assertFalse(matches);

	}

	@Test
	public void matchAnswersTrueForAnyDontCareCriteria() {
		
		profile.add(new Answer(question, Bool.FALSE));
		Answer criteriaAnswer = new Answer(question, Bool.TRUE);
		criteria.add(new Criterion(criteriaAnswer, Weight.DontCare));
		
		boolean matches = profile.matches(criteria);
		assertTrue(matches);
	}
}
