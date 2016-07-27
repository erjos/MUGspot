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
</head>
<body>

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
		
	
	<form class="newUser-bg" action="success" method="get">
		<br> <input type="text" name="user_id" value="${user_id}"><br>
		Review:<br> <input type="text" name="review"><br>
		Rating:<br> <input type="number" name="rating"><br>
		Shop ID:<br> <input type="text" name="shop_id" value = "${shop_id}"><br>
		<br> <input type="submit" value="Submit">
	</form>
	<br>
	<br>
</body>
</html>