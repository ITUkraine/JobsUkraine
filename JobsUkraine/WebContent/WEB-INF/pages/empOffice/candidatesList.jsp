<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="col-lg-4">
		<div class="panel panel-default">
			<div class="panel-heading">Potential candidates</div>

			<ul class="nav nav-pills nav-stacked">
				<c:forEach items="${candidates}" var="candidate">
					<li><a href="#">${candidate}</a></li>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>