<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">Potential candidates</div>
		<div class="panel-body">
			<c:forEach items="${candidates}" var="candidate">
				<div class="panel panel-default">
					<div class="panel-heading">
						<a href="/JobsUkraine/candidate/${candidate.id}">${candidate }</a>
					</div>
					<div class="panel-body"></div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>