/**
 * 
 */
package org.opensrp.etl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author proshanto
 */
public class DateUtil {
	
	private final static SimpleDateFormat getYYYYMMDDFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private final static SimpleDateFormat getYYYYMMDDHHMMSSFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static Date getDateFromString(JSONObject doc, String key) throws ParseException, JSONException {
		Date date = null;
		if (doc.has(key) && !"null".equalsIgnoreCase(doc.getString(key)) && !doc.getString(key).isEmpty()) {
			date = getYYYYMMDDFormat.parse(doc.getString(key));
			return date;
		}
		return date;
	}
	
	public static Date getDateTimeFromString(JSONObject doc, String key) throws ParseException, JSONException {
		Date date = null;
		if (doc.has(key) && !"null".equalsIgnoreCase(doc.getString(key)) && !doc.getString(key).isEmpty()) {
			date = getYYYYMMDDHHMMSSFormat.parse(doc.getString(key));
		}
		return date;
	}
	
}
