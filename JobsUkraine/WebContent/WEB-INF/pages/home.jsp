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
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">
		<br> <br> <br> <br> <br> <br>
		<div>
			<h1 align="center">Registration</h1>
		</div>
		<div align="center">
			<button type="button" onclick="location.href='regEmployer'"
				class="btn btn-primary btn-custom btn-arrow-left">Employer</button>
			<button type="button" class="btn btn-default btn-circle btn-xl">OR</button>
			<button type="button" onclick="location.href='regCandidate'"
				class="btn btn-warning btn-custom btn-arrow-right">Candidate</button>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>