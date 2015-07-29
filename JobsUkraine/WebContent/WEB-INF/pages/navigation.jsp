<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="shortcut icon" href="<c:url value="/resources/pictures/icon.png" />">
<style>
ul#menu {
    padding: 0;
}

ul#menu li {
    display: inline;
}

ul#menu li a {
    background-color: #0099FF;
    color: white;
    padding: 10px 25px;
    text-decoration: none;
    border-radius: 4px 4px 0 0;
}

ul#menu li a:hover {
    background-color: orange;
}
</style>
</head>
<body>
	<div align="center"><img src="<c:url value="/resources/pictures/JobsUkr.PNG" />" ></div>
	
		<ul id="menu">
			<li>
				<a href="/JobsUkraine">  Home  </a>
			</li>
			<li>
				<a href="employers">  Employers  </a>
			</li>
			<li>
				<a href="candidates">  Candidates  </a>
			</li>
			<li>
				<a href="login">  Sign In  </a>
			</li>
			<li>
				<a href="contacts">  Contact us  </a>
			</li>
		</ul>

</body>
</html>