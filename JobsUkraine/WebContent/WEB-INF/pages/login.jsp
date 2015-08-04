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
				<c:url value="/j_spring_security_check" var="loginUrl" />
				<form action="${loginUrl}" class="form-signin" role="form"
					method="post">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							Error
						</div>

					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success text-center">
							Logout
						</div>

					</c:if>
					<div class="row text-center">
						<h2 class="form-signin-heading">
							Enter login and password
						</h2>
					</div>
					<input type="text" id="j_username" name="j_username"
						class="form-control"
						placeholder="Login" required
						autofocus /> <input type="password" id="j_password"
						name="j_password" class="form-control"
						placeholder="Password" required />

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Sign In
					</button>
				</form>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>