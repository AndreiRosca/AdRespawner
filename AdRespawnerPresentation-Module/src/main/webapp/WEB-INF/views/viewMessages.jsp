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
	<table>
		<tr>
			<th>Date</th><th>Sender</th><th>Receiver</th><th>Message</th>
		</tr>
	<c:forEach items="${messageSet}" var="message">
		<tr>
			<td>${message.postingDate}</td>
			<td>${message.sender.login}</td>
			<td>${message.receiver.login}</td>
			<td>${message.message}</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>