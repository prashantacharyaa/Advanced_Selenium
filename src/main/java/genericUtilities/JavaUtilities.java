package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtilities {
	// Generate Random Number
	public int getRandomNumber() {
		Random random = new Random();
		int randomInteger = random.nextInt(5000);
		return randomInteger;
	}

	// Get System Date
	public String getSystemDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = sdf.format(date);
		return currentDate;
	}

	// Get the required Date
	public String getExpectedDate_ddMMYYYY(int days) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String currentDate = sdf.format(date);
		Calendar cal = sdf.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String expectedDate = sdf.format(cal.getTime());
		System.out.println(expectedDate);
		return expectedDate;
	}
	// Get Data and Time for screenshot
	public String getSystemDateAndTimeForScreenshot() {
		String date = new Date().toString();
		String DateSS = date.replace(" ", "_").replace(":", "_");
		return DateSS;

		//Making changes for Pull request
	}
}
