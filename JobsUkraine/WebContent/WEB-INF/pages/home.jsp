<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JobsUkraine</title>
<link href="<c:url value="/resources/css/btn/btn.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap/bootstrap.css" />"
	rel="stylesheet">
<link rel="shortcut icon"
	href="<c:url value="/resources/pictures/icon.png" />">
<link>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-2 col-md-2"></div>
		<div class="col-lg-8 col-md-8">
			<h1 align="center">Registration</h1>
		</div>
		<div class="col-lg-2 col-md-2"></div>
	</div>
	<br>
	<div class="container-fluid">
		<div class="col-lg-2 col-md-2"></div>
		<div align="center" class="col-lg-8 col-md-2">
			<p class="perspective" style="display: inline-block;">
				<button onclick="location.href='regCandidate'"
					class="mybtn btn-8 btn-8c">I'm candidate</button>
			</p>
			<p class="perspective" style="display: inline-block;">
				<button onclick="location.href='regEmployer'"
					class="mybtn btn-8 btn-8d">I'm employer</button>
		</div>
		<div class="col-lg-2 col-md-2"></div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>