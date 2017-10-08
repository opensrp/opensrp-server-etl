/**
 * 
 */
package org.opensrp.etl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author proshanto
 *
 */
public class DateUtil {
	
	private  final static SimpleDateFormat getYYYYMMDDFormat = new SimpleDateFormat("yyyy-MM-dd");
	private final static SimpleDateFormat getYYYYMMDDHHMMSSFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static  Date getDateFromString(String string){
		Date date = null;
		try {
			date =getYYYYMMDDFormat.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}
	
	public static Date getDateTimeFromString(String string){
		Date date = null;
		try {
			date =getYYYYMMDDHHMMSSFormat.parse(string);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}

}
