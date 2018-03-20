<%@page import="org.mcare.common.util.PaginationHelperUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	List<Integer> pageList = (List<Integer>) session
			.getAttribute("pageList");
	String offSet = request.getParameter("offSet");

	Map<String, String> paginationAtributes = (Map<String, String>) session
			.getAttribute("paginationAtributes");
	String division = "";
	int divId = 0;
	if (paginationAtributes.containsKey("divId")) {
		divId = Integer.parseInt(paginationAtributes.get("divId"));
	}

	int distId = 0;
	if (paginationAtributes.containsKey("distId")) {
		distId = Integer.parseInt(paginationAtributes.get("distId"));
	}

	int upzilaId = 0;
	if (paginationAtributes.containsKey("upzilaId")) {
		upzilaId = Integer
				.parseInt(paginationAtributes.get("upzilaId"));
	}
	String union = "";
	int unionId = 0;
	if (paginationAtributes.containsKey("unionId")) {
		unionId = Integer.parseInt(paginationAtributes.get("unionId"));
	}

	int wardId = 0;
	if (paginationAtributes.containsKey("wardId")) {
		wardId = Integer.parseInt(paginationAtributes.get("wardId"));
	}

	int subunitId = 0;
	if (paginationAtributes.containsKey("subunitId")) {
		subunitId = Integer.parseInt(paginationAtributes
				.get("subunitId"));
	}

	int mauzaparaId = 0;
	if (paginationAtributes.containsKey("mauzaparaId")) {
		mauzaparaId = Integer.parseInt(paginationAtributes
				.get("mauzaparaId"));
	}

	String provider = "";
	if (paginationAtributes.containsKey("provider")) {
		provider = paginationAtributes.get("provider");
	}

	String name = "";
	if (paginationAtributes.containsKey("name")) {
		name = paginationAtributes.get("name");
	}

	// String paginationLink = divisionLink+districtLink+upazilaLink+unionLink + subunitLink+mauzaparaLink+providerLink+nameLink+searchLink;
	/* disabledLINK has been used to to make current page number nonhiperlink i.e unclickable
	e.g if user is at page number 15 then page number 15 should not be clickable*/
	String paginationLink = "";
	if (paginationAtributes.containsKey("paginationLink")) {
		paginationLink = paginationAtributes.get("paginationLink");
	}
	int disabledLINK = 0;
	if (offSet != null) {
		disabledLINK = Integer.parseInt(offSet);
	}
	/* size is used for moving user to end page  by clicking on END link*/
	int size = Integer
			.parseInt(session.getAttribute("size").toString());

	List<Object[]> parentDataList = (List<Object[]>) session
			.getAttribute("parentData");
	List<Object[]> districts = (List<Object[]>) session
			.getAttribute("districtListByParent");
	List<Object[]> upazilas = (List<Object[]>) session
			.getAttribute("upazilasListByParent");
	List<Object[]> unions = (List<Object[]>) session
			.getAttribute("unionsListByParent");
	List<Object[]> wards = (List<Object[]>) session
			.getAttribute("wardsListByParent");
	List<Object[]> subuits = (List<Object[]>) session
			.getAttribute("subunitListByParent");
	List<Object[]> mauzaparas = (List<Object[]>) session
			.getAttribute("mauzaparaListByParent");
%>

<div class="row">
	<div class="col-sm-12 col-md-5">
		<div class="dataTables_info" id="dataTable_info"></div>
	</div>

	<div class="col-sm-12 col-md-7">
		<div class="dataTables_paginate paging_simple_numbers"
			id="dataTable_paginate">
			<ul class="pagination">
				<%
					if (disabledLINK != 0) {
				%>
				<li class="paginate_button page-item previous"
					id="dataTable_previous"><a data-dt-idx="0" tabindex="0"
					class="page-link" href="?offSet=<%=0%><%=paginationLink%>">Start</a></li>

				<li class="paginate_button page-item previous"
					id="dataTable_previous"><a data-dt-idx="0" tabindex="0"
					class="page-link"
					href="?offSet=<%=disabledLINK - 1%><%=paginationLink%>">Previous</a>
				</li>
				<%
					}
				%>

				<%
					for (Integer i : pageList) {
						if (disabledLINK == i) {
							if (disabledLINK != size) {
				%>
				<li class="paginate_button page-item disabled"><a
					data-dt-idx="1" tabindex="0" class="page-link"
					href="${pageName.toString()}?offSet=<%=i%><%=paginationLink%>"><%=i + ""%></a></li>
				<%
					}
						} else {
				%>
				<li class="paginate_button page-item active"><a data-dt-idx="1"
					tabindex="0" class="page-link"
					href="${pageName.toString()}?offSet=<%=i%><%=paginationLink%>"><%=i + ""%></a></li>
				<%
					}
					}
				%>
				<%
					if (disabledLINK == size) {
				%>

				<%
					} else {
				%>
				<li class="paginate_button page-item next" id="dataTable_next"><a
					data-dt-idx="7" tabindex="0" class="page-link"
					href="${pageName.toString()}?offSet=<%=disabledLINK + 1%><%=paginationLink%>">Next</a>
				</li>
				<li class="paginate_button page-item next" id="dataTable_next"><a
					data-dt-idx="7" tabindex="0" class="page-link"
					href="${pageName.toString()}?offSet=<%=size%><%=paginationLink%>">End</a>
				</li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</div>
