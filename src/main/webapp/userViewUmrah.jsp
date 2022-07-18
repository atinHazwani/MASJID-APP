<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<% //In case, if Admin session is not set, redirect to Login page
	if((request.getSession(false).getAttribute("user")== null) ){%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%} %>
	<meta name="viewport" content="width=device-width, initial-scale=1" />
	<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	<!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
	<title>Masjid App</title>
</head>

<body>
	<!-- HEADER -->
	<nav class="navbar navbar-expand-lg bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">MasApp</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="userHome.jsp">Home</a></li> 
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="AdminJumaatController?action=adminListJumaat">My Book</a></li>
					<li class="nav-item"><a class="nav-link active" aria-current="page" href="AdminJumaatController?action=adminListJumaat">Feedback</a></li>  
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/LogoutController">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav><br><br>
	<!-- end of HEADER -->
	
	
	<div align="center">
	<!-- Display Jumaat Slots -->
	  <h5 class="card-header">MENGAJI SLOT</h5><br><br>
	  <div class="card" style="width:50%;">
	  <table class="table table-borderless">
	   <thead>
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Slot Date</th>
	      <th scope="col">Slot Time</th>
	      <th scope="col">Guru Name</th>
	      <th scope="col">Venue</th>
	      <th colspan="3">Actions</th>
	    </tr>
	  </thead>
	  <c:forEach items="${mcslots}" var="mc" varStatus="mcslots">
	  <tbody>
	    <tr>
	      <td><c:out value="${mc.slotID}" /></td>
	      <td><c:out value="${mc.date}" /></td>
	      <td><c:out value="${mc.time}" /></td>
	      <td><c:out value="${mc.guruname}" /></td>
	      <td><c:out value="${mc.venue}" /></td>
    	  <td><a href="UserBookJumaatController?action=&slotID=<c:out value="${jumaatPrayer.slotID}" />" class="btn btn-primary">View Slot</a></td>
	    </tr>
	  </tbody>
	  </c:forEach>
		</table>
	  </div><br><br>
	<!-- End Display Jumaat Slots -->
	
	
	<!-- BACK BUTTON -->
	<div class="mx-auto" style="width: 300px;">
	<ul class="nav nav-pills nav-fill">
		<li class="nav-item"><a class="nav-link active" aria-current="page" href="userHome.jsp">Back</a></li>
	</ul><br><br>
	</div>
	<!-- BACK BUTTON -->
	</div>
</body>
</html>	