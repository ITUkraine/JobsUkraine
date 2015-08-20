<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<strong style="font-size: 20px;">Potential candidates</strong>
		</div>
		<div class="panel-body">
			<c:forEach items="${candidates}" var="candidate">
				<div class="panel panel-default">
					<div class="panel-heading col-lg-12">
						<div class="col-lg-4">

							<img alt="avatar" width="60px" height="60px"
								style="margin-right: 20px;"
								src="<c:url value="${candidate.pictureURL}" />"></img>
						</div>
						<div class="col-lg-8">
							<h5 align="right">
								<img alt="avatar" width="20px" height="20px"
									style="margin-right: 2px; margin-top: -5px;"
									src="http://icons.iconarchive.com/icons/icojam/blue-bits/256/star-rating-icon.png"></img>
								<fmt:formatNumber maxFractionDigits="1" value="${candidate.rating}" />
							</h5>
							<a style="font-size: 16px;"
								href="/JobsUkraine/candidate/${candidate.id}">${candidate.lastName}
								${candidate.name} </a>
						</div>
					</div>
					<div class="panel-body">
						<br>
						<p>
							<strong>Age:</strong> ${candidateService.getAge(candidate)} years
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
</body>
</html>