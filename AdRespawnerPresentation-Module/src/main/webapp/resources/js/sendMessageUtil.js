
	$(document).ready(function () {
		$("#sendMessageLink").click(function (e) {
			e.preventDefault();
			$("#messageContainer").append("<textarea id='adOwnerMessage' rows='4' cols='20'></textarea>")
								  .append("<button id='sendMessageButton'>SendMessage</button>");
			$("#sendMessageButton").click(function (e) {
				$.ajax({ url : "" });
				$("#messageContainer").empty();
			});
		});
	});
	