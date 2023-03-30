<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
body {
	padding: 0;
	margin: 0;
	background: #f2f6e9;
}

.navbar {
	background: #6ab446;
}

.nav-link, .navbar-brand {
	color: #fff;
	cursor: pointer;
}

.nav-link {
	margin-right: 1em !important;
}

.nav-link:hover {
	color: #000;
}

#nav-tab {
	margin-inline-start: auto;
}

.contact-form {
	background: #fff;
	margin-top: 5%;
	margin-bottom: 5%;
	width: 70%;
}

.contact-form .form-control {
	border-radius: 1rem;
}

.contact-image {
	text-align: center;
}

.contact-image img {
	border-radius: 6rem;
	width: 11%;
	margin-top: -3%;
	transform: rotate(29deg);
}

.contact-form form {
	padding: 14%;
}

.contact-form form .row {
	margin-bottom: -7%;
}

.contact-form h3 {
	margin-bottom: 8%;
	margin-top: -10%;
	text-align: center;
	color: #0062cc;
}

.contact-form .btnContact {
	width: 50%;
	border: none;
	border-radius: 1rem;
	padding: 1.5%;
	background: #dc3545;
	font-weight: 600;
	color: #fff;
	cursor: pointer;
}

.btnContactSubmit {
	width: 50%;
	border-radius: 1rem;
	padding: 1.5%;
	color: #fff;
	background-color: #0062cc;
	border: none;
	cursor: pointer;
}
</style>
<style>
<!--
body {
	color: #999;
	background: #f5f5f5;
	font-family: 'Varela Round', sans-serif;
}

-->
.form-control {
	box-shadow: none;
	border-color: #ddd;
}

.form-control:focus {
	border-color: #4aba70;
}

.login-form {
	width: 350px;
	margin: 0 auto;
	padding: 30px 0;
}

.login-form form {
	color: #434343;
	border-radius: 1px;
	margin-bottom: 15px;
	background: #fff;
	border: 1px solid #f3f3f3;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	padding: 30px;
}

.login-form h4 {
	text-align: center;
	font-size: 22px;
	margin-bottom: 20px;
}

.login-form .avatar {
	color: #fff;
	margin: 0 auto 30px;
	text-align: center;
	width: 100px;
	height: 100px;
	border-radius: 50%;
	z-index: 9;
	background: #4aba70;
	padding: 15px;
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.1);
}

.login-form .avatar i {
	font-size: 62px;
}

.login-form .form-group {
	margin-bottom: 20px;
}

.login-form .form-control, .login-form .btn {
	min-height: 40px;
	border-radius: 2px;
	transition: all 0.5s;
}

.login-form .close {
	position: absolute;
	top: 15px;
	right: 15px;
}

.login-form .btn {
	background: #4aba70;
	border: none;
	line-height: normal;
}

.login-form .btn:hover, .login-form .btn:focus {
	background: #42ae68;
}

.login-form .checkbox-inline {
	float: left;
}

.login-form input[type="checkbox"] {
	margin-top: 2px;
}

.login-form .forgot-link {
	float: right;
}

.login-form .small {
	font-size: 13px;
}

.login-form a {
	color: #4aba70;
}

