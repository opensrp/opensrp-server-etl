/**
 * 
 */
package org.opensrp.etl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author proshanto
 */
public class DateUtil {
	
	private final static SimpleDateFormat getYYYYMMDDFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private final static SimpleDateFormat getYYYYMMDDHHMMSSFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date getDateFromString(String string) throws ParseException {
		Date date = null;
		date = getYYYYMMDDFormat.parse(string);
		return date;
	}
	
	public static Date getDateTimeFromString(String string) throws ParseException {
		Date date = null;
		date = getYYYYMMDDHHMMSSFormat.parse(string);
		return date;
		
	}
	
}
