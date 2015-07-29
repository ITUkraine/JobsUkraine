<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>

	<h1>Register new employer</h1>
	<table>
		<form:form modelAttribute="empForm" method="POST" action="regEmployerNew">
			<tr>
				<td>Login:</td>
				<td><form:input path="info.login" size="30" /></td>
			</tr>
			<tr>
				<td>Pass:</td>
				<td><form:password path="info.password" size="30" /></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><form:input path="name" size="30" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" size="30" /></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><form:input path="phone" size="30" /></td>
			</tr>
			<tr>
				<td>Adress:</td>
				<td><form:input path="adress" size="30" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:textarea path="description" size="30" /></td>
			</tr>
			<tr>
				<td>Website:</td>
				<td><form:input path="website" size="30" /></td>
			</tr>
			<tr>
				<td>PictureURL:</td>
				<td><form:input path="pictureURL" size="30" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Register" /></td>
				<td></td>
			</tr>
		</form:form>
	</table>
</body>
</html>