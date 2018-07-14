<%@ page import="java.util.*,java.text.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
	<head>
		<title>Try to hack</title>
		<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<style>
		
			.register_wrapper{
				position:fixed;
				top:20%;
				left:10%;
				margin:0 auto;
			}
			
			.register_wrapper div{
				background-color:white;
				border-radius:10px;
				padding:0 25px 10px 25px;
				width:500px;
			}
			
			.register_wrapper div h2{
				text-align:center;
				font-weight:400;
				padding-bottom:15px;
			}
			
			.register_wrapper div p {
				color:#6A6D70;
				font-size:12px;
				margin:15px 0 5px 0;
			}
			
			.register_wrapper div input{
				width:100%;
				padding:10px 10px;
				border:1px solid #BABCBF;
				border-radius:5px;
				outline: none;
				background-color:white;
			}
			
			.register_wrapper div input:hover, .register_wrapper div input:focus, .register_wrapper div input:active{
				border:1px solid black;
			}
			
			#submit_btn:hover{
				opacity:0.8;
			}
		</style>
	</head>
	
	<div class="register_wrapper">
		<div>
			<p style="text-align:right; margin:0px -25px 0 0; padding:10px; font-size:24px;"><a style="color:#6A6D70;" href="Login"><i class="fa fa-times"></i></a></p>
			<h2>Sign up</h2>
			<form ACTION="Register" METHOD="POST">

				<p style="width:49%; float:left;">Nom</p>
			    <p style="width:49%; float:right;">Prénom</p>
			    <input style="width:49%; float:left;" TYPE="TEXT" NAME="nom" autofocus>
				<input style="width:49%; float:right;" TYPE="TEXT" NAME="prenom">

			    <p style="width:49%; float:left;">Username</p>
			    <p style="width:49%; float:right;">Email</p>
			    <input style="width:49%; float:left;" TYPE="TEXT" NAME="username">
				<input style="width:49%; float:right;" TYPE="TEXT" NAME="email">

			    <p style="width:49%; float:left;">Password</p>
			    <p style="width:49%; float:right;">Confirm password</p>
			    <input style="width:49%; float:left;" TYPE="TEXT" NAME="password">
			    <input style="width:49%; float:right;" TYPE="TEXT" NAME="password_confirm">
			    
			    <!-- <p style="width:49%; float:left;">Address</p>
			    <p style="width:49%; float:right;">Postal code</p>
			    <input style="width:49%; float:left;" TYPE="TEXT" NAME="address">
			    <input style="width:49%; float:right;" TYPE="TEXT" NAME="codepostal"> -->

				<input id="submit_btn" type="submit" name="signup" value="Sign up" style="background-color:black; color:white; border:0; font-size:14px; margin-top:15px;">
			
				<jsp:include page="/WEB-INF/messageErreur.jsp" />
			</form>
			
			<!--<p style="text-align:center; font-size:10px; margin-top:25px;"><i class="fa fa-lock"></i><span> Version sécurisé</span></p>
			 <jsp:include page="/WEB-INF/messageErreur.jsp" />
			<%= DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CANADA_FRENCH).format(new java.util.Date()) %> -->
		</div>
	</div>
</html>
