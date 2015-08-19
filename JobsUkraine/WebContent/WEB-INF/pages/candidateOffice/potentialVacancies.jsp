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
		<div class="panel-heading">
			<strong style="font-size: 20px;">Potential vacancies</strong>
		</div>
		<div class="panel-body">
			<div class="panel-group" id="accordion">
				<c:forEach items="${vacancies}" var="vacancy">
					<div class="panel panel-default" id="panel1">
						<div class="panel-heading">
							<div class="panel-title row">
								<div class="col-lg-8">
									<a style="text-decoration: none;" data-toggle="collapse"
										data-target="#${vacancy.id}" href="#"> ${vacancy.name}</a>
								</div>
								<div class="col-lg-4">
									<p align="right">${vacancy.salary}$</p>
								</div>
							</div>
						</div>
						<div id="${vacancy.id}" class="panel-collapse collapse">
							<div class="panel-heading">
								<p>
									<strong>Category:</strong> ${vacancy.category.name}
								</p>
								<strong>Description:</strong>
								<c:if test="${vacancy.description.length()<300}">
								${vacancy.description}
							</c:if>

								<c:if test="${vacancy.description.length()>=300}">
								${vacancy.description.substring(0,300)}...
							</c:if>
							</div>
							<div class="panel-body" align="right">
								<button class="btn btn-black"
									style="width: 100px; height: 35px;" type="button"
									onclick="location.href='<c:url value="/vacancy/${vacancy.id}" />'">More</button>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>