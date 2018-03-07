<%@page import="org.mcare.etl.entity.ENCCEntity"%>
<%@page import="java.util.List"%>
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

<title>Child Details</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
</head>
<c:url var="saveUrl" value="child/${id}/view.html" />
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />

	<div class="content-wrapper">
		<div class="container-fluid">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/encc.html">encc List</a>
				</li>
				<li class="breadcrumb-item active">ENCC count ${encclist.size()} of ${child.getCaseId()}</li>
			</ol>
			<div class="row">
				<%
					List<ENCCEntity> enccList = (List<ENCCEntity>) session.getAttribute("encclist");
					for (ENCCEntity encc : enccList) {
				%>
				<div class="col-4">
					<p>Name : <%=encc.getEnccName()%></p>
				</div>
				<div class="col-4">
					<p>FW ENCC HDCOV : <%=encc.getFWENCCHDCOV()%></p>
				</div>
				<div class="col-4">
					<p>FW ENCC DSFVRCLD : <%=encc.getFWENCCDSFVRCLD()%></p>
				</div>
				<%
					}
				%>
			</div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>