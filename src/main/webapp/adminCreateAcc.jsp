<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<% //In case, if Admin session is not set, redirect to Login page
	if((request.getSession(false).getAttribute("admin")== null) ){%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%} %>
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
		     var adminID = document.form.adminID.value;
		     var adminName = document.form.adminName.value; 
		     var adminEmail = document.form.adminEmail.value;
		     var adminPhone = document.form.adminPhone.value;
		     var password = document.form.password.value;
		     var conpass= document.form.conpassword.value;
		     
			if (adminID == null || adminID == "")
		     { 
		     alert("Admin ID can't be blank"); 
		     return false; 
		     }
		     else if (adminName == null || adminName=="")
		     { 
		     alert("Admin Name can't be blank"); 
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
	<!-- HEADER -->
	<nav class="navbar navbar-expand-lg bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">MasjidApps</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="AdminJumaatController?action=adminListJumaat">Manage Slot</a></li> 
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="AdminRegisterController?action=adminCreateAcc">Add Admin</a></li> 
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/LogoutController">Logout</a></li>
					<li class="nav-item"><a class="nav-link">Welcome <%=request.getAttribute("userID") %></a></li>
				</ul>
			</div>
		</div>
	</nav><br>
	<!-- end of HEADER -->
	
	<br><br>
	
	<div align="center">
	<div class="card" style="width:35%;">
	  <div class="card-body">
	  	 <h5>ADMIN REGISTER</h5>
	    <!-- LOGIN FORM -->
	    <form class="row g-4" name="form" action="AdminController" method="post" onsubmit="return validate()">
			<input type="hidden" id="role" name="role" value="admin">
			<div class="col-12" align="left">
				<input type="text" class="form-control" name="userID" id="userID" placeholder="Enter Admin ID" required>
			</div>
			<div class="col-12" align="left">
				<input type="text" class="form-control" name="username" id="username" placeholder="Enter Admin Name" required>
			</div>
			<div class="col-6" align="left">
				<input type="text" class="form-control" name="username" id="username" placeholder="Enter Admin Email" required>
			</div>
			<div class="col-6" align="left">
				<input type="text" class="form-control" name="username" id="username" placeholder="Enter phone number" required>
			</div>
			<div class="col-6" align="left">
				<input type="password" class="form-control" name="password" id="password" placeholder="Enter password" required>
			</div>
			<div class="col-6" align="left">
				<input type="password" class="form-control" name="conpass" id="conpass" placeholder="Confirm password" required>
			</div>
			<div class="d-grid gap-3">
				<span style="color:red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
			</div>
			<div class="d-grid gap-3">
				<button type="submit" class="btn btn-dark" value="Register">Register</button>
				<button type="reset" class="btn btn-outline-dark" value="Reset">Reset</button>
			</div>
		</form>
		<!-- END OF LOGIN FORM -->
	  </div>
	</div>
	</div><br><br>
</body>
</html>