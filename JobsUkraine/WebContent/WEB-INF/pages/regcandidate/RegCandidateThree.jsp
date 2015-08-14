<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="<c:url value="/resources/js/datepicker.js" />"></script>

<link rel="stylesheet"
	href="//cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.css" />
<script
	src="//cdn.jsdelivr.net/bootstrap.tagsinput/0.4.2/bootstrap-tagsinput.min.js"></script>

<title>Register</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="panel panel-default col-md-4">
				<div class="panel-heading">
					<i style="font-size: 20px; font-family:">Step 3</i>
				</div>
				<div class="panel-body">
					<form:form id="bootstrapTagsInputForm" modelAttribute="candidate"
						action="addCandidateCategory" method="POST">
						<fieldset>
							<p>Education:</p>
							<form:input class="form-control" path="education" size="40" />

							<p>Experience:</p>
							<form:input class="form-control" path="experience" size="40" />

							<p>Your address:</p>
							<form:input class="form-control" path="address" size="40" />

							<p>Start date</p>
							<form:input id="datepicker" class="form-control"
								path="dateStartToWork" size="40" />

							<p>Dream job:</p>
							<form:input class="form-control" path="dreamJob" size="40" />

							<p>Primary skills:</p>

							<form:input size="50" path="primarySkills" class="form-control"
								data-role="tagsinput" />

							<br> <br>
							<div align="right">
								<button type="submit" class="btn btn-default"
									style="width: 120px;">Next</button>
								<button type="submit" class="btn btn-default"
									style="width: 120px;">Skip</button>
							</div>
						</fieldset>
					</form:form>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>
