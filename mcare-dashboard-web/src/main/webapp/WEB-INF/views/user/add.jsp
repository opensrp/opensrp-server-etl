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

  </head>
  <body>
  <c:url var="saveUrl" value="/user/add" />
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
			<td><form:label path="username">User Name:</form:label></td>
			<td><form:input path="username"/></td>
   <td><form:label path="password">Password:</form:label></td>
   <td><form:input path="password"/></td>
		</tr>
	</table>
	
	<input type="submit" value="Save" />
</form:form>
        </div>
              
    </div>
 </div> 

   
  </body>
</html>