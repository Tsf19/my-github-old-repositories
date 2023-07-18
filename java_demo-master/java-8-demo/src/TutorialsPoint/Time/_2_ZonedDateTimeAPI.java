/**
 * 
 */
package TutorialsPoint.Time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author Tousif
 * @ZONED_DATE_TIME_API
 * Zoned date-time API is to be used when time zone is to be considered.
 */
public class _2_ZonedDateTimeAPI {

	public static void main(String[] args) {
		
		/**Get the current date and time*/
		ZonedDateTime zonedDateTime = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
		System.out.println("zonedDateTime: " + zonedDateTime);
		//zonedDateTime: 2007-12-03T10:15:30+05:00[Asia/Karachi]

		ZoneId zoneId = ZoneId.of("Europe/Paris");
		System.out.println("ZoneId: " + zoneId);
		//ZoneId: Europe/Paris

		ZoneId zoneId2 = ZoneId.of("Asia/Kolkata");
		System.out.println("ZoneId: " + zoneId2);
		//ZoneId: Asia/Kolkata
		
		ZoneId currentZone = ZoneId.systemDefault();
		System.out.println("CurrentZone: " + currentZone);
		//CurrentZone: Asia/Kolkata
	
	}

}
