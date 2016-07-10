
	$(document).ready(function () {
		var webSocket = new WebSocket("ws://localhost:8081/AdRespawnerPresentation-Module/newAdNotifier");
		
		webSocket.onmessage = function (freshAdAsJSON) {
			var freshAd = JSON.parse(freshAdAsJSON.data);
			insertFreshAdIntoList(freshAd);
		};
	});
	
	function insertFreshAdIntoList(freshAd) {
		var postingDate = new Date(freshAd.postingDate);
		var formattedDate =  postingDate.toLocaleDateString() + ", " + 
		 					 postingDate.toLocaleTimeString();
		var link = "<a href='" + location.href + "ads/" + freshAd.subCategory.id + "'>" + 
								  freshAd.subCategory.name + "</a>";
		$("#freshAdsList").append("<tr>" +
				"<td>" + freshAd.title +"</td>" +
				"<td>" + link + "</td>" +
				"<td>" + formattedDate + "</td>" +
				"</tr>");
	}
	