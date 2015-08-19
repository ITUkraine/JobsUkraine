<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office | Profile</title>
</head>
<body background="http://thehomesitter.com/wp-content/uploads/2013/09/business-office-furniture-62.jpg" style="background-attachment: fixed; background-repeat: no-repeat;">

	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="col-lg-2">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-lg-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong style="font-size: 24px;">${employer.name }</strong>
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
						<strong>Categories:</strong>
					</p>
					<p>
						<c:forEach var="category" items="${employer.categories}"
							varStatus="loop">
									${category.name}<c:if test="${!loop.last}">, </c:if>
						</c:forEach>
					</p>
				</div>
			</div>
			<div class="panel panel-default">
				<div class="panel-heading">
					<strong style="font-size: 20px;">Description</strong>
				</div>
				<div class="panel-body">
					<p>${employer.description}</p>
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