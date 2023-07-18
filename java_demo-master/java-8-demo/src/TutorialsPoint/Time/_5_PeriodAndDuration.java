/**
 * 
 */
package TutorialsPoint.Time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author Tousif
 *
 */
public class _5_PeriodAndDuration {

	public static void main(String[] args) {
		
		/**Get the current date*/
		LocalDate today = LocalDate.now();
		System.out.println("Current date: " + today);
		//Current date: 2019-04-17

		/**add 7 month to the current date*/
		LocalDate date2 = today.plus(7, ChronoUnit.MONTHS);
		System.out.println("Date after 7 months: " + date2);
		//Date after 7 months: 2019-11-17

		Period period = Period.between(date2, today);
		System.out.println("Period between Current date and Date after 7 months: " + period);
		//Period between Current date and Date after 7 months: P-7M

		
		LocalTime now = LocalTime.now();
		System.out.println("Time now is: "+now);
		//Time now is: 11:41:46.224

		Duration twoHours = Duration.ofHours(2);
		System.out.println("Duration of Two hours is : "+twoHours);
		//Duration of Two hours is : PT2H

		LocalTime nowPlus = now.plus(twoHours);
		Duration durationBetween = Duration.between(now, nowPlus);
		System.out.println("Duration Between Now and Two Hours is: " + durationBetween);
		//Duration Between Now and Two Hours is: PT2H
	}

}
