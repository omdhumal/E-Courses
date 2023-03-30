<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forget password web</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
</style>
</head>
<body style="background-color: gray;">



	<div class="modal-header">
		<h2 class="modal-title text-primary">Forgot Password Page</h2>


	</div>
	<div class="modal-body ">
		<form action="verifyusername" class="text-center">

			<h3>Enter The Email ID</h3>

			<input class="mt-5 rounded" type="email"
				placeholder="Enter The Email" name="email"><br> <br>
			<input class="btn btn-primary rounded " type="submit"
				value="Send the otp">
		</form>
	</div>
	<div class="modal-footer">

		<button type="button" class="btn btn-primary" data-dismiss="modal">
			close</button>
	</div>



</body>
</html>