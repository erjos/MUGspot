<%@page import="org.omg.CORBA.Current"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding = "ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.group.mugspot.controller.DAO"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet"
	href="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/css/bootstrap.css"
	integrity="sha384-XXXXXXXX" crossorigin="anonymous">
<script
	src="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/js/bootstrap.js"
	integrity="sha384-XXXXXXXX" crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<style>
/* body {
	font-family: 'Indie Flower', cursive;
}
 */
table {
	align: center;
}

th {
	text-align: center;
	font-size: 30px;
}

td {
	padding: 15px;
	text-align: left;
	font-size: 20px;
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
<table>
<c:forEach items="${reviews}" var="current">
<tr><td>USERNAME: ${current.username} <br>REVIEW: ${current.review} <br>RATING: ${current.rating} <br><br><br></td></td></tr>
</c:forEach> 
</table>
</body>
</html>