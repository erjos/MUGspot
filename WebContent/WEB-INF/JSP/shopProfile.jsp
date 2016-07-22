<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>shop details</title>
</head>
<body>
<h1><center><c:out value="${shopProfile.name}" /></center></h1><br>
<center><c:out value="${shopProfile.description2}" /></center><br>
menu: <c:out value="${shopProfile.menu}" /><br>
number of outlets: <c:out value="${shopProfile.outlets}" /><br>
Amount of seating available: <c:out value="${shopProfile.capacity}" /><br>


</body>
</html>