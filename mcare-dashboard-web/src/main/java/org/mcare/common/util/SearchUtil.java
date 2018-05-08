package org.mcare.common.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mcare.acl.entity.FormNameEntity;
import org.mcare.acl.entity.ProviderEntity;
import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.common.service.impl.DatabaseServiceImpl;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.mcare.reports.service.SearchFilterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchUtil {
	
	private static final Logger logger = Logger.getLogger(SearchUtil.class);
	
	private static final int DIVISION_TAG_ID = 1;
	
	@Autowired
	private SearchBuilder searchBuilder;
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private ProviderServiceImpl providerServiceImpl;
	
	@Autowired
	private SearchFilterBuilder searchFilterBuilder;
	
	@Autowired
	private PaginationHelperUtil paginationHelperUtil;
	
	@Autowired
	private DatabaseServiceImpl databaseServiceImpl;
	
	public SearchUtil() {
	}
	
	public void setProviderAttribute(HttpSession session) {
		List<ProviderEntity> providers = providerServiceImpl.findAll("ProviderEntity");
		logger.debug("set session attribute providers: " + providers.size());
		session.setAttribute("providers", providers);
	}
	
	public void setDivisionAttribute(HttpSession session) {
		List<Object[]> divisions = locationServiceImpl.getLocationByTagId(DIVISION_TAG_ID);
		logger.debug("set session attribute divisions: " + divisions.size());
		session.setAttribute("divisions", divisions);
	}
	
	public void setFormAttribute(HttpSession session) {
		List<FormNameEntity> forms = databaseServiceImpl.findAllFormNames("FormNameEntity");
		logger.debug("set session attribute forms: " + forms.size());
		session.setAttribute("forms", forms);
	}
	
	public SearchFilterBuilder setParamsForReport(HttpServletRequest request, HttpSession session) {
		logger.debug("setting filter from request string: " + request.getQueryString());
		String division = "";
		String district = "";
		String upazila = "";
		String union = "";
		String ward = "";
		String subunit = "";
		String mauzapara = "";
		String provider = "";
		String name = "";
		String start = "";
		String end = "";
		
		if (request.getParameterMap().containsKey("division")) {
			division = (String) request.getParameter("division");
			paginationHelperUtil.setParentLocationToSession(division, "districtListByParent", session);
		}
		if (request.getParameterMap().containsKey("district")) {
			district = (String) request.getParameter("district");
			paginationHelperUtil.setParentLocationToSession(district, "upazilasListByParent", session);
		}
		if (request.getParameterMap().containsKey("upazila")) {
			upazila = (String) request.getParameter("upazila");
			paginationHelperUtil.setParentLocationToSession(upazila, "unionsListByParent", session);
		}
		if (request.getParameterMap().containsKey("union")) {
			union = (String) request.getParameter("union");
			paginationHelperUtil.setParentLocationToSession(union, "wardsListByParent", session);
		}
		if (request.getParameterMap().containsKey("ward")) {
			ward = (String) request.getParameter("ward");
			paginationHelperUtil.setParentLocationToSession(ward, "subunitListByParent", session);
		}
		if (request.getParameterMap().containsKey("subunit")) {
			subunit = (String) request.getParameter("subunit");
			paginationHelperUtil.setParentLocationToSession(subunit, "mauzaparaListByParent", session);
		}
		if (request.getParameterMap().containsKey("mauzapara")) {
			mauzapara = (String) request.getParameter("mauzapara");
		}
		if (request.getParameterMap().containsKey("provider")) {
			provider = (String) request.getParameter("provider");
		}
		if (request.getParameterMap().containsKey("formName")) {
			provider = (String) request.getParameter("formName");
		}
		if (request.getParameterMap().containsKey("name")) {
			name = (String) request.getParameter("name");
		}
		if (request.getParameterMap().containsKey("start")) {
			start = (String) request.getParameter("start");
		}
		if (request.getParameterMap().containsKey("end")) {
			end = (String) request.getParameter("end");
		}
		searchFilterBuilder.setDivision(PaginationHelperUtil.locationName(division));
		searchFilterBuilder.setDistrict(PaginationHelperUtil.locationName(district));
		searchFilterBuilder.setUpazila(PaginationHelperUtil.locationName(upazila));
		searchFilterBuilder.setUnion(PaginationHelperUtil.locationName(union));
		searchFilterBuilder.setWard(PaginationHelperUtil.locationName(ward));
		searchFilterBuilder.setSubunit(PaginationHelperUtil.locationName(subunit));
		searchFilterBuilder.setMauzapara(PaginationHelperUtil.locationName(mauzapara));
		searchFilterBuilder.setProvider(provider);
		searchFilterBuilder.setName(name);
		searchFilterBuilder.setStart(start);
		searchFilterBuilder.setEnd(end);
		logger.info("successfully set report filters: " + searchFilterBuilder.toString());
		return searchFilterBuilder;
	}
	
	public void setSelectedfilter(HttpServletRequest request, HttpSession session) {
		Map<String, String> map = new HashMap<>();
		String division = "";
		int divId = 0;
		if (request.getParameterMap().containsKey("division")) {
			division = request.getParameter("division") == null ? "0?" : request.getParameter("division");
			divId = PaginationHelperUtil.getParentId(division);
			map.put("divId", String.valueOf(divId));
		}
		String district = "";
		int distId = 0;
		if (request.getParameterMap().containsKey("district")) {
			district = request.getParameter("district") == null ? "0?" : request.getParameter("district");
			distId = PaginationHelperUtil.getParentId(district);
			map.put("distId", String.valueOf(distId));
		}
		String upazila = "";
		int upzilaId = 0;
		if (request.getParameterMap().containsKey("upazila")) {
			upazila = request.getParameter("upazila") == null ? "0?" : request.getParameter("upazila");
			upzilaId = PaginationHelperUtil.getParentId(upazila);
			
			map.put("upzilaId", String.valueOf(upzilaId));
		}
		String union = "";
		int unionId = 0;
		if (request.getParameterMap().containsKey("union")) {
			union = request.getParameter("union") == null ? "0?" : request.getParameter("union");
			unionId = PaginationHelperUtil.getParentId(union);
			map.put("unionId", String.valueOf(unionId));
		}
		
		String ward = "";
		int wardId = 0;
		if (request.getParameterMap().containsKey("ward")) {
			ward = request.getParameter("ward") == null ? "0?" : request.getParameter("ward");
			wardId = PaginationHelperUtil.getParentId(ward);
			map.put("wardId", String.valueOf(wardId));
		}
		
		String subunit = "";
		int subunitId = 0;
		if (request.getParameterMap().containsKey("subunit")) {
			subunit = request.getParameter("subunit") == null ? "0?" : request.getParameter("subunit");
			subunitId = PaginationHelperUtil.getParentId(subunit);
			map.put("subunitId", String.valueOf(subunitId));
		}
		String mauzapara = "";
		int mauzaparaId = 0;
		if (request.getParameterMap().containsKey("mauzapara")) {
			mauzapara = request.getParameter("mauzapara") == null ? "0?" : request.getParameter("mauzapara");
			mauzaparaId = PaginationHelperUtil.getParentId(mauzapara);
			map.put("mauzaparaId", String.valueOf(mauzaparaId));
		}
		
		String provider = "";
		if (request.getParameterMap().containsKey("provider")) {
			provider = request.getParameter("provider") == null ? "" : request.getParameter("provider");
			map.put("provider", provider);
		}
		
		String formName = "";
		if (request.getParameterMap().containsKey("formName")) {
			formName = request.getParameter("formName") == null ? "" : request.getParameter("formName");
			map.put("formName", formName);
		}
		
		String start = "";
		if (request.getParameterMap().containsKey("start")) {
			start = request.getParameter("start") == null ? "" : request.getParameter("start");
			map.put("start", start);
		}
		
		String end = "";
		if (request.getParameterMap().containsKey("end")) {
			end = request.getParameter("end") == null ? "" : request.getParameter("end");
			map.put("end", end);
		}
		String year = "";
		
		if (request.getParameterMap().containsKey("year")) {
			year = request.getParameter("year") == null ? "" : request.getParameter("year");
			map.put("year", String.valueOf(year));
		}
		session.setAttribute("selectedFilter", map);
	}
	
	public SearchBuilder generateSearchBuilderParams(HttpServletRequest request, HttpSession session) {
		String search = "";
		search = (String) request.getParameter("search");
		if (search != null) {
			searchBuilder = paginationHelperUtil.setParams(request, session);
		} else {
			searchBuilder = searchBuilder.clear();
		}
		return searchBuilder;
	}
}
