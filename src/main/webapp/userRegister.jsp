<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	<title>Masjid App</title>
	<style>
		body {
  		
	}
	</style>
	<script> 
		function validate()
		{ 
		     var userID = document.form.userID.value;
		     var username = document.form.username.value; 
		     var password = document.form.password.value;
		     var conpass= document.form.conpassword.value;
		     
			if (userID == null || userID == "")
		     { 
		     alert("User ID can't be blank"); 
		     return false; 
		     }
		     else if (username == null || username=="")
		     { 
		     alert("Username can't be blank"); 
		     return false; 
		     }
		     else if (password!=conpass)
		     { 
		     alert("Confirm Password should match with the Password"); 
		     return false; 
		     } 
		 } 
	</script> 
</head>
<body>
	<br><br>
	<div align="center">
	<h3>MASJID APPOINTMENT SYSTEM</h3>
	<br><br>
	<div class="card" style="width:35%;">
	  <div class="card-body">
	  	 <h5>REGISTER</h5>
	    <!-- LOGIN FORM -->
	    <form class="row g-4" name="form" action="UserRegisterController" method="post" onsubmit="return validate()">
			<input type="hidden" id="role" name="role" value="user">
			<div class="col-12" align="left">
				<label for="userID" class="form-label">User ID</label>
				<input type="text" class="form-control" name="userID" id="userID" placeholder="Enter your user ID" required>
			</div>
			<div class="col-12" align="left">
				<label for="username" class="form-label">Username</label>
				<input type="text" class="form-control" name="username" id="username" placeholder="Enter your username" required>
			</div>
			<div class="col-12" align="left">
				<label for="password" class="form-label">Password</label>
				<input type="password" class="form-control" name="password" id="password" placeholder="Enter your password" required>
			</div>
			<div class="col-12" align="left">
				<label for="conpass" class="form-label">Confirm Password</label>
				<input type="password" class="form-control" name="conpass" id="conpass" placeholder="Confirm password" required>
			</div>
			<div class="d-grid gap-3">
				<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
			</div>
			<div class="d-grid gap-3">
				<button type="submit" class="btn btn-dark" value="Register">Register</button>
				<button type="reset" class="btn btn-outline-dark" value="Reset">Reset</button>
			</div>
			<div class="d-grid gap-3">
				<p>Already created an account? <a href="login.jsp"> Login Here </a></p>
			</div>
		</form>
		<!-- END OF LOGIN FORM -->
	  </div>
	</div>
	</div><br><br>
</body>
</html>