<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add a Shop</h1>
<form name="form1" action="addShop.jsp" method="get">
	Shop Name: <input name="shop_name" type="text"><br>
	Description: <input name="description" type="text"><br>
	Menu: <input name="menu" type="text"><br>
	Outlets: <input name="outlets" type="text"><br>
	Capacity: <input name="capacity" type="text"><br>
	Budget: <input name="budget" type="text"><br>
	Place ID: <input name="place_id" type="text"><br>
	<button type="submit">Submit!</button>
</form>
<form name="deleteShop" action="deleteShop.jsp" method="post">
		<button type="hidden" name="hiddenbutton">Delete!</button>
		</form>

</body>
</html>