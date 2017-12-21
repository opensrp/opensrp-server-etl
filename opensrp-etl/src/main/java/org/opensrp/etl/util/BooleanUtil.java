package org.opensrp.etl.util;

public class BooleanUtil {

    public BooleanUtil() {
        // TODO Auto-generated constructor stub
    }
    
    public static Boolean convertToBoolean(String str) {
        if(str.equalsIgnoreCase("true")) {
            return Boolean.valueOf("true");
        } else {
            return Boolean.valueOf("false");
        }
    }

}
