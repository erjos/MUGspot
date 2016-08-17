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
<!-- This script is what's messing up the stying on Review page -->
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>  
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<!-- <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!-- <link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"> -->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<!-- <script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script> -->
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
<%-- <link href="<c:url value="/WebContent/resources/css/main.css" />" rel="stylesheet"> --%>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>  -->

<%-- <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet"> --%>

</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="createLogin">Mugspot</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				

			</div>
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
			</div>
		</h2>
	</center>
	<center>
		<a class="btn" style="position: absolute; top: 35%; left: 10%;"
			onclick="plusDivs(-1)">&#10094; </a> <a class="btn"
			style="position: absolute; top: 35%; right: 10%"
			onclick="plusDivs(+1)">&#10095;</a>
	</center>


	<div class="dbinfo">
		<br>
		<p>
			Phone:
			<c:out value="${shopProfile.phone}" />
		</p>
		<p>
			Address:
			<c:out value="${shopProfile.address}" />
		</p>
		<p>
			Avg cost: ~$
			<c:out value="${shopProfile.budget}" />
			.00
		</p>
		<br> Number of available power outlets:
		<c:out value="${shopProfile.outlets}" />
		<br> Amount of seating available:
		<c:out value="${shopProfile.capacity}" />
		<br>
		<br><br>
			<p class="d">
				Description:<br>
				<c:out value="${shopProfile.description2}" />
			</p>
		<br> Weekly Hours:<br>
		<c:out value="${shopProfile.monday}" /><br>
		<c:out value="${shopProfile.tuesday}" /><br>
		<c:out value="${shopProfile.wednesday}" /><br>
		<c:out value="${shopProfile.thursday}" /><br>
		<c:out value="${shopProfile.friday}" /><br>
		<c:out value="${shopProfile.saturday}" /><br>
		<c:out value="${shopProfile.sunday}" /><br>
		<br>
		
	</div>
	<center>
		<div class="rvwbtns">
			<%-- <div class="container">
				<!-- Trigger the modal with a button -->
				<button type="button" class="btn btn-info btn-lg"
					data-toggle="modal" data-target="#myModal">Leave Review</button>
				href="reviews?id=${shopProfile.id}"
				<!-- Modal -->
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog">

						<!-- Modal content-->
						<div class="modal-content">
					   		<div class="modal-header">
								<form:errors path="reviews.*" />
								<form class="newUser-bg" style="background-color: #E6E6FA"
									action="success" method="get">
									<input type="hidden" name="user_id" value="${user_id}">
									<textarea class="longInput" style="height: 65%"
										" placeholder="Your Review"></textarea>
									<!-- <input type="text" name="review" placeholder="Your Review"> -->
									<input type="number" name="rating" style="height: 10%"
										"1" max="5" placeholder="Your Rating"> <input
										type="hidden" name="shop_id" value="${shop_id}"> <input
										type="submit" value="Submit">
									<!-- cols="30" rows="20" -->
								</form>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
								<!-- <h4 class="modal-title">Modal Header</h4> -->
							</div>
						</div>
					</div>
				</div> --%>
			<%-- <button type="button" class="btn btn-info btn-lg" data-toggle="modal"
				data-target="#myModal">Leave Review</button>
			<textarea class="longInput" style="height: 65%"
				" placeholder="Your Review"></textarea>
			<button class="button" onclick="myFunction('reviews?id=${shopProfile.id}', 'Helpdesk',400,400)" name = "shopid">Leave Review</button>
			<form name="Review" action="Review" method="get">
				<input type="hidden" name="shopid" value="${shopProfile.id}">
				<input type="submit" name="seeReview" value="See Reviews">
			</form>
		</div>
	</center>
	</div> --%>
	<center>
<div class="rvwbtns">
	<button class="button" onclick="myFunction('reviews?id=${shopProfile.id}', 'Helpdesk',400,200)" name = "shopid">Leave Review</button>
	<form name="Review" action="Review" method="get">
	<input type = "hidden" name = "shopid" value = "${shopProfile.id}"/>
    <input type="submit" name = "seeReview" value="See Reviews">
    </form>
</div>	
		</center> 

	<%-- 	<center>
<div class="rvwbtns">
	<button class="button" onclick="myFunction('reviews?id=${shopProfile.id}', 'Helpdesk',400,400)" name = "shopid">Leave Review</button>
	<form name="Review" action="Review" method="get">
	<input type = "hidden" name = "shopid" value = "${shopProfile.id}">
    <input type="submit" name = "seeReview" value="See Reviews">
    </form>
</div>	
		</center> --%>

</body>
</html>