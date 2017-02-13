<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<header id="head" class="secondary"></header>
<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<spring:url value="/" var="home"/>
			<li><a href="${home }">Home</a></li>
			<li class="active">Registration</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Registration</h1>
				</header>
				
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Register a new account</h3>
							
							<spring:url value="/signin" var="signin"/>
							<p class="text-center text-muted">For <a href="${signin }">Login</a> Page</p>
							<hr>
							<spring:url value="/saveRegistartionDetails" var="target"/>
							<form:form modelAttribute="userRegistration" action="${target}">
								<div class="top-margin">
									<label>First Name <span class="text-danger">*</span> </label>
									<form:input path="firstName" type="text" class="form-control"/> <form:errors path="firstName"/>
								</div>
								<div class="top-margin">
									<label>Middle Name</label>
									<form:input path="middleName" type="text" class="form-control"/>
								</div>
								<div class="top-margin">
									<label>Last Name <span class="text-danger">*</span> </label>
									<form:input path="lastName" type="text" class="form-control"/> <form:errors path="lastName"/>
								</div>
								<div class="top-margin">
									<label>Gender</label>
									<form:radiobutton path="gender" value="Male" />&nbsp;Male
									<form:radiobutton path="gender" value="Female" />&nbsp;Female
								</div>
								<div class="top-margin">
									<label>Email Address <span class="text-danger">*</span></label>
									<form:input path="emailId" type="text" class="form-control"/> <form:errors path="emailId"/>
								</div>
								<div class="top-margin">
									<label>Phone No <span class="text-danger">*</span> </label>
									<form:input path="phoneNo" type="text" class="form-control"/> <form:errors path="phoneNo"/>
								</div>
								<div class="top-margin">
									<label>Country <span class="text-danger">*</span> </label>
									<form:select path="country" items="${country }"/>
									<form:errors path="country"/>
								</div>
								<div class="top-margin">
									<label>State <span class="text-danger">*</span> </label>
									<form:select path="country" items="${state }"/>
									<form:errors path="country"/>
								</div>
								<div class="top-margin">
									<label>City <span class="text-danger">*</span> </label>
									<form:select path="country" items="${city }"/>
									<form:errors path="country"/>
								</div>
								
								<hr>

								<div class="row">
									<div class="col-lg-8">
										<label class="checkbox">
											<input type="checkbox"> 
											I've read the <a href="page_terms.html">Terms and Conditions</a>
										</label>                        
									</div>
									<div class="col-lg-4 text-right">
										<button class="btn btn-action" type="submit">Register</button>
									</div>
								</div>
							</form:form>
						</div>
					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->