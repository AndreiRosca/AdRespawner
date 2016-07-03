<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>AdRespawner - categories</title>
	<meta charset="utf-8" />
	<script src="<spring:url value="/resources/js/lib/jquery-3.0.0.js" />"></script>
</head>
<body>
	<h1>Welcome to AdRespawner!</h1>
	<h4>Categories</h4>
	<ul>
		<c:forEach items="${categoryList}" var="category">
			<li>${category.name}
				<ol>
				<c:forEach items="${category.subCategories}" var="subCategory">
					<li><a href="<spring:url value="/ads/${subCategory.id}" />">${subCategory.name}</a></li>
				</c:forEach>
				</ol>
			</li>
		</c:forEach>
	</ul>
</body>
</html>