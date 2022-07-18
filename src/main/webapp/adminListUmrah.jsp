<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
	
	
	
	<!-- BACK BUTTON -->
	<div class="mx-auto" style="width: 300px;">
	<ul class="nav nav-pills nav-fill">
		<li class="nav-item"><a class="nav-link active" aria-current="page" href="adminAddUmrah.jsp">Create New Slot</a></li>
	</ul><br><br>
	</div>
	<!-- END OF BACK BUTTON -->
	
	
	
	<!-- BACK BUTTON -->
	<div class="mx-auto" style="width: 300px;">
	<ul class="nav nav-pills nav-fill">
		<li class="nav-item"><a class="nav-link active" aria-current="page" href="AddMengajiController?action=adminAddUmrah">Create New Slot</a></li>
	</ul><br><br>
	</div>
	<!-- END OF BACK BUTTON -->
	
	
	
	<div class="mx-auto" style="width: 300px;">
	<!-- BACK BUTTON -->
	<ul class="nav nav-pills nav-fill">
		<li class="nav-item"><a class="nav-link active" aria-current="page" href="AdminUmrahController?action=addUmrahForm">Create New Slot</a></li>
	</ul><br><br>
	<!-- END OF BACK BUTTON -->
	</div>
	
	<div class="mx-auto" style="width: 800px;">
	<!-- MENGAJI LIST TABLE -->
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Slot Date</th>
	      <th scope="col">Slot Time</th>
	      <th scope="col">Chapter</th>
	      <th scope="col">Venue</th>
	      <th colspan="3">Actions</th>
	    </tr>
	  </thead>
	  <c:forEach items="${umslots}" var="um" varStatus="umslots">
	  <tbody>
	    <tr>
	      <td><c:out value="${um.slotID}" /></td>
	      <td><c:out value="${um.date}" /></td>
	      <td><c:out value="${um.time}" /></td>
	      <td><c:out value="${um.chapter}" /></td>
	      <td><c:out value="${um.venue}" /></td>
    	  <td><a href="AdminUmrahController?action=adminUpdateUmrah&slotID=<c:out value="${um.slotID}" />" class="btn btn-primary">Update</a></td>
          <td><input type="hidden" id="slotID-${umslots.index}" value="<c:out value="${um.slotID}"/>"><button class="btn btn-danger" onclick="confirmation('${umslots.index}')">Delete</button></td>    
	    </tr>
	  </tbody>
	  </c:forEach>
	</table>
	<!-- END OF MENGAJI LIST TABLE -->
	</div>
	
	<script>
		function confirmation(index){
			  var slotID = $("#slotID-" + index).val();
			 
			  console.log(slotID);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'AdminUmrahController?action=deleteUmrah&slotID=' + slotID;
				  alert("Slot successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</body>