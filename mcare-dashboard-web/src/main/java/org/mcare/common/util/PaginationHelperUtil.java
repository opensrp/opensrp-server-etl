package org.mcare.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaginationHelperUtil {
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private SearchBuilder searchBuilder;
	
	public PaginationHelperUtil() {
		
	}
	
	public static int getParentId(String locationName) {
		int parentId = 0;
		try {
			//System.err.println("locationName:::::::::::::::;" + locationName);
			if (locationName != null && !locationName.isEmpty() && !locationName.equalsIgnoreCase("0?")) {
				String[] div = locationName.split("\\?");
				parentId = Integer.parseInt(div[0]);
				System.err.println("parentId::" + parentId);
			}
		}
		catch (Exception e) {
			
		}
		return parentId;
		
	}
	
	public static String locationName(String locationName) {
		String name = "";
		try {
			if (locationName != null && !locationName.isEmpty() && !locationName.equalsIgnoreCase("0?")) {
				String[] div = locationName.split("\\?");
				name = div[1];
				System.err.println("name::" + name);
			}
		}
		catch (Exception e) {
			
		}
		return name;
	}
	
	@SuppressWarnings("null")
	public void setParentLocationToSession(String location, String sessionName, HttpSession session) {
		if (location != null && !location.isEmpty() && !location.equalsIgnoreCase("0?")) {
			String[] divisionName = location.split("\\?");
			List<Object[]> parentLOcationListByParent = locationServiceImpl.getChildData(Integer.parseInt(divisionName[0]));
			session.setAttribute(sessionName, parentLOcationListByParent);
		}
	}
	
	public SearchBuilder setParams(HttpServletRequest request, HttpSession session) {
		String division = "";
		String district = "";
		String upazila = "";
		String union = "";
		String ward = "";
		String subunit = "";
		String mauzapara = "";
		String provider = "";
		String name = "";
		
		if (request.getParameterMap().containsKey("division")) {
			division = (String) request.getParameter("division");
			this.setParentLocationToSession(division, "districtListByParent", session);
		}
		if (request.getParameterMap().containsKey("district")) {
			district = (String) request.getParameter("district");
			this.setParentLocationToSession(district, "upazilasListByParent", session);
		}
		if (request.getParameterMap().containsKey("upazila")) {
			upazila = (String) request.getParameter("upazila");
			this.setParentLocationToSession(upazila, "unionsListByParent", session);
		}
		if (request.getParameterMap().containsKey("union")) {
			union = (String) request.getParameter("union");
			this.setParentLocationToSession(union, "wardsListByParent", session);
		}
		if (request.getParameterMap().containsKey("ward")) {
			ward = (String) request.getParameter("ward");
			this.setParentLocationToSession(ward, "subunitListByParent", session);
		}
		if (request.getParameterMap().containsKey("subunit")) {
			subunit = (String) request.getParameter("subunit");
			this.setParentLocationToSession(subunit, "mauzaparaListByParent", session);
		}
		if (request.getParameterMap().containsKey("mauzapara")) {
			mauzapara = (String) request.getParameter("mauzapara");
		}
		if (request.getParameterMap().containsKey("provider")) {
			provider = (String) request.getParameter("provider");
		}
		if (request.getParameterMap().containsKey("name")) {
			name = (String) request.getParameter("name");
		}
		
		searchBuilder.setDivision(this.locationName(division));
		searchBuilder.setDistrict(this.locationName(district));
		searchBuilder.setUpazila(this.locationName(upazila));
		searchBuilder.setUnion(this.locationName(union));
		searchBuilder.setWard(this.locationName(ward));
		searchBuilder.setSubunit(this.locationName(subunit));
		searchBuilder.setMauzapara(this.locationName(mauzapara));
		searchBuilder.setProvider(this.locationName(provider));
		searchBuilder.setName(name);
		return searchBuilder;
		
	}
	
}
