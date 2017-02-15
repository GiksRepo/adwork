<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport"    content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><tiles:getAsString name="PageTitle"/></title>
<spring:url value="resources/assets/images/gt_favicon.png" var="shortcutIcon"/>
<link rel="shortcut icon" href="${shortcutIcon}">
	
<link rel="stylesheet" media="screen" href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,700">

<spring:url value="resources/assets/css/bootstrap.min.css" var="bootstrapCss"/>
<link rel="stylesheet" href="${bootstrapCss}">

<spring:url value="resources/assets/css/font-awesome.min.css" var="fontCss"/>
<link rel="stylesheet" href="${fontCss}">

<!-- Custom styles for our template -->
<spring:url value="resources/assets/css/bootstrap-theme.css" var="themeCss"/>
<link rel="stylesheet" href="${themeCss}" media="screen" >

<spring:url value="resources/assets/css/main.css" var="mainCss"/>
<link rel="stylesheet" href="${mainCss}">

</head>
<body class="home">
		<tiles:insertAttribute name="headerMenu"/>

		<tiles:insertAttribute name="headerBody"/>
	
		<tiles:insertAttribute name="footer"/>
	
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<spring:url value="resources/assets/js/headroom.min.js" var="headroomjs"/>
<script src="${headroomjs}"></script>
<spring:url value="resources/assets/js/jQuery.headroom.min.js" var="jqueryheadroomjs"/>
<script src="${jqueryheadroomjs}"></script>
<spring:url value="resources/assets/js/template.js" var="templatejs"/>
<script src="${templatejs}"></script>
<spring:url value="resources/assets/js/adwork.js" var="adworkjs"/>
<script src="${adworkjs}"></script>
</body>
</html>