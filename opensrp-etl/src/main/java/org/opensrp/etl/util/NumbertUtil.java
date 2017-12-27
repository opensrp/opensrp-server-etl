/**
 * 
 */
package org.opensrp.etl.util;

/**
 * @author proshanto
 */
public class NumbertUtil {

    public static Integer convertToInteger(String str) {
        if (!isNaN(str)) {
            int i = 0;
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException ex) {

            }
            return i;
        } else {
            return 0;
        }
    }

    public static Long convertToLong(String str) {
        if (!isNaN(str)) {
            long i = 0L;
            try {
                i = Long.parseLong(str);
            } catch (NumberFormatException ex) {

            }
            return i;
        } else {
            return 0L;
        }
    }

    public static Double convertToDouble(String str) {
        if (!isNaN(str)) {
            double i = 0.0;
            try {
                i = Double.parseDouble(str);
            } catch (NumberFormatException ex) {

            }
            return i;
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
