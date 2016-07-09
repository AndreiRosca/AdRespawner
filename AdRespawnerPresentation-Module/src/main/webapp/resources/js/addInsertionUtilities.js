
	$(document).ready(function () {
		$("#addPhotoButton").click(function (e) {
			e.preventDefault();
			$("#fileChooserContailer").append("<input type='file' name='adPhotos' /><br/>");
		});
	});

	$(document).ready(function () {
		$("#priceAmount").keyup(function () {
			var price = $(this).val();
			$("#priceCurrency option").each(function () {
				var currency = $(this).val().split("-").pop();
				var newCurrencyValue = (price) ? price + "-" + currency : currency;
				$(this).val(newCurrencyValue);
			});
		});
	});

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
					$("#subCategoryList").empty();
					for (let subCategory of category.subCategories) {
						$("#subCategoryList").append("<option value='" + 
								selectedAdDomainId + "-" + subCategory.id + "'>" + 
								subCategory.name + "</option>");
					}
				});
			});
		});
	});
	