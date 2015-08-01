<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Office</title>
<link href="<c:url value="/resources/css/btn/btn.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap/bootstrap.css" />"
	rel="stylesheet">
<link rel="shortcut icon"
	href="<c:url value="/resources/pictures/icon.png" />">
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container-fluid">
		<div class="col-lg-1">space</div>
		<div class="col-lg-2">
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><img alt="avatar" width="100%" height="100%"
					src="<c:url value="/resources/pictures/icon.png" />"></img></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Vacancies</a></li>
			</ul>
		</div>
		<div class="col-lg-1">space</div>
		<div class="col-lg-4">
			<div class="form-group">
				<form:form action="addVacancy"
					commandName="vacancy" method="POST">
					<fieldset>
						<p>Name</p>
						<form:input class="form-control" path="name" size="40" />

						<p>Category</p>
						<form:select class="form-control" id="sel1" path="category">
							<c:forEach var="item" items="${list}">
								<option value="${item.name}">${item.name}</option>
							</c:forEach>
						</form:select>

						<p>Description</p>
						<form:textarea class="form-control" path="description" />

						<p>Salary</p>
						<form:input id="datepicker" class="form-control" path="salary"
							size="40" />

						<br>
						<div align="right">
							<button type="submit" class="btn btn-default"
								style="width: 120px;">Add</button>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
		<div class="col-lg-1">space</div>
		<div class="col-lg-2">
			<ul class="nav nav-pills nav-stacked">
				<li class="active"><a>Candidates</a></li>
				<li><a href="#">Candidate 1</a></li>
				<li><a href="#">Candidate 2</a></li>
			</ul>
		</div>
		<div class="col-lg-1">space</div>
	</div>


	<%@ include file="footer.jsp"%>
</body>
</html>