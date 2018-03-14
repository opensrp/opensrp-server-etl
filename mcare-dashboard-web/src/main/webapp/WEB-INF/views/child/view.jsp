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

<jsp:include page="/WEB-INF/views/header.jsp" />

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />

	<div class="content-wrapper">
		<div class="container-fluid">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/child.html">Child
						List</a></li>
				<li class="breadcrumb-item active">Details of
					${child.getFirstName()}</li>
			</ol>
			<div class="row">
				<div class="col-4">
					<p>Name : ${child.getFirstName()}</p>
				</div>
				<div class="col-4">
					<p>Gender : ${child.getGender()}</p>
				</div>
				<div class="col-4">
					<p>caseId : ${child.getCaseId()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>GOB HHID : ${child.getGOBHHID()}</p>
				</div>
				<div class="col-4">
					<p>JIVITA HHID : ${child.getJIVITAHHID()}</p>
				</div>
				<div class="col-4">
					<p>Provider : ${child.getProvider()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>RegistrationDate : ${child.getRegistrationDate()}</p>
				</div>
				<div class="col-4">
					<p>Birth Date : ${child.getBirthDate()}</p>
				</div>
				<div class="col-4">
					<p>Country : ${child.getCountry()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>Division : ${child.getDivision()}</p>
				</div>
				<div class="col-4">
					<p>District : ${child.getDistrict()}</p>
				</div>
				<div class="col-4">
					<p>Upazila : ${child.getUpazila()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>Union : ${child.getUnion()}</p>
				</div>
				<div class="col-4">
					<p>Ward : ${child.getWard()}</p>
				</div>
				<div class="col-4">
					<p>Subunit : ${child.getSubunit()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>MauzaPara : ${child.getMauzaPara()}</p>
				</div>
				<div class="col-4">
					<p>FW HUS NAME : ${child.getFWHUSNAME()}</p>
				</div>
				<div class="col-4">
					<p>FW WOM FNAME : ${child.getFWWOMFNAME()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>User Type : ${child.getUserType()}</p>
				</div>
				<div class="col-4">
					<p>Child visits : ${child.getFWBNFCHLDVITSTS()}</p>
				</div>
				<div class="col-4">
					<p>Current FormStatus : ${child.getCurrentFormStatus()}</p>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>