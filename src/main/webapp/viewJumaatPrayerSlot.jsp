<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<% //In case, if User session is not set, redirect to Login page
	if((request.getSession(false).getAttribute("user")== null) ){%>
	<jsp:forward page="login.jsp"></jsp:forward>
	<%} %>
<meta charset="ISO-8859-1">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Masjid Appointment System</title>
	
	<!-- Bootstrap CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
	
	<!-- Bootstrap JS -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous">
	</script>
</head>

<body>
	<br><h2 align="center"><font><strong>Book Jumaat Prayer Slot</strong></font></h2>
	<br>

	<br><br>
	
	<!-- Create Account  form -->
	<div class="row justify-content-center">
    <div class="col-auto">
		<form action="BookJumaatPrayerController" method="post" style="align:center">
			<div class="mb-3">
			  <label for="slotID" class="form-label">Slot ID:</label>
			  <input type="text" name="slotID" class="form-control" id="slotID" value= "<c:out value="${jumaatPrayer.slotID}"/>" readonly>
			</div>
			<div class="mb-3">
			  <label for="date" class="form-label">Date:</label>
			  <input type="text"  name="date" class="form-control" id="date" value="<c:out value="${jumaatPrayer.date}"/>" readonly>
			</div>
			<div class="mb-3">
			  <label for="khutbahTitle" class="form-label">Khutbah:</label>
			  <input type="text"  name="khutbahTitle" class="form-control" id="khutbahTitle" value="<c:out value="${jumaatPrayer.khutbahTitle}"/>" readonly>
			</div>
			<div class="mb-3">
			  <label for="userID" class="form-label">user IC:</label>
			  <input type="text"  name="userID" class="form-control" id="userID">
			</div>
			<div class="mb-3">
			  <label for="bookDate" class="form-label">Date of booking made:</label>
			  <input type="date"  name="bookDate" class="form-control" id="bookDate">
			</div>
			  <input class="btn btn-dark" type="submit" value="Book Now">
			  <input class="btn btn-dark" type="reset" value="Reset">
		 </form>
	</div>	
	</div>
</body>
</html>
