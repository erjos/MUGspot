<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- <script src="http://listjs.com/no-cdn/list.js"></script> -->

<script src="http://listjs.com/no-cdn/list.js"></script>


<!-- <script src="http://listjs.com/no-cdn/list.js"></script> -->

<script type="text/javascript">
	var map;
	var service;
	var infowindow;
	var val1;
	var myData = new Array();
	function initMap() {
		<c:forEach items="${shop}" var="current" >
		var pyrmont = new google.maps.LatLng(${current.lat}, ${current.lng});
		map = new google.maps.Map(document.getElementById('map'), {
			center : pyrmont,
			zoom : 13
		});
		var request = {
			location : pyrmont,
			radius : '10000',
			name : '${current.name}'
		};
		service = new google.maps.places.PlacesService(map);
		service.nearbySearch(request, callback);
		</c:forEach>
	}
	function callback(results, status) {
		for (var i = 0; i < results.length; i++) {
			var place = results[i];
			console.log(results[i]);
			var marker = new google.maps.Marker({
				position : results[i].geometry.location,
				map : map
			})
			var infowindow = new google.maps.InfoWindow({
				content : results[i].name
			});
			marker.addListener('click', function() {
				/*  infoWindow.setContent(results[i].name); */
				infowindow.open(map, marker);
			});
		}
		;
	}
</script>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
	
} 

h2 {
	font-family: sans-serif;
}

.list {
	font-family: sans-serif;
	margin: 0;
	padding: 20px 0 0;
	text-align: center;
}

.list>li {
	display: block;
	background-color: #eee;
	padding: 10px;
	box-shadow: inset 0 1px 0 #fff;
}

#one {
	/*width: 55%;
	display: block;*/
	height: 650px;
	overflow: auto;
	/*margin-top:5px; 
	padding: 5px; */
}

#map {
	 /* width: 50%;  */
	height: 600px;
	display: block; 
	float: right;  
	padding: 5px;
	border-style: solid;
    border-width: 5px;
} 
/*  .btn {
	width: 15%;
	float: right;
	padding: 10px;
}  */
/* .avatar {
	max-width: 150px;
}
*/
img {
	max-width: 100%;
} 
</style>

<title>Shops</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">

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
		<div class="collapse navbar-collapse" id="myNavbar"></div>
	</div>
	</nav>
	
	<div id="one" class="col-lg-6 col-xs-12">
	<form name="addNewShop" action="shopLocationSearch" method="get">
		<button name="cityID" type="submit" value="${cityID}">Add New
			Shop</button>
	</form>
		<ul class="list">

			<c:forEach items="${shop}" var="current" varStatus="status">
				<li>

					<h2 class="Tile">
						<%-- <c:out value="${current.name}" /> --%>
						<c:out
							value="<a href='./shopProfile?id=${current.id}'>${current.name}</a>"
							escapeXml="false" />
					</h2>
					<p class="Address">
						Address:
						<c:out value="${current.address}" />
					</p>
					<p class="Phone">
						Phone:
						<c:out value="${current.phone}" />
					</p>
					<p class="Hours">
						
						<c:out value="${current.hours}" />
					</p>
					<div class="name">
						<div id="demo">
							<button type="button" class="btn" data-toggle="collapse"
								data-target="#${status.index}">Expand</button>

							<div id="${status.index}" class="collapse">
								<br>
								<p class="Description">
									Description:</b>
									<c:out value="${current.description}" />
								</p>

								<br> <br> <img src="${current.picture1}" />
							</div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</div>
	<div id="map" class="col-lg-6 col-xs-12">
		<script
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAX6vlBGntuXNYQiRIry2UFlU5YHlU0Si4&libraries=places&callback=initMap"
			async defer></script>
	</div>


</body>
</html>
