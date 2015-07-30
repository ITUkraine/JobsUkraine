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
	href="<c:url value="/resources/css/pure/forms.css" />">
	<link rel="stylesheet"
	href="<c:url value="/resources/css/pure/buttons.css" />">

<title>Log In</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<br>
	<h1 align="center">Enter your login and password</h1>
	<br>
	<div align="center">
		<form:form class="pure-form pure-form-stacked" commandName="loginForm" action="candidateOffice">
			<fieldset>
				Login:
				<form:input path="login" size="40"/> 
				Password:
				<form:input path="password" type="password" size="40"/>
				<br>
				<button type="submit" class="pure-button pure-button-active" style="width: 120px; height: 30px;">Log In</button>
			</fieldset>
		</form:form>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>