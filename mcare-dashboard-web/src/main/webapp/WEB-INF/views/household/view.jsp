 <%@page import="org.mcare.acl.entity.ProviderEntity"%>
<%@page import="org.mcare.etl.entity.HouseholdEntity"%>
  <%@page import="org.mcare.common.util.PaginationHelperUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
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
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta name="__csrf_parameter" content="${__csrf_parameter}"/>
    <title>Household information</title>
    
    <link  type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
  
    <link  type="text/css" href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
    <link  type="text/css" href="<c:url value="/resources/datatables/dataTables.bootstrap4.css"/>" rel="stylesheet">
    <link  type="text/css" href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">
    
  </head>
  
  
  

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <jsp:include page="/WEB-INF/views/navbar.jsp"/>
  
  <div class="content-wrapper">
      <div class="card-header">
          <i class="fa fa-table"></i> Details of ${household.getFirstName()}
          
      </div>
      <div class="card-body">
         
            <div class="row">
               <div class="col-sm-12">
               <p>Name : ${household.getFirstName()}</p>
               <p>Birth Date : ${household.getBirthDate()}</p>
               <p>Gender : ${household.getGender()}</p>
               <p>caseId : ${household.getCaseId()}</p>
               <p>Provider : ${household.getProvider()}</p>
               <p>Start : ${household.getStart()}</p>
               <p>End : ${household.getEnd()}</p>
               <p>RegistrationDate : ${household.getRegistrationDate()}</p>
               <p>Country : ${household.getCountry()}</p>
               <p>Division : ${household.getDivision()}</p>
               <p>District : ${household.getDistrict()}</p>
               <p>Upazila : ${household.getUpazila()}</p>
               <p>Union : ${household.getUnion()}</p>
               <p>Ward : ${household.getWard()}</p>
               <p>Subunit : ${household.getSubunit()}</p>
               <p>MauzaPara : ${household.getMauzaPara()}</p>
               <p>UserType : ${household.getUserType()}</p>
               <p>CurrentFormStatus : ${household.getCurrentFormStatus()}</p>
               <p>ReceivedTime : ${household.getReceivedTime()}</p>
               <p>FWGOBHHID : ${household.getFWGOBHHID()}</p>
               <p>FWNHHMBRNUM : ${household.getFWNHHMBRNUM()}</p>
               <p>FWNHHMWRA : ${household.getFWNHHMWRA()}</p>
               <p>ELCO : ${household.getELCO()}</p>
               
               </div>
            </div>
            
          </div>
      
  </div>
       
      
   
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
</html> 

<script src="<c:url value='/resources/js/jquery.min.js' />"></script>
<script src="<c:url value='/resources/js/bootstrap.bundle.min.js' />"></script>