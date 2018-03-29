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
			String alertStatus = scheduleStringToArray[0];
			String expiryDate = scheduleStringToArray[1];
			String isActionActive = scheduleStringToArray[2];
			String visitCode = scheduleStringToArray[3];
			if ("f".equalsIgnoreCase(isActionActive)) {
				map.put("status", "false");
				map.put("bgColor", "Gainsboro");
				map.put("message", "");
				map.put("date", "");
				map.put("visitCode", "");
			} else {
				if ("urgent".equalsIgnoreCase(alertStatus)) {
					map.put("bgColor", "red");
					map.put("message", "urgent");
					map.put("date", expiryDate);
					map.put("visitCode", visitCode);
				} else if ("upcoming".equalsIgnoreCase(alertStatus)) {
					map.put("bgColor", "yellow");
					map.put("message", "upcoming");
					map.put("visitCode", visitCode);
					map.put("date", expiryDate);
				} else if ("expired".equalsIgnoreCase(alertStatus)) {
					map.put("bgColor", "");
					map.put("message", "expired");
					map.put("visitCode", "");
					map.put("date", "");
				} else if ("normal".equalsIgnoreCase(alertStatus)) {
					map.put("bgColor", "green");
					map.put("message", "");
					map.put("visitCode", visitCode);
					map.put("date", expiryDate);
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
	
	public static String generateMessageForScheduleSubmittions(List<Object[]> objects, String visitCode, int scheduleNumber) {
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
	
	public static StringBuilder generateMessageForNoScheduleSubmittions(String schedule) {
		StringBuilder sb = new StringBuilder();
		String red = "red";
		if (!schedule.isEmpty()) {
			String[] scheduleStringToArray = schedule.split(",");
			String visitCode = scheduleStringToArray[3];
			String[] visitCodeStringToArray = visitCode.split("_");
			String visitCodeWithoutNumber = visitCodeStringToArray[0];
			int visitCodeNumber = Integer.parseInt(visitCodeStringToArray[1]);
			String alertStatus = scheduleStringToArray[0];
			if (visitCodeNumber == 2) {
				sb.append("<span  class='fa fa-close' style=color:" + red + "></span> " + visitCodeWithoutNumber + "_1"
				        + "<br/>");
			} else if (visitCodeNumber == 3) {
				
				sb.append("<span  class='fa fa-close' style=color:" + red + "></span> " + visitCodeWithoutNumber + "_1"
				        + "<br/>");
				sb.append("<span  class='fa fa-close' style=color:" + red + "></span> " + visitCodeWithoutNumber + "_2"
				        + "<br/>");
				
				if ("expired".equalsIgnoreCase(alertStatus)) {
					sb.append("<span  class='fa fa-close' style=color:" + red + "></span> " + visitCodeWithoutNumber + "_3"
					        + "<br/>");
				}
			} else if (visitCodeNumber == 4) {
				sb.append("<span  class='fa fa-close' style=color:" + red + "></span> " + visitCodeWithoutNumber + "_1"
				        + "<br/>");
				sb.append("<span  class='fa fa-close' style=color:" + red + "></span> " + visitCodeWithoutNumber + "_2"
				        + "<br/>");
				sb.append("<span  class='fa fa-close' style=color:" + red + "></span> " + visitCodeWithoutNumber + "_3"
				        + "<br/>");
				if ("expired".equalsIgnoreCase(alertStatus)) {
					sb.append("<span  class='fa fa-close' style=color:" + red + "></span> " + visitCodeWithoutNumber + "_4"
					        + "<br/>");
				}
			}
		}
		return sb;
	}
}
