/**
 * 
 */
package org.unicef.etl.util;

/**
 * @author proshanto
 */
public class NumbertUtil {
	
	public static Integer convertToInteger(String str) {
		return Integer.parseInt(str);
	}
	
	public static Long convertToLong(String str) {
		return Long.parseLong(str);
	}
	
	public static Double convertToDouble(String str) {
		return Double.parseDouble(str);
	}
}
