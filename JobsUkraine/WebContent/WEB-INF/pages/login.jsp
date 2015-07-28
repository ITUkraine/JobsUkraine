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
<%@ include file="navigation.jsp" %>
	<h1>Welcome!</h1>
<table>
	<form:form action="" commandName="loginForm">
	
			<tr>
				<td>Login:</td>
				<td ><form:input path="login" size="30" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="31" /></td>
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