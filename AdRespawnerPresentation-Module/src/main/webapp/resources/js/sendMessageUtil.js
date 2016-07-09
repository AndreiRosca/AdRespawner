
	$(document).ready(function () {
		$("#sendMessageLink").click(function (e) {
			e.preventDefault();
			$("#messageContainer").append("<textarea id='adOwnerMessage' rows='4' cols='20'></textarea>")
								  .append("<button id='sendMessageButton'>SendMessage</button>");
			$("#sendMessageButton").click(function () {
				var url = "http://localhost:8081/AdRespawnerPresentation-Module/sendMessage";
				var messageData = { message : $("#adOwnerMessage").val(),
									sender : { id : 2 },
									receiver : { id : $("#sendMessageLink").data("adAuthorId") }
								  };
				$.ajax({ url : url, 
						 method : "post",
						 data : JSON.stringify(messageData),
						 contentType : "application/json" });
				$("#messageContainer").empty();
			});
		});
	});
	