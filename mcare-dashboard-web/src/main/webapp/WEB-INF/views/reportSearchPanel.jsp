<%@page import="org.mcare.acl.entity.ProviderEntity"%>
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
	List<ProviderEntity> providers = (List<ProviderEntity>) session
			.getAttribute("providers");

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


<div class="card mb-3">
	<div class="card-header">
		<i class="fa fa-table"></i> ${title.toString()} Search
	</div>
	<div class="card-body">
		<form id="search-form">

			<div class="form-group">
				<div class="row">
					<div class="col-3">
						<label>Start Date</label> <input class="form-control" type=text
							name="start" id="start">
					</div>
					<div class="col-3">
						<label>End Date</label> <input class="form-control" type="text"
							name="end" id="end">

					</div>
				</div>
			</div>

			<div class="row">
				<div class="col-3">
					<select class="custom-select custom-select-lg mb-3" id="division"
						name="division">
						<option value="0?">Please Select Division</option>
						<%
							for (Object[] objects : parentDataList) {
						%>
						<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
						<%
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
						%>
						<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
						<%
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
						%>
						<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
						<%
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
						%>
						<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
						<%
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
						%>
						<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
						<%
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
						%>
						<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
						<%
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
						%>
						<option value="<%=objects[1]%>?<%=objects[0]%>"><%=objects[0]%></option>
						<%
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
						%>
						<option value="<%=objects.getProvider()%>"><%=objects.getProvider()%></option>
						<%
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