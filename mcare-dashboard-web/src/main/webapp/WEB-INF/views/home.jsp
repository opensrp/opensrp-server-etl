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

<title>mCare2 Dashboard Home</title>

<jsp:include page="/WEB-INF/views/css.jsp" />
<link type="text/css"
	href="<c:url value="/resources/css/style.css"/>"
	rel="stylesheet">
</head>
<c:url var="saveUrl" value="/role/add" />
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
	<jsp:include page="/WEB-INF/views/navbar.jsp" />

	<div class="content-wrapper">
		<div class="container-fluid">
			<!-- Example DataTables Card-->
			<div class="card mb-3">
				<div class="card-header">
					<i class="fa fa-table"></i>Welcome to mcare
				</div>
			</div>	
		
		
			<div class="row">
				<div class="col-lg-6 col-xs-6">					
					<div class="box1 ">
						<a class="imgs" alt="image" href="index.html">
						<img src="<c:url value="/resources/img/station_icon.png"/>"></a>						
							<div class="counter">
								<div class="counter_left">1</div>
								<div class="counter_mid">0</div>
								<div class="counter_mid">3</div>
								<div class="counter_right">5</div>
							</div>
					</div>
					
					<div class="count_box">
						<div class="box_inner1">
							<div class="box_top2">  TODAY  </div>
							<div class="box_buttom2">  10  </div>
						</div>
						<div class="box_inner1">
							<div class="box_top2">   LAST 7 DAYS  </div>
							<div class="box_buttom2">  09  </div>
						</div>
						<div class="box_inner1">
							<div class="box_top2">  THIS MONTH  </div>
								<div class="box_buttom2"> 18 </div>
						</div>
					</div>					
				</div>	
				
				<div class="col-lg-6 col-xs-6">					
					<div class="box2 ">
						<a class="imgs" alt="image" href="index.html">
						<img src="<c:url value="/resources/img/cupol_icon.png"/>"></a>						
							<div class="counter">
								<div class="counter_left">1</div>
								<div class="counter_mid">0</div>
								<div class="counter_mid">3</div>
								<div class="counter_right">5</div>
							</div>
					</div>
					<div class="count_box">
						<div class="box_inner1">
							<div class="box_top2">  TODAY  </div>
							<div class="box_buttom2">  10  </div>
						</div>
						<div class="box_inner1">
							<div class="box_top2">   LAST 7 DAYS  </div>
							<div class="box_buttom2">  09  </div>
						</div>
						<div class="box_inner1">
							<div class="box_top2">  THIS MONTH  </div>
								<div class="box_buttom2"> 18 </div>
						</div>
					</div>	
										
				</div>
			</div>
			<br />
			<div class="row">
				<div class="col-lg-6 col-xs-6">					
					<div class="box3">
						<a class="imgs" alt="image" href="index.html">
						<img src="<c:url value="/resources/img/p_icon.png"/>"></a>						
							<div class="counter">
								<div class="counter_left">1</div>
								<div class="counter_mid">0</div>
								<div class="counter_mid">3</div>
								<div class="counter_right">5</div>
							</div>
					</div>
					
					<div class="count_box">
						<div class="box_inner1">
							<div class="box_top2">  TODAY  </div>
							<div class="box_buttom2">  10  </div>
						</div>
						<div class="box_inner1">
							<div class="box_top2">   LAST 7 DAYS  </div>
							<div class="box_buttom2">  09  </div>
						</div>
						<div class="box_inner1">
							<div class="box_top2">  THIS MONTH  </div>
								<div class="box_buttom2"> 18 </div>
						</div>
					</div>						
				</div>
				
				
				<div class="col-lg-6 col-xs-6">					
					<div class="box2 ">
						<a class="imgs" alt="image" href="index.html">
						<img src="<c:url value="/resources/img/cupol_icon.png"/>"></a>						
							<div class="counter">
								<div class="counter_left">1</div>
								<div class="counter_mid">0</div>
								<div class="counter_mid">3</div>
								<div class="counter_right">5</div>
							</div>
					</div>
					<div class="count_box">
						<div class="box_inner1">
							<div class="box_top2">  TODAY  </div>
							<div class="box_buttom2">  10  </div>
						</div>
						<div class="box_inner1">
							<div class="box_top2">   LAST 7 DAYS  </div>
							<div class="box_buttom2">  09  </div>
						</div>
						<div class="box_inner1">
							<div class="box_top2">  THIS MONTH  </div>
								<div class="box_buttom2"> 18 </div>
						</div>
					</div>						
				</div>
			</div>	
			
				
		</div>
		
		<jsp:include page="/WEB-INF/views/footer.jsp" />
	</div>

</body>
</html>