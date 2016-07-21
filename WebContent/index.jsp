<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring 4 MVC - HelloWorld Index Page</title>
</head>
<body>
 
	<center>
		<h2>MUGspot</h2>
		<h3>
			<a href="shops">Detroit Coffee Shops</a>
			<br><br>
			<a href="location">Create New Location</a>
		</h3>
	</center>
	<h1>Add a User</h1>
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
