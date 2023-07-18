/**
 * 
 */
package TutorialsPoint.Time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Tousif
 *
 */
public class _3_DateTimeFormatter {

	public static void main(String[] args) {
		
		
	    /**Will give us the current time and date*/ 
	    LocalDateTime localDateTimeNow = LocalDateTime.now(); 
	    System.out.println("Current Date & Time : "+ localDateTimeNow);
	    //Current Date & Time : 2019-04-21T02:25:13.250
		
	    
	    /**To print in a particular format*/
	    DateTimeFormatter format =  DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");   
	    System.out.println("Format : " + format);
	    //Format : Value(DayOfMonth,2)'-'Value(MonthOfYear,2)'-'Value(YearOfEra,4,19,EXCEEDS_PAD)' 'Value(HourOfDay,2)':'Value(MinuteOfHour,2)':'Value(SecondOfMinute,2)
	    
	    String formatedDateTime = localDateTimeNow.format(format);   
	     
	    System.out.println("In dd-MM-yyyy HH:mm:ss Foramatted Manner : "+ formatedDateTime);
	    //In dd-MM-yyyy HH:mm:ss Foramatted Manner : 21-04-2019 02:27:01
	    
	    /**We can shuffle "MM-dd-yyyy HH:mm:ss" however we want, but it's case-sensitive*/
	    format =  DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");
	    formatedDateTime = localDateTimeNow.format(format);
	    System.out.println("In MM-dd-yyyy HH:mm:ss Foramatted Manner : "+ formatedDateTime);
	    //In MM-dd-yyyy HH:mm:ss Foramatted Manner : 04-21-2019 02:31:36
	    
	    format =  DateTimeFormatter.ofPattern("MM-dd-yyyy ss:mm:HH");
	    formatedDateTime = localDateTimeNow.format(format);
	    System.out.println("In MM-dd-yyyy ss:mm:HH Foramatted Manner : "+ formatedDateTime);
	    //In MM-dd-yyyy ss:mm:HH Foramatted Manner : 04-21-2019 36:31:02
	}
}
