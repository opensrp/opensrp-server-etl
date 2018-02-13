<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta name="__csrf_parameter" content="${__csrf_parameter}" />
<title>mCare2 Dashboard Home</title>

<link type="text/css"
	href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>"
	rel="stylesheet">
<link type="text/css"
	href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">
<link type="text/css"
	href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet">
</head>
<%--  <c:set var="url" value="<c:url value="/" />" /> --%>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<c:url var="saveUrl" value="/export" />
	<c:url var="homeUrl" value="/" />
	<c:url var="home" value="/log" scope="request" />

	<jsp:include page="/WEB-INF/views/navbar.jsp" />
	<div class="content-wrapper"></div>

	<!-- /.container-fluid-->
	<!-- /.content-wrapper-->
	<footer class="sticky-footer">
		<div class="container">
			<div class="text-center">
				<small>Copyright © Your Website 2018</small>
			</div>
		</div>
	</footer>
</body>
<script src="<c:url value='/resources/js/jquery-1.12.4.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.bundle.min.js' />"></script>

</html>