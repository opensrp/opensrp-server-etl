package org.mcare.schedule.monitoring.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mcare.schedule.monitoring.service.impl.ANCScheduleMonitoringServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ScheduleMonitoringUtil {
	
	public ScheduleMonitoringUtil() {
		
	}
	
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
			} else if ("normal".equalsIgnoreCase(scheduleStringToArray[0])) {
				map.put("bgColor", "green");
				map.put("message", "");
				map.put("visitCode", scheduleStringToArray[3]);
				map.put("date", scheduleStringToArray[1]);
			}
		}
		return map;
		
	}
	
	public List<Object[]> getSubmittedScheduleData(String provider, String caseId,
	                                               ANCScheduleMonitoringServiceImpl ancScheduleMonitoringServiceImpl) {
		
		return ancScheduleMonitoringServiceImpl.getSubmittedScheduleData(provider, caseId);
	}
	
	private static Map<String, String> colorMap = new HashMap<>();
	static {
		
		colorMap.put("normal", "green");
		colorMap.put("upcoming", "yellow");
		colorMap.put("urgent", "red");
		
	}
	
	public static StringBuilder getScheduleDate(List<Object[]> objects) {
		String filteredVisitCode = "";
		String s = "";
		StringBuilder sb = new StringBuilder();
		for (Object[] object : objects) {
			filteredVisitCode = object[2].toString();
			if (filteredVisitCode.equalsIgnoreCase("ancrv_1")) {
				sb.append("<span style=background-color:" + colorMap.get(object[3]) + ">ANC1: " + object[1].toString()
				        + "</span><br/>");
				
			} else if (filteredVisitCode.equalsIgnoreCase("ancrv_2")) {
				//message += "ANC2: " + object[1].toString() + "<br/>";
				sb.append("<span style=background-color:" + colorMap.get(object[3]) + ">ANC2: " + object[1].toString()
				        + "</span><br/>");
			} else if (filteredVisitCode.equalsIgnoreCase("ancrv_3")) {
				//message += "ANC3: " + object[1].toString() + "<br/>";
				sb.append("<span style=background-color:" + colorMap.get(object[3]) + ">ANC3: " + object[1].toString()
				        + "</span><br/>");
			} else if (filteredVisitCode.equalsIgnoreCase("ancrv_4")) {
				//message += "ANC4: " + object[1].toString();
				sb.append("<span style=background-color:" + colorMap.get(object[3]) + ">ANC4: " + object[1].toString()
				        + "</span>");
			} else {
				
			}
			
		}
		return sb;
		
	}
}
