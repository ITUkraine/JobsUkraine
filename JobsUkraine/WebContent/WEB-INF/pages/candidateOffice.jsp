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
	href="<c:url value="/resources/css/menuInOffice.css" />">
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="pure-g">
		<div class="pure-u-1-3">
			<div class="menu_simple">
				<ul>
					<li><a href="candidateOffice"><img style="width: 100px; height: 150px;"
					src="<c:url value="/resources/pictures/avatar/jpg" />" /></a></li>
					<li><a href="candidateOffice">Profile</a></li>
					<li><a href="vacancies">Vacancies</a></li>
					<li><a href="settings">Settings</a></li>
				</ul>
			</div>
		</div>
		<div class="pure-u-1-3"></div>
		<div class="pure-u-1-3"></div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>