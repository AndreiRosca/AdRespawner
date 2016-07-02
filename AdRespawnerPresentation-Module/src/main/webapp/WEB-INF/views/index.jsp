<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>AdRespawner - welcome page</title>
	<meta charset="utf-8" />
	<script src="<spring:url value="/resources/js/lib/jquery-3.0.0.js" />"></script>
</head>
<body>
	<h1>Welcome to AdRespawner!</h1>
	<h4>Ad domains</h4>
	<ul>
		<c:forEach items="${adDomainList}" var="adDomain">
			<li><a href="<spring:url value="/categories/${adDomain.id}" />">${adDomain.name}</a></li>
		</c:forEach>
	</ul>
</body>
</html>