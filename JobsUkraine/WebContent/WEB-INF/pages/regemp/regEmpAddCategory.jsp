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
<title>Add category</title>
<style type="text/css">
/* .row-fluid1 {
	display: block;
	width: 100%;
	min-height: 30px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	float: left;
	margin-left: 3.4482758620689653%;
} */
</style>
</head>
<body>
	<%@ include file="../header.jsp"%>
	<div class="container">
		<h4 align="center">Add categories which include the activities of
			your company:</h4>
		<div class="raw">
			<div class="col-md-4"></div>
			<div class="form-group col-md-4">
				<form:form commandName="empForm" method="POST" action="regEmployerNew">

					<div align="center">
						<form:checkboxes path="categories" items="${listCat}"
							element="div" cssClass="row-fluid1" />
					</div>
					<br>
					<br>
					<p>Put website of your company:</p>
					<form:input class="form-control" path="website" size="40" />

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