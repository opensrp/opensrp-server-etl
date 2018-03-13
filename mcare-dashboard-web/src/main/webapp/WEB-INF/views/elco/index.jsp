<%@page import="org.mcare.acl.entity.ProviderEntity"%>
<%@page import="org.mcare.etl.entity.ElcoEntity"%>
<%@page import="org.mcare.common.util.PaginationHelperUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Elco Information</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
</head>
<%
	List<ElcoEntity> households = (List<ElcoEntity>) session
			.getAttribute("dataList");
	List<ProviderEntity> providers = (List<ProviderEntity>) session
			.getAttribute("providers");
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





<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />
	<div class="content-wrapper">
		<div class="container-fluid">

			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Elco Search
				</div>
				<div class="card-body">
					<form id="search-form">
						<div class="row">
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3"
									id="division" name="division">
									<option value="0?">Please Select Division</option>
									<%
										for (Object[] objects : parentDataList) {
											if (divId == ((Integer) objects[1]).intValue()) {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>
									<%
										} else {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
									<%
										}
										}
									%>
								</select>
							</div>
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3"
									id="district" name="district">
									<option value="0?">Please Select District</option>
									<%
										if (districts != null) {
											for (Object[] objects : districts) {
												if (distId == ((Integer) objects[1]).intValue()) {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>
									<%
										} else {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
									<%
										}
											}
										}
									%>
								</select>
							</div>
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3" id="upazila"
									name="upazila">
									<option value="0?">Please Select Upazilla</option>
									<%
										if (upazilas != null) {
											for (Object[] objects : upazilas) {
												if (upzilaId == ((Integer) objects[1]).intValue()) {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>
									<%
										} else {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
									<%
										}
											}
										}
									%>
								</select>
							</div>
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3" id="union"
									name="union">
									<option value="0?">Please Select Union</option>
									<%
										if (unions != null) {
											for (Object[] objects : unions) {
												if (unionId == ((Integer) objects[1]).intValue()) {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>
									<%
										} else {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
									<%
										}
											}
										}
									%>
								</select>
							</div>
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3" id="ward"
									name="ward">
									<option value="0?">Please Select Ward</option>
									<%
										if (wards != null) {
											for (Object[] objects : wards) {
												if (wardId == ((Integer) objects[1]).intValue()) {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>
									<%
										} else {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
									<%
										}
											}
										}
									%>
								</select>
							</div>
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3" id="subunit"
									name="subunit">
									<option value="0?">Please Select Subunit</option>
									<%
										if (subuits != null) {
											for (Object[] objects : subuits) {
												if (subunitId == ((Integer) objects[1]).intValue()) {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>
									<%
										} else {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
									<%
										}
											}
										}
									%>
								</select>
							</div>
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3"
									id="mauzapara" name="mauzapara">
									<option value="0?">Please Select Mauzapara</option>
									<%
										if (mauzaparas != null) {
											for (Object[] objects : mauzaparas) {
												if (mauzaparaId == ((Integer) objects[1]).intValue()) {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>" selected><%=objects[0]%></option>
									<%
										} else {
									%>
									<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
									<%
										}
											}
										}
									%>
								</select>
							</div>
							<div class="col-3">
								<select class="custom-select custom-select-lg mb-3"
									name="provider">
									<option value="">Please Select Provider</option>
									<%
										if (providers != null) {
											for (ProviderEntity objects : providers) {
												if (provider.equalsIgnoreCase(objects.getProvider())) {
									%>
									<option value="<%=objects.getProvider()%>" selected><%=objects.getProvider()%></option>
									<%
										} else {
									%>
									<option value="<%=objects.getProvider()%>"><%=objects.getProvider()%></option>
									<%
										}
											}
										}
									%>
								</select>
							</div>
						</div>


						<div class="row">
							<div class="col-6">
								<div class="form-group">
									<input name="name" type="search" class="form-control"
										value="<%=name%>" placeholder="">
								</div>
							</div>
							<div class="col-6">
								<button name="search" type="submit" id="bth-search"
									class="btn btn-primary" value="search">Search</button>
							</div>
						</div>
					</form>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>


			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Elco List
				</div>
				<div class="card-body">
					<div class="table-responsive">
						<div id="dataTable_wrapper"
							class="dataTables_wrapper container-fluid dt-bootstrap4">
							<div class="row">
								<div class="col-sm-12">
									<table class="table table-bordered dataTable" id="dataTable"
										style="width: 100%;">
										<thead>
											<tr>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Woman Name</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Provider</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 106px;">GOB HHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 43px;">JIVITA HHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Registration Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Case Id</th>
											</tr>
										</thead>
										<tfoot>
											<tr>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Name</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 79px;">Provider</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 106px;">FWGOBHHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 43px;">FWJIVHHID</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 140px;">Registration Date</th>
												<th tabindex="0" rowspan="1" colspan="1"
													style="width: 225px;">Case Id</th>
											</tr>
										</tfoot>
										<tbody>
											<%
												for (ElcoEntity household : households) {
													pageContext.setAttribute("id", household.getId());
											%>
											<tr class="even">
												<td><a href="<c:url value="elco/${id}/view.html"/>"><%=household.getFirstName()%></a></td>
												<td><%=household.getProvider()%></td>
												<td><%=household.getGOBHHID()%></td>
												<td><%=household.getJiVitAHHID()%></td>
												<td><%=household.getRegistrationDate()%></td>
												<td><%=household.getCaseId()%></td>
											</tr>
											<%
												}
											%>
										</tbody>
									</table>
								</div>
							</div>


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
												href="elco.html?offSet=<%=i%><%=paginationLink%>"><%=i + ""%></a></li>
											<%
												}
													} else {
											%>
											<li class="paginate_button page-item active"><a
												data-dt-idx="1" tabindex="0" class="page-link"
												href="elco.html?offSet=<%=i%><%=paginationLink%>"><%=i + ""%></a></li>
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
											<li class="paginate_button page-item next"
												id="dataTable_next"><a data-dt-idx="7" tabindex="0"
												class="page-link"
												href="elco.html?offSet=<%=disabledLINK + 1%><%=paginationLink%>">Next</a>
											</li>
											<li class="paginate_button page-item next"
												id="dataTable_next"><a data-dt-idx="7" tabindex="0"
												class="page-link"
												href="elco.html?offSet=<%=size%><%=paginationLink%>">End</a>
											</li>
											<%
												}
											%>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="card-footer small text-muted"></div>
			</div>
		</div>

		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>