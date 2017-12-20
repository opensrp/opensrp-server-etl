/**
 * 
 */
package org.opensrp.etl.util;

/**
 * @author proshanto
 */
public class NumbertUtil {

    public static Integer convertToInteger(String str) {
        if (!isNaN(str)){
            return Integer.parseInt(str);
        } else {
            return 0;
        }
    }

    public static Long convertToLong(String str) {
        if (!isNaN(str)){
            return Long.parseLong(str);
        } else {
            return 0L;
        }
    }

    public static Double convertToDouble(String str) {
        if (!isNaN(str)){
            return Double.parseDouble(str);
        } else {
            return 0.0;
        }
    }

    private static boolean isNaN(String str) {
        if (str.equalsIgnoreCase("NaN")) {
            return true;
        }
        return false;
    }
}
