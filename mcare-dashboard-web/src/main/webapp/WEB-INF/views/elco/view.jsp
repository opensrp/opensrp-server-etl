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
				<li class="breadcrumb-item"><a href="/elco.html">Elco List</a>
				</li>
				<li class="breadcrumb-item active">Details of ${household.getFirstName()}</li>
			</ol>
			<div class="row">
				<div class="col-4">
					<p>Name : ${household.getFirstName()}</p>
				</div>
				<div class="col-4">
					<p>Birth Date : ${household.getBirthDate()}</p>
				</div>
				<div class="col-4">
					<p>Gender : ${household.getGender()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>caseId : ${household.getCaseId()}</p>
				</div>
				<div class="col-4">
					<p>Provider : ${household.getProvider()}</p>
				</div>
				<div class="col-4">
					<p>Start : ${household.getStart()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>End : ${household.getEnd()}</p>
				</div>
				<div class="col-4">
					<p>RegistrationDate : ${household.getRegistrationDate()}</p>
				</div>
				<div class="col-4">
					<p>Country : ${household.getCountry()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>Division : ${household.getDivision()}</p>
				</div>
				<div class="col-4">
					<p>District : ${household.getDistrict()}</p>
				</div>
				<div class="col-4">
					<p>Upazila : ${household.getUpazila()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>Union : ${household.getUnion()}</p>
				</div>
				<div class="col-4">
					<p>Ward : ${household.getWard()}</p>
				</div>
				<div class="col-4">
					<p>Subunit : ${household.getSubunit()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>MauzaPara : ${household.getMauzaPara()}</p>
				</div>
				<div class="col-4">
					<p>UserType : ${household.getUserType()}</p>
				</div>
				<div class="col-4">
					<p>CurrentFormStatus : ${household.getCurrentFormStatus()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>ReceivedTime : ${household.getReceivedTime()}</p>
				</div>
				<div class="col-4">
					<p>FWWOMGOBHHID : ${household.getFWWOMGOBHHID()}</p>
				</div>
				<div class="col-4">
					<p>FWWOMBID : ${household.getFWWOMBID()}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-4">
					<p>FWWOMNID : ${household.getFWWOMNID()}</p>
				</div>
				<div class="col-4">
					<p>FWHUSNAME : ${household.getFWHUSNAME()}</p>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>
</body>
</html>