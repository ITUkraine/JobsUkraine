<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon"
	href="<c:url value="/resources/pictures/icon.png" />">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#datepicker").datepicker({});
	});
</script>

<title>Register</title>
</head>

<body>
	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="form-group col-md-4">
				<form:form modelAttribute="candidate" action="addCandidateInfo2"
					method="POST">
					<fieldset>

						<p>Last name</p>
						<form:input class="form-control" path="lastName" size="40" />

						<p>Name</p>
						<form:input class="form-control" path="name" size="40" />

						<p>Gender</p>
						<form:select path="sex" class="form-control" id="sel1">
							<option>male</option>
							<option>female</option>
						</form:select>


						<p>Birthday</p>
						<form:input id="datepicker" class="form-control"
							path="dateOfBirthInString" size="40" />


						<p>E-mail</p>
						<form:input class="form-control" path="email" size="40" />

						<p>Address</p>
						<form:input class="form-control" path="address" size="40" />

						<p>Mobile phone</p>
						<form:input class="form-control" path="mobileNumber" size="40" />

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
	<%@ include file="../footer.jsp"%>
</body>
</html>