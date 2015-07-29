<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
	<%@ include file="navigation.jsp"%>
	<center>
		<h1>Register new candidate</h1>
		<table>
			<form:form method="POST" action="regCandidate" modelAttribute="">
					<tr>
						<td>Login:</td>
						<td><form:input path="info.login" size="30" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:password path="info.password" size="30" /></td>
					</tr>
					<tr>
						<td>Name:</td>
						<td><form:input path="name" size="30" /></td>
					</tr>
					<tr>
						<td>Last name:</td>
						<td><form:input path="lastName" size="30" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><form:input path="email" size="30" /></td>
					</tr>
					<%-- <tr>
				<td>Birthday:</td>
				<td><form:input path="date" size="30" /></td>
			</tr> --%>
					<tr>
						<td>Phone:</td>
						<td><form:input path="mobileNumber" size="30" /></td>
					</tr>
					<tr>
						<td>Address:</td>
						<td><form:input path="address" size="30" /></td>
					</tr>
					<tr>
						<td>Primary skills:</td>
						<td><form:textarea path="primarySkills" size="30" /></td>
					</tr>
					<tr>
						<td>City:</td>
						<td><form:input path="sityWhereLookingForWork" size="30" /></td>
					</tr>
					<%-- <tr>
				<td>Start date:</td>
				<td><form:input path="dateStartToWork" size="30" /></td>
			</tr> --%>
					<tr>
						<td>Experience:</td>
						<td><form:input path="experience" size="30" /></td>
					</tr>
					<tr>
						<td>CV:</td>
						<td><form:input path="cv" size="30" /></td>
					</tr>
					<tr>
						<td>Dream job:</td>
						<td><form:input path="dreamJob" size="30" /></td>
					</tr>
					<tr>
						<td>Education:</td>
						<td><form:input path="education" size="30" /></td>
					</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Register" /></td>
					<td></td>
				</tr>
			</form:form>
		</table>
	</center>
</body>
</html>