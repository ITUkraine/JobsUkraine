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
			<div class="form-group col-md-4">
				<form:form modelAttribute="candidate" action="addCandidateInfo"
					method="Post">
					<fieldset>
						<p>Login:</p>
						<form:input class="form-control" path="info.login" size="40" />
						<p>Password:</p>
						<form:input class="form-control" path="info.password"
							type="password" size="40" />
						<p>Confirm password:</p>
						<form:input class="form-control" path="info.confirmPassword"
							type="password" size="40" />
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