package assignment;

/*The Task:
A friend of yours is having some issues to pay his rent and energy on time. He always forgets which day he is 
supposed to pay it. So he asks you to create a program that creates a sheet for him which contains the dates on 
which he has to transfer the money.
Requirements:
 The rent has to be paid monthly. Always at the last day of the month, unless that day is a weekend 
(Saturday or Sunday). In this case, the rent must be paid before the weekend. (You don’t have to worry about 
public holidays for this solution)
 The energy is paid monthly too, but at the 10th of a month, unless this day is a weekend (Saturday or Sunday). 
In this case, the money should be paid on the following Tuesday after the weekend.
 Your program should receive a file name that should be used to output the calculation.
 The output file should be a .csv file containing the dates your friend has to pay his rent and energy for the 
next year. Example: If today is 15.10.2015, it should calculate from October 2015 until September 2016.
 The csv file should have three columns: name of the month, day of the month the rent should be paid on and day 
of the month the energy should be paid on.

Example Output:
Month Pay Rent Pay Energy
July     29th    12th 
August   31th    10th
…
…
…
*/
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @References from http://tutorials.jenkov.com/java-date-time/java-util-calendar.html
 * @References from http://stackoverflow.com/questions/3666007/how-to-serialize-object-to-csv-file
 * @author nirozjung
 *
 */
public class DayTracker {
	// Delimiter used in CSV file
	private static final int  totalMonths = 12;
	private static final String COMMA_DELIMITER = ",";

	// CSV file header
	private static final String FILE_HEADER = "Month,  Pay rent,  Pay Energy";
	private static final String file = "/Users/nirozjungkarki/Desktop/test.csv";

	public static void main(String[] args) throws IOException {

		// Initialize Calendar with current date
		Date startDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(startDate);
		
		PaymentDate pdo = new PaymentDate();
		
		ArrayList<PaymentDate> paymentDateList =new ArrayList<PaymentDate>();;
		// constructing PaymentDate objects for every months upto year
		for (int i = 0; i < totalMonths; i++) {
			
			pdo.setMonth(calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
			
			calendar.setTime(rentPaymentDate(calendar.getTime()));
			pdo.setRentPaymentDay(calendar.get(Calendar.DAY_OF_MONTH));
			
			calendar.setTime(energyPaymentDate(calendar.getTime()));
			pdo.setEnergyPaymentDay(calendar.get(Calendar.DAY_OF_MONTH));
			System.out.println(pdo.toString());
			paymentDateList.add(new PaymentDate(pdo.getMonth(),pdo.getRentPaymentDay(),pdo.getEnergyPaymentDay()));
			calendar.add(Calendar.MONTH, 1); // incrementing month
		} // end loop

		writeToCSV(file,paymentDateList);
	
	} // end main method

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

	// Calculate Energy payment date : 10th day of a month: if Sat/Sun,  Switch to Tuesday
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
	// method to print CSV
	public static void writeToCSV(String fileName, ArrayList<PaymentDate> paymentDateList) {
		try
        {
		// FileOutputStream fos=new FileOutputStream(file);
		// OutputStreamWriter osw = new OutputStreamWriter(fos);
        // BufferedWriter bw = new BufferedWriter(osw);
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8")); 
		 
		 StringBuffer header=new StringBuffer();
		 header.append(FILE_HEADER);
		 bw.write(header.toString());
		 bw.newLine();
		 for (PaymentDate pd : paymentDateList)
            {	 StringBuffer oneLine = new StringBuffer();
                oneLine.append(pd.getMonth());
                oneLine.append(COMMA_DELIMITER);
                oneLine.append(pd.getRentPaymentDay());
                oneLine.append(COMMA_DELIMITER);
                oneLine.append(pd.getEnergyPaymentDay());
                oneLine.append(COMMA_DELIMITER);
                bw.write(oneLine.toString());
                bw.newLine(); 
            }
            bw.flush();
            bw.close();
        }
        catch (UnsupportedEncodingException e) { e.printStackTrace();}
        catch (FileNotFoundException e){ e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
} // end method writeCsvFile
	
	public static void printArrayList(ArrayList<PaymentDate> pd){
		for (PaymentDate paydate : pd){
			System.out.println(paydate.toString());
		}
	} // end method printArrayList

	}// end class
