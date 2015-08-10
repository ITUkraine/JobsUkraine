<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="shortcut icon"
	href="<c:url value="/resources/pictures/icon.png" />">
<link href="<c:url value="/resources/css/custom.css" />"
	rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="/JobsUkraine"><img
					src="<c:url value="/resources/css/images/logo-cut.png" />" /></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<sec:authorize access="!isAuthenticated()">
						<li><a href="/JobsUkraine">HOME</a></li>
					</sec:authorize>
					<li><a href="/JobsUkraine/vacancies">VACANCIES</a></li>
					<li><a href="/JobsUkraine/candidates">CANDIDATES</a></li>
					<li><a href="/JobsUkraine/aboutUs">ABOUT US</a></li>
					<li><a href="/JobsUkraine/contacts">CONTACTS</a></li>
					<sec:authorize
						access="isAuthenticated() && hasRole('ROLE_CANDIDATE')">
						<li><a href="/JobsUkraine/candidateOffice">OFFICE</a></li>
					</sec:authorize>
					<sec:authorize
						access="isAuthenticated() && hasRole('ROLE_EMPLOYER')">
						<li><a href="/JobsUkraine/employerOffice">OFFICE</a></li>
					</sec:authorize>
					<sec:authorize access="!isAuthenticated()">
						<li><a href="/JobsUkraine/login">LOG IN</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li><a href="/JobsUkraine/logout">LOG OUT</a></li>
					</sec:authorize>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</body>
</html>