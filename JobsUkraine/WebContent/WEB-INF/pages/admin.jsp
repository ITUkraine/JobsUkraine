<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin office</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>

	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 align="center">Employers who choose candidates</h4>
				</div>
				<div class="panel-body">
					<div class="panel-group" id="accordion">
						<c:forEach items="${employers}" var="employer">
							<c:if test="${employer.candidates.size()!=0}">
								<div class="panel panel-default" id="panel1">
									<div class="panel-heading">
										<div class="panel-title row">
											<div class="col-lg-10">
												<a style="text-decoration: none;" data-toggle="collapse"
													data-target="#e${employer.id}" href="#"> <img
													alt="avatar" width="60px" height="60px"
													src="<c:url value="${employer.pictureURL}" />"></img> <strong
													style="margin-left: 10px;">${employer.name}</strong>
												</a>
											</div>
											<div align="right" class="col-lg-2">
												<a href="/JobsUkraine/employer/${employer.id}"> <img
													alt="avatar" width="30px" height="30px"
													src="<c:url value="/resources/pictures/link.jpg" />"></img></a>
											</div>
										</div>
									</div>
									<div id="e${employer.id}" class="panel-collapse collapse">
										<div class="panel-body" style="word-wrap: break-word;">
											<c:forEach items="${employer.candidates}" var="candidate">
												<div class="panel panel-default">
													<div class="panel-heading">

														<img alt="avatar" width="40px" height="40px"
															style="margin-right: 20px;"
															src="<c:url value="${candidate.pictureURL}" />"></img> <a
															style="font-size: 14px;"
															href="/JobsUkraine/candidate/${candidate.id}">${candidate.lastName}
															${candidate.name} </a>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h4 align="center">Candidates who choose vacancies</h4>
				</div>
				<div class="panel-body">
					<div class="panel-group" id="accordion">
						<c:forEach items="${candidates}" var="candidate">
							<c:if test="${candidate.vacancies.size()!=0}">
								<div class="panel panel-default" id="panel1">
									<div class="panel-heading">
										<div class="panel-title row">
											<div class="col-lg-10">
												<a style="text-decoration: none;" data-toggle="collapse"
													data-target="#c${candidate.id}" href="#"> <img
													alt="avatar" width="60px" height="60px"
													style="margin-right: 20px;"
													src="<c:url value="${candidate.pictureURL}" />"></img> <strong
													style="margin-left: 10px;">${candidate.lastName}
														${candidate.name}</strong>
												</a>
											</div>
											<div align="right" class="col-lg-2">
												<a href="/JobsUkraine/candidate/${candidate.id}"> <img
													alt="avatar" width="30px" height="30px"
													src="<c:url value="/resources/pictures/link.jpg" />"></img></a>
											</div>
										</div>
									</div>
									<div id="c${candidate.id}" class="panel-collapse collapse">
										<div class="panel-body" style="word-wrap: break-word;">
											<c:forEach items="${candidate.vacancies}" var="vacancy">
												<div class="panel panel-default">
													<div class="panel-heading">

														<img alt="avatar" width="40px" height="40px"
															src="<c:url value="${vacancy.employer.pictureURL}" />"></img>

														<a style="font-size: 14px; margin-left: 10px;"
															href="/JobsUkraine/employer/${vacancy.employer.id}">${vacancy.employer.name}</a>
														<a style="font-size: 14px; margin-left: 10px;"
															href="/JobsUkraine/vacancy/${vacancy.id}">${vacancy.name}</a>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>
</body>
</html>