/**
 * 
 */
package agile.planner.util;

import java.util.Calendar;

/**
 * 
 * 
 * @author Andrew Roe
 */
public class Time {
	
	public static int determineRangeOfDays(Calendar date1, Calendar date2) {
		long milliseconds = Math.abs(date1.getTimeInMillis() - date2.getTimeInMillis());
		return (int) Math.round((milliseconds / 1000.0 / 3600.0 / 24.0));
	}
	
	public static Calendar getFormattedCalendarInstance(int days) {
		Calendar date = Calendar.getInstance();
		date.add(Calendar.DAY_OF_MONTH, days);
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
		return date;
	}

}
