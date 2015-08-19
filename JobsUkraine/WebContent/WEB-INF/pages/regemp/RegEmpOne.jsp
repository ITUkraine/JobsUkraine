<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body background="/JobsUkraine/resources/pictures/coffee-notebook.png">
	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="panel panel-default col-md-4 panel-center" style="opacity:0.95;">
				<div class="panel-heading"><i style="font-size: 20px; font-family: ">Step 1</i></div>
				<div class="panel-body">
					<form:form modelAttribute="infoForm" action="addEmployerInfo"
						method="Post">
						<fieldset>
							<p>Login:</p>
							<form:input class="form-control" path="login" size="40" />
							<div class="valid-error">
								<form:errors path="login"></form:errors>
							</div>
							<p>Password:</p>
							<form:input class="form-control" path="password" type="password"
								size="40" />
							<div class="valid-error">
								<form:errors path="password"></form:errors>
							</div>
							<p>Confirm password:</p>
							<form:input class="form-control" path="confirmPassword"
								type="password" size="40" />
							<div class="valid-error">
								<form:errors path="confirmPassword"></form:errors>
							</div>
							<div class="valid-error">
								<p>${msg}</p>
							</div>

							<br>
							<div align="right">
								<button type="submit" class="btn btn-default"
									style="width: 120px;">Next</button>
							</div>
						</fieldset>
					</form:form>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>