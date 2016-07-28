<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
	<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
		<script>
		function myFunction(pageURL, title,w,h) {
	        var left = (screen.width/2)-(w/2);
	        var top = (screen.height/2)-(h/2);
	        var targetWin = window.open (pageURL, title, 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='+w+', height='+h+', top='+top+', left='+left);
	        }
	</script>
<title>shop details</title>
<link href="<c:url value="/WebContent/resources/css/main.css" />" rel="stylesheet">

</head>
<body>

<center>
	<h1>
		<c:out value="${shopProfile.name}" />
		</h1>
		</center>

	<center>
		<h2>
<div class="slideshow">
		<img class="slide" src="<c:out value="${shopProfile.picture1}"/>" />
		<img class="slide" src="<c:out value="${shopProfile.picture2}"/>" />
		<img class="slide" src="<c:out value="${shopProfile.picture3}"/>" />
		<img class="slide" src="<c:out value="${shopProfile.picture4}"/>" />
		<img class="slide" src="<c:out value="${shopProfile.picture5}"/>" />
		<img class="slide" src="<c:out value="${shopProfile.picture6}"/>" />
		<img class="slide" src="<c:out value="${shopProfile.picture7}"/>" />
		<img class="slide" src="<c:out value="${shopProfile.picture8}"/>" />
		<img class="slide" src="<c:out value="${shopProfile.picture9}"/>" />
		<img class="slide" src="<c:out value="${shopProfile.picture10}"/>" />

		<script>
			var slideIndex = 1;
			showDivs(slideIndex);

			function plusDivs(n) {
				showDivs(slideIndex += n);
			}

			function showDivs(n) {
				var i;
				var x = document.getElementsByClassName("slide");
				if (n > x.length) {
					slideIndex = 1
				}
				if (n < 1) {
					slideIndex = x.length
				}
				for (i = 0; i < x.length; i++) {
					x[i].style.display = "none";
				}
				x[slideIndex - 1].style.display = "block";
			}
		</script>
</div>
	</h2>
	</center>
	<center>
		<a class="btn" style="position: absolute; top: 35%; left: 10%;"
			onclick="plusDivs(-1)">&#10094; </a>
	    <a class="btn" style="position: absolute; top: 35%; right: 10%"
			onclick="plusDivs(+1)">&#10095;</a>
	</center>
	
	
<div class="dbinfo">
	<br>
	<p>Phone:<c:out value="${shopProfile.phone}" /></p>
	<p>Address: <c:out value="${shopProfile.address}" /></p>
	<p>Avg cost: ~$<c:out value="${shopProfile.budget}" />.00</p>
	<br> Number of available power outlets:  
	<c:out value="${shopProfile.outlets}" />
	<br> Amount of seating available:
	<c:out value="${shopProfile.capacity}" />
	<br>
	<center>
		<p>Description:<br> <c:out value="${shopProfile.description2}" /></p>
	</center>
</div>
	<center>
<div class="rvwbtns">
	<button class="button" onclick="myFunction('reviews?id=${shopProfile.id}', 'Helpdesk',400,200)" name = "shopid">Leave Review</button>
	<form name="Review" action="Review" method="get">
	<input type = "hidden" name = "shopid" value = "${shopProfile.id}"/>
    <input type="submit" name = "seeReview" value="See Reviews">
    </form>
</div>	
		</center>
</body>
</html>