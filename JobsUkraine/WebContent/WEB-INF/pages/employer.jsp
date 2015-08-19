<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employer</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<br>
			<div class="panel panel-default">
				<div class="panel-heading">

					<img alt="avatar" width="100px" height="100px"
						style="margin-right: 20px;"
						src="<c:url value="${employer.pictureURL}" />"></img> <strong
						style="font-size: 24px;">${employer.name}</strong>
				</div>

				<div class="panel-body">
					<p>
						<strong>Contacts:</strong>
					</p>
					<p><strong>Email:</strong> ${employer.email }</p>
					<p><strong>Phone:</strong> ${employer.phone }</p>
					<p>
						<strong>Website:</strong> <a href="${employer.website} ">${employer.website}</a>
					</p>
					<p><strong>Address:</strong> ${employer.address }</p>
					<p>
						<br> <strong>Categories:</strong>
					</p>
					<p>
						<c:forEach var="category" items="${employer.categories}"
							varStatus="loop">
									${category.name}<c:if test="${!loop.last}">, </c:if>
						</c:forEach>
					</p>
					<p>
						<br> <strong>Description:</strong>
					</p>
					<p>${employer.description}</p>
				</div>
			</div>
		</div>
		<div class="col-lg-2"></div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>