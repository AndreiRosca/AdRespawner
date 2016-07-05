<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>AdRespawner - Edit user profile</title>
	<meta charset="utf-8" />
	<script src="<spring:url value="/resources/js/lib/jquery-3.0.0.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/style.css" />" />
</head>
<body>
	<h4>Edit user profile</h4>
	<spring:url value="/users/${editedUser.id}/edit" var="formTargetUrl" />
	<form:form method="post" action="${formTargetUrl}" modelAttribute="editedUser" enctype="multipart/form-data">
		<fieldset>
			<legend>Edit user</legend>
			<label for="firstName">First Name:</label>
			<form:input path="firstName" id="firstName" /><br/>
			<label for="lastName">Last Name:</label>
			<form:input path="lastName" id="lastName" /><br/>
			<label for="email">Email:</label>
			<form:input path="email" id="email" /><br/>
			<label for="birthDate">Birth date:</label>
			<form:input path="birthDate" id="birthdate" /><br/>
			<label for="sex">Sex:</label>
			<form:select path="sex" items="${sexSelectValues}" id="sex" /><br/>
			<label for="profilePhoto">Profile photo:</label>
			<form:input id="profilePhoto" path="userPhotoFile" type="file" />
			
			<label>Contacts:</label>
			<div id="contactList">
			</div>
			<button id="addContact">Add</button>
			
			<input type="submit" value="Edit" />
		</fieldset>
	</form:form>
	<script>
		$("#addContact").click(function (e) {
			e.preventDefault();
			$("#contactList").append("<input type='text' name='contacts' /><br/>");
		});
	</script>
</body>
</html>