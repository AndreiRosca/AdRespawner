<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>AdRespawner - ${ad.title}</title>
	<meta charset="utf-8" />
	<script src="<spring:url value="/resources/js/lib/jquery-3.0.0.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/style.css" />" />
</head>
<body>
	<h1>Welcome to AdRespawner!</h1>
	<h4>${ad.title}</h4>
	<p>${ad.description}</p>
	<p>${ad.region.country}, ${ad.region.municipality}</p>
	<p>${ad.price.amount} ${ad.price.currency}</p>
	<a href="<spring:url value="/ads/${ad.subCategory.id}" />">Back</a>
</body>
</html>