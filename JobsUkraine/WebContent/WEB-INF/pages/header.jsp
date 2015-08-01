<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="navbar-brand"><a href="/JobsUkraine"><img src="<c:url value="/resources/css/images/logo.png" />"/></a></div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="/JobsUkraine">Home</a></li>
			<li><a href="vacancies">Vacancies</a></li>
			<li><a href="addVacancy">Add vacancy</a></li>
			<li><a href="candidates">Candidates</a></li>
			<li><a href="login">Log In</a></li>
			<li><a href="aboutUs">About Us</a></li>
			<li><a href="contacts">Contacts</a></li>
		</ul>
	</nav>
</body>
</html>