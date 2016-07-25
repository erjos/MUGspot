<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ page import="com.group.mugspot.controller.DAO"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirmation Page</title>
</head>
<body>
<h1>Confirmation Page</h1>
<jsp:useBean id="Shop_Name" class="com.group.mugspot.controller.Shops">    
<jsp:setProperty property="*" name="Shop_Name"/>
</jsp:useBean>
<% 
DAO.addShop(Shop_Name);
%>   
</body>
</html>