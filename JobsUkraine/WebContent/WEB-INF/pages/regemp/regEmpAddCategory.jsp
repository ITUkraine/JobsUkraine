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
<title>Register</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<form:form modelAttribute="listCat" method="POST" action="/something">
		<c:forEach items="${listCat}" var="category">
		<%-- 
			<form:checkbox path="category" value="${category}"
				label="${category.name}" /> --%>
			<br style="">${category.name}	
		</c:forEach>
	</form:form>
	<%@ include file="../footer.jsp"%>
</body>
</html>