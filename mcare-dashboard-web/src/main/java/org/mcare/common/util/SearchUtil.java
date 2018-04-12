package org.mcare.common.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.mcare.acl.entity.ProviderEntity;
import org.mcare.acl.service.impl.ProviderServiceImpl;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.reports.service.SearchFilterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchUtil {

	private static final Logger logger = Logger.getLogger(SearchUtil.class);

	private static final int DIVISION_TAG_ID = 1;

	@Autowired
	private LocationServiceImpl locationServiceImpl;

	@Autowired
	private ProviderServiceImpl providerServiceImpl;

	@Autowired
	private SearchFilterBuilder searchFilterBuilder;

	@Autowired
	private PaginationHelperUtil paginationHelperUtil;

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
}
