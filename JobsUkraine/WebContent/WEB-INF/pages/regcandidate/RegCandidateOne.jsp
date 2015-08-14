<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<%@ include file="../header.jsp"%>

	<div class="container">
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="panel panel-default col-md-4">
				<div class="panel-heading">
					<i style="font-size: 20px; font-family:">Step 1</i>
				</div>
				<div class="panel-body">
					<form:form modelAttribute="infoForm" action="addCandidateInfo"
						method="Post">
						<fieldset>
							<p>Login:</p>
							<form:input class="form-control" path="login" size="40" />
							<div class="valid-error">
								<form:errors path="login" />
							</div>
							<p>Password:</p>
							<form:input class="form-control" path="password" type="password"
								size="40" />
							<div class="valid-error">
								<form:errors path="password" />
							</div>
							<p>Confirm password:</p>
							<form:input class="form-control" path="confirmPassword"
								type="password" size="40" />
							<div class="valid-error">
								<form:errors path="confirmPassword" />
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
				<div class="col-md-4"></div>
			</div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>