<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="<c:url value="/resources/pictures/icon.png" />">
<link href="<c:url value="/resources/css/bootstrap/bootstrap.css" />"
	rel="stylesheet">
<title>Log In</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<!-- <br> 
	<h1 align="center">Enter your login and password</h1>
	<br> -->
	
				<form:form action="login" method="POST" commandName="loginInfo">
					<div class="form-group" style="width: 300">
						<label>Login</label> <input type="text" class="form-control"
							placeholder="Login" name="login">
					</div>
					<div class="form-group" style="width: 300">
						<label>Password</label> <input type="password"
							class="form-control" placeholder="Password" name="password">
					</div>
					<button type="submit" class="btn btn-default">Log In</button>
				</form:form>
			
	<%@ include file="footer.jsp"%>
</body>
</html>