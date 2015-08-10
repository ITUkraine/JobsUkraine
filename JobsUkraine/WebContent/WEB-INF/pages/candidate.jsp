<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidate</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
			<br>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="panel-title">${candidate.lastName}
						${candidate.name}</h1>
				</div>
				<div class="panel-body">
					<p>${candidate}</p>
					<br>
				</div>
			</div>
			<sec:authorize access="hasRole('ROLE_EMPLOYER')">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h1 class="panel-title">Add feedback</h1>
					</div>
					<div class="panel-body">
						<form:form class="form-group" action="addFeedBack"
							commandName="feedback" method="POST">
							<p>Category</p>
							<form:select class="form-control" id="sel1" path="category">
								<c:forEach var="category" items="${list}">
									<option value="${category.name}">${category.name}</option>
								</c:forEach>
							</form:select>
							<br>
							<p>Mark</p>
							<form:select class="form-control" path="mark">
								<c:forEach begin="1" end="10" var="i">
									<form:option value="${11-i}">${11-i}</form:option>
								</c:forEach>
							</form:select>
							<br>
							<p>Comment</p>
							<form:textarea rows="7" class="form-control" path="comment" />
							<br>
							<div align="right">
								<button type="submit" class="btn btn-default"
									style="width: 120px;">Add</button>
							</div>
						</form:form>
					</div>

				</div>
			</sec:authorize>
			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="panel-title">All feedbacks</h1>
				</div>
				<div class="panel-body">
					<c:forEach var="feedback" items="${candidate.feedbacks}">
						<div class="panel panel-default">
							<div class="panel-heading col-lg-12">
								<div class="col-lg-6">
									Author: <a href="/JobsUkraine/employer/${feedback.employer.id}">${feedback.employer.name}</a>
								</div>
								<div class="col-lg-6" align="right">
									<fmt:formatDate value="${feedback.date}"
										pattern="dd/MM/yyyy HH:mm:ss" />
								</div>
							</div>
							<div class="panel-heading">
								Category: ${feedback.category.name}<br> Mark:
								${feedback.mark}
							</div>
							<div class="panel-body">${feedback.comment}</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="col-lg-2"></div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>