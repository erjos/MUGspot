<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shops</title>
</head>
<body>
	<center>
		<h1>Here's Your Shop Info</h1>
	</center>	
		<h2>Shop 1:</h2>
			${icon}
			<br>
			<b> Name:</b> ${name}
			<br>
			<b>Description:</b> ${description}
			<br>
			<b>Menu:</b>${menu}
			<br>
			<b># of Outlets:</b> ${outlets}
			<br>
			<b>Capacity: </b>${capacity}
			<br>
			<b>Phone #:</b> ${phone}
			<br>
			<b>Address:</b> ${address}
			<br>
			<b>Budget: </b> ${budget}
</body>
</html>