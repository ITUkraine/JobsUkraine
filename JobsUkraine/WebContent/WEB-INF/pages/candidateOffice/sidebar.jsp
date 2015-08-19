<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="panel panel-default panel-body">
		<ul class="nav nav-pills nav-stacked">
			<li class="active"><c:if test="${candidate.pictureURL == null}">
					<img alt="avatar" width="100%"
						src="resources/pictures/avatar.png"></img>
				</c:if> <c:if test="${candidate.pictureURL != null}">
					<img alt="avatar" width="100%"
						src="<c:url value="${candidate.pictureURL}" />"></img>
				</c:if></li>
			<li><a href="/JobsUkraine/candidateOffice">Profile</a></li>
			<li><a href="/JobsUkraine/myVacancies">My vacancies</a></li>
		</ul>
	</div>
</body>
</html>