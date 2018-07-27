// 
//Source: https://github.com/benbai123/JSP_Servlet_Practice 
//
window.chat = {};

// post to send message to chat.do
chat.sendMsg = function(msg) {
	var request;

	// ------------------------------------- Pour XSS
	// -------------------------------------
	// msg = msg.replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g,
	// '&gt;').replace(/"/g, '&quot;').replace(/\n/g, '<br />');

	if (request = this.getXmlHttpRequest()) {
		request.open('POST', 'Accueil?action=send&msg=' + msg + '&time='
				+ new Date().getTime());
		request.send(null);
		var currentdate = new Date();
		var datetime = currentdate.getHours() + ":"
				+ (currentdate.getMinutes() < 10 ? '0' : '')
				+ currentdate.getMinutes();

		chat.updateContent('<div class="container"> <p>You said: ' + msg
				+ '</p> <span class="time-right">' + datetime
				+ '</span> </div>');
	}
};

// post 'get' action to chat.do to require new message if any
chat.startListen = function() {
	if (!chat.listen)
		chat.listen = setInterval(function() {
			var request;
			if (request = chat.getXmlHttpRequest()) {
				request.open('POST', 'Accueil?action=get&time='+ new Date().getTime());
				request.send(null);
				request.onreadystatechange = function() {
					if (request.readyState === 3) {
						if (request.status === 200) {
							var json = request.responseText;
							// has new message
							if (json && json.length) {
								// parse to array
								var obj = eval('(' + json + ')');
								var msg = '';
								for (var i = 0; i < obj.length; i++) {
									// msg += '<div>' + obj[i] + '</div>';

									var currentdate = new Date();
									var datetime = currentdate.getHours() + ":"
												+ (currentdate.getMinutes() < 10 ? '0' : '')
												+ currentdate.getMinutes();

									msg += '<div class="container darker"> <p>'
											+ obj[i]
											+ '</p> <span class="time-right">'
											+ datetime + '</span> </div>'
								}
								chat.updateContent(msg);
							}
						}
					}
				};
			}
		}, 3000);

};

chat.updateContent = function(msg) {
	var content = document.getElementById('content'), atBottom = (content.scrollTop + content.offsetHeight) >= content.scrollHeight;
	content.innerHTML += msg;
	// only scroll to bottom if it is at bottom before msg added
	if (atBottom)
		content.scrollTop = content.scrollHeight;
};

chat.dosendbtn = function() {
	var value = document.getElementById('txtInput').value;
	if (value && value.replace(/^\s\s*/, '').replace(/\s\s*$/, '').length > 0) {
		this.sendMsg(value);
		document.getElementById('txtInput').value = '';
	}
}

chat.dokeyup = function dokeyup(event) {
	if (!event) // IE will not pass event
		event = window.event;
	if (event.keyCode == 13 && !event.shiftKey) { // ENTER pressed
		var target = (event.currentTarget) ? event.currentTarget
				: event.srcElement, value = target.value;
		// make sure not only space char
		if (value
				&& value.replace(/^\s\s*/, '').replace(/\s\s*$/, '').length > 0) {
			this.sendMsg(target.value);
			target.value = '';
		}
	}
};
// get the XmlHttpRequest object
chat.getXmlHttpRequest = function() {
	if (window.XMLHttpRequest
			&& (window.location.protocol !== 'file:' || !window.ActiveXObject))
		return new XMLHttpRequest();
	try {
		return new ActiveXObject('Microsoft.XMLHTTP');
	} catch (e) {
		throw new Error('XMLHttpRequest not supported');
	}
};
onload = function() {
	chat.startListen();
};