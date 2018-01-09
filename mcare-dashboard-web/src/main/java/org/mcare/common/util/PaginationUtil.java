package org.mcare.common.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component
public class PaginationUtil {
	
	public PaginationUtil() {
		
	}
	
	public <T> void pagination(HttpServletRequest request, HttpSession session, String offset, List<Integer> pageList,
	                           List<Object> data) {
		
		/*when user click on any page number then this part will be executed. 
		 * else part will be executed on load i.e first time on page*/
		
		if (offset != null) {
			int listsize = Integer.parseInt(session.getAttribute("size").toString());
			if (Integer.parseInt(offset) < 6) {
				if (listsize >= 10) {
					for (int i = 1; i <= 9; i++) {
						pageList.add(i);
					}
				} else {
					for (int i = 1; i <= listsize; i++) {
						pageList.add(i);
					}
				}
				
			} else {
				if (listsize >= 10 && Integer.parseInt(offset) - 5 > 0) {
					List<Integer> temp = new ArrayList<Integer>();
					for (int i = Integer.parseInt(offset); i > Integer.parseInt(offset) - 5; i--) {
						temp.add(i);
					}
					for (int i = temp.size() - 1; i >= 0; i--) {
						pageList.add(temp.get(i));
					}
				}
				if (listsize >= 10 && Integer.parseInt(offset) + 5 < listsize) {
					for (int i = Integer.parseInt(offset) + 1; i < Integer.parseInt(offset) + 5; i++) {
						pageList.add(i);
					}
				} else if (listsize >= 10) {
					for (int i = Integer.parseInt(offset) + 1; i < listsize; i++) {
						pageList.add(i);
					}
				}
			}
		} else {
			int listsize = Integer.parseInt(session.getAttribute("size").toString());
			if (listsize >= 10) {
				for (int i = 1; i <= 10; i++) {
					pageList.add(i);
				}
			} else {
				for (int i = 1; i <= listsize; i++) {
					pageList.add(i);
				}
			}
		}
		session.setAttribute("pageList", pageList);
		session.setAttribute("dataList", data);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void dd() throws InstantiationException, IllegalAccessException, ClassNotFoundException,
	    IllegalArgumentException, InvocationTargetException {
		
		try {
			Class cls = Class.forName("org.mcare.etl.service.HouseholdService");
			Object obj = cls.newInstance();
			
			Method method = cls.getDeclaredMethod("print");
			method.invoke(obj, 7);
		}
		catch (SecurityException e) {}
		catch (NoSuchMethodException e) {}
	}
}
