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

    <title>Add user information</title>
    
    <link  type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
    <link  type="text/css" href="<c:url value="/resources/css/jquery-ui.css"/>" rel="stylesheet">

  </head>
  <body>
  <c:url var="saveUrl" value="/export" />
 <div th:fragment="header">
    <!-- this is header -->
    <nav class="navbar navbar-inverse">
        <div class="container">
            <div class="navbar-header">
               <a href = "<c:url value = "/"/>">Home</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <a href = "<c:url value = "/"/>">Home</a>
                </ul>
            </div>
        </div>
    </nav>
</div>
 <div class="container">
     <div class="row">               
         <div class="col-md-12">
              <form:form  method="POST" action="${saveUrl}">
	<table>
		<tr>
			<td><form:label path="formName">User Name:</form:label></td>
			<td><form:input path="formName"/></td>
   <td><form:label path="provider">Password:</form:label></td>
   <td><form:input path="provider"/></td>
    <td><form:input  path="start"/></td>
    <td><form:input  path="endDate"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Export" />
</form:form>
        </div>
              
    </div>
 </div> 

 
   
  </body>
  
  <script src="<c:url value='/resources/js/jquery-1.12.4.js' />"></script>
    <script src="<c:url value='/resources/js/jquery-ui.js' />"></script>
    
    
    
     <script>
  $( function() {
	  var dateToday = new Date();
	     $('#start').datepicker({
	        // dateFormat: "yy-mm-dd",
	         minDate: null,
	         maxDate: dateToday,
	           onSelect: function(selected) {
	             $('#endDate').datepicker("option", "minDate",  
	            		 $("#start").datepicker('getDate') )
	          } 
	     });

	     $('#endDate').datepicker({
	        // dateFormat: "yy-mm-dd",
	         minDate: null,
	         maxDate: dateToday,
	     });  
  } );
  </script>
</html>