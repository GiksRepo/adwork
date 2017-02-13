<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Fixed navbar -->
	<div class="navbar navbar-inverse navbar-fixed-top headroom" >
		<div class="container">
			<div class="navbar-header">
				<!-- Button for smallest screens -->
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
				</button>
				<spring:url value="resources/assets/images/logo.png" var="Imagelogo"/>
				<a class="navbar-brand" href="index.html"><img src="${Imagelogo}" alt="Progressus HTML5 template"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav pull-right">
					<spring:url value="/" var="home"/>
					<li <c:if test="${curl eq 'home' }"> class="active"</c:if> >
						<a href="${home}">Home</a>
					</li>
					<li>
						<a href="about.html">About</a>
					</li>
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">More Pages <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="sidebar-left.html">Left Sidebar</a></li>
							<li class="active"><a href="sidebar-right.html">Right Sidebar</a></li>
						</ul>
					</li>
					<li>
						<a href="contact.html">Contact</a>
					</li>
					<spring:url value="/signin" var="signin"/>
					<li <c:if test="${curl eq 'signin' }"> class="active"</c:if> >
						<a class="btn" href="${signin}">SIGN IN / SIGN UP</a>
					</li>
				</ul>
			</div><!--/.nav-collapse -->
		</div>
	</div> 
	<!-- /.navbar -->