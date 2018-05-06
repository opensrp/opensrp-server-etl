/**
 * 
 */
package org.mcare.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author proshanto
 */
public class DateUtil {
	
	public static DateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date parseDate(String date) throws ParseException {
		try {
			return yyyyMMdd.parse(date);
		}
		catch (ParseException e) {}
		return null;
		
	}
	
	public static List<Integer> getYearList() {
		List<Integer> years = new ArrayList<Integer>();
		Integer startYear = 2017;
		Integer currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int yearDiff = currentYear - startYear;
		for (int i = 0; i <= yearDiff; i++) {
			years.add(currentYear - i);
		}
		return years;
		
	}
	
}
