<%@page import="org.mcare.acl.entity.ProviderEntity"%>
<%@page import="org.mcare.common.util.PaginationHelperUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.mcare.common.util.DateUtil"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	List<ProviderEntity> providers = (List<ProviderEntity>) session.getAttribute("providers");

	List<Integer> yearList = DateUtil.getYearList();
	

	@SuppressWarnings("unchecked")
	List<Object[]> divisions = (List<Object[]>) session
			.getAttribute("divisions");

	@SuppressWarnings("unchecked")
	List<Object[]> districts = (List<Object[]>) session
			.getAttribute("districtListByParent");

	@SuppressWarnings("unchecked")
	List<Object[]> upazilas = (List<Object[]>) session
			.getAttribute("upazilasListByParent");

	@SuppressWarnings("unchecked")
	List<Object[]> unions = (List<Object[]>) session
			.getAttribute("unionsListByParent");

	@SuppressWarnings("unchecked")
	List<Object[]> wards = (List<Object[]>) session
			.getAttribute("wardsListByParent");

	@SuppressWarnings("unchecked")
	List<Object[]> subuits = (List<Object[]>) session
			.getAttribute("subunitListByParent");

	@SuppressWarnings("unchecked")
	List<Object[]> mauzaparas = (List<Object[]>) session
			.getAttribute("mauzaparaListByParent");

	Map<String, String> selectedFilter = (Map<String, String>) session
			.getAttribute("selectedFilter");
	String division = "";
	int divId = 0;
	if (selectedFilter.containsKey("divId")) {
		divId = Integer.parseInt(selectedFilter.get("divId"));
	}

	int distId = 0;
	if (selectedFilter.containsKey("distId")) {
		distId = Integer.parseInt(selectedFilter.get("distId"));
	}

	int upzilaId = 0;
	if (selectedFilter.containsKey("upzilaId")) {
		upzilaId = Integer.parseInt(selectedFilter.get("upzilaId"));
	}
	String union = "";
	int unionId = 0;
	if (selectedFilter.containsKey("unionId")) {
		unionId = Integer.parseInt(selectedFilter.get("unionId"));
	}

	int wardId = 0;
	if (selectedFilter.containsKey("wardId")) {
		wardId = Integer.parseInt(selectedFilter.get("wardId"));
	}

	int subunitId = 0;
	if (selectedFilter.containsKey("subunitId")) {
		subunitId = Integer.parseInt(selectedFilter.get("subunitId"));
	}

	int mauzaparaId = 0;
	if (selectedFilter.containsKey("mauzaparaId")) {
		mauzaparaId = Integer.parseInt(selectedFilter
				.get("mauzaparaId"));
	}

	String provider = "";
	if (selectedFilter.containsKey("provider")) {
		provider = selectedFilter.get("provider");
	}

	Integer selectedYear = 0;
	if (selectedFilter.containsKey("year")) {
		selectedYear =Integer.parseInt(selectedFilter.get("year"));
	}
	
	
	
%>


<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> ${title.toString()}
	</div>
	<div class="card-body">
		<form id="search-form">

			<div class="form-group">
				<div class="row">
					<div class="col-3">
					<select class="custom-select custom-select-lg mb-3" id="year"
						name="year" required>
						<option value="">Please Select Year</option>
						<%
						for (Integer year : yearList) {
							if (selectedYear.intValue() == year.intValue()) {
						%>
							<option value="<%=year%>" selected><%=year%></option>
						<%
							} else {
						%>
							<option value="<%=year%>"><%=year%></option>
						<%
							}
						}
						%>
					</select>
				</div>
					
				</div>
			</div>

			<div class="row">
				<div class="col-3">
					<select class="custom-select custom-select-lg mb-3" id="division"
						name="division">
						<option value="0?">Please Select Division</option>
						<%
						for (Object[] objects : divisions) {
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
					<select class="custom-select custom-select-lg mb-3" id="district"
						name="district">
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
					<select class="custom-select custom-select-lg mb-3" id="mauzapara"
						name="mauzapara">
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
					<select class="custom-select custom-select-lg mb-3" name="provider">
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
					<button name="search" type="submit" id="bth-search"
						class="btn btn-primary" value="search">Search</button>
				</div>
				
			</div>
		</form>
	</div>
	<div class="card-footer small text-muted"></div>
</div>