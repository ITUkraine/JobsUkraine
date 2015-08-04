<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office</title>
<link href="<c:url value="/resources/css/btn/btn.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap/bootstrap.css" />"
	rel="stylesheet">
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container-fluid">
		<div class="col-lg-1">space</div>
		<div class="col-lg-1">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-lg-6">
			Main page
			<p>${employer}</p>
		</div>
		<div class="col-lg-3">
			<%@ include file="candidatesList.jsp"%>
		</div>
		<div class="col-lg-1">space</div>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>