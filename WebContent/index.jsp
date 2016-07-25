<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.group.mugspot.controller.DAO"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<body> 
	<center>
		<h2>MUGspot</h2>
		<h3>
		<% ArrayList locations = DAO.getCityNames();
		pageContext.setAttribute("cities", locations);
			%>
			Select City <br>
			<form name = "selectCity" action="shops" method="get">
			<select name="City">
			<c:forEach items="${cities}" var ="current">
			<option value ="${current.id}" > ${current.name}</option>
			</c:forEach>
			</select>
			<input type="submit" value="select">
			</form>
			<br><br>
			<a href="location">Create New Location</a>
			<br><br>
			<a href="newShopForm.jsp">New Shop Form</a>
		</h3>
	</center>
</body>
</html>