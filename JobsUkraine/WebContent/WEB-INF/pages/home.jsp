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
<link href="<c:url value="/resources/css/pure/grids.css" />"
	rel="stylesheet">
<link rel="shortcut icon"
	href="<c:url value="/resources/pictures/icon.png" />">
<link>
</head>
<body>
	<%@ include file="header.jsp"%>

	<br>
	<br>
	<div class="pure-g">
		<div class="pure-u-1-4"></div>
		<div class="pure-u-1-4">
			<p align="right" class="perspective" style="display: inline-block;">			
					<button onclick="location.href='regCandidate'" class="btn btn-8 btn-8c">I'm candidate</button>
			</p>
		</div>
		<div class="pure-u-1-4">
			<p class="perspective" style="display: inline-block;">
					<button onclick="location.href='regEmployer'" class="btn btn-8 btn-8d">I'm employer</button>
			</p>
		</div>
		<div class="pure-u-1-4"></div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>