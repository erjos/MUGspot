<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter your Location</title>
</head>

<body>
<form name="form1" action="createLocation" method="post">
Enter your city: <input name ="city" type ="text">
<button type="submit"> submit </button>
</form>
${message}
</body>
</html>