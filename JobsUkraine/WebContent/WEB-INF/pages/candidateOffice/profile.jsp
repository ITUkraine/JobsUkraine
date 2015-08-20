<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office | Profile</title>
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
				<div class="panel-heading col-lg-12">
					<div class="col-lg-8">
						<strong style="font-size: 24px;">${candidate.lastName}
							${candidate.name} </strong>
					</div>
					<div class="col-lg-4">
						<h4 align="right">
							<img alt="avatar" width="23px" height="23px"
								style="margin-right: 2px; margin-top: -5px;"
								src="http://icons.iconarchive.com/icons/icojam/blue-bits/256/star-rating-icon.png"></img>
							<fmt:formatNumber maxFractionDigits="1" value="${candidate.rating}" />
						</h4>
					</div>

				</div>
				<div class="panel-body">
					<br>
					<p>
						<strong>City:</strong> ${candidate.cityWhereLookingForWork}
					</p>
					<p>
						<strong>Gender:</strong> ${candidate.sex}
					</p>
					<p>
						<strong>Date of birth:</strong>
						<fmt:formatDate value="${candidate.dateOfBirth}"
							pattern="dd/MM/yyyy" />
					</p>
					<p>
						<strong>Categories:</strong>
						<c:forEach var="category" items="${candidate.categories}">
									${category.name}<c:if test="${!loop.last}">, </c:if>
						</c:forEach>
					</p>
					<p>
						<strong>Skills:</strong> ${candidate.primarySkills}
					</p>
					<p>
						<strong>Address:</strong> ${candidate.address}
					</p>
					<p>
						<strong>Date start work:</strong> ${candidate.dateStartToWork}
					</p>
					<p>
						<strong>Dream job:</strong> ${candidate.dreamJob}
					</p>
					<p>
						<strong>Education:</strong> ${candidate.education}
					</p>
					<p>
						<strong>Experience:</strong> ${candidate.experience}
					</p>
					<p>
						<strong>Contacts:</strong>
					</p>
					<p>
						<strong>Email:</strong> ${candidate.email}
					</p>
					<p>
						<strong>Mobile phone:</strong> ${candidate.mobileNumber}
					</p>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong style="font-size: 20px;">Feedbacks</strong>
				</div>
				<div class="panel-body">
					<c:forEach var="feedback" items="${candidate.feedbacks}">
						<div class="panel panel-default">
							<div class="panel-heading col-lg-12">
								<div class="col-lg-6">
									<strong> <img
										style="margin-left: -13px; margin-right: 10px;" alt="avatar"
										width="30px" height="30px"
										src="<c:url value="${feedback.employer.pictureURL}" />"></img>${feedback.employer.name}</strong>
								</div>
								<div class="col-lg-6" align="right">
									<fmt:formatDate value="${feedback.date}"
										pattern="dd/MM/yyyy HH:mm:ss" />
								</div>
							</div>
							<div class="panel-heading">
								<br>
								<p>
									<strong>Category:</strong> ${feedback.category.name}
								</p>
								<p>
									<strong>Mark:</strong> ${feedback.mark}
								</p>
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