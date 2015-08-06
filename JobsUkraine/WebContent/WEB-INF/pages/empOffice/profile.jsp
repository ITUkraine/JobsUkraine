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

	<div class="container-fluid" style="color: black;">
		<div class="col-lg-1"></div>

		<div class="col-lg-1">
			<%@ include file="sidebar.jsp"%>
		</div>

		<div class="col-lg-6">
			<br>

			<div class=" col-lg-12 panel panel-default">

				<h1>${employer.name }</h1>

				<h4>
					<sec:authorize
						access="isAuthenticated() && !hasRole('ROLE_CANDIDATE')">
					${employer.email } <br> ${employer.phone } <br>
						<a href="${employer.website} ">${employer.website}</a>
					</sec:authorize>
					<br> ${employer.address }
				</h4>

				<p>${employer.description}</p>

			</div>

		</div>

		<div class="col-lg-3">
			<br>

			<div class="col-lg-12 panel panel-default">
				<%@ include file="candidatesList.jsp"%>
			</div>

		</div>

		<div class="col-lg-1"></div>

	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>