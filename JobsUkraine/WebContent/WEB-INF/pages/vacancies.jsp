<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidate</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<div class="panel panel-default">
				<div class="panel-heading">Vacancies</div>
				<div class="panel-body">
					<c:forEach var="vacancy" items="${vacancies}">
						<div class="panel panel-default">
							<div class="panel-heading">
								<a style="font-size: 20px;"
									href="/JobsUkraine/vacancy/${vacancy.id}">${vacancy.name} </a>
							</div>
							<div class="panel-body">
								<p>Category: ${vacancy.category.name}</p>
								<p>Salary: ${vacancy.salary}</p>
								<p>Description: ${vacancy.description}</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col-lg-2"></div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>