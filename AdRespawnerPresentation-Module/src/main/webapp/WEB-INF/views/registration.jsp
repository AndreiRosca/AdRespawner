<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>AdRespawner - User registration</title>
	<meta charset="utf-8" />
	<script src="<spring:url value="/resources/js/lib/jquery-3.0.0.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/style.css" />" />
</head>
<body>
	<h4>User registration</h4>
	<spring:url value="/registration" var="forTargetUrl" />
	<form:form method="post" modelAttribute="user" action="${formTargetUrl}">
		<p>
			<form:errors path="*" />
		</p>
		<fieldset>
			<legend>Registration</legend>
			<label for="email">Email:</label>
			<form:input id="email" path="email" /><br/>
			<label for="login">Login:</label>
			<form:input id="login" path="login" /><br/>
			<label for="password">Password:</label>
			<form:password id="password" path="password" /><br/>
			<input type="submit" value="Register" />
		</fieldset>
	</form:form>
</body>
</html>