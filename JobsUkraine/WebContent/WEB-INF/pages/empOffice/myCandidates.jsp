<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office | Profile</title>
</head>
<body
	background="http://thehomesitter.com/wp-content/uploads/2013/09/business-office-furniture-62.jpg"
	style="background-attachment: fixed; background-repeat: no-repeat;">

	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="col-lg-2">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>My candidates</h3>
				</div>
				<div class="panel-body">
					<c:forEach var="candidate" items="${myCandidates}">
						<div class="panel panel-default">
							<div class="panel-heading col-lg-12">
								<div class="col-lg-8">
									<img alt="avatar" width="70px" height="70px"
										style="margin-right: 10px;"
										src="<c:url value="${candidate.pictureURL}" />"></img> <a
										style="font-size: 20px;"
										href="/JobsUkraine/candidate/${candidate.id}">${candidate.lastName}
										${candidate.name} </a>
								</div>
								<div class="col-lg-4">
									<h4 align="right">
										<img alt="avatar" width="20px" height="20px"
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
								<p>
									<strong>Age:</strong> ${candidateService.getAge(candidate)}
									years
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
							</div>
						</div>

					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col-lg-4">
			<%@ include file="potentialCandidates.jsp"%>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>