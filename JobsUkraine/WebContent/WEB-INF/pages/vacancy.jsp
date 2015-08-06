<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vacancy</title>
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
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
		<br>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="panel-title">Vacancy "${vacancy.name}"</h1>
				</div>
				<div class="panel-body">
					<h3 class="panel-title">Category: ${vacancy.category.name}</h3>
					<h3 class="panel-title">Salary: ${vacancy.salary}</h3>
					<h4 class="panel-title">Description:</h4>
					<p>${vacancy.description}</p>

					<div class="row">
						<!-- remove mark after test -->
						<sec:authorize
							access="isAuthenticated() && !hasRole('ROLE_CANDIDATE')">
							<div class="col-lg-3">
								<input class="form-control" type="button"
									value="Accept (dont work)">
							</div>
						</sec:authorize>

						<c:if test="${sameEmployer}">
							<div class="col-lg-3">
								<input class="form-control" type="button"
									value="Edit (dont work)">
							</div>

							<div class="col-lg-2">
								<input class="form-control" type="button"
									onclick="location.href='<c:url value="/vacancy/delete?id=${vacancy.id}" />';"
									value="Delete">
							</div>
						</c:if>

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