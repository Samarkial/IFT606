<%@ page import="java.util.*,java.text.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
	<head>
		<title>Try to hack</title>
		<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

		<script type="text/javascript" src="scripts/chat.js"></script>
		<script type="text/javascript" src="scripts/email.js"></script>
		
		<style>
			body {margin:0;}
			
			.icon-bar {
			    width: 100%;
			    background-color: #555;
			    overflow: auto;
			}
			
			.icon-bar a {
			    float: left;
			    width: 20%;
			    text-align: center;
			    padding: 12px 0;
			    transition: all 0.3s ease;
			    color: white;
			    font-size: 36px;
			}
			
			.icon-bar a:hover {
			    background-color:#00b8e6;
			}
			
			#mainFrame {
			    margin: auto;
			    width: 100%;
			    height: 700px;
			 
			    padding: 100px;
			}
			.box1{
				width: 400px;
			    height: 500px;
			    border: 1px solid w3-light-grey;
			    float: left;
			    text-align: center;
			    border-radius: 5px;
			    vertical-align: middle;
			    margin-top: 23px;
			   
			}
			.box2{
				width: 65%;
			    height: 500px;
			    border: 1px solid w3-light-grey;
			    float: right;
			    margin: 0 auto;
			    border-radius: 5px;
			
			    
			}
			.container {
			    border: 2px solid #dedede;
			    background-color: #f1f1f1;
			    border-radius: 5px;
			    padding: 10px;
			    margin: 10px 0;
			}
			
			.darker {
			    border-color: #ccc;
			    background-color: #ddd;
			}
			
			.container::after {
			    content: "";
			    clear: both;
			    display: table;
			}
			
			.container img {
			    float: left;
			    max-width: 60px;
			    width: 100%;
			    margin-right: 20px;
			    border-radius: 50%;
			}
			
			.container img.right {
			    float: right;
			    margin-left: 20px;
			    margin-right:0;
			}
			
			.time-right {
			    float: right;
			    color: #aaa;
			}
			
			.time-left {
			    float: left;
			    color: #999;
			}
			.content {
				height: 100%;
				overflow: auto;
				border: 1px solid w3-light-grey;
			}

			.txtInput {				
				border: 2px solid #dedede;
			    background-color: #f1f1f1;
			    border-radius: 5px;
			    padding: 10px;
			    margin: 10px 0;
			    width: 100%;
			}
			
			.box2{
				border:1px solid #dedede;
			}
		</style>
		
	</head>

	<body>
		<div class="icon-bar">
		  <a href="#"><i class="fa fa-user"></i></a> 
		  <a href="#"><i class="fa fa-search"></i></a> 
		  <a href="#"><i class="fa fa-envelope"></i></a> 
		  <a href="#"><i class="fa fa-address-book"></i></a>
		  <a href="Logout"><i class="fa fa-sign-out"></i></a> 
		</div>
		<div id="mainFrame">
			<div class="box1">
				<input type="file" name="img" multiple>
				<div class="sendMessage">
				  <form class="w3-container w3-card-4 w3-light-grey w3-text-blue w3-margin">
					 
					<div class="w3-row w3-section">
					  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
					    <div class="w3-rest">
					      <input id="emailDest" class="w3-input w3-border" name="first" type="text" placeholder="Email destinataire">
					    </div>
					</div>
		
					<div class="w3-row w3-section">
					  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
					    <div class="w3-rest">
					      <input id="emailSender" class="w3-input w3-border" name="last" type="text" placeholder="Gmail emmetteur">
					    </div>
					</div>

					<div class="w3-row w3-section">
						<div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-key"></i></div>
						  <div class="w3-rest">
							<input id="emailSenderPsw" class="w3-input w3-border" name="last" type="password" placeholder="FakePSW">
						  </div>
					  </div>
					
					<div class="w3-row w3-section">
					  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil-square-o"></i></div>
					    <div class="w3-rest">
					      <input placeholder="Subject" id="emailSubject" class="w3-input w3-border" name="last"></textarea>
					    </div>
					</div>
		
					<div class="w3-row w3-section">
					  <div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-pencil"></i></div>
					    <div class="w3-rest">
					      <input id="emailMsg" class="w3-input w3-border" name="message" type="text" placeholder="Message">
					    </div>
					</div>
		
					<button type="submit" class="w3-button w3-block w3-section w3-blue w3-ripple w3-padding" onclick="email.dosendbtn();" >Send</button>
					</form>
				</div>
			</div>
			<div class="box2">
				<h2>Messages</h2>
				<div id="content" class="content"></div>
					<div style="margin-top: -50px;">
						<textarea id="txtInput" class="txtInput" onkeyup="dokeyup(event);" placeholder="Message"></textarea>
					</div>
					<input id="btnEnvoyer" type="button" value="Envoyer" onclick="dosendbtn();" /> 
			</div>
		</div>
	</body>
</html>
