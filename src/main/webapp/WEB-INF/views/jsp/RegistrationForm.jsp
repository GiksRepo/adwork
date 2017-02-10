<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
<spring:url value="/saveRegistartionDetails" var="target"/>
<form:form modelAttribute="userRegistration" action="${target}">
<table>
	<tr>
		<td>First Name</td>
		<td><form:input path="firstName" type="text"/> <form:errors path="firstName"/> </td>
	</tr>
	<tr>
		<td>Middle Name</td>
		<td><form:input path="middleName" type="text"/> </td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><form:input path="lastName" type="text"/> <form:errors path="lastName"/></td>
	</tr>
	<tr>
		<td>Gender</td>
		<td>
			<form:radiobutton path="gender" value="Male"/>Male
			<form:radiobutton path="gender" value="Female"/>Female
			<form:errors path="gender"/>
		</td>
	</tr>
	<tr>
		<td>Date Of Birth</td>
		<td><form:input path="dateOfBirth" type="text"/> <form:errors path="dateOfBirth"/></td>
	</tr>
	<tr>
		<td>Email Id</td>
		<td><form:input path="emailId" type="text"/> <form:errors path="emailId"/></td>
	</tr>
	<tr>
		<td>Phone No</td>
		<td><form:input path="phoneNo" type="text"/> <form:errors path="phoneNo"/></td>
	</tr>
	<tr>
		<td>Country</td>
		<td>
			<form:select path="country">
				<form:option value="">Select Country</form:option>
				<form:option value="INDIA">India</form:option>
				<form:option value="NEPAL">Nepal</form:option>
			</form:select>
			<form:errors path="country"/>
		</td>
	</tr>
	<tr>
		<td>State</td>
		<td>
			<form:select path="state">
				<form:option value="">Select State</form:option>
				<form:option value="UTTARPRADESH">Uttarpradesh</form:option>
				<form:option value="UTTARAKHAND">Uttarakhand</form:option>
			</form:select>
			<form:errors path="state"/>
		</td>
	</tr>
	<tr>
		<td>City</td>
		<td>
			<form:select path="city">
				<form:option value="">Select City</form:option>
				<form:option value="DEHRA_DUN">Dehra Dun</form:option>
				<form:option value="HARIDWAR">Haridwar</form:option>
			</form:select>
			<form:errors path="city"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="Register"/>
			
		</td>
	</tr>
</table>
</form:form>
 <a href="javascript:formSubmit()"> Logout</a>
<c:url value="/logout" var="logoutUrl"/>

<form action="${logoutUrl}" method="post" id="logoutForm">
	  <input type="hidden"
		name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>

	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>
</body>
</html>