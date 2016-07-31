package assignment;

import java.util.Calendar;
import java.util.Date;

/** Class that contains methods to calculate dates for Rent and energy Payment with input as Date. 
 * @author nirozjungkarki
 * @since 2016-07-20
 */
public class DayTracker {
	
	// method to calculate date for rent payment
	public static Date rentPaymentDate(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int lastday = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DAY_OF_MONTH, lastday);

		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			calendar.add(Calendar.DAY_OF_MONTH, -2);
			return calendar.getTime();
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			return calendar.getTime();
		} else {
			return calendar.getTime();
		}
	} // end rentPaymentDate method

	// Calculate Energy payment date : 10th day of a month: if Sat/Sun, Switch
	// to Tuesday
	public static Date energyPaymentDate(Date date) {
		int tenthdayofMonth = 10;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, tenthdayofMonth);

		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			calendar.add(Calendar.DAY_OF_MONTH, +2);
			return calendar.getTime();
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			calendar.add(Calendar.DAY_OF_MONTH, +3);
			return calendar.getTime();
		} else {
			return calendar.getTime();
		}
	} // end energyPayment method

}// end class
