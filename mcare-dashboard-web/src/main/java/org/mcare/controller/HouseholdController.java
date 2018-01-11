package org.mcare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.acl.entity.ProviderEntity;
import org.mcare.acl.service.ProviderServiceImpl;
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
			division = (String) request.getParameter("division");
			if (division != null || !division.equalsIgnoreCase("0?")) {
				System.err.println("division:" + division);
				String[] di = division.split("\\?");
			} else {
				division = "0";
			}
			district = (String) request.getParameter("district");
			if (district != null || !district.equalsIgnoreCase("0?")) {
				System.err.println("district:" + district);
				String[] dist = district.split("\\?");
				List<Object[]> districtListByParent = locationServiceImpl.getChildData(Integer.parseInt(dist[0]));
				session.setAttribute("districtListByParent", districtListByParent);
			} else {
				district = "0";
			}
			upazila = (String) request.getParameter("upazila");
			union = (String) request.getParameter("union");
			ward = (String) request.getParameter("ward");
			subunit = (String) request.getParameter("subunit");
			mauzapara = (String) request.getParameter("mauzapara");
			provider = (String) request.getParameter("provider");
			name = (String) request.getParameter("name");
			System.err.println("union:" + union);
			searchBuilder.setDivision(division);
			searchBuilder.setDistrict(district);
			searchBuilder.setUpazila(upazila);
			searchBuilder.setUnion(union);
			searchBuilder.setWard(ward);
			searchBuilder.setSubunit(subunit);
			searchBuilder.setMauzapara(mauzapara);
			searchBuilder.setProvider(provider);
			searchBuilder.setName(name);
			
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
