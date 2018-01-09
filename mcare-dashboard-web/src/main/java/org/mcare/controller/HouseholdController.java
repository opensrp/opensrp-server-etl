package org.mcare.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mcare.common.util.PaginationUtil;
import org.mcare.etl.entity.HouseholdEntity;
import org.mcare.etl.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HouseholdController {
	
	@Autowired
	private HouseholdService householdService;
	
	@Autowired
	private PaginationUtil paginationUtil;
	
	public HouseholdController() {
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/household.html", method = RequestMethod.GET)
	public String lisst(HttpServletRequest request, HttpSession session) {
		
		String offset = (String) request.getParameter("offSet");
		int result = 10;
		int size;
		Class<HouseholdEntity> entityClassName = HouseholdEntity.class;
		List<Integer> pageList = new ArrayList<Integer>();
		List<Object> data;
		if (offset != null) {
			int offsetReal = Integer.parseInt(offset);
			offsetReal = offsetReal * 10;
			data = householdService.list(result, offsetReal, entityClassName);
			if (session.getAttribute("size") == null) {
				size = householdService.count();
				session.setAttribute("size", size / 10);
			}
			
		} else {
			data = householdService.list(result, 0, entityClassName);
			size = householdService.count();
			if ((size % result) == 0) {
				session.setAttribute("size", (size / 10) - 1);
			} else {
				session.setAttribute("size", size / 10);
			}
		}
		
		paginationUtil.pagination(request, session, offset, pageList, data);
		
		return "household/index";
	}
}
