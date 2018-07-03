<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="org.opensrp.common.util.CheckboxHelperUtil"%>
<%@page import="java.util.List"%>
<%@page import="org.opensrp.acl.entity.LocationTag"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Add permissions</title>
<jsp:include page="/WEB-INF/views/css.jsp" />
</head>

<c:url var="saveUrl" value="/location/add.html" />

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />
	<div class="content-wrapper">
		<div class="container-fluid">
		<div class="form-group">				
				   <a  href="<c:url value="/location/tag/list.html"/>"> <strong> Manage Tags</strong> 
					</a>  |   <a  href="<c:url value="/location.html"/>"> <strong>Manage Locations</strong>
					</a>			
		</div>
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i> Add Location
				</div>
				<div class="card-body">
					<form:form method="POST" action="${saveUrl}" modelAttribute="location">
						<div class="form-group">
							<div class="row">
								<div class="col-5">
									<label for="exampleInputName">Location Name</label>
									<form:input path="name" class="form-control"
										required="required" aria-describedby="nameHelp"
										placeholder="Location Name" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-5">
									<label for="exampleInputName">Description</label>
									<form:input path="description" class="form-control"
										required="required" aria-describedby="nameHelp"
										placeholder="Description" />
								</div>
							</div>
						</div>
						
						<div class="form-group">							
								<div class="row">									
									<div class="col-5">
									<label for="exampleInputName">Parent Location </label>
										<form:select path="parentLocation" class="custom-select custom-select-lg mb-3">
										    <form:option value="Please Select" />
   									        <form:options items="${parentLocation}" />
										</form:select>
									</div>									
								</div>
							
						</div>
						
						<div class="form-group">							
								<div class="row">									
									<div class="col-5">
									<label for="exampleInputName"> Location Tag</label>
										<form:select path="locationTag" class="custom-select custom-select-lg mb-3">
										    <form:option value="Please Select" />
   									        <form:options items="${locationsTag}" />
										</form:select>
									</div>									
								</div>
							
						</div>
							
						
						<div class="form-group">
							<div class="row">
								<div class="col-3">
									<input type="submit" value="Save"
										class="btn btn-primary btn-block" />
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
		<!-- /.container-fluid-->
		<!-- /.content-wrapper-->
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>
