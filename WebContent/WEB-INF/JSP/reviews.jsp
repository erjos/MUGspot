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
<%-- 
	<form:errors path="reviews.*" />
	<form class="newUser-bg" style="background-color:#E6E6FA"action="success" method="get">
		<input type="hidden" name="user_id" value="${user_id}">
		<textarea class="longInput" style=height:65%" placeholder="Your Review"></textarea> 
		<!-- <input type="text" name="review" placeholder="Your Review"> -->
		<input type="number" name="rating" style=height:10% "1" max="5" placeholder="Your Rating">
		<input type="hidden" name="shop_id" value="${shop_id}">
		<input type="submit" value="Submit">
		<!-- cols="30" rows="20" -->
	</form> --%>
	${message}
</body>
</html>