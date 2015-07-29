<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Navigation</title>
<link href="<c:url value="/resources/nav/css/style.css" />"
	rel="stylesheet">
<link rel="shortcut icon" href="<c:url value="/resources/pictures/icon.png" />">
</head>
<body>
	<section class="container">
		<img src="<c:url value="/resources/pictures/JobsUkr.PNG"/>">
		<nav>
			<br>
			<ul class="nav">
				<!-- <li class="active"><a href="/JobsUkraine" class="nav-icon"
					title="Home"><span class="icon-home">Home</span></a></li> -->
				<li><a href="/JobsUkraine" title="Home">Home</a></li>
				<li><a href="employers" title="Employers">Employers</a></li>
				<li><a href="candidates" title="Candidates">Candidaters</a></li>
				<li><a href="login" title="Log In">Log In</a></li>
				<li><a href="aboutUs" title="About Us">About Us</a></li>
				<li><a href="contacts" title="Contact">Contact</a></li>
			</ul>
		</nav>
	</section>
</body>
</html>