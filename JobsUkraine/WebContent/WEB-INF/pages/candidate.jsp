<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidate</title>
</head>
<body background="/JobsUkraine/resources/pictures/candidate.png"
	style="background-attachment: fixed; background-repeat: no-repeat;">
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<br>
			<div class="panel panel-default">
				<div class="panel-heading col-lg-12">
					<div class="col-lg-9">

						<img alt="avatar" width="100px" height="100px"
							style="margin-right: 20px;"
							src="<c:url value="${candidate.pictureURL}" />"></img> <strong
							style="font-size: 24px;">${candidate.lastName}
							${candidate.name} </strong>
					</div>
					<div class="col-lg-3">
						<h4 align="right"><img alt="avatar" width="23px" height="23px"
										style="margin-right: 2px; margin-top: -5px;"
										src="http://icons.iconarchive.com/icons/icojam/blue-bits/256/star-rating-icon.png"></img> ${candidate.rating}</h4>
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
						<strong>Age:</strong> ${age} years
					</p>

					<p>
						<strong>Categories:</strong>
						<c:forEach var="category" items="${candidate.categories}"
							varStatus="loop">
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
					<sec:authorize access="hasRole('ROLE_ADMIN')">
						<p>
							<strong>Contacts:</strong>
						</p>
						<p>
							<strong>Email:</strong> ${candidate.email}
						</p>
						<p>
							<strong>Mobile phone:</strong> ${candidate.mobileNumber}
						</p>
					</sec:authorize>
					<sec:authorize access="hasRole('ROLE_EMPLOYER')">
						<div align="right">
							<button class="btn btn-black"
								onclick="location.href='<c:url value="/connectEmployerCandidate?id=${candidate.id}" />'">Interesting
								candidate</button>
						</div>
					</sec:authorize>
				</div>
			</div>
			<sec:authorize access="hasRole('ROLE_EMPLOYER')">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="panel-title">Add feedback</h1>
					</div>
					<div class="panel-body">
						<form:form class="form-group" action="addFeedBack"
							commandName="feedback" method="POST">
							<p>
								<strong>Category</strong>
							</p>
							<form:select class="form-control" id="sel1" path="category">
								<c:forEach var="category" items="${list}">
									<option value="${category.name}">${category.name}</option>
								</c:forEach>
							</form:select>
							<br>
							<p>
								<strong>Mark</strong>
							</p>
							<form:select class="form-control" path="mark">
								<c:forEach begin="1" end="10" var="i">
									<form:option value="${11-i}">${11-i}</form:option>
								</c:forEach>
							</form:select>
							<br>
							<p>
								<strong>Comment</strong>
							</p>
							<form:textarea rows="7" class="form-control" path="comment" />
							<br>
							<div align="right">
								<button type="submit" class="btn btn-black">Add</button>
							</div>
						</form:form>
					</div>

				</div>
			</sec:authorize>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="panel-title">
						<strong>All feedbacks</strong>
					</h1>
				</div>
				<div class="panel-body">
					<c:forEach var="feedback" items="${candidate.feedbacks}">
						<div class="panel panel-default">
							<div class="panel-heading col-lg-12">
								<div class="col-lg-6">
									<sec:authorize access="!hasRole('ROLE_CANDIDATE')"><strong>Author: <a style="text-decoration: none;"
										href="/JobsUkraine/employer/${feedback.employer.id}">${feedback.employer.name}</a></strong>
										</sec:authorize>
								</div>
								<div class="col-lg-6" align="right">
									<fmt:formatDate value="${feedback.date}"
										pattern="dd/MM/yyyy HH:mm:ss" />
								</div>
							</div>
							<div class="panel-heading"></div>
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
		<div class="col-lg-2"></div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>