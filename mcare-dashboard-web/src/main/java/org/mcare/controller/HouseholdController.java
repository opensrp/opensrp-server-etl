package org.mcare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.entity.ProviderEntity;
import org.mcare.acl.service.ProviderServiceImpl;
import org.mcare.common.util.PaginationHelperUtil;
import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.service.HouseholdService;
import org.mcare.location.serviceimpl.LocationServiceImpl;
import org.mcare.params.builder.SearchBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HouseholdController {
	
	@Autowired
	private HouseholdService householdService;
	
	@Autowired
	private PaginationUtil paginationUtil;
	
	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private ProviderServiceImpl providerServiceImpl;
	
	@Autowired
	private SearchBuilder searchBuilder;
	
	@Autowired
	private PaginationHelperUtil paginationHelperUtil;
	
	public HouseholdController() {
		
	}
	
	@RequestMapping(value = "/household.html", method = RequestMethod.GET)
	public String search(HttpServletRequest request, HttpSession session, Model model) {
		
		String division = "";
		String district = "";
		String upazila = "";
		String union = "";
		String ward = "";
		String subunit = "";
		String mauzapara = "";
		String provider = "";
		String name = "";
		String search = "";
		search = (String) request.getParameter("search");
		
		if (search != null) {
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
			
			searchBuilder.setDivision(paginationHelperUtil.locationName(division));
			searchBuilder.setDistrict(paginationHelperUtil.locationName(district));
			searchBuilder.setUpazila(paginationHelperUtil.locationName(upazila));
			searchBuilder.setUnion(union);
			searchBuilder.setWard(ward);
			searchBuilder.setSubunit(subunit);
			searchBuilder.setMauzapara(mauzapara);
			searchBuilder.setProvider(provider);
			searchBuilder.setName(name);
			
			List<ProviderEntity> providers = providerServiceImpl.findAll("ProviderEntity");
			String offset = (String) request.getParameter("offSet");
			int result = 10;
			int size = 0;
			List<Object[]> parentData = locationServiceImpl.getParentData();
			Class<HouseholdEntity> entityClassName = HouseholdEntity.class;
			List<Integer> pageList = new ArrayList<Integer>();
			List<Object> data;
			if (offset != null) {
				int offsetReal = Integer.parseInt(offset);
				offsetReal = offsetReal * 10;
				data = householdService.search(searchBuilder, result, offsetReal, entityClassName);
				if (session.getAttribute("size") == null) {
					size = householdService.countBySearch(searchBuilder);
					session.setAttribute("size", size / 10);
				}
				
			} else {
				data = householdService.search(searchBuilder, result, 0, entityClassName);
				size = householdService.countBySearch(searchBuilder);
				if ((size % result) == 0) {
					session.setAttribute("size", (size / 10) - 1);
				} else {
					session.setAttribute("size", size / 10);
				}
			}
			System.err.println("size:;............" + size);
			paginationUtil.pagination(request, session, offset, pageList, data);
			
		}
		List<ProviderEntity> providers = providerServiceImpl.findAll("ProviderEntity");
		String offset = (String) request.getParameter("offSet");
		int result = 10;
		int size;
		List<Object[]> parentData = locationServiceImpl.getParentData();
		Class<HouseholdEntity> entityClassName = HouseholdEntity.class;
		List<Integer> pageList = new ArrayList<Integer>();
		List<Object> data;
		if (offset != null) {
			int offsetReal = Integer.parseInt(offset);
			offsetReal = offsetReal * 10;
			data = householdService.search(searchBuilder, result, offsetReal, entityClassName);
			if (session.getAttribute("size") == null) {
				size = householdService.count();
				session.setAttribute("size", size / 10);
			}
			
		} else {
			data = householdService.search(searchBuilder, result, 0, entityClassName);
			size = householdService.count();
			if ((size % result) == 0) {
				session.setAttribute("size", (size / 10) - 1);
			} else {
				session.setAttribute("size", size / 10);
			}
		}
		session.setAttribute("parentData", parentData);
		model.addAttribute("providers", providers);
		paginationUtil.pagination(request, session, offset, pageList, data);
		
		return "household/index";
	}
	
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public String getChildLocationList(HttpServletRequest request, HttpSession session, Model model, @RequestParam int id) {
		List<Object[]> parentData = locationServiceImpl.getChildData(id);
		session.setAttribute("data", parentData);
		return "household/location";
	}
}
