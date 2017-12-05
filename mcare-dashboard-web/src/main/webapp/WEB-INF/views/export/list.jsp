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
    <title>Add user information</title>
    
    <link  type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
  
    <link  type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet">

  </head>
 <%--  <c:set var="url" value="<c:url value="/" />" /> --%>
  <body>
  <c:url var="saveUrl" value="/export" />
  <c:url var="homeUrl" value="/" />
  <c:url var="home" value="/log" scope="request" />
 <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="<c:url value="/"/>">mCare2 Dashboard</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="<c:url value="/"/>">Home</a></li>
      <li><a href="<c:url value="/export"/>">CSV Export</a></li>
      <li><a href="<c:url value="/logout"/>">Logout</a></li>
      
    </ul>
  </div>
</nav>

 <%-- <c:out value="${name}" /> --%>
 
 
  
 <div class="container">
     <div class="row">               
         <div class="col-md-8">
             <table class="table table-hover" id="dev-table"">
                 <thead>
                  <tr>        
                   <th>User</th>
                   <th>File Name</th>
                    <th>Craeted Date</th>
                   <th>Action</th>
                   
                  </tr>
                 </thead>
                 <tbody>
                   <c:forEach items="${exports}" var="export"> 
                  <tr>       
                  <td>${export.getUser()}</td> 
                  <td>${export.getReportName()}</td>
                  <td>${export.getCraeted()}</td>
                  <td> <a  href="/opt/multimedia/export/${export.getReportName()}" >Download</a></td>
                  </tr>
                  </c:forEach>
                 </tbody>
            </table>    
        </div>      
    </div>
 </div> 

  </body>
  
  <script src="<c:url value='/resources/js/jquery-1.12.4.js' />"></script>
    <script src="<c:url value='/resources/js/jquery-ui.js' />"></script>
    
    
    
     <script>
     
     $(function () {
         $("#start").datepicker({
        	 dateFormat: "yy-mm-dd",
        	 maxDate: new Date,
             onSelect: function (selectedDate) {
                 var orginalDate = new Date(selectedDate);
                 var monthsAddedDate = new Date(new Date(orginalDate).setMonth(orginalDate.getMonth() + 3));
                 
                 $("#end").datepicker("option", 'minDate', selectedDate);
                 $("#end").datepicker("option", 'maxDate', monthsAddedDate);
             }
         });

         $("#end").datepicker({
        	 dateFormat: "yy-mm-dd",
        	 maxDate: new Date,
             onSelect: function (selectedDate) {
                 var orginalDate = new Date(selectedDate);
                 var monthsAddedDate = new Date(new Date(orginalDate).setMonth(orginalDate.getMonth() - 3));
               
                 $("#start").datepicker("option", 'minDate', monthsAddedDate);
                 $("#start").datepicker("option", 'maxDate', selectedDate);
             }
         })
     });
 /*  $( function() {
	  var dateToday = new Date();
	     $('#start').datepicker({
	        dateFormat: "yy-mm-dd",
	         minDate: null,
	         maxDate: dateToday,
	           onSelect: function(selected) {
	             $('#end').datepicker("option", "minDate",  
	            		 $("#start").datepicker('getDate') );
	          } 
	     });

	     $('#end').datepicker({
	        dateFormat: "yy-mm-dd",
	         minDate: null,
	         maxDate: dateToday,
	     });  
  } );  */
  </script>
  
  
  
  <script>
 jQuery(document).ready(function($) {

  $("#search-form").submit(function(event) {
	 
   // Disble the search button
  // enableSearchButton(false);

   // Prevent the form from submitting via the browser.
   event.preventDefault();
  
  // window.location = "/log?roleName=name"; 
   searchViaAjax() ;
  });

 });

 function searchViaAjax() {

 
  $.ajax({
   type : "GET",
   contentType : "application/json",
   url : "${homeUrl}search?start="+$("#start").val()+"&end="+$("#end").val()+"&provider="+$("#provider").val()+"&formName="+$("#formName").val(),
 //  data : JSON.stringify(search),
   dataType : 'json',
   timeout : 100000,
   beforeSend: function() {
	   
	   $('#dev-table').hide(); 
	   $('#loader').show(); 
   },
   success : function(data) {
    console.log("SUCCESS: ", data);
    $('#loader').hide();
    $('#dev-table').show(); 
    $('#download').show();
    $('#fileName').html(data);
    $("a#download").attr('href', 
    '/opt/multimedia/export/'+data);
   },
   error : function(e) {
    console.log("ERROR: ", e);
    display(e);
   },
   done : function(e) {
	   
    console.log("DONE");
    //enableSearchButton(true);
   }
  });

 }

 function enableSearchButton(flag) {
  $("#btn-search").prop("disabled", flag);
 }

 function display(data) {
  var json = "<h4>Ajax Response</h4><pre>"
    + JSON.stringify(data, null, 4) + "</pre>";
  $('#feedback').html(json);
 }
</script>
</html>