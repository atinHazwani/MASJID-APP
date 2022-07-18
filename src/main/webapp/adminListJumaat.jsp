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
	
	
	
	<!-- BACK BUTTON -->
	<div class="mx-auto" style="width: 300px;">
	<ul class="nav nav-pills nav-fill">
		<li class="nav-item"><a class="nav-link active" aria-current="page" href="adminAddJumaat.jsp">Create New Slot</a></li>
	</ul><br><br>
	</div>
	<!-- END OF BACK BUTTON -->
	
	
	<!-- JUMAAT LIST TABLE -->
	<div class="mx-auto" style="width: 800px;">
	<table class="table" id="totalSlot">
	  <thead>
	  	<td></td>
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Slot Date</th>
	      <th scope="col">Khutbah Title</th>
	      <th colspan="3">Actions</th>
	    </tr>
	  </thead>
	  <c:forEach items="${jumaatPrayers}" var="jumaatPrayer" varStatus="jumaatPrayers">
	  <tbody>
	    <tr>
	      <td><c:out value="${jumaatPrayer.slotID}" /></td>
	      <td><c:out value="${jumaatPrayer.date}" /></td>
	      <td><c:out value="${jumaatPrayer.khutbahTitle}" /></td>
    	  <td><a href="AdminJumaatController?action=adminUpdateJumaat&slotID=<c:out value="${jumaatPrayer.slotID}" />" class="btn btn-primary">Update</a></td>
          <td><input type="hidden" id="slotID-${jumaatPrayers.index}" value="<c:out value="${jumaatPrayer.slotID}"/>"><button class="btn btn-danger" onclick="confirmation('${jumaatPrayers.index}')">Delete</button></td>    
	    </tr>
	  </tbody>
	  </c:forEach>
	</table>
	</div>
	<!-- END OF JUMAAT LIST TABLE -->
	
	
	<script>
		function confirmation(index){
			  var slotID = $("#slotID-" + index).val();
			 
			  console.log(slotID);
			  var r = confirm("Are you sure you want to delete?");
			  if (r == true) {				 		  
				  location.href = 'AdminJumaatController?action=deleteJumaat&slotID=' + slotID;
				  alert("Slot successfully deleted");			
			  } else {				  
			      return false;	
			  }
		}
		
		function totalSlot(){
			var rows = document.getElementById("totalSlot").rows;
			for(var i=1; i<=rows.length; i++){
				rows[i-1].id = 'Total Slots:' + i;
			}
			
		}
	</script>
	<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
</body>
</html>