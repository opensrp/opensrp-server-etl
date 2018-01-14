package org.mcare.common.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaginationHelperUtil {
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	public PaginationHelperUtil() {
		
	}
	
	public static int getParentId(String locationName) {
		int parentId = 0;
		try {
			//System.err.println("locationName:::::::::::::::;" + locationName);
			if (locationName != null || !locationName.equalsIgnoreCase("0?")) {
				String[] div = locationName.split("\\?");
				parentId = Integer.parseInt(div[0]);
			}
		}
		catch (Exception e) {
			
		}
		return parentId;
		
	}
	
	public static String locationName(String locationName) {
		String name = "";
		try {
			if (locationName != null || !locationName.equalsIgnoreCase("0?")) {
				String[] div = locationName.split("\\?");
				name = div[1];
			}
		}
		catch (Exception e) {
			
		}
		return name;
	}
	
	@SuppressWarnings("null")
	public void setParentLocationToSession(String location, String sessionName, HttpSession session) {
		if (location != null || !location.equalsIgnoreCase("0?")) {
			String[] divisionName = location.split("\\?");
			List<Object[]> parentLOcationListByParent = locationServiceImpl.getChildData(Integer.parseInt(divisionName[0]));
			session.setAttribute(sessionName, parentLOcationListByParent);
		}
	}
	
}
