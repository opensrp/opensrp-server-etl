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

    <title>Login</title>
    
    
     <link  type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
  
    <link  type="text/css" href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet">
   
    <link  type="text/css" href="<c:url value="/resources/css/sb-admin.css"/>" rel="stylesheet">
    

  </head>
  <body class="bg-dark">
  <c:url var="saveUrl" value="/user/add" />
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
       <c:url var="loginUrl" value="/login" />
         <form action="${loginUrl}" method="post" class="form-horizontal">
             <c:if test="${param.error != null}">
              <div class="alert alert-danger">
                  <p>Invalid username and password.</p>
              </div>
             </c:if>
             <c:if test="${param.logout != null}">
                 <div class="alert alert-success">
                     <p>You have been logged out successfully.</p>
                  </div>
              </c:if>
             <div class="form-group">
                  <label for="exampleInputEmail1">UserName</label>
                 <input type="text" class="form-control" id="username" name="username" placeholder="Enter Username" required>
              </div>
              <div class="form-group">
                  <label for="exampleInputPassword1">Password</label> 
                  <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
              </div>
              <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                                 
               <div class="form-actions">
                   <input type="submit"
                                    class="btn btn-block btn-primary btn-default" value="Log in">
               </div>
                        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Register an Account</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  
 
   
  </body>
</html>