<!DOCTYPE html>
<html>
<head>
	<title>UNNATI : LOGIN</title>
	<meta charset="utf-8">
	<meta name="Job Protal"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>
	<link rel="shortcut icon" href="img/logo.png"/>
	<link rel="stylesheet" type="text/css" href="css/main.css"/>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body>

	<div class="top-header">
		<div class="container">
			<a href="index.jsp"><img src="img/logo.png" style="float: left;"></a>
			<a href="signup.html" style="float: right;padding-top: 12px;"><span class="glyphicon glyphicon-log-in">&nbsp;</span>SIGN UP</a>
		</div>
	</div>

	<div class="login-section">
		<form action="LoginController" method="POST">
			<div class="container">
				<h2>Login And Get To Work</h2>
				<table>
					<tr>
						${message}
						<th>
							<h4>Login As : </h4>
						</th>
						<th>
							<select name="login-as">
								<option value="company">Company</option>
								<option value="institute">ITI</option>
							</select>
						<th>
					</tr>
				</table>
				
  				<input type="text" name="username" placeholder="Enter Username" required="required" minlength="6" maxlength="6"><br>
				<input type="password" name="password" placeholder="Enter Password" required="required"><br>
				
				<button class="loginbutton" type="submit" >Log In</button><br>
			</div>	
		</form>		
		
		<div class="other-option">
			<div class="container">		
				<p><a href="#forgetpassword">Forget Password ?</a></p>
			</div>
		</div>
	</div>

	<div class="footer">
		<div class="container">
			<hr>
				
				<div class="social-link">
					<h3 class="fa fa-text">Follow Us :</h3>
					
					<a href="https://www.facebook.com/SkillIndiaOfficial/" class="fa fa-facebook"></a>
					<a href="https://twitter.com/MSDESkillIndia" class="fa fa-twitter"></a>
				</div>
			<hr>

			<div class="rights">
				<h6>All Rights are Reserved &copy; 2017</h6>
			</div>
		</div>
	</div>
</body>
</html>
