<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</head>
<title>Admin Login</title>
</head>
<body>

<%-- <form:form action="addUser.jsp" method="POST">
<form:input path="username" placeholder="username"></form:input>
<form:input path="password" placeholder="password"></form:input>
<form:input path="email" placeholder="email"></form:input>
<input type="submit" value="submit">
</form:form> --%>

<h1>Log In</h1>
<form:form action="submitLogin" method="POST">
        <table>
            <tbody>
                <tr>
                    <td><form:input path="email" placeholder="Enter email"></form:input></td>
                    <td class="error">${userError}</td>
                </tr>
                <tr>
                    <td><form:input type = "password" path="password" placeholder="Enter password"></form:input></td>
                    <td class="error">${passError}</td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Submit"></td>
                </tr>
            </tbody>
        </table>
    </form:form>
    <a href = "userSignUp">Create Account</a>





</body>
</html>