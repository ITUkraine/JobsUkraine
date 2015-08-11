<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container-fluid"
		style="width: 50%; height: 50%; position: absolute; top: 0; bottom: 0; left: 0; right: 0; margin: auto;">
		<div class="col-lg-5">
			<img src="<c:url value="/resources/pictures/error.png" />"
				alt="Exception error image" width="80%" height="80%" />
		</div>
		<div class="col-lg-7">
			<h1 style="font-size: 70px">Oops! Something went wrong</h1>
			<p>
				<b>${name}</b>
			</p>
			<p>${message}</p>
			<p>
				<br> <a href="/JobsUkraine" style="font-size: 50px">Go home</a>
			</p>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>