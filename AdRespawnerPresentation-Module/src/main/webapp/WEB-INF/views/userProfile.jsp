<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>AdRespawner - User profile</title>
	<meta charset="utf-8" />
	<script src="<spring:url value="/resources/js/lib/jquery-3.0.0.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/style.css" />" />
</head>
<body>
	<h4>User profile</h4>
	<h3>Name: ${user.firstName} ${user.lastName}</h3>
	<h4>email: ${user.email}</h4>
	<h4>login: ${user.login}</h4>
	<h4>sex: ${user.sex}</h4>
	<h4>birthdate: ${user.birthDate}</h4>
	<a href="<spring:url value="${user.photo.fileSystemPath}" />">
		<img src="<spring:url value="${user.photo.fileSystemPath}" />" width="300" height="200" />
	</a>
	<h5>Contacts</h5>
	<c:forEach items="${user.contacts}" var="contact">
		<p>${contact.countryCode} ${contact.phoneNumber}</p>
	</c:forEach>
	<a href="#">Back</a>
</body>
</html>