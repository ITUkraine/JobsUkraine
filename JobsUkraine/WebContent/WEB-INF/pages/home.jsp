<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JobsUkraine</title>
<link href="<c:url value="/resources/css/btn/btn-arrow.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/btn/btn-circle.css" />"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div id="myCarousel" class="carousel slide" data-ride="carousel"
		style="margin-top: -30px;">
		<!-- Indicators -->
		<!-- <ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		</ol> -->

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img alt="text1"
					src="/JobsUkraine/resources/css/images/carousel/1.png">
			</div>
			<div class="item">
				<img alt="text1"
					src="/JobsUkraine/resources/css/images/carousel/2.png">
			</div>
			<div class="item">
				<img alt="text1"
					src="/JobsUkraine/resources/css/images/carousel/3.png">
			</div>
		</div>

		<!-- Left and right controls -->
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<div class="container">
		<div class="col-lg-1"></div>
		<div class="col-lg-10 panel panel-default transparent"
			style="font-size: 17px; margin-top: -70px;">
			<div class="panel-body">
				<h3>Whatever you're looking for, we've got it.</h3>
				<p>JobsUkraine is a temporary work / recruitment agency located
					in Lviv, Ukraine, founded by two people from the Netherlands. We
					try to find the best people to fill a large variety of job
					vacancies in and outside Ukraine. We have a special focus on IT for
					western companies looking for qualified specialists. See our
					IT-Ukraine page for more information. We have a dedicated team of
					specialists to assist you in a personal manner in order to make a
					perfect match. We offer a wide variety of staffing possibilities to
					Company businesses, in order to find the right people and to fill
					certain job vacancies. Employee candidates can get into many
					different working contracts through us. We try to offer the best
					and most flexible solutions.</p>
			</div>
			<div class="panel-footer" align="center">
				<button class="btn btn-primary" style="width: 350px;" type="button"
					onclick="location.href='join'">Join us</button>
			</div>
		</div>
		<div class="col-lg-1"></div>
	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>