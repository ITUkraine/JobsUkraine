<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="panel panel-default">
		<div class="panel-heading">Potential vacancies</div>
		<div class="panel-body">
			<div class="panel-group" id="accordion">
				<c:forEach items="${vacancies}" var="vacancy">
					<div class="panel panel-default" id="panel1">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-target="#${vacancy.id}" href="#">
									${vacancy.name}, ${vacancy.category.name}, ${vacancy.salary } </a>
							</h4>
						</div>
						<div id="${vacancy.id}" class="panel-collapse collapse">
							<div class="panel-heading" style="word-wrap: break-word;">
								${vacancy.description}</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>