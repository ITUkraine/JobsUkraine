<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
<link href="<c:url value="/resources/css/btn/btn.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap/bootstrap.css" />"
	rel="stylesheet">
<link rel="shortcut icon"
	href="<c:url value="/resources/pictures/icon.png" />">
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container-fluid"
		style="width: 50%; height: 50%; position: absolute; top: 0; bottom: 0; left: 0; right: 0; margin: auto;">
		<div class="col-lg-5">
			<img
				src="http://icetea09.com/wp-content/uploads/2014/05/exception-example.jpg"
				alt="Exception error image" width="100%" height="100%" />
		</div>
		<div class="col-lg-7">
			<h1 style="font-size: 70px">Oops! Something went wrong</h1>
			<b>${name}</b>: ${message}
			<p>
				<br> <a href="/JobsUkraine" style="font-size: 50px">Go home</a>
			</p>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>