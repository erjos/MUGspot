<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/css/bootstrap.css"
	integrity="sha384-XXXXXXXX" crossorigin="anonymous">
<script
	src="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/js/bootstrap.js"
	integrity="sha384-XXXXXXXX" crossorigin="anonymous"></script>
<link href='https://fonts.googleapis.com/css?family=Indie+Flower'
	rel='stylesheet' type='text/css'>
<style>
body {
	font-family: 'Indie Flower', cursive;
}

th {
	text-align: center;
	font-size: 45px;
}

td {
	padding: 15px;
	text-align: left;
	font-size:25px;
	
}

tr:nth-child(even) {
	background-color: #5F9EA0;
}
tr:nth-child(odd) {
	background-color: #DEB887;
}
</style>
<title>Reviews</title>
</head>
<body>
	<table border="1" style="width: 100%; height: 100%;">
		<tr>
			<!-- <th>ID</th> -->
			<th>Reviews</th>
		</tr>
		<!-- <th>Modify User</th> -->

		<c:forEach items="${reviews}" var="current">
			<tr>
				<td>
					<p>${current.getReview()}</p>
					<br>
				<%-- <p>${current.getUser_id() }</p> --%>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>