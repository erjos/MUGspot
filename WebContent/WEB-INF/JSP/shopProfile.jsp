<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
	

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<!-- This script is what's messing up the stying on Review page -->
<!-- <script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script> -->
	
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script>
	function myFunction(pageURL, title, w, h) {
		var left = (screen.width / 2) - (w / 2);
		var top = (screen.height / 2) - (h / 2);
		var targetWin = window
				.open(
						pageURL,
						title,
						'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width='
								+ w
								+ ', height='
								+ h
								+ ', top='
								+ top
								+ ', left=' + left);
	}
</script>
<title>shop details</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle"  data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">Mugspot</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar"></div>
	</div>
	</nav>


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
		</h2>
	</center>
	<center>
		<a class="btn" style="position: absolute; top: 55%; left: 15px;"
			onclick="plusDivs(-1)">&#10094; </a> <a class="btn"
			style="position: absolute; top: 55%; left: 645px"
			onclick="plusDivs(+1)">&#10095;</a>
	</center>

	</div>
	<div class="dbinfo">
		<br>
		<p><h3>
			Description:<br></h3>
			<c:out value="${shopProfile.description2}" />
		</p>
		<p><h4>
			Phone:
			<c:out value="${shopProfile.phone}" />
		</p></h4>
		<p><h4>
			Address:
			<c:out value="${shopProfile.address}" />
		</p></h4>
		<p><h4>
			Avg cost: ~$
			<c:out value="${shopProfile.budget}" />
			.00
		</p></h4>
		<p><h4> Number of available power outlets:
		<c:out value="${shopProfile.outlets}" /></p></h4>
		<p> <h4>Amount of seating available:
		<c:out value="${shopProfile.capacity}" /></p></h4>
		<br>
		<div class ="wkhrs">
		
		<h4> Weekly Hours:</h4>
		<c:out value="${shopProfile.monday}" />
		<br>
		<c:out value="${shopProfile.tuesday}" />
		<br>
		<c:out value="${shopProfile.wednesday}" />
		<br>
		<c:out value="${shopProfile.thursday}" />
		<br>
		<c:out value="${shopProfile.friday}" />
		<br>
		<c:out value="${shopProfile.saturday}" />
		<br>
		<c:out value="${shopProfile.sunday}" />
		</div>
		
					<button class="button" id = "LeaveReview"
						onclick="myFunction('reviews?id=${shopProfile.id}', 'Helpdesk',400,200)"
						name="shopid">Leave Review</button>
						<br><br>
					<form name="Review" action="Review" method="get">
						<input type="hidden" name="shopid" value="${shopProfile.id}" /> <input
							type="submit" name="seeReview" value="See Reviews" id = "SeeReview" width = 100px>
					</form>
				

	</div>
			
</body>
</html>