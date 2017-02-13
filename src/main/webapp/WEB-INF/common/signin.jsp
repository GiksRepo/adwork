<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header id="head" class="secondary"></header>
<!-- container -->
	<div class="container">

		<ol class="breadcrumb">
			<spring:url value="/" var="home"/>
			<li><a href="${home }">Home</a></li>
			<li class="active">User access</li>
		</ol>

		<div class="row">
			
			<!-- Article main content -->
			<article class="col-xs-12 maincontent">
				<header class="page-header">
					<h1 class="page-title">Sign in</h1>
				</header>
					<c:if test="${not empty error}">
						<div align="center"><span class="text-danger">${error}</span></div>
					</c:if>
				<div class="col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
					<div class="panel panel-default">
						<div class="panel-body">
							<h3 class="thin text-center">Sign in to your account</h3>
							<spring:url value="/registartion" var="registartion"/>
							<p class="text-center text-muted">if you are not yet registered. Please <a href="${registartion }">Register here</a></p>
							<hr>
							<form name="signin" action="<c:url value='j_spring_security_check' />" method='POST' autocomplete="off">
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
								<div class="top-margin">
									<label>Username <span class="text-danger">*</span></label>
									<input type="text" class="form-control" name="username" required="required" value=""/>
								</div>
								<div class="top-margin">
									<label>Password <span class="text-danger">*</span></label>
									<input type="password" class="form-control" name="password" required="required" value=""/>
								</div>

								<hr>

								<div class="row">
									<div class="col-lg-8">
										<b><a href="">Forgot password?</a></b>
									</div>
									<div class="col-lg-4 text-right">
										<button class="btn btn-action" type="submit">Sign in</button>
									</div>
								</div>
							</form>
						</div>
					</div>

				</div>
				
			</article>
			<!-- /Article -->

		</div>
	</div>	<!-- /container -->