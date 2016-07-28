<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ page import="com.group.mugspot.controller.DAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">
<title>MUGspot</title>
<!-- Latest compiled and minified CSS -->
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
				<a class="navbar-brand" href="index.jsp">Mugspot</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="index.jsp">Home</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="userSignUp""><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<li><a href="createLogin"><span
							class="glyphicon glyphicon-log-in"></span> Log In</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Main jumbotron for a primary marketing message or call to action -->
	<div class="jumbotron">
		<div class="container">
			<h1 id="header1">Mugspot</h1>
			<p id="home1">We know how hard it can be to find the perfect
				coffee shop. Whether you're looking for a spot to get work done, a
				relaxing place to read or just to enjoy the best cup of coffee in town,
				we're here to help you find your perfect mug spot today!</p>
			<%
				ArrayList locations = DAO.getCityNames();
				pageContext.setAttribute("cities", locations);
			%>
			<br>
			<form role="form" name="selectCity" action="shops" method="get">
				<div class="form-group">
					<label id="label1" for="sel1">Select City</label> 
					<select name = "City" class="form-control" id="sel1">
						<c:forEach items="${cities}" var="current">
					<option value="${current.id}">${current.name}</option>
				</c:forEach>
					</select>
					<input type="submit" class="btn btn-primary btn-lg" value="Select City &raquo";>
				</div>
			</form>
		</div>
	</div>
	</div>
	<hr>
	<footer>
		<p>&copy; 2016 MUGspot, Inc.</p>
	</footer>
	</div>
	<!-- /container -->
	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>