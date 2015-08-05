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
	<%@ include file="../header.jsp"%>

	<div class="container-fluid">
		<div class="col-lg-1">space</div>
		<div class="col-lg-1">
			<%@ include file="sidebar.jsp"%>
		</div>
		<div class="col-lg-1"></div>
		<div class="col-lg-3">
			<h2>Add vacancy</h2>
			<div class="form-group">
				<form:form action="" commandName="vacancy"
					method="POST">
					<fieldset>
						<p>Name</p>
						<form:input class="form-control" path="name" size="40" />

						<p>Category</p>
						<form:select class="form-control" id="sel1" path="category">
							<c:forEach var="category" items="${list}">
								<option value="${category.name}">${category.name}</option>
							</c:forEach>
						</form:select>

						<p>Description</p>
						<form:textarea class="form-control" path="description" />

						<p>Salary</p>
						<form:input class="form-control" path="salary" />

						<br>
						<div align="right">
							<button type="submit" class="btn btn-default"
								style="width: 120px;">Add</button>
						</div>
					</fieldset>
				</form:form>
			</div>
		</div>
		<div class="col-lg-5"><%@ include file="vacanciesList.jsp"%></div>
		<div class="col-lg-1">space</div>
	</div>


	<%@ include file="../footer.jsp"%>
</body>
</html>