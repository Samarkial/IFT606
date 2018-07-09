<%@ page import="java.util.*,java.text.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">

<html>
	<head>
		<title>Try to hack</title>
		<meta HTTP-EQUIV="Content-Type" CONTENT="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href="style.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<style>	
			.login_wrapper{
				position:fixed;
				top:20%;
				left:10%;
				margin:0 auto;
			}
		
			.login_wrapper div{
				background-color:white;
				border-radius:10px;
				padding:25px;
				width:225px;
			}
			
			.login_wrapper div h2{
				text-align:center;
				font-weight:400;
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
			
			#signup_btn{
				color:rgb(63, 159, 255);
				border:0;
				font-size:12px;
			}
			
			#signup_btn:hover{
				opacity:0.8;
			}
			
		</style>
	</head>

	<div class="login_wrapper">
		<div>
			<h2>Sign in</h2>
			<form ACTION="Login" METHOD="POST">

			    <p>Username</p>
			    <input TYPE="TEXT" NAME="username" autofocus>

			    <p>Password</p>
			    <input TYPE="PASSWORD" NAME="password">

				<input id="submit_btn" type="submit" name="signin" value="Sign in" style="background-color:black; color:white; border:0; font-size:14px; margin-top:15px;">
				<input id="signup_btn" type="submit" name="signup" value="Sign up" />			
			</form>
			<p style="text-align:center; font-size:10px; margin-top:25px;"><i class="fa fa-lock"></i><span> Version sécurisé</span></p>
			<!-- <jsp:include page="/WEB-INF/messageErreur.jsp" />
			<%= DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CANADA_FRENCH).format(new java.util.Date()) %> -->
		</div>
	</div>

</html>


