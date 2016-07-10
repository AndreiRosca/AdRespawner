
	$(document).ready(function () {
		var webSocket = new WebSocket("ws://localhost:8081/AdRespawnerPresentation-Module/newAdNotifier");
		
		webSocket.onmessage = function (freshAdAsJSON) {
			var freshAd = JSON.parse(freshAdAsJSON.data);
			insertFreshAdIntoList(freshAd);
		};
	});
	
	function insertFreshAdIntoList(freshAd) {
		var postingDate = new Date(freshAd.postingDate);
		$("#freshAdsList").append("<tr>" +
				"<td>" + freshAd.title +"</td>" +
				"<td>" + freshAd.subCategory.name + "</td>" +
				"<td>" + postingDate.toLocaleDateString() + ", " + 
						 postingDate.toLocaleTimeString() + "</td>" +
				"</tr>");
	}
	