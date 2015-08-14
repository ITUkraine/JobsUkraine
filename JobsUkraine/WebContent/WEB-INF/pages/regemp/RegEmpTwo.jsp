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
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="panel panel-default col-md-4">
				<div class="panel-heading">
					<i style="font-size: 20px; font-family:">Step 2</i>
				</div>
				<div class="panel-body">
					<form:form modelAttribute="empForm" action="addEmpCategory"
						method="POST">
						<fieldset>

							<p>Name</p>
							<form:input class="form-control" path="name" size="40" />
							<div class="valid-error">
								<form:errors path="name" />
							</div>

							<p>E-mail</p>
							<form:input class="form-control" path="email" size="40" />
							<div class="valid-error">
								<form:errors path="email" />
							</div>

							<p>Mobile phone</p>
							<form:input class="form-control" path="phone" size="40" />
							<div class="valid-error">
								<form:errors path="phone" />
							</div>

							<p>Address</p>
							<form:input class="form-control" path="address" size="40" />
							<div class="valid-error">
								<form:errors path="address" />
							</div>

							<p>Description</p>
							<form:textarea class="form-control" path="description" />
							<div class="valid-error">
								<form:errors path="description" />
							</div>

							<p>Web-site</p>
							<form:input class="form-control" path="website" value="http://" />

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