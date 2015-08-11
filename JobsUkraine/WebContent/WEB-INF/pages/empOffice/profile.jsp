<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office | Profile</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="col-lg-2">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-lg-6">
			<div class=" col-lg-12 panel panel-default">
				<div class="panel-heading">
					<h3>${employer.name }</h3>
				</div>

				<div class="panel-heading">
					<h4>
						${employer.email } <br> ${employer.phone } <br> <a
							href="${employer.website} ">${employer.website}</a> <br>
						${employer.address }
					</h4>
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