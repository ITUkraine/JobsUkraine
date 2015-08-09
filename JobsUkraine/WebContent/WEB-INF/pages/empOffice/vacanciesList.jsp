<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="col-lg-4">
		<div class="panel panel-default">
			<div class="panel-heading">My vacancies</div>
			<div class="panel-body">
				<div class="panel-group" id="accordion">
					<c:forEach items="${vacancies}" var="vacancy">
						<div class="panel panel-default" id="panel1">
							<div class="panel-heading">
								<h4 class="panel-title">
									<a data-toggle="collapse" data-target="#collapse${vacancy.id}"
										href="#collapse${vacancy.id}"> ${vacancy.name},
										${vacancy.category.name}, ${vacancy.salary } </a>
								</h4>

							</div>
							<div id="collapse${vacancy.id}" class="panel-collapse collapse">
								<div class="panel-heading"
									style="word-wrap: break-word;">
									${vacancy.description}
									<div align="right">
										<button class="btn btn-default">edit</button>
										<button class="btn btn-default">delete</button>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>