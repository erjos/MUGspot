<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shop Locations</title>
</head>
<body>
<c:forEach items= "${shops}" var="current">
<form name="createShopProfile" action = "newShop" method = "get">
<tr>
<td><c:out value="${current.name}" /><td>
<input type="hidden" name = "name" value="${current.name}">
<td><c:out value="${current.address}" /><td>
<td><c:out value="${current.place_id}" /><td>
<input type="hidden" name = "place_id" value="${current.place_id}">
<input type="hidden" name = "city_id" value ="${city_id}">
<button type="submit">Select</button> 
</form>
<br><br>
</c:forEach>

</body>
</html>