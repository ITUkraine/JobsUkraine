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
<title>Register</title>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="form-group col-md-4">
				<form:form modelAttribute="candidate" action="regCandidateNew"
					method="POST">
					<fieldset>
						<p>Education</p>
						<form:input class="form-control" path="education" size="40" />

						<p>Experience</p>
						<form:input class="form-control" path="experience" size="40" />

						<p>City for work</p>
						<form:input class="form-control" path="cityWhereLookingForWork"
							size="40" />

						<%-- <p>Start date</p>
						<form:input class="form-control" path="dateStartToWork" size="40" /> --%>

						<p>Dream job</p>
						<form:input class="form-control" path="dreamJob" size="40" />

						<p>Primary skills</p>
						<form:textarea class="form-control" path="primarySkills" />
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
