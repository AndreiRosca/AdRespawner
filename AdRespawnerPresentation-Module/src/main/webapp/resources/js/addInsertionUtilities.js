
	$(document).ready(function () {
		$("#adCategory").change(function () {
			"use strict";
			var selectedAdDomainId = $("#adCategory option:selected").val();
			if (!selectedAdDomainId)
				return;
			var resourceUrl = "http://localhost:8081/AdRespawnerPresentation-Module/getCategories/" + 
				selectedAdDomainId;
			var request = $.ajax({ url : resourceUrl, 
								   method : "get", 
								   headers : { Accept : "application/json" } });
			request.done(function (categoryList) {
				$("#categoryList").empty();
				categoryList.forEach(function (category, index) {
					$("#categoryList").append("<option value='" + category.id + "'>" + category.name +"</option>");
					for (let subCategory of category.subCategories) {
						$("#subCategoryList").append("<option value='" + 
								selectedAdDomainId + "-" + subCategory.id + "'>" + 
								subCategory.name + "</option>");
					}
				});
			});
		});
	});
	