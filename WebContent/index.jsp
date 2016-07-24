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
			<a href="shops">Detroit Coffee Shops</a>
			<br><br>
			<select name="City">
			<option value ="Detroit">Detroit<Value>
			</select>
			<a href="location">Create New Location</a>
			<% out.println(DAO.getCityNames());
			%>
			<br><br>
			<a href="newShopForm.jsp">New Shop Form</a>
		</h3>
	</center>
</body>
</html>