<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Us</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<img style="margin: 0px auto; display: block"
		src="<c:url value="/resources/pictures/1.bmp" />">
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-3">
				<h4>Why choose our services</h4>
				<p>
					<br> We are a boutique staffing and recruitment company, for a
					wide variety of businesses, with a special focus on IT. For IT
					specialist we have developed a unique in house certification
					program, which guarantees a certain level of expertise for each
					candidate.
				</p>
			</div>
			<div class="col-md-4">
				<h4>Our process</h4>
				<p>
					<br> Every possible candidate has been personally interviewed
					by one of our specialist. Checked for his credentials and expertise
					to guarantee the best possible person for a specific vacancy you
					need to fill. All our IT specialist have been screened and tested.
					We use a special testing method to determine exactly the level of
					specific knowledge, which can be proven with a certification.
				</p>

			</div>
			<div class="col-md-3">
				<h4>Our process</h4>
				<p>
					<br>We have a team in Lviv, Ukraine that consists of highly
					skilled and experienced HR personnel.
				</p>
			</div>
			<div class="col-md-1"></div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>
</body>
</html>