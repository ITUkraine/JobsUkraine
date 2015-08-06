<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Navigation</title>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
<link rel="shortcut icon"
	href="<c:url value="/resources/pictures/icon.png" />">
<link href="<c:url value="/resources/css/bootstrap/bootstrap.css" />"
	rel="stylesheet">

</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-*">
		<div class="navbar-brand">
			<a href="/JobsUkraine"><img
				src="<c:url value="/resources/css/images/logo.png" />" /></a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/JobsUkraine">Home</a></li>
			<li><a href="/JobsUkraine/vacancies">Vacancies</a></li>
			<li><a href="/JobsUkraine/candidates">Candidates</a></li>
			<li><a href="/JobsUkraine/aboutUs">About Us</a></li>
			<li><a href="/JobsUkraine/contacts">Contacts</a></li>
			<sec:authorize
				access="isAuthenticated() && hasRole('ROLE_CANDIDATE')">
				<li><a href="/JobsUkraine/candidateOffice">Office</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated() && hasRole('ROLE_EMPLOYER')">
				<li><a href="/JobsUkraine/employerOffice">Office</a></li>
			</sec:authorize>
			<sec:authorize access="!isAuthenticated()">
				<li><a href="/JobsUkraine/login">Log In</a></li>
			</sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li><a href="/JobsUkraine/logout">Log Out</a></li>
			</sec:authorize>
		</ul>
	</nav>
</body>
</html>