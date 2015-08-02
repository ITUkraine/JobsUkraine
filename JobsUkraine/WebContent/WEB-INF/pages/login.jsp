<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon"
	href="<c:url value="/resources/pictures/icon.png" />">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap/bootstrap.css" />">

<title>Log In</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<br>
	<br>
	<div class="container">
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="form-group col-md-4">
				<form:form commandName="loginForm" action="loginCheck">
					<fieldset>
						<p>Login:</p>
						<form:input class="form-control" path="login" size="40" />
						<p>Password:</p>
						<form:input class="form-control" path="password" type="password"
							size="40" />
						<br>
						<div align="center">
							<button type="submit" class="btn btn-default"
								style="width: 100px;">Log In</button>
						</div>
					</fieldset>
				</form:form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>