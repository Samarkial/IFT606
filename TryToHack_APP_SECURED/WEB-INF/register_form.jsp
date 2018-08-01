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
				box-shadow: 0 0 12px 0 rgba(0,0,0,0.1), 0 10px 30px 0 rgba(0,0,0,0.5);
			}
			
			.register_wrapper div h2{
				text-align:center;
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
				text-decoration: underline;
			}
			
			.goBack:hover{
				text-decoration: underline;
			}
			
			input.disabled {
		    		pointer-events:none;
			    	background-color:rgba(0,0,0,0.6) !important;
			}
			
		</style>
	</head>
	
	<div class="register_wrapper">
		<div>
			<p class="goBack" style="display:inline-block; text-align:left; margin:0 0 0 -25px; padding:10px; font-size:12px;"><a style="color:#6A6D70; text-decoration:none;" href="Login"><i style="padding-right:5px;" class="fa fa-arrow-left"></i>Back</a></p>
			<h2>Sign up</h2>
			
			<jsp:include page="/WEB-INF/messageErreur.jsp" />
			
			<form ACTION="Register" METHOD="POST">

				<p style="width:49%; float:left;">Nom*</p>
			    <p style="width:49%; float:right;">Prénom*</p>
			    <input style="width:49%; float:left;" TYPE="TEXT" NAME="nom" autofocus onkeyup="validateChar(this.value);">
				<input style="width:49%; float:right;" TYPE="TEXT" NAME="prenom" onkeyup="validateChar(this.value);">

			    <p style="width:49%; float:left;">Username*</p>
			    <p style="width:49%; float:right;">Email*</p>
			    <input style="width:49%; float:left;" TYPE="TEXT" NAME="username" onkeyup="validateChar(this.value);">
				<input style="width:49%; float:right;" TYPE="TEXT" NAME="email" onkeyup="validateChar(this.value);">

			    <p style="width:49%; float:left;">Password* <span  id="label" style="float:right; padding:0 6px; border-radius:3px; color:white;"></span></p>
			    <p style="width:49%; float:right;">Confirm password*</p>
			    <input id="txtNewPassword"  style="width:49%; float:left;" TYPE="password" NAME="password" onkeyup="validatePassword(this.value);"/>
			    <input id="txtConfirmPassword" style="width:49%; float:right;" TYPE="password" NAME="password_confirm" onkeyup="checkPasswordMatch();"/>
			    
				<p id="matchLabel" style="font-size:10px; color:#d9534f;"></p>

				<input id="submit_btn" class="disabled" type="submit" name="signup" value="Sign up" style="background-color:black; color:white; border:0; font-size:14px; margin-top:15px;">
			
			</form>
			
			<p style="font-size:10px; margin-top:15px;"><span><b>Your password must have:</b></span></p>
			<p id="8orMore" style="font-size:10px; margin-top:5px;"><i class="fa fa-check-circle"></i><span> 8 or more characters</span></p>
			<p id="1uppercase" style="font-size:10px; margin-top:5px;"><i class="fa fa-check-circle"></i><span> Upper & lowercase letters</span></p>
			<p id="1number" style="font-size:10px; margin-top:5px;"><i class="fa fa-check-circle"></i><span> At least one number</span></p>
			
			<!--<p style="text-align:center; font-size:10px; margin-top:25px;"><i class="fa fa-lock"></i><span> Version sécurisé</span></p>
			 <jsp:include page="/WEB-INF/messageErreur.jsp" />
			<%= DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.CANADA_FRENCH).format(new java.util.Date()) %> -->
		</div>
	</div>
	
	<script>
	
			var eightOrMore = false;
			var uppercase = false;
			var number = false;
			var wrongChar = false;
			
			function validateChar(input){
				if(/[<>]/.test(input)){
					wrongChar = true;
				}else
					wrongChar = false;
				
				if (wrongChar == true){
	            		document.getElementById("matchLabel").innerHTML = "Character not allowed.";
	            		
	            		var element = document.getElementById("submit_btn");
	                 element.classList.add("disabled");
	            }else{
	        			document.getElementById("matchLabel").innerHTML = "";
		    			
		    			var element = document.getElementById("submit_btn");
		             element.classList.remove("disabled");
	            }
			}
			
            function validatePassword(password) {
            	
                if (password.length === 0) {
                    document.getElementById("label").innerHTML = "";
                    
                    var element = document.getElementById("submit_btn");
                    element.classList.add("disabled");
                    
                    document.getElementById("8orMore").style.color = "#6A6D70";
                    eightOrMore = false;
                    
                    document.getElementById("1uppercase").style.color = "#6A6D70";
            			uppercase = false;
            			
            			document.getElementById("1number").style.color = "#6A6D70";
                		number = false;
                    
                    return;
                }
                
                if (password.length >= 8) {
                    document.getElementById("8orMore").style.color = "#5cb85c";
                    eightOrMore = true;
                }else{
                    document.getElementById("8orMore").style.color = "#6A6D70";
                    eightOrMore = false;
                }
                
                if(/[A-Z]/.test(password)){
                    document.getElementById("1uppercase").style.color = "#5cb85c";
                    uppercase = true;
                }else{
                		document.getElementById("1uppercase").style.color = "#6A6D70";
                		uppercase = false;
                }
                
                if(/[0-9]/.test(password)){
                    document.getElementById("1number").style.color = "#5cb85c";
                    number = true;
                }else{
                		document.getElementById("1number").style.color = "#6A6D70";
                		number = false;
                }

                var alphabet = new Array();
                alphabet.push("[A-Z]"); 
                alphabet.push("[a-z]");   
                alphabet.push("[0-9]");  
                alphabet.push("[$@$!%*#?&]"); 

                var ctr = 0;
                for (var i = 0; i < alphabet.length; i++) {
                    if (new RegExp(alphabet[i]).test(password)) {
                        ctr++;
                    }
                }

                var color = "";
                var strength = "";
                switch (ctr) {
                    case 0:
                    case 1:
                    case 2:
                        strength = "Weak";
                        color = "#d9534f";
                        break;
                    case 3:
                        strength = "Medium";
                        color = "#f0ad4e";
                        break;
                    case 4:
                        strength = "Strong";
                        color = "#5cb85c";
                        break;
                }
                document.getElementById("label").innerHTML = strength;
                document.getElementById("label").style.backgroundColor = color;
            }
            
            function checkPasswordMatch() {
                var password = document.getElementById("txtNewPassword").value;
                var confirmPassword = document.getElementById("txtConfirmPassword").value;

                if (password != confirmPassword && eightOrMore == true && uppercase == true && number == true && wrongChar != true){
                		document.getElementById("matchLabel").innerHTML = "The passwords you entered do not match.";
                		
                		var element = document.getElementById("submit_btn");
                     element.classList.add("disabled");
                }else if(eightOrMore == true && uppercase == true && number == true && wrongChar != true){
            			document.getElementById("matchLabel").innerHTML = "";
            			
                    var element = document.getElementById("submit_btn");
                    element.classList.remove("disabled");
                }
                		
            }
            
            if(eightOrMore == true && uppercase == true && number == true && wrongChar == false){
	    			document.getElementById("matchLabel").innerHTML = "";
	    			
	    			var element = document.getElementById("submit_btn");
	             element.classList.remove("disabled");
	        }
            
        </script>
</html>
