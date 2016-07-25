<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Login</title>
</head>
<body>

<%-- <form:form action="addUser.jsp" method="POST">
<form:input path="username" placeholder="username"></form:input>
<form:input path="password" placeholder="password"></form:input>
<form:input path="email" placeholder="email"></form:input>
<input type="submit" value="submit">
</form:form> --%>

<form name="registerUser" action="addUser.jsp" method="get">
	username	<input name="username" type="text">
	password	<input name="password" type="text">
	email		<input name="email" type="text">
	<button type="submit">Register</button>

</form>


</body>
</html>