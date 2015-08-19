<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vacancies</title>
</head>
<body background="/JobsUkraine/resources/pictures/vaca.png"   style="background-attachment: fixed; background-repeat: no-repeat;">
	<%@ include file="header.jsp"%>

	<div class="container">
		<div class="col-lg-2"></div>
		<div class="col-lg-8">
					<c:forEach var="vacancy" items="${vacancies}">
						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<div class="col-lg-8">
										<a style="font-size: 20px;"
											href="/JobsUkraine/vacancy/${vacancy.id}">${vacancy.name}
										</a>
									</div>
									<sec:authorize access="hasRole('ROLE_ADMIN')">
										<div class="col-lg-4">
											<c:if test="${employer.pictureURL == null}">
												<img alt="avatar" width="40px" height="40px"
													style="margin-right: 10px;"
													src="https://cdn3.iconfinder.com/data/icons/business-office-2/512/businessman_tie-512.png"></img>
											</c:if>
											<c:if test="${employer.pictureURL != null}">
												<img alt="avatar" width="40px" height="40px"
													style="margin-right: 10px;"
													src="<c:url value="${vacancy.employer.pictureURL}" />"></img>
											</c:if>
											<a style="text-decoration: none;"
												href="/JobsUkraine/employer/${vacancy.employer.id}">${vacancy.employer.name}</a>
										</div>
									</sec:authorize>
								</div>
							</div>
							<div class="panel-body">
								<p>
									<strong>Category:</strong> ${vacancy.category.name}
								</p>
								<p>
									<strong>Salary:</strong> ${vacancy.salary}$
								</p>
								<strong>Description:</strong>
								<c:if test="${vacancy.description.length()<555}">
								${vacancy.description}
							</c:if>

								<c:if test="${vacancy.description.length()>=555}">
								${vacancy.description.substring(0,555)}...
							</c:if>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		<div class="col-lg-2"></div>


	<%@ include file="footer.jsp"%>
</body>
</html>