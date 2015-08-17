<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidates</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3>Candidates</h3>
				</div>
				<div class="panel-body">
					<c:forEach var="candidate" items="${candidates}">
						<div class="panel panel-default">
							<div class="panel-heading col-lg-12">
								<div class="col-lg-6">
									<img alt="avatar" width="70px" height="70px"
										src="<c:url value="/resources/pictures/avatar.png" />"></img>
									<a style="font-size: 20px;"
										href="/JobsUkraine/candidate/${candidate.id}">${candidate.lastName}
										${candidate.name} </a>
								</div>
								<div class="col-lg-6">
									<h4 align="right">Rating: ${candidate.rating}</h4>
								</div>
							</div>
							<div class="panel-body">
								<br>
								<p>City: ${candidate.cityWhereLookingForWork}</p>
								<p>
								<p>Age: ${candidateService.getAge(candidate)} years</p>
					
								<p>
									Categories:
									<c:forEach var="category"  items="${candidate.categories}" varStatus="loop">
									${category.name}<c:if test="${!loop.last}">, </c:if>
								</c:forEach>
								</p>
								<p>Skills: ${candidate.primarySkills}</p>
							</div>
						</div>

					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<div class="col-lg-2"></div>


	<%@ include file="footer.jsp"%>
</body>
</html>