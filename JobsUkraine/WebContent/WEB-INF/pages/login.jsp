<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log In</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<br>
	<h1 align="center">Enter your login and password</h1>
	<br>
		<table align="center">
			<form:form action="login" commandName="loginForm">
				<tr>
					<td>Login:</td>
					<td><form:input path="login" size="30" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" size="30" /></td>
				</tr>
				<tr>
					<td></td>
					<td align="center"><input type="submit" value="Log In" /></td>
					<td></td>
				</tr>
			</form:form>
		</table>
</body>
</html>