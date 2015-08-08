<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
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
			<option value="/JobsUkraine/vacancy/${vacancy.id} ">${vacancy.name},
				${vacancy.category.name}, ${vacancy.salary }, ${vacancy.description }</option>
		</c:forEach>
	</select>
</body>
</html>