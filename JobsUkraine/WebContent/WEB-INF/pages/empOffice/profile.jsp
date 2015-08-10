<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office | Profile</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container-fluid">
		<%@ include file="sidebar.jsp"%>
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
		<%@ include file="candidatesList.jsp"%>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>