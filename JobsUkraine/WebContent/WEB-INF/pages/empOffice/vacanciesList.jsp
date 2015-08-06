<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Vacancies</h3>
	<select size="20" name="decision2" class="form-control"
		style="font-size: 20px"
		onchange="location = this.options[this.selectedIndex].value;">
		<c:forEach items="${vacancies}" var="vacancy">
			<option value="/JobsUkraine/vacancy/${vacancy.id} ">${vacancy.name}, ${vacancy.category.name}, ${vacancy.salary }, ${vacancy.description }</option>
		</c:forEach>
	</select>
</body>
</html>