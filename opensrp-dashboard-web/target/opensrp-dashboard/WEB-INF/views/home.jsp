<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html xmlns:th="http://www.thymeleaf.org">
<head>
	<title>Home</title>
	
	<link rel="stylesheet" href="/webjars/bootstrap/3.3.7/css/bootstrap-theme.min.css" />
	
</head>
<body>
 <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6">
                    <h1>Hello world</h1>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>

<div layout:fragment="content">
    <span th:text="|${name}|"/>,<span th:utext="${formatted}"/> is running successfully.<span th:text="${formatted}"/> 
</div>
<P>  The time on the server is ${serverTime}. </P>

<script src="/webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
