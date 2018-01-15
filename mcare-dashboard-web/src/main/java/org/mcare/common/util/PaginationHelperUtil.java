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
	
	public static String getPaginationLint(HttpServletRequest request) {
		String division = "";
		int divId = 0;
		String divisionLink = "";
		if (request.getParameterMap().containsKey("division")) {
			division = request.getParameter("division") == null ? "0?" : request.getParameter("division");
			divId = PaginationHelperUtil.getParentId(division);
			divisionLink = "&division=" + division;
		}
		String district = "";
		int distId = 0;
		String districtLink = "";
		if (request.getParameterMap().containsKey("district")) {
			district = request.getParameter("district") == null ? "0?" : request.getParameter("district");
			distId = PaginationHelperUtil.getParentId(district);
			districtLink = "&district=" + district;
		}
		String upazila = "";
		int upzilaId = 0;
		String upazilaLink = "";
		if (request.getParameterMap().containsKey("upazila")) {
			upazila = request.getParameter("upazila") == null ? "0?" : request.getParameter("upazila");
			upzilaId = PaginationHelperUtil.getParentId(upazila);
			upazilaLink = "&upazila=" + upazila;
		}
		String union = "";
		int unionId = 0;
		String unionLink = "";
		if (request.getParameterMap().containsKey("union")) {
			union = request.getParameter("union") == null ? "0?" : request.getParameter("union");
			unionId = PaginationHelperUtil.getParentId(union);
			unionLink = "&union=" + union;
		}
		
		String ward = "";
		int wardId = 0;
		String wardLink = "";
		if (request.getParameterMap().containsKey("ward")) {
			ward = request.getParameter("ward") == null ? "0?" : request.getParameter("ward");
			wardId = PaginationHelperUtil.getParentId(ward);
			wardLink = "&ward=" + ward;
		}
		
		String subunit = "";
		int subunitId = 0;
		String subunitLink = "";
		if (request.getParameterMap().containsKey("subunit")) {
			subunit = request.getParameter("subunit") == null ? "0?" : request.getParameter("subunit");
			subunitId = PaginationHelperUtil.getParentId(subunit);
			subunitLink = "&subunit=" + subunit;
		}
		String mauzapara = "";
		int mauzaparaId = 0;
		String mauzaparaLink = "";
		if (request.getParameterMap().containsKey("mauzapara")) {
			mauzapara = request.getParameter("mauzapara") == null ? "0?" : request.getParameter("mauzapara");
			mauzaparaId = PaginationHelperUtil.getParentId(mauzapara);
			mauzaparaLink = "&mauzapara=" + mauzapara;
		}
		
		String provider = "";
		String providerLink = "";
		if (request.getParameterMap().containsKey("provider")) {
			provider = request.getParameter("provider") == null ? "0?" : request.getParameter("provider");
			providerLink = "&provider=" + provider;
		}
		
		String name = "";
		String nameLink = "";
		if (request.getParameterMap().containsKey("name")) {
			name = request.getParameter("name") == null ? "0?" : request.getParameter("name");
			nameLink = "&name=" + name;
		}
		String search = "";
		String searchLink = "";
		if (request.getParameterMap().containsKey("search")) {
			search = request.getParameter("search") == null ? "0?" : request.getParameter("search");
			searchLink = "&search=" + search;
		}
		String paginationLink = divisionLink + districtLink + upazilaLink + unionLink + subunitLink + mauzaparaLink
		        + providerLink + nameLink + searchLink;
		return paginationLink;
	}
	
}
