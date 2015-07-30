<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office</title>
<link rel="stylesheet"
	href="<c:url value="/resources/css/pure/menus.css" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/menuInOfficeLeft.css" />">
	<link rel="stylesheet"
	href="<c:url value="/resources/css/menuInOfficeRight.css" />">
	<link rel="stylesheet"
	href="<c:url value="/resources/css/pure/grids.css" />">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="pure-g">
		<div class="pure-u-1-6"> 
			<div class="menu_simple_left">
				<ul>
					<li><img style="width: 130px; height: 120px;"
						src="<c:url value="/resources/pictures/avatar.png" />" /></li>
					<li><p>${candidate.info.login}</p></li>
					<li><a href="candidateOffice">Profile</a></li>
					<li><a href="vacancies">Vacancies</a></li>
					<li><a href="vacancies">Search</a></li>
					<li><a href="settings">Settings</a></li>
				</ul>
			</div>
		</div>
		<div class="pure-u-3-5">
			<br>
			<p>Last name: ${candidate.lastName}</p>
			<p>Name: ${candidate.name}</p>
			<p>Mobile phone: ${candidate.mobileNumber}</p>
			<p>Address: ${candidate.address}</p>
			<p>Education: ${candidate.education}</p>
		</div>
		<div class="pure-u-5-30">
			<div class="menu_simple_right">
				<ul>
					<li><a href="candidateOffice">Candidate #1</a></li>
					<li><a href="vacancies">Candidate #2</a></li>
					<li><a href="settings">Candidate #3</a></li>
					<li><a href="candidateOffice">Candidate #4</a></li>
					<li><a href="vacancies">Candidate #5</a></li>
					<li><a href="settings">Candidate #6</a></li>
					<li><a href="candidateOffice">Candidate #7</a></li>
					<li><a href="candidateOffice">Candidate #8</a></li>
					<li><a href="vacancies">Candidate #9</a></li>
					<li><a href="settings">Candidate #10</a></li>
				</ul>
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>