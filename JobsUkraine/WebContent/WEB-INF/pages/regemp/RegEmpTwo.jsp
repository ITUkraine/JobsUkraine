<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon"
	href="<c:url value="/resources/pictures/icon.png" />">
<title>Register</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="form-group col-md-4">
				<form:form modelAttribute="empForm" action="addEmpCategory"
					method="POST">
					<fieldset>

						<p>Name</p>
						<form:input class="form-control" path="name" size="40" />

						<p>E-mail</p>
						<form:input class="form-control" path="email" size="40" />

						<form:errors path="email" cssClass="error" />
					
						<p>Mobile phone</p>
						<form:input class="form-control" path="phone" size="40" />

						<p>Address</p>
						<form:input class="form-control" path="address" size="40" />

						<p>Description</p>
						<form:textarea class="form-control" path="description" />
						<br>
						<div align="right">
							<button type="submit" class="btn btn-default"
								style="width: 120px;">Next</button>
						</div>
					</fieldset>
				</form:form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>