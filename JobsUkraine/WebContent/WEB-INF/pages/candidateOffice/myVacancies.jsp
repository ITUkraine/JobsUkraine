<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office | My vacancies</title>
</head>
<body background="/JobsUkraine/resources/pictures/offcan.png"
	style="background-attachment: fixed; background-repeat: no-repeat;">
	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="col-lg-2">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">My vacancies</div>
				<div class="panel-body">
					<c:forEach var="vacancy" items="${myVacancies}">
						<div class="panel panel-default">
							<div class="panel-heading">
								<a style="font-size: 20px;"
									href="/JobsUkraine/vacancy/${vacancy.id}">${vacancy.name} </a>
							</div>
							<div class="panel-body">
								<p>
									<strong>Category:</strong> ${vacancy.category.name}
								</p>
								<p>
									<strong>Salary:</strong> ${vacancy.salary}$
								</p>
								<strong>Description:</strong>
								<c:if test="${vacancy.description.length()<300}">
								${vacancy.description}
							</c:if>

								<c:if test="${vacancy.description.length()>=300}">
								${vacancy.description.substring(0,300)}...
							</c:if>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<%@ include file="potentialVacancies.jsp"%>
		</div>
	</div>


	<%@ include file="../footer.jsp"%>
</body>
</html>