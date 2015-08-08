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
		<h4 align="center">Add categories which include the activities of
			your company:</h4>
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="form-group col-md-4">
				<form:form commandName="candidate" method="POST"
					action="regCandidateNew">

					<form:checkboxes path="categories" items="${listCat}"
						itemLabel="name" itemValue="name" element="div"
						cssClass="row-fluid1" />
					<br>

					<div align="right">
						<button type="submit" class="btn btn-default"
							style="width: 120px;">Next</button>
					</div>


				</form:form>

			</div>
			<div class="col-md-4"></div>
		</div>
	</div>
	<%@ include file="../footer.jsp"%>
</body>
</html>