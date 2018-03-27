package org.mcare.schedule.monitoring.utils;

import java.util.HashMap;
import java.util.Map;

public class ScheduleMonitoringUtil {
	
	public static Map<String, String> getScheduleStatus(String schedule) {
		Map<String, String> map = new HashMap<>();
		
		String[] scheduleStringToArray = schedule.split(",");
		
		if ("f".equalsIgnoreCase(scheduleStringToArray[2])) {
			map.put("status", "false");
			map.put("bgColor", "green");
			map.put("message", "");
			map.put("date", "");
			map.put("visitCode", "");
		} else {
			if ("urgent".equalsIgnoreCase(scheduleStringToArray[0])) {
				map.put("bgColor", "red");
				map.put("message", "");
				map.put("date", scheduleStringToArray[1]);
				map.put("visitCode", scheduleStringToArray[3]);
			} else if ("upcoming".equalsIgnoreCase(scheduleStringToArray[0])) {
				map.put("bgColor", "yellow");
				map.put("message", "");
				map.put("visitCode", scheduleStringToArray[3]);
				map.put("date", scheduleStringToArray[1]);
			} else if ("expired".equalsIgnoreCase(scheduleStringToArray[0])) {
				map.put("bgColor", "red");
				map.put("message", "expired");
				map.put("visitCode", scheduleStringToArray[3]);
				map.put("date", scheduleStringToArray[1]);
			}
		}
		return map;
		
	}
}
