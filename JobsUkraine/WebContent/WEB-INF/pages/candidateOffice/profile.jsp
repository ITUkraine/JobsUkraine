<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office | Profile</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="col-lg-2">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>${candidate.name}${candidate.lastName}</h3>
				</div>
				<div class="panel-heading">
					<h4>${candidate.email}${candidate }</h4>
				</div>
				<div class="panel-body">
					<p>${candidate.primarySkills}</p>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>Feedbacks</h3>
				</div>
				<div class="panel-body">
					<c:forEach var="feedback" items="${candidate.feedbacks}">
						<div class="panel panel-default">
							<div class="panel-heading col-lg-12">
								<div class="col-lg-6">
									Author: <a href="/JobsUkraine/employer/${feedback.employer.id}">${feedback.employer.name}</a>
								</div>
								<div class="col-lg-6" align="right">
									<fmt:formatDate value="${feedback.date}"
										pattern="dd/MM/yyyy HH:mm:ss" />
								</div>
							</div>
							<div class="panel-heading">
								Category: ${feedback.category.name}<br> Mark:
								${feedback.mark}
							</div>
							<div class="panel-body">${feedback.comment}</div>
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