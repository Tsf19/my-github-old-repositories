/**
 * 
 */
package TutorialsPoint.Time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * @author Tousif
 *
 * Java 8 introduces a new date-time API under the package java.time.
 * Following are some of the important classes introduced in java.time package.
 * 	Local − Simplified date-time API with no complexity of timezone handling.
 * 	Zoned − Specialized date-time API to deal with various timezones.
 * 
 */
public class _1_LocalDateTimeAPI {

	public static void main(String[] args) {

		LocalDateTime localDateTimeNow = LocalDateTime.now();
		System.out.println("CurrentDateTime(localDateTimeNow) : " + localDateTimeNow);
		//2019-04-16T17:40:15.612 - YYYY-MM-DDTHH:MM:SS.NNN

		
		LocalDate localDate = localDateTimeNow.toLocalDate();
		System.out.println("localDate(Date) : " + localDate);
		//2019-04-16 - YYYY-MM-DD

		
		Month month1 = localDateTimeNow.getMonth();
		int day1 = localDateTimeNow.getDayOfMonth();
		int seconds1 = localDateTimeNow.getSecond();
		System.out.println("Month: " + month1 +" day: " + day1 +" seconds: " + seconds1);
		//Month: APRIL day: 16 seconds: 13

		
		Month month2 = localDate.getMonth();
		int day2 = localDate.getDayOfMonth();
		//int seconds2 = localDate.getSecond(); //<--ERROR
		System.out.println("Month: " + month2 +" day: " + day2);
		//Month: APRIL day: 16

		/**Printing specific date with current time*/
		LocalDateTime localDateTimeNow2 = localDateTimeNow.withDayOfMonth(10).withYear(2012);
		System.out.println("localDateTimeNow2: " + localDateTimeNow2);
		//localDateTimeNow2: 2012-04-10T17:52:43.544
		
		
		LocalDate localDate3 = LocalDate.of(2014, Month.DECEMBER, 12);
		System.out.println("localDate3: " + localDate3);
		//2014-12-12

		
		LocalTime localTime1 = LocalTime.of(22, 15);
		System.out.println("localTime: " + localTime1);
		//localTime1: 22:15 --> 22 hour 15 minutes

		
		/**parse a string*/
		LocalTime localTime2 = LocalTime.parse("22:15:30");
		System.out.println("localTime: " + localTime2);
		//localTime: 20:15:30
		
	}
}