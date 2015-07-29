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
		<form:form action="regCandidate" modelAttribute="candidate" method="post">
			<form:input path="info.login" />
			<form:input path="info.password" />
			<form:input path="cv" />
			<input type="submit" value="Register" />
		</form:form>
	</center>
</body>
</html>