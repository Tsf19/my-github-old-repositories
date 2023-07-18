/**
 * 
 */
package TutorialsPoint.Time;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * @author Tousif
 * 
 * A toInstant() method is added to the original Date and Calendar objects, 
 * which can be used to convert them to the new Date-Time API. 
 * Use an ofInstant(Insant,ZoneId) method to get a LocalDateTime or ZonedDateTime object.
 */
public class _6_BackwardCompatibility {

	public static void main(String[] args) {
		
		/**Get the current date*/
		Date today = new Date();
		System.out.println("Date() : " + today);
		//Date() : Wed Apr 17 12:45:15 IST 2019 -- WeekDay Month DD HH:MM:SS TimeZone YYYY

		Instant instantNow = Instant.now();
		System.out.println("Instant.now(): "+instantNow);
		//Instant.now(): 2019-04-17T07:15:15.301Z -- YYYY-MM-DD T HH:MM:SS.NNNZ
		/**
		 * The T is just a literal to separate the date from the time,
		 * and the Z means "zero hour offset" also known as "Zulu time"(UTC).
		 */
		
		/**Get the instant of current date in terms of milliseconds*/
		Instant instant = today.toInstant();
		System.out.println("Date to Instant: " + instant);
		//Date to Instant: 2019-04-17T07:15:15.288Z
		
		
		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("currentZone: " + currentZone);
		//currentZone: Asia/Kolkata
		
		/**Getting LocalDateTime from Instant using ZoneId*/
		LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, currentZone);
		System.out.println("Local date: " + localDateTime);
		//Local date: 2019-04-17T12:45:15.288

		/**Getting ZonedDateTime from Instant using ZoneId*/
		ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, currentZone);
		System.out.println("Zoned date: " + zonedDateTime);
		//Zoned date: 2019-04-17T12:45:15.288+05:30[Asia/Kolkata]
	}

}
