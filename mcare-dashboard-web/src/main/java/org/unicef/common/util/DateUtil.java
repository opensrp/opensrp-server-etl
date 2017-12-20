/**
 * 
 */
package org.unicef.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author proshanto
 */
public class DateUtil {
	
	public static DateFormat yyyyMMdd = new SimpleDateFormat("yyyy-MM-dd");
	
	public static Date parseDate(String date) throws ParseException {
		System.err.println("Date:" + date);
		try {
			return yyyyMMdd.parse(date);
		}
		catch (ParseException e) {}
		return null;
		
	}
}
