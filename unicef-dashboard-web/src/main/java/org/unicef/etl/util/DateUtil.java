/**
 * 
 */
package org.unicef.etl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author proshanto, sohel
 */
public class DateUtil {
	
	private final static SimpleDateFormat getDDMMYYYYFormat = new SimpleDateFormat("dd-MM-yyyy");
	
	private final static SimpleDateFormat getYYYYMMDDFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private final static SimpleDateFormat getYYYYMMDDHHMMSSFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private final static SimpleDateFormat getEddMMMyyyyhhmmssz = new SimpleDateFormat("E, dd MMM yyyy hh:mm:ss z");
	
	private final static SimpleDateFormat getYYYYMMDDTHHMMSSFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss");
	
	public static Date getDateFromString(JSONObject doc, String key) throws ParseException, JSONException {
		Date date = null;
		if (doc.has(key) && !"null".equalsIgnoreCase(doc.getString(key)) && !doc.getString(key).isEmpty()) {
			date = getYYYYMMDDFormat.parse(doc.getString(key));
			return date;
		}
		return date;
	}
	
	public static Date getStringToDate( String str) throws ParseException, JSONException {
		Date date = null;
		if (!"null".equalsIgnoreCase(str) && !str.isEmpty()) {
			date = getYYYYMMDDFormat.parse(str);
			return date;
		}
		return date;
	}
	
	public static Date getDDMMYYYYDateFromString(JSONObject doc, String key) throws ParseException, JSONException {
		Date date = null;
		if (doc.has(key) && !"null".equalsIgnoreCase(doc.getString(key)) && !doc.getString(key).isEmpty()) {
			date = getDDMMYYYYFormat.parse(doc.getString(key));
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
	
	public static Date getDateFromGMTString(JSONObject doc, String key) throws ParseException, JSONException {
		Date date = null;
		
		if (doc.has(key) && !"null".equalsIgnoreCase(doc.getString(key)) && !doc.getString(key).isEmpty()
		        && !"Invalid Date".equalsIgnoreCase(doc.getString(key))) {
			date = getEddMMMyyyyhhmmssz.parse(doc.getString(key));
			return getYYYYMMDDFormat.parse(getYYYYMMDDFormat.format(date));
		}
		return date;
	}
	
	public static Date getDateTFromString(JSONObject doc, String key) throws ParseException, JSONException {
		Date date = null;
		if (doc.has(key) && !"null".equalsIgnoreCase(doc.getString(key)) && !doc.getString(key).isEmpty()) {
			date = getYYYYMMDDTHHMMSSFormat.parse(doc.getString(key));
			return date;
		}
		return date;
	}
	
}
