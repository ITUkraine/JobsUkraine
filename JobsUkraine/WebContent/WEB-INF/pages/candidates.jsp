<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidates</title>
</head>
<body  background="/JobsUkraine/resources/pictures/cand.png"   style="background-attachment: fixed; background-repeat: no-repeat;">
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<div class="panel-body">
				<c:forEach var="candidate" items="${candidates}">
					<div class="panel panel-default">
						<div class="panel-heading col-lg-12">
							<div class="col-lg-6">
								<c:if test="${candidate.pictureURL == null}">
									<img alt="avatar" width="70px" height="70px"
										style="margin-right: 20px;"
										src="<c:url value="/resources/pictures/avatar.png" />"></img>
								</c:if>
								<c:if test="${candidate.pictureURL != null}">
									<img alt="avatar" width="70px" height="70px"
										style="margin-right: 20px;"
										src="<c:url value="${candidate.pictureURL}" />"></img>
								</c:if>
								<a style="font-size: 20px;"
									href="/JobsUkraine/candidate/${candidate.id}">${candidate.lastName}
									${candidate.name} </a>
							</div>
							<div class="col-lg-6">
								<h4 align="right">
									<img alt="avatar" width="23px" height="23px"
										style="margin-right: 2px; margin-top: -5px;"
										src="http://icons.iconarchive.com/icons/icojam/blue-bits/256/star-rating-icon.png"></img>
									${candidate.rating}
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
	<div class="col-lg-2"></div>


	<%@ include file="footer.jsp"%>
</body>
</html>