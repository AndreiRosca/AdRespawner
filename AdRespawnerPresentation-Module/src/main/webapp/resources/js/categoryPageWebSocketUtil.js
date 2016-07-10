
	$(document).ready(function () {
		var endpointUrl = "ws://127.0.0.1:8081/AdRespawnerPresentation-Module/newAdNotifierByCategory/" +
			location.pathname.split("/").pop();
		var webSocket = new WebSocket(endpointUrl);
		
		webSocket.onmessage = function (freshAdAsJSON) {
			var freshAd = JSON.parse(freshAdAsJSON.data);
		};
	});
	
	function insertFreshAdIntoList(freshAd) {
		console.log(freshAd);		
	}
	