//
// XSS TEST	:	<img src=x onerror="alert('Try to hack - XSS');"
//

function sendMsg(msg) {
	var request;
	if (request = window.self.getXmlHttpRequest()) {
		request.open('POST', 'Accueil?action=send&msg=' + msg + '&time='
				+ new Date().getTime());
		request.send(null);

		var currentdate = new Date();
		var datetime = currentdate.getHours() + ":"
				+ (currentdate.getMinutes() < 10 ? '0' : '')
				+ currentdate.getMinutes();

		updateContent('<div class="container"> <p>Vous avez dit: ' + msg
				+ '</p> <span class="time-right">' + datetime
				+ '</span> </div>');
	}
};

function startListen() {

	if (!self.listen)
		self.listen = setInterval(function() {
			var request;
			if (request = self.getXmlHttpRequest()) {
				request.open('POST', 'Accueil?action=get&time='
						+ new Date().getTime());
				request.send(null);

				request.onreadystatechange = function() {
					if (request.readyState === 3 && request.status === 200) {
						var json = request.responseText;
						if (json && json.length) {
							var obj = eval('(' + json + ')');
							var msg = '';
							for (var i = 0; i < obj.length; i++) {

								var currentdate = new Date();
								var datetime = currentdate.getHours()
										+ ":"
										+ (currentdate.getMinutes() < 10 ? '0'
												: '')
										+ currentdate.getMinutes();

								msg += '<div class="container darker"> <p>'
										+ obj[i]
										+ '</p> <span class="time-right">'
										+ datetime + '</span> </div>'
							}
							updateContent(msg);
						}
					}
				};
			}
		}, 3000);
};

function updateContent(msg) {
	var content = document.getElementById('content'), atBottom = (content.scrollTop + content.offsetHeight) >= content.scrollHeight;
	content.innerHTML += msg;
	if (atBottom)
		content.scrollTop = content.scrollHeight;
};

function sendBtn() {
	var value = document.getElementById('txtInput').value;
	if (value && value.replace(/^\s\s*/, '').replace(/\s\s*$/, '').length > 0) {
		sendMsg(value);
		document.getElementById('txtInput').value = '';
	}
};

function dokeyup(event) {
	if (!event)
		event = window.event;
	if (event.keyCode == 13 && !event.shiftKey) {
		var target = (event.currentTarget) ? event.currentTarget
				: event.srcElement, value = target.value;
		if (value
				&& value.replace(/^\s\s*/, '').replace(/\s\s*$/, '').length > 0) {
			this.sendMsg(target.value);
			target.value = '';
		}
	}
};

function getXmlHttpRequest() {
	if (window.XMLHttpRequest
			&& (window.location.protocol !== 'file:' || !window.ActiveXObject))
		return new XMLHttpRequest();
	try {
		return new ActiveXObject('Microsoft.XMLHTTP');
	} catch (e) {
		throw new Error('XMLHttpRequest not supported');
	}
};