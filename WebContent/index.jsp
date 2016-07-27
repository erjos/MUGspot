<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.group.mugspot.controller.DAO"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<title>Spring 4 MVC - HelloWorld Index Page</title>
<style>
body {
    background-image: url("https://images.unsplash.com/photo-1440492248262-6895f9da82fc?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&s=b55bcaa28b217821a149f4d2479a1f59");
    background-size: 100% 100%;
    background-repeat: no-repeat; 
}
</style>
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
			<a href="userSignUp">Sign up</a>
			<br><br>
			<a href="createLogin">Login</a>
			
		</h3>
	</center>
</body>
</html>