</style>
</head>
<body>
	<nav class="navbar navbar-expand-md">
		<a class="navbar-brand" href="#">LIFESECURE</a>

		<div class="nav nav-tabs" id="nav-tab" role="tablist">
			<button class="nav-link active" id="nav-home-tab"
				data-bs-toggle="tab" data-bs-target="#nav-home" type="button"
				role="tab" aria-controls="nav-home" aria-selected="true">Home</button>
			<button class="nav-link" id="nav-profile-tab" data-bs-toggle="tab"
				data-bs-target="#nav-profile" type="button" role="tab"
				aria-controls="nav-profile" aria-selected="false">Product</button>
			<button class="nav-link" id="nav-contact-tab" data-bs-toggle="tab"
				data-bs-target="#nav-contact" type="button" role="tab"
				aria-controls="nav-contact" aria-selected="false">Contact</button>
		</div>
	</nav>
	<div class="tab-content" id="nav-tabContent">
		<div class="tab-pane fade show active" id="nav-home" role="tabpanel"
			aria-labelledby="nav-home-tab">
			<!--login form code-->
			<h4 class="text-center mt-4" style="color: red">${msg}</h4>
			<div class="login-form">
				
				<form action="verifyUser" method="Get">
					<div class="avatar">
						<i class="material-icons">&#xE7FF;</i>
					</div>
					<h4 class="modal-title">Login to Your Account</h4>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Username"
							name="username" required="required">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="Password"
							name="password" required="required">
					</div>

					<input type="submit" class="btn btn-primary btn-block btn-lg"
						value="Login"> <br>

				</form>
				<div class="text-center">
					<a href="forgot" data-toggle="modal" data-target="#modalPopup1">Forgot
						password?</a>
				</div>
				<div class="text-center small">
					Don't have an account? <a href="register">Sign up</a>
				</div>
			</div>




		</div>
		<div class="tab-pane fade" id="nav-profile" role="tabpanel"
			aria-labelledby="nav-profile-tab">
			<!--product form code-->
			<div class="container">
				<div class="row box">
					<div class="col-3 ">
						<div class="card bg-light"
							style="width: 15rem; margin-top: 10px; margin-bottom: 10px;">
							<!--    <img src="..." class="card-img-top" alt="">        -->
							<div class="card-body">
								<h5 class="card-title">Health Insurance</h5>
								<p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p>
								<a href="#" class="btn btn-primary">BUY NOW</a>
							</div>
						</div>
					</div>
					<div class="col-3 ">
						<div class="card bg-light"
							style="width: 15rem; margin-top: 10px; margin-bottom: 10px;">
							<!--    <img src="..." class="card-img-top" alt="">        -->
							<div class="card-body">
								<h5 class="card-title">Home Insurance</h5>
								<p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p>
								<a href="#" class="btn btn-primary">BUY NOW</a>
							</div>
						</div>
					</div>
					<div class="col-3">
						<div class="card bg-light"
							style="width: 15rem; margin-top: 10px; margin-bottom: 10px;">
							<!--    <img src="..." class="card-img-top" alt="">        -->
							<div class="card-body">
								<h5 class="card-title">Car Insurance</h5>
								<p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p>
								<a href="#" class="btn btn-primary">BUY NOW</a>
							</div>
						</div>
					</div>
					<div class="col-3 ">
						<div class="card bg-light"
							style="width: 15rem; margin-top: 10px; margin-bottom: 10px;">
							<!--    <img src="..." class="card-img-top" alt="">        -->
							<div class="card-body">
								<h5 class="card-title">Vechicle Insurance</h5>
								<p class="card-text">Some quick example text to build on the
									card title and make up the bulk of the card's content.</p>
								<a href="#" class="btn btn-primary">BUY NOW</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="tab-pane fade" id="nav-contact" role="tabpanel"
			aria-labelledby="nav-contact-tab">
			<!--contact form code-->
			<div class="container contact-form">
				<div class="contact-image">
					<img src="https://image.ibb.co/kUagtU/rocket_contact.png"
						alt="rocket_contact" />
				</div>
				<form:form  action="contactUs" method="post" modelAttribute="contactUs">
					<h3>Contact Us</h3>
					<div class="row">
						<div class="col-md-6">
							<div class="form-group ">
								<form:input type="text" name="txtName" path="name" class="form-control"
									placeholder="Your Name *" value="" />
							</div>
							<div class="form-group my-2">
								<form:input type="text" name="txtEmail" path="email" class="form-control"
									placeholder="Your Email *" value="" />
							</div>
							<div class="form-group my-2">
								<form:input type="text" name="txtPhone" path="phoneNo" class="form-control"
									placeholder="Your Phone Number *" value="" />
							</div>
							<div class="form-group mt-4">
								<input type="submit" name="btnSubmit" class="btnContact"
									value="Send Message" />
							</div>
						</div>
						<div class="col-md-6">
							<div class="form-group">
								<form:textarea name="txtMsg" path="message" class="form-control"
									placeholder="Your Message *"
									style="width: 100%; height: 150px;"></form:textarea>
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
<div class="modal fade" tabindex="-1" role="dialog" id="modalPopup1">
	<div class="modal-dialog">
	<div class="modal-content">
			<div class="modal-header">
				<h2 class="modal-title text-primary">Forgot Password Page</h2>
				

			</div>
			<div class="modal-body ">
				<form action="verifyusername" class="text-center">
					<h3 style="color: red">${msg }</h3>
					<h3>Enter The Email ID</h3>

					<input class="mt-5 rounded" type="email"
						placeholder="Enter The Email" name="email"><br> <br>
					<input class="btn btn-primary rounded " type="submit"
						value="Send the otp">
				</form>
			</div>
			<div class="modal-footer">
	 
	  <button type="button" class="btn btn-primary" data-dismiss="modal"> close</button>
	  </div>
	  </div>
	</div>
  </div>
</html>