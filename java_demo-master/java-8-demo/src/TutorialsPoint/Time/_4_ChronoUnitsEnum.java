/**
 * 
 */
package TutorialsPoint.Time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @author Tousif
 * java.time.temporal.ChronoUnit enum is added in Java 8 to replace the integer values
 * used in old API to represent day, month, etc. Let us see them in action.
 */
public class _4_ChronoUnitsEnum {

	public static void main(String[] args) {

		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);
		//Current date: 2019-04-17

		/**add 1 week to the current date*/
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Next week: " + nextWeek);
		//Next week: 2019-04-24
		
		LocalDate nextWeek2 = today.plusWeeks(1);
		System.out.println("Next week: " + nextWeek2);
		//Next week: 2019-04-24

		LocalDate previousWeek = today.minus(1, ChronoUnit.WEEKS);
		System.out.println("Previous Week: " + previousWeek);
		//Previous Week: 2019-04-10
		
		LocalDate previousWeek2 = today.minusWeeks(1);
		System.out.println("Previous Week: " + previousWeek2);
		//Previous Week: 2019-04-10
		
		/**add 1 month to the current date*/
		LocalDate nextMonth = today.plus(1, ChronoUnit.MONTHS);
		System.out.println("Next month: " + nextMonth);
		//Next month: 2019-05-17

		/**add 1 year to the current date*/
		LocalDate nextYear = today.plus(1, ChronoUnit.YEARS);
		System.out.println("Next year: " + nextYear);
		//Next year: 2020-04-17

		/**add 10 years to the current date*/
		LocalDate nextDecade = today.plus(1, ChronoUnit.DECADES);
		System.out.println("Date after ten year: " + nextDecade);
		//Date after ten year: 2029-04-17
	}

}
