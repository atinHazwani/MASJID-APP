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
</head>
<body>
	<br><br><br>
	<div align="center">
	<h3>MASJID APPOINTMENT SYSTEM</h3>
	<br><br>
	<div class="card" style="width:35%;">
	  <div class="card-body">
	  	 <h5>LOGIN</h5>
	    <!-- LOGIN FORM -->
		<form class="row g-4" name="form" action="<%=request.getContextPath()%>/LoginController" method="POST">
			<div class="col-12" align="left">
				<label for="userID" class="form-label">User ID</label>
				<input type="text" class="form-control" name="userID" id="userID" placeholder="Enter your user ID" required>
			</div>
			<div class="col-12" align="left">
				<label for="password" class="form-label">Password</label>
				<input type="password" class="form-control" name="password" id="password" placeholder="Enter your password" required>
			</div>
			<div class="d-grid gap-3">
				<button type="submit" class="btn btn-dark" value="Login">Login</button>
			</div>
			<div class="col-12 text-center">
				<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
			</div>
			<div class="d-grid gap-3">
				<p>Don't have an account? <a href="userRegister.jsp"> Register Here </a></p>
			</div>
		</form>
		<!-- END OF LOGIN FORM -->
	  </div>
	</div>
	</div>
</body>
</html>