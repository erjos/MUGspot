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
		<tr>
		<div class="container">
			<td><h2>
					<c:out value="${current.name}" />
				</h2>
					<button type="button" class="btn btn-info" data-toggle="collapse"
						data-target="#${status.index}">See More</button>
					<div id="${status.index}" class="collapse">
					</td>
						<td><b>Description:</b> <c:out value="${current.description}" />
						<td><br>
						<td><b>Menu:</b> <c:out value="${current.menu}" />
						<td><br>
						<td><b>Outlets:</b> <c:out value="${current.outlets}" />
						<td><br>
						<td><b>Capacity:</b> <c:out value="${current.capacity}" />
						<td><br>
						<td><b>Budget:</b> <c:out value="${current.budget}" />
						<td><br>
						<td><b>Phone:</b> <c:out value="${current.phone}" />
						<td><br>
						<td><b>Address:</b> <c:out value="${current.address}" />
						<td><br> <br> <br>
		</tr>
		</div>
		</div>
	</c:forEach>
</body>
</html>