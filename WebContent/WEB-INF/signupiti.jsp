<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<title>Training Institute : SIGNUP</title>
<meta charset="utf-8">
<meta name="Job Protal" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="shortcut icon" href="img/logo.png" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
</head>
<style>
</style>

<body>

	<div class="top-header">
		<div class="container">
			<a href="index.html"><img src="img/logo.png" style="float: left;"></a>
			<a href="signup.html" style="float: right; padding-top: 12px;"><span
				class="glyphicon glyphicon-log-in">&nbsp;</span>SIGN UP</a>
		</div>
	</div>

	<div class="institute-signup">
		<div class="container-signup">
			<h2 style="text-align: center;">ITI Sign-Up</h2>
			<form action="ITIRegisterController" method="POST">
				<div class="col-md-12">
					<label for="fname">Training Institute Name :</label> <input
						type="text" name="fullName"
						placeholder="Input Training Center Name.." required="required">
				</div>
				<div class="col-md-6">
					<label for="email">Email ID :</label> 
						<input type="email" name="email" placeholder="Enter Email" required="required">
				</div>
				<div class="col-md-6">
					<label for="password">Password :</label> <input type="password"
						name="password" placeholder="Enter Password" required="required">
				</div>
				<div class="col-md-4">
					<label for="lname">Contact Number :</label> <input type="text"
						name="contactNumber" id="contact" placeholder="Contact Number.."
						required="required" minlength="10" maxlength="10">
				</div>
				<div class="col-md-4">
					<label for="zipcode">Zip Code :</label> 
					<input type="text" name="zipCode" id="zipcode" placeholder="Pin Code" required="required" maxlength="6" minlength="6"/>
				</div>

				<div class="col-md-4">
					<label for="country">Country :</label>
					<input type="text" value="India"/>
				</div>
				<div class="col-md-6">
					<label for="state">State :</label> 
					<select id="state" name="state">
						<c:forEach var="stateNames" items="${states}">
							<option value="${stateNames}">${stateNames}</option>
						</c:forEach>
					</select>
				</div>

				<div class="col-md-4">
					<label for="address">Address :</label> <input type="text" name="address"
						id="txtAddress" placeholder="Address.." required="required" onchange="GetLocation()">

				</div>

				<script type="text/javascript">
					function GetLocation() {
						var geocoder = new google.maps.Geocoder();
						var address = document.getElementById("txtAddress").value;
						geocoder
								.geocode(
										{
											'address' : address
										},
										function(results, status) {
											if (status == google.maps.GeocoderStatus.OK) {
												var latitude = results[0].geometry.location
														.lat();
												var longitude = results[0].geometry.location
														.lng();
												//alert("Latitude: " + latitude + "\nLongitude: " + longitude);
												document
														.getElementById('demo1').innerHTML = "Latitude: "
														+ latitude;
												document
														.getElementById('demo2').innerHTML = "Longitude: "
														+ longitude;
												document
														.getElementById('latitude').value = latitude;
												document
														.getElementById('longitude').value =longitude;
											} else {
												alert("Request failed.")
											}
										});
					};
				</script>
				<input type="hidden" name="latitude" id="latitude">
				<input type="hidden" name="longitude" id="longitude">
				<br> <input style="margin-top: 16px; margin-right: 24px;"
					type="submit" value="Submit">
			</form>
			<div id="demo1" style="margin-left: 20px;display:none" name="latitute"></div>
			<div id="demo2" style="margin-left: 20px;display:none" name="longitude"></div>
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

<script>
	function pinFunction() {
		var x = document.getElementById('zipcode').value.length;

		if (x > 6 || x < 6) {
			alert("Pin Code Must be of 6 Digits.");
		}
	}

	function contactFunction() {
		var x = document.getElementById('contact').value.length;

		if (x > 10 || x < 10) {
			alert("Contact Number Must be of 10 Digits.");
		}
	}
</script>

<script type="text/javascript"
	src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBIWcz37GLZrMMHvyAZr-3UGiPU2-JzzBk"></script>

</html>
