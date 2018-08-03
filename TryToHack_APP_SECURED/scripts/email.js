window.email = {};

email.send = function(receiver, sender, senderPSW, subject, message){
	var request;
	
	if(request = this.getXmlHttpRequest()){
		request.open('POST', 'Accueil?action=email&receiver=' + receiver 
				+ '&sender=' + sender 
				+ '&senderPSW=' + senderPSW
				+ '&subject=' + subject 
				+ '&message=' + message);
		request.send(null);
		
	}
};

email.dosendbtn = function() {
	var values = [
	              document.getElementById('emailDest').value,
	              document.getElementById('emailSender').value,
				  document.getElementById('emailSenderPsw').value,
	              document.getElementById('emailSubject').value,
	              document.getElementById('emailMsg').value,
	              ];
	
	verifiedEscaping = true;
	values.forEach(function(value){
		if (!value || !value.replace(/^\s\s*/, '').replace(/\s\s*$/, '').length > 0)
			{
				verfiedEscaping = false;
			}
	})
	if (verifiedEscaping) {
		this.send(values[0],values[1], values[2], values[3],values[4]);
		
		document.getElementById('emailDest').value = '';
        document.getElementById('emailSender').value= '';
		document.getElementById('emailSenderPsw').value='';
        document.getElementById('emailSubject').value= '';
        document.getElementById('emailMsg').value= '';
	}else{
		document.getElementById('emailDest').value = 'fail';
	}
};

email.getXmlHttpRequest = function() {
	if (window.XMLHttpRequest
			&& (window.location.protocol !== 'file:' || !window.ActiveXObject))
		return new XMLHttpRequest();
	try {
		return new ActiveXObject('Microsoft.XMLHTTP');
	} catch (e) {
		throw new Error('XMLHttpRequest not supported');
	}
};