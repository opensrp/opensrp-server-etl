package org.mcare.schedule.monitoring.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mcare.schedule.monitoring.service.ScheduleMonitoringService;
import org.springframework.stereotype.Service;

@Service
public class ScheduleMonitoringUtil {
	
	public ScheduleMonitoringUtil() {
		
	}
	
	public static Map<String, String> getScheduleStatus(String schedule) {
		Map<String, String> map = new HashMap<>();
		
		if (!schedule.isEmpty()) {
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
					map.put("bgColor", "");
					map.put("message", "expired");
					map.put("visitCode", "");
					map.put("date", "");
				} else if ("normal".equalsIgnoreCase(scheduleStringToArray[0])) {
					map.put("bgColor", "green");
					map.put("message", "");
					map.put("visitCode", scheduleStringToArray[3]);
					map.put("date", scheduleStringToArray[1]);
				}
			}
		} else {
			map.put("visitCode", "");
			map.put("date", "");
			map.put("bgColor", "");
			map.put("message", "expired");
			
		}
		return map;
		
	}
	
	public List<Object[]> getSubmittedScheduleData(String provider, String caseId,
	                                               ScheduleMonitoringService scheduleMonitoringService) {
		
		return scheduleMonitoringService.getSubmittedScheduleData(provider, caseId);
	}
	
	private static Map<String, String> colorMap = new HashMap<>();
	static {
		colorMap.put("normal", "green");
		colorMap.put("upcoming", "Gold");
		colorMap.put("urgent", "red");
	}
	
	public static String getScheduleSubmittedOrNotMessage(List<Object[]> objects, String visitCode, int scheduleNumber) {
		String filteredVisitCode = "";
		String red = "red";
		String message = "";
		String returnMessage = "";
		boolean isExists = false;
		if (objects.size() != 0) {
			for (Object[] object : objects) {
				filteredVisitCode = object[2].toString();
				if (filteredVisitCode.equalsIgnoreCase(visitCode)) {
					isExists = true;
					message = "<span class='fa fa-check' style= color:" + colorMap.get(object[3]) + "></span> " + visitCode
					        + " : " + object[1].toString() + "<br/>";
				}
			}
			String[] visitCodeStringToArray = filteredVisitCode.split("_");
			int number = Integer.parseInt(visitCodeStringToArray[1]);
			if (isExists) {
				returnMessage = message;
			} else if (!isExists && number > scheduleNumber) {
				returnMessage = "<span  class='fa fa-close' style=color:" + red + "></span> " + visitCode + "  " + "<br/>";
			} else {
				
			}
		} else {
			
		}
		return returnMessage;
		
	}
	
	public static String getOutcomeMessage(int deleveryStatus) {
		String message = "";
		if (deleveryStatus == 3) {
			message = "Live Birth";
		} else {
			message = "Still Birth";
		}
		return message;
	}
}
