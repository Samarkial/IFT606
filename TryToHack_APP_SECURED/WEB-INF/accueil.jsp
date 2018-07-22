<%@ page import="java.util.*,java.text.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
	<head>
		<title>Try to hack</title>
		<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<style>
		
			.navigation_wrapper{
				width:100%;
			}
			
			.navigation_wrapper ul{ 
				width:100%;
				display: inline-block; 
				padding:0;
				list-style-type: none;
			}
			
			.navigation_wrapper ul li{ 
				margin-right:15px; 
				float:right;
			}
			
			.navigation_wrapper ul li a{ 
				color:black;
				text-decoration:none;
			}
			
			.wrapper{
				position:fixed;
				top:20%;
				left:0;
				right:0;
				width:250px;
				margin:0 auto;
				background-color:#e9e9e9;
				border-radius:10px;
				padding:25px;
			}
			
			.wrapper h2{
				text-align:center;
				font-weight:400;
			}
			
			.wrapper input:hover, .wrapper input:focus{
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
	
	<body style="margin:0;">
		<div class="navigation_wrapper">
			<ul>
				<li><a href="Logout">Déconnexion</a></li>
				<li><a href="Accueil">Accueil</a></li>
			</ul>
		</div>
		<div class="wrapper">
			<h2>Accueil</h2>
		</div>
		
		<div class="copyright">
			<p>©2018 IFT606 - Sécurité & Cryptography. Projet de session.</p>
		</div>
	</body>
</html>
