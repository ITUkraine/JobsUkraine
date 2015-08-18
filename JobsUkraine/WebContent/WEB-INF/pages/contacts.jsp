<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contacts</title>
<script type="text/javascript"
	src="http://maps.google.com/maps/api/js?sensor=TRUEORFALSE">
	
</script>
<script src="<c:url value="/resources/js/map.js" />"></script>
</head>
<body onload="initialize()">
	<%@ include file="header.jsp"%>
	<img src="/JobsUkraine/resources/css/images/contacts.png"
		style="width: 100%; margin-top: -20px;" />
	<div class="container" style="margin-top: -55px;">
		<div class="col-lg-6">
			<div class="col-lg-11 panel panel-default">
				<div class="panel-heading">
					<strong style="font-size: 24px;">Contact us</strong>
				</div>
				<div class="panel-body">
					<p>JobsUkraine Lviv</p>
					<p>info@jobsukraine.com.ua</p>
					<p>Tel: +380 97 73 00 963</p>
					<p>Skype: jobsukraine</p>
				</div>
			</div>
			<div class="col-lg-11 panel panel-default">
				<div class="panel-heading">
					<strong style="font-size: 24px;">We in social networks</strong>
				</div>
				<div class="panel-body">
					<a href="https://www.facebook.com/jobsukraine?fref=ts"><img
						src="<c:url value="/resources/css/images/footer-icons/facebook.png" />" /></a>
					<a href="https://twitter.com/infoJobsUkraine"><img
						src="<c:url value="/resources/css/images/footer-icons/twitter.png" />" /></a>
					<a href="https://www.linkedin.com/company/9411466"><img
						src="<c:url value="/resources/css/images/footer-icons/linkedin.png" />" /></a>
					<a href="https://plus.google.com/u/0/113965925287630219590/posts"><img
						src="<c:url value="/resources/css/images/footer-icons/g+.png" />" /></a>
					<a href="http://vk.com/public91525529"><img
						src="<c:url value="/resources/css/images/footer-icons/vk.png" />" /></a>
				</div>
			</div>
		</div>
		<div class="col-lg-6 panel panel-default">
			<div class="panel-heading">
				<strong style="font-size: 24px;">Where you can find us</strong>
			</div>
			<div class="panel-body">
				<div id="map_canvas" style="width: 500px; height: 300px"></div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
