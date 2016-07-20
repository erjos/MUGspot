
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shops</title>
</head>
<body>
	<center>
		<h1>Here's Your Shop Info</h1>
	</center>


	<c:forEach items="${shop}" var="current">
		<tr>

			<td><h2>
					<c:out value="${current.name}" />
				</h2>
			<td>
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
			<td><br>
			<br>
			<br>
		</tr>
	</c:forEach>
</body>
</html>