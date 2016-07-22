<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
	var map;
	var service;
	var infowindow;
	var val1;
	var myData = new Array();

	function initMap() {
		<c:forEach items="${shop}" var="current" >
		var pyrmont = new google.maps.LatLng(42.331429, -83.045753);

		map = new google.maps.Map(document.getElementById('map'), {
			center : pyrmont,
			zoom : 15
		});

		var request = {
			location : pyrmont,
			radius : '1000',
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
button {
	float: right;
	vertical-align: text-bottom;
	width: 100px;
	margin: -41px auto;
}

html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#map {
	width: 500px;
	height: 300px;
}

h2 {
	font-family: sans-serif;
}

.list {
	font-family: sans-serif;
	margin: 0;
	padding: 20px 0 0;
}

.list>li {
	display: block;
	background-color: #eee;
	padding: 10px;
	box-shadow: inset 0 1px 0 #fff;
}

.avatar {
	max-width: 150px;
}

img {
	max-width: 100%;
}
</style>
<title>Shops</title>
</head>
<body>
	

		<option>Sort by Outlets</option>
		<div id="users">
			<input class="search" placeholder="Search" /> Sort Button<select
				id="sortbox" class="sort" data-sort="capacity">
				<option value="outlets">Outlets</option>
				<option value="capacity">Capacity</option>
				<option value="budget">Budget</option>
			</select><br>
			</div>
			<ul class="list">
				<c:forEach items="${shop}" var="current" varStatus="status">
					<script>
						myData.push("${current.address}")
					</script>

					<li>
						<div class="container">
							<h2 class="Tile">
								<%-- <c:out value="${current.name}" /> --%>
								<c:out
									value="<a href='./shopProfile?id=${current.id}'>${current.name}</a>"
									escapeXml="false" />
							</h2>

							<p class="Description">
								Description:</b>
								<c:out value="${current.description}" />

							</p>
							<button type="button" class="btn btn-info" data-toggle="collapse"
								data-target="#${status.index}">Expand</button>
							<div id="${status.index}" class="collapse">
								<p class="Description">
									Menu:
									<c:out value="${current.menu}" />
								</p>
								<p class="outlets">
									Outlets:
									<c:out value="${current.outlets}" />
								</p>
								<p class="capacity">
									Capacity:
									<c:out value="${current.capacity}" />
								</p>
								<p class="budget">
									Budget:
									<c:out value="${current.budget}" />
								</p>
								<p class="Description">
									Phone:
									<c:out value="${current.phone}" />
								</p>
								<p class="Description">
									Address:
									<c:out value="${current.address}" />
								</p>
								<button type="button" class="btn btn-primary"
									data-toggle="button" aria-pressed="false" autocomplete="off">
									See More</button>
								<br> <br>
								

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
						<td><img class="slide" src="${current.picture1}"/>
						
					</tr>
				</table>
			
	
			</div>
		
		
	</div>
</div>
</div>

		
	</c:forEach>
	<center>
	<div id="map">
			<script
				src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAX6vlBGntuXNYQiRIry2UFlU5YHlU0Si4&libraries=places&callback=initMap"
				async defer></script>
				</div>
</center>
				
		
</body>
</html>

