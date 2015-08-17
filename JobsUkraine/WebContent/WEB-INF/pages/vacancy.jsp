<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vacancy</title>
<link>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<br>
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong style="font-size: 24px;">${vacancy.name} </strong>
				</div>
				<div class="panel-body">
					<p>Category: ${vacancy.category.name}</p>
					<p>Salary: ${vacancy.salary}</p>
					<p>Description: ${vacancy.description}</p>
					<br>
					<div class="row">
						<div class="col-lg-8"></div>
						<div class="col-lg-4">
							<sec:authorize
								access="isAuthenticated() && hasRole('ROLE_ADMIN')">
								<input class="btn btn-black" type="button"
									onclick="location.href='<c:url value="/vacancy/delete?id=${vacancy.id}" />';"
									value="Delete">
							</sec:authorize>
							<sec:authorize
								access="isAuthenticated() && hasRole('ROLE_CANDIDATE')">
								<button class="btn btn-black" type="button"
									onclick="location.href='<c:url value="/acceptVacancy?id=${vacancy.id}" />'">Accept</button>
							</sec:authorize>
						</div>


					</div>
					<br>
				</div>
			</div>
		</div>
		<div class="col-lg-2"></div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>