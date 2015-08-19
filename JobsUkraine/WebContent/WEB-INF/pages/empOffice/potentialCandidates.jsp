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
		<div class="panel-heading">Potential candidates</div>
		<div class="panel-body">
			<c:forEach items="${candidates}" var="candidate">
				<div class="panel panel-default">
					<div class="panel-heading col-lg-12">
						<div class="col-lg-4">
							<c:if test="${candidate.pictureURL == null}">
								<img alt="avatar" width="60px" height="60px"
									style="margin-right: 20px;"
									src="<c:url value="/resources/pictures/avatar.png" />"></img>
							</c:if>
							<c:if test="${candidate.pictureURL != null}">
								<img alt="avatar" width="60px" height="60px"
									style="margin-right: 20px;"
									src="<c:url value="${candidate.pictureURL}" />"></img>
							</c:if>
						</div>
						<div class="col-lg-8">
							<h5 align="right">Rating: ${candidate.rating}</h5>
							<a style="font-size: 16px;"
								href="/JobsUkraine/candidate/${candidate.id}">${candidate.lastName}
								${candidate.name} </a>
						</div>
					</div>
					<div class="panel-body">
						<br>
						<p>Age: ${candidateService.getAge(candidate)}</p>
						<p>
							Categories:
							<c:forEach var="category" items="${candidate.categories}">
									${category.name}<c:if test="${!loop.last}">, </c:if>
							</c:forEach>
						</p>
						<p>Skills: ${candidate.primarySkills}</p>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>