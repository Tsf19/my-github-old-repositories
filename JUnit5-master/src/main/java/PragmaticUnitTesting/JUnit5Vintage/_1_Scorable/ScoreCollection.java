/**
 * 
 */
package PragmaticUnitTesting.JUnit5Vintage._1_Scorable;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tousif
 *
 */
public class ScoreCollection {

	private List<Scoreable> scores = new ArrayList<Scoreable>();
	
	public void add(Scoreable scoreable) {
		scores.add(scoreable);
	}
	
	public int arithmeticMean() {
		int total = scores.stream().mapToInt(Scoreable::getScore).sum();
		return total/scores.size();
	}
	
}
