package org.opensrp.common.util;

import javax.servlet.http.HttpSession;

public class ControllerUtil {
	public ControllerUtil() {}

	public static void setSessionAttributes(HttpSession session, String pageName, String title) {
		session.setAttribute("pageName", pageName);
		session.setAttribute("title", title);
	}

}
