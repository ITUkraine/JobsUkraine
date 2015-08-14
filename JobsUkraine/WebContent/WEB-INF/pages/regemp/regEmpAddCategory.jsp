<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="raw">
			<div class="col-md-2"></div>
			<div class="panel panel-default col-md-8">
				<div class="panel-heading">
					<h3 align="center">Add categories which include the activities
						of your company:</h3>
				</div>
				<div class="panel-body">
					<div class="col-md-1"></div>
					<div class="col-md-11">
						<form:form commandName="empForm" method="POST"
							action="regEmployerNew">
							<br>
							<div class="valid-error">
								<strong>${msg}</strong>
							</div>
							<br>
							<div class="checkbox">
								<form:checkboxes path="categories" items="${listCat}"
									itemLabel="name" itemValue="name" element="li" />
							</div>
							<br>
							<br>
							<div align="right">
								<button type="submit" class="btn btn-default"
									style="width: 120px;">Next</button>
							</div>


						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>
</body>
</html>