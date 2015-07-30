<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Register</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div align="center">
		<form:form class="pure-form pure-form-stacked"
			modelAttribute="empForm" action="regEmployerNew" method="POST">
			<fieldset>

				<h3 align="center">Put your name:</h3>
				<form:input path="name" size="40" />
				
				<h3 align="center">Put your email:</h3>
				<form:input path="email" size="40" />
				
				<h3 align="center">Put your number:</h3>
				<form:input path="phone" size="40" />
				
				<h3 align="center">Put your Address:</h3>
				<form:input path="address" size="40" />
				
				<h3 align="center">Description:</h3>
				<form:textarea path="description" style="margin: 3px 859.3125px; width: 283px; height: 107px;"/>
				<button type="submit" class="pure-button pure-button-active"
					style="width: 120px; height: 30px;">Next</button>

			</fieldset>
		</form:form>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>