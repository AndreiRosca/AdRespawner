<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>AdRespawner - ${ad.title}</title>
	<meta charset="utf-8" />
	<script src="<spring:url value="/resources/js/lib/jquery-3.0.0.js" />"></script>
	<script src="<spring:url value="/resources/js/sendMessageUtil.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/style.css" />" />
</head>
<body>
	<h1>Welcome to AdRespawner!</h1>
	<a href="<spring:url value="/users/${ad.adAuthor.id}" />">${ad.adAuthor.login}</a><br/>
	<a href="#" id="sendMessageLink">Send message</a>
	<script>
		$("#sendMessageLink").data("adAuthorId", ${ad.adAuthor.id});
	</script>
	<div id="messageContainer"></div>
	<br/>
	<h4>${ad.title}</h4>
	<p>${ad.description}</p>
	<p>${ad.region.country}, ${ad.region.municipality}</p>
	<p>${ad.price.amount} ${ad.price.currency}</p>
	<p>${ad.postingDate}</p>
	
	<c:forEach items="${ad.photos}" var="photo">
		<a href="<spring:url value="${photo.fileSystemPath}" />">
			<img src="<spring:url value="${photo.fileSystemPath}" />" width="300" height="100" alt="Photo" />
		</a>
	</c:forEach>
	<br/>
	
	<h3>Characteristics</h3>
	<c:forEach items="${ad.characteristics}" var="characteristic">
		<p>${characteristic.name} -> ${characteristic.value}</p>
	</c:forEach>
	<br/>
	
	<h5>Contacts</h5>
	<c:forEach items="${ad.adAuthor.contacts}" var="contact">
		<p>${contact.countryCode} ${contact.phoneNumber}</p>
	</c:forEach>
	<br/>
	<a href="<spring:url value="/ads/${ad.subCategory.id}" />">Back</a>
</body>
</html>