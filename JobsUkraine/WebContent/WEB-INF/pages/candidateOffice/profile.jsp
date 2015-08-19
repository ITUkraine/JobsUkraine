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
				<div class="panel-heading col-lg-12">
					<div class="col-lg-8">
						<strong style="font-size: 24px;">${candidate.lastName}
							${candidate.name} </strong>
					</div>
					<div class="col-lg-4">
						<h4 align="right">Rating: ${candidate.rating}</h4>
					</div>

				</div>
				<div class="panel-body">
					<br>
					<p>City: ${candidate.cityWhereLookingForWork}</p>
					<p>Gender: ${candidate.sex}</p>
					<p>
						Date of birth:
						<fmt:formatDate value="${candidate.dateOfBirth}"
							pattern="dd/MM/yyyy" />
					</p>
					<p>
						Categories:
						<c:forEach var="category" items="${candidate.categories}">
									${category.name}<c:if test="${!loop.last}">, </c:if>
						</c:forEach>
					</p>
					<p>Skills: ${candidate.primarySkills}</p>
					<p>Address: ${candidate.address}</p>
					<p>Date start work: ${candidate.dateStartToWork}</p>
					<p>Dream job: ${candidate.dreamJob}</p>
					<p>Education: ${candidate.education}</p>
					<p>Experience: ${candidate.experience}</p>
					<p>
						<strong>Contacts:</strong>
					</p>
					<p>Email: ${candidate.email}</p>
					<p>Mobile phone: ${candidate.mobileNumber}</p>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>Feedbacks</h3>
				</div>
				<div class="panel-body">
					<c:forEach var="feedback" items="${candidate.feedbacks}">
						<div class="panel panel-default">
							<div class="panel-heading" align="right">
									<fmt:formatDate value="${feedback.date}"
										pattern="dd/MM/yyyy HH:mm:ss" />
							</div>
							<div class="panel-heading">
									<br>
									<p>Category: ${feedback.category.name}</p>
									<p>Mark: ${feedback.mark}</p>
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