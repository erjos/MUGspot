
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
button {
	float: right;
	vertical-align: text-bottom;
	width: 100px;
	margin: -41px   auto;
} 

</style>
<title>Shops</title>
</head>
<body>
	<center>
		<h1>Here's Your Shop Info</h1>
	</center>

	<c:forEach items="${shop}" var="current" varStatus="status">

		

		<div class="container">
			<h2>
				<c:out value="<a href='./shopProfile?id=${current.id}'>${current.name}</a>" escapeXml="false"/>
			</h2>
			<button type="button" class="btn btn-info" data-toggle="collapse"
				data-target="#${status.index}">See More</button>
			<div id="${status.index}" class="collapse">
				<table>
					<tr>
						<td><b>Description:</b> <c:out value="${current.description}" /></td>
						<td><b>Menu:</b> <c:out value="${current.menu}" /></td>
						<td><b>Outlets:</b> <c:out value="${current.outlets}" /></td>
						<td><b>Capacity:</b> <c:out value="${current.capacity}" /></td>
						<td><b>Budget:</b> <c:out value="${current.budget}" /></td>
						<td><b>Phone:</b> <c:out value="${current.phone}" /></td>
						<td><b>Address:</b> <c:out value="${current.address}" /></td>
					</tr>
				</table>
			
				<div class="slideshow">
					 <img class="slide" src="${current.picture1}"/>
					  <img class="slide" src="<c:out value="${current.picture2}"/>"/>
					  <img class="slide" src="<c:out value="${current.picture3}"/>"/>
					  <img class="slide" src="<c:out value="${current.picture4}"/>"/>
					  <img class="slide" src="<c:out value="${current.picture5}"/>"/>
					  <img class="slide" src="<c:out value="${current.picture6}"/>"/>
					  <img class="slide" src="<c:out value="${current.picture7}"/>"/>
					  <img class="slide" src="<c:out value="${current.picture8}"/>"/>
					  <img class="slide" src="<c:out value="${current.picture9}"/>"/>
					  <img class="slide" src="<c:out value="${current.picture10}"/>"/>
					
					<a class="w3-btn-floating" style="position:absolute;top:35%;left:100px" onclick="plusDivs(-1)">&#10094;</a>
					<a class="w3-btn-floating"  style="position:absolute;top:35%;right:840px" onclick="plusDivs(+1)">&#10095;</a>
		
				<script>
				var slideIndex = 1;
				showDivs(slideIndex);
				
				function plusDivs(n) {
				  showDivs(slideIndex += n);
				}
				
				function showDivs(n) {
				  var i;
				  var x = document.getElementsByClassName("slide");
				  if (n > x.length) {slideIndex = 1}
				  if (n < 1) {slideIndex = x.length}
				  for (i = 0; i < x.length; i++) {
				     x[i].style.display = "block";
				  }
				  x[slideIndex-1].style.display = "block";
				}
				</script>
			</div>
		
		
	</div>
</div>
		
	</c:forEach>

</body>
</html>