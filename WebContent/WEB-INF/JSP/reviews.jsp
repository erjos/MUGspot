<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script
	src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
<title>Insert title here</title>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>


<style>
/* .longInput {
         height: 287px; 
         margin-top: 8px; 
         margin-bottom: 8px;
} */
form {
	background-color: #5F9EA0;
}
</style>
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



	<!-- <div data-role="popup" id="myPopup" class="ui-content"> -->
	<%-- 	 <form:errors path="users.*"/> 
	<form class="newUser-bg" action="/MUGspot/success" method="post">
	<!-- <form name="form" action="/MUGspot/success" method="post"> -->
		<input type="text" name="username" placeholder="Username">
		<input type="text" name="review" style="min-width: 250px; min-height: 250px" placeholder="Your Review">
		<input type="number" name="rating" min="1" max="5"
			placeholder="Your Rating"> <input type="text" name="shop_id"
			value="${param.id}"> <input type="submit" data-inline="true"
			value="Submit">
		</form> --%>
${message}



	<form:errors path="reviews.*" />
	<form class="newUser-bg" style="background-color:#E6E6FA"action="success" method="get">
		<input type="hidden" name="user_id" value="${user_id}">
		<textarea class="longInput" name="review" style=height:65%" placeholder="What are your thoughts about this location?"></textarea> 
	<!-- 	 <input type="text" name="review" placeholder="Your Review"> -->
		<input type="number" name="rating" style=height:10% "1" max="5" placeholder="Your Rating max - 5">
		<input type="hidden" name="shop_id" value="${shop_id}">
		<input type="submit" value="Submit">
		<%-- cols="30" rows="20"--%>
	</form>
	

</body>
</html>