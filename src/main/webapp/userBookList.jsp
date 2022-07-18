<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
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
	
	<br><h2 align="center"><font><strong>Booked List</strong></font></h2>
	<br>

	<br><br>
	
	<!-- Create Account  form -->
	<div class="row justify-content-center">
    <div class="col-auto">
	<table id="list" class="table table-striped" style="width:100%">
  	<tr>
    <th>Book Id</th>
    <th>Slot</th>
    <th>Booked By</th>
    <th>Booking Date</th>
    <th colspan="2"></th>
  	</tr>
 	<c:forEach items="${bookedSlots}" var="bookedSlot" varStatus="bookedSlots">
  	<tr>
    <td><c:out value="${bookedSlot.bookID}" /></td>
    <td><c:out value="${bookedSlot.slotID}" /></td>
    <td><c:out value="${bookedSlot.userID}" /></td>
    <td><c:out value="${bookedSlot.bookDate}" /></td>    
    <td><a href="DelBookController?bookID=<c:out value="${bookedSlot.bookID}" />" class="btn btn-primary">Cancel Booking</a></td>    
   
	</tr></c:forEach></table>
	</div>
	</div>
</body>
</html>
