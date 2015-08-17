<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	<img src="/JobsUkraine/resources/css/images/registration/reg-blur.png"
		style="width: 100%; margin-top: -20px;" />
	<div class="container" style="margin-top: -350px;">
		<div align="center" class="col-lg-6">
			<button class="btn btn-register btn-register-yellow" type="button"
				onclick="location.href='regCandidate'">
				<img src="/JobsUkraine/resources/css/images/registration/ic1.png"
					style="width: 70px; height: 70px; margin-bottom: 10px;">
				<p>Find job</p>
			</button>
		</div>
		<div align="center" class="col-lg-6">
			<button class="btn btn-register btn-register-blue" type="button"
				onclick="location.href='regEmployer'">
				<img src="/JobsUkraine/resources/css/images/registration/ic2.png"
					style="width: 70px; height: 70px; margin-bottom: 10px;">
				<p>Post job</p>
			</button>
		</div>
	</div>
	<div class="container">
		<div class="col-lg-12">
			<div class="panel panel-default transparent"
				style="font-size: 17px; margin-top: 80px;">
				<div class="panel-body">
					<div class="col-lg-6">
						<h3>Job Seekers</h3>
						<p>Anyone looking for a job, temporary or permanent, can seek
							to get our help and expertise. We are looking for people with a
							passion for what they are doing. We try to offer the best to our
							Company Clients, so it is extremely important to be skillful, or
							have a particular expertise. Hard working, flexible and timely
							people will always find a good job that will create the
							circumstances to live a better life. Especially for IT specialist
							we have created an 'in house' testing method which will determine
							their level of expertise and can give them the possibility to be
							certified. Especially for our European clients this is essential.

							IT Specialist will be able to work for European Companies, while
							residing in Ukraine. We have the infrastructure in place to make
							this possible. We can offer different labor contracts, including
							FOP.</p>
					</div>
					<div class="col-lg-6">
						<h3>Employers</h3>
						<p>Whether you are looking to hire someone on a temporary
							basis or permanent basis, we are here to find the best qualified
							person for the job. When finding an employee it's not only
							important to find someone who can do the job, but also someone
							with the right work attitude and ethics. Someone who fits in the
							organization. We therefore not only look for certain job skills,
							but a lot more. Every possible candidate has been personally
							interviewed by one or more of our recruitment specialist. Their
							credentials and expertise checked to guarantee the best possible
							person for a specific vacancy you need to fill. All our IT
							specialists have been screened and tested. We use a special
							testing method to determine exactly the level of specific
							knowledge, which can be proven with a certification process.</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footer.jsp"%>

</body>
</html>