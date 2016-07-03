<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>AdRespawner - ads</title>
	<meta charset="utf-8" />
	<script src="<spring:url value="/resources/js/lib/jquery-3.0.0.js" />"></script>
</head>
<body>
	<h1>Welcome to AdRespawner!</h1>
	<h4>Ads</h4>
	<c:forEach items="${adList}" var="ad">
		<div>
			<p>${ad.title}</p>
			<p>${ad.description}</p>
			<p>${ad.region.country}, ${ad.region.municipality}</p>
			<p>${ad.price.amount} ${ad.price.currency}</p>
		</div>
	</c:forEach>
</body>
</html>