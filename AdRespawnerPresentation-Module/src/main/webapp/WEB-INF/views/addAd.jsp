<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>AdRespawner - new ad</title>
	<meta charset="utf-8" />
	<script src="<spring:url value="/resources/js/lib/jquery-3.0.0.js" />"></script>
	<link rel="stylesheet" type="text/css" href="<spring:url value="/resources/css/style.css" />" />
</head>
<body>
	<spring:url value="/addAd" var="targetFormUrl" />
	<form:form method="post" action="${targetFormUrl}" modelAttribute="newAd">
		<fieldset>
			<legend>Add ad</legend>
			<form:errors path="*" />
			<label for="adCategory">Category:</label>
			<form:select path="adDomain" id="adCategory">
				<option value="0">Select Ad domain</option>
				<c:forEach items="${adDomainList}" var="adDomain">
					<option value="${adDomain.id}">${adDomain.name}</option>
				</c:forEach>
			</form:select>
			<br/>
			<form:select id="categoryList" path="adCategory">
				<option value="0">Select category</option>
			</form:select>
			<label for="adTitle">Title:</label>
			<form:input path="title" id="adTitle" /><br/>
			<label for="adDescription">Description:</label>
			<form:textarea rows="3" cols="20" path="description" id="adDescription" /><br/>
			<input type="submit" value="Add" />
		</fieldset>
	</form:form>
	<script>
		$("#adCategory").change(function () {
			var selectedAdDomainId = $("#adCategory option:selected").val();
			console.log(selectedAdDomainId);
			var resourceUrl = "http://localhost:8080/AdRespawnerWebService-Module/rest/adDomains/" + selectedAdDomainId;
			var request = $.ajax({ url : resourceUrl, method : "get", headers : { Accept : "application/json" } });
			request.done(function (data) {
				var categoryList = JSON.parse(data);
				console.log(data);
				categoryList.forEach(function (category, index) {
					console.log(category);
					$("#categoryList").append("<option value='" + category.id + "'>" + category.name +"</option>");
				});
			});
		});
	</script>
</body>
</html>