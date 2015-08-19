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
			<li class="active"><c:if test="${employer.pictureURL == null}">
					<img alt="avatar" width="100%"
						src="https://cdn3.iconfinder.com/data/icons/business-office-2/512/businessman_tie-512.png"></img>
				</c:if> <c:if test="${employer.pictureURL != null}">
					<img alt="avatar" width="100%"
						src="<c:url value="${employer.pictureURL}" />"></img>
				</c:if></li>

			<li><a href="/JobsUkraine/employerOffice">Profile</a></li>
			<li><a href="/JobsUkraine/empOffice/addVacancy">My vacancies</a></li>
			<li><a href="/JobsUkraine/myCandidates">My candidates</a></li>
		</ul>
	</div>
</body>
</html>