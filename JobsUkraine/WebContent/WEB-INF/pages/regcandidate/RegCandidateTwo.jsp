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

<title>Register</title>
</head>

<body background="/JobsUkraine/resources/pictures/coffee-notebook.png">
	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="panel panel-default col-md-4 panel-center" style="opacity:0.95;">
				<div class="panel-heading">
					<i style="font-size: 20px; font-family:">Step 2</i>
				</div>
				<div class="panel-body">
					<form:form modelAttribute="candidate" action="addCandidateInfo2"
						method="POST">
						<fieldset>
							<p>Last name:</p>
							<form:input class="form-control" path="lastName" size="40" />
							<div class="valid-error">
								<form:errors path="lastName" />
							</div>
							<p>Name:</p>
							<form:input class="form-control" path="name" size="40" />
							<div class="valid-error">
								<form:errors path="name" />
							</div>
							<p>Gender:</p>
							<form:select path="sex" class="form-control" id="sel1">
								<option>male</option>
								<option>female</option>
							</form:select>

							<p>Birthday:</p>
							<form:input id="datepicker" class="form-control"
								path="dateOfBirth" size="40" />
							<div class="valid-error">
								<form:errors path="dateOfBirth" />
							</div>
							<p>E-mail:</p>
							<form:input class="form-control" path="email" size="40" />
							<div class="valid-error">
								<form:errors path="email" />
							</div>
							<p>City where you looking for work:</p>
							<form:input class="form-control" path="cityWhereLookingForWork"
								size="40" />
							<div class="valid-error">
								<form:errors path="cityWhereLookingForWork" />
							</div>
							<p>Mobile phone</p>
							<form:input class="form-control" path="mobileNumber" size="40" />
							<div class="valid-error">
								<form:errors path="mobileNumber" />
							</div>
							<br>
							<div align="right">
								<button type="submit" class="btn btn-default"
									style="width: 120px;">Next</button>
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