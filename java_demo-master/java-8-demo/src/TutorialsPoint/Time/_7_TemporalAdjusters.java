/**
 * 
 */
package TutorialsPoint.Time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * @author Tousif
 *
 */
public class _7_TemporalAdjusters {

	public static void main(String[] args) {
		
		/**Get the current date*/
		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);
		//Current date: 2019-04-17

		/**get the next tuesday*/
		LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		System.out.println("Next Monday on : " + nextMonday);
		//Next Monday on : 2019-04-22

		/**get the second saturday of next month*/
		LocalDate firstOfMonth = LocalDate.of(today.getYear(),today.getMonth(), 1);
		System.out.println("First Of Month: "+firstOfMonth);
		//First Of Month: 2019-04-01
		
		LocalDate secondSaturday = firstOfMonth.with(TemporalAdjusters.nextOrSame(
				DayOfWeek.SATURDAY)).with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
		System.out.println("Second Saturday on : " + secondSaturday);
		//Second Saturday on : 2019-04-13
	}
}
