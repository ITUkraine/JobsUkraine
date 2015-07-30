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
		<form:form
			modelAttribute="category" action="candidateOffice">
	
			<form:checkboxes items="${category}" path="name"/>
				

		
		</form:form>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>