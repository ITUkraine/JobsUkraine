<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
</head>
<body background="http://blog.placeit.net/wp-content/uploads/2014/10/3796bf864f1a4ab7adfa09b9c886079a.jpg">
	<%@ include file="header.jsp"%>
	<br>
	<br>
	<div class="container">
		<div class="col-md-4"></div>
		<div
			class="form-group col-md-4 panel panel-default transparent panel-center">
			<c:url value="/j_spring_security_check" var="loginUrl" />
			<form action="${loginUrl}" class="form-signin" role="form"
				method="post">
				<c:if test="${param.error != null}">
					<div class="alert alert-danger">Invalid login or password</div>

				</c:if>
				<c:if test="${param.logout != null}">
					<div class="alert alert-success text-center">Logout</div>

				</c:if>
				<img src="<c:url value="/resources/css/images/logo.png" />"
					style="margin: 30px;" /> <input type="text" id="j_username"
					name="j_username" class="form-control" placeholder="Login" required
					autofocus /> <br> <input type="password" id="j_password"
					name="j_password" class="form-control" placeholder="Password"
					required /> <input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" /> <br>
				<div align="center">
					<button class="btn btn-default" type="submit">Sign In</button>
				</div>
			</form>
		</div>
		<div class="col-md-4"></div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>