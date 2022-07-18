<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head> 

	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	<title>Masjid App</title>
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
	
	
	<!-- NAVBAR FOR SLOT CATEGORY -->
	<div class="mx-auto" style="width: 800px;">
	<h3 class="text-center">MASJID SLOT</h3><br><br>
	<ul class="nav nav-tabs nav-justified">
	<li class="nav-item"><a class="nav-link active" aria-current="page" href="AdminJumaatController?action=adminListJumaat">Jumaat Prayer</a></li>
	<li class="nav-item"><a class="nav-link" href="AdminMengajiController?action=adminListMengaji">Mengaji Class</a></li>
	<li class="nav-item"><a class="nav-link" href="AdminUmrahController?action=adminListUmrah">Umrah/Haji</a></li>
	</ul><br><br>
	</div>
	<!-- END OF NAVBAR -->
	
	
	<!-- VIEW SLOT BUTTON -->
	<div class="mx-auto" style="width: 300px;">
	<ul class="nav nav-pills nav-fill">
		<li class="nav-item"><a class="nav-link active" aria-current="page" href="AdminJumaatController?action=adminListJumaat">View Slots</a></li>
	</ul><br><br>
	</div>
	<!-- END OF VIEW SLOT BUTTON -->
	
	
	<!-- JUMAAT FORM -->
	<div class="mx-auto" style="width: 800px;">
	<form class="row g-3" action="AddJumaatController" method="POST">
		<div class="col-12">
			<label for="slotID" class="form-label">Enter Slot ID</label>
			<input type="text" class="form-control" name="slotID" id="slotID" required>
		</div>
		<div class="col-12">
			<label for="date" class="form-label">Choose Date</label>
			<input type="date" class="form-control" name="date" id="date" required>
		</div>
		<div class="col-12">
			<label for="khutbahTitle" class="form-label">Khutbah Title</label>
			<input type="text" class="form-control" name="khutbahTitle" id="khutbahTitle" placeholder="Insert Khutbah Title" required>
		</div>
		<div class="col-6 d-grid gap-3">
			<button type="submit" class="btn btn-primary">Submit</button>
		</div>
		<div class="col-6 d-grid gap-3">
			<button type="reset" class="btn btn-outline-primary">Reset</button>
		</div>
	</form><br>
	</div>
	<!-- END OF JUMAAT FORM -->
</body>
</html>
