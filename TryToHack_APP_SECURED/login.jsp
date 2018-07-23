<%@ page import="java.util.*,java.text.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
	<head>
		<title>Try to hack</title>
		<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<style>	
		
			body{
				background-image:url(background.jpg);
				background-size:cover;
				background-repeat:no-repeat;
				background-position: top center ;
			}
			
			h1{
				color:white;
				font-weight:400;
				margin-left:5px;
				text-shadow: 0 1px 4px rgba(0,0,0,1);
				font-size:22px;
				display:inline;
				margin:0 auto;
			}
		
			.login_wrapper{
				position:fixed;
				top:20%;
				left:10%;
				margin:0 auto;
			}
			
			.register_btn{
				
				text-align:center;
			}
			
			.register_btn a{
				color:rgb(63, 159, 255);
				text-decoration:none;
			}
			
			.login_wrapper div{
				background-color:white;
				box-shadow: 0 0 12px 0 rgba(0,0,0,0.1), 0 10px 30px 0 rgba(0,0,0,0.5);
				border-radius:10px;
				padding:25px;
				width:225px;
			}
			
			.login_wrapper div h2{
				text-align:center;
				padding-bottom:15px;
			}
			
			.login_wrapper div p {
				color:#6A6D70;
				font-size:12px;
				margin:15px 0 5px 0;
			}
			
			.login_wrapper div input{
				width:100%;
				padding:10px 10px;
				border:1px solid #BABCBF;
				border-radius:5px;
				outline: none;
				background-color:white;
			}
			
			.login_wrapper div input:hover, .login_wrapper div input:focus, .login_wrapper div input:active{
				border:1px solid black;
			}
			
			#submit_btn:hover{
				opacity:0.8;
			}
			
			.copyright{
				position:fixed;
				right:0;
				left:0;
				bottom:20px;		
			}
			
			.copyright p {
				color: white ; //#6A6D70;
				text-align:right;
				font-size:12px;
				margin:15px 25px 5px 0;
				text-shadow: 0 1px 4px rgba(0,0,0,0.5);
			}
		</style>
	</head>

	<body>
		<!-- <div class="navigation_wrapper">
			<ul>
				<li><a href="Logout">D�connexion</a></li>
				<li><a href="Accueil">Accueil</a></li>
			</ul>
		</div> -->
		
		<h1 style="position:fixed; left:15px; background-color:black; padding:2px 5px;">Try to hack</h1>
		<h1 style="text-align:center; position:fixed; left:0; right:0; top:15px; font-size:16px;"><i class="fa fa-lock"></i><span> Version s�curis�</span></h1>
			 
		<%
  			if (request.getAttribute("isRegistering") == "true"){
		%>
			<jsp:include page="/WEB-INF/register_form.jsp" />
		<%
  			}else{
		%>
			<jsp:include page="/WEB-INF/login_form.jsp" />
		<%
  			}
		%>
		<div class="copyright">
			<p>�2018 IFT606 - S�curit� & Cryptography. Projet de session.</p>
		</div>
	</body>
</html>
