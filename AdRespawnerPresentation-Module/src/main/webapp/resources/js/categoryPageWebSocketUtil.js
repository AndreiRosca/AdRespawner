
	$(document).ready(function () {
		var serverEndpointUrl = "ws://localhost:8081/AdRespawnerPresentation-Module/newAdNotifierByCategory/" +
			location.pathname.split("/").pop();
		var webSocket = new WebSocket(serverEndpointUrl);
		
		webSocket.onmessage = function (freshAdAsJSON) {
			var freshAd = JSON.parse(freshAdAsJSON.data);
			insertFreshAdIntoList(freshAd);
		};
	});
	
	function insertFreshAdIntoList(freshAd) {
		console.log(freshAd);
		var postingDate = new Date(freshAd.postingDate);
		var formattedDate =  postingDate.toLocaleDateString() + ", " + 
		 					 postingDate.toLocaleTimeString();
		var categoryLink = "<a href='" + location.origin + "ads/" + freshAd.subCategory.id + "'>" + 
								  freshAd.subCategory.name + "</a>";
		var adLink = "<a href='" + location.origin + "/ads/" + freshAd.subCategory.id + "/ad/" + freshAd.id +
			"'>" + freshAd.title + "</a>";
		$("#freshAdsList").append("<tr>" +
				"<td>" + adLink +"</td>" +
				"<td>" + categoryLink + "</td>" +
				"<td>" + formattedDate + "</td>" +
				"</tr>");
	}
	