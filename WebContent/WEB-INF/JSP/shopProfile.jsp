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
<c:out value="${shopProfile.phone}" /><br>
<c:out value="${shopProfile.address}" /><br>
<c:out value="${shopProfile.id}" /><br>
<c:out value="${shopProfile.budget}" /><br>

<c:out value="${shopProfile.name}" /><br>
<c:out value="${shopProfile.description}" /><br>
<c:out value="${shopProfile.menu}" /><br>
<c:out value="${shopProfile.outlets}" /><br>
<c:out value="${shopProfile.capacity}" /><br>

<div class="slideshow">
<img class="slide" src="<c:out value="${shopProfile.picture1}"/>"/>
<img class="slide" src="<c:out value="${shopProfile.picture2}"/>"/>
<img class="slide" src="<c:out value="${shopProfile.picture3}"/>"/>
<img class="slide" src="<c:out value="${shopProfile.picture4}"/>"/>
<img class="slide" src="<c:out value="${shopProfile.picture5}"/>"/>
<img class="slide" src="<c:out value="${shopProfile.picture6}"/>"/>
<img class="slide" src="<c:out value="${shopProfile.picture7}"/>"/>
<img class="slide" src="<c:out value="${shopProfile.picture8}"/>"/>
<img class="slide" src="<c:out value="${shopProfile.picture9}"/>"/>
<img class="slide" src="<c:out value="${shopProfile.picture10}"/>"/>



 <a class="btn" style="position:absolute;top:35%;left:100px" onclick="plusDivs(-1)">&#10094;</a>
<a class="btn"  style="position:absolute;top:35%;right:840px" onclick="plusDivs(+1)">&#10095;</a>
		 
				 <script>
				var slideIndex = 1;
				showDivs(slideIndex);
				
				function plusDivs(n) {
				  showDivs(slideIndex += n);
				}
				
				function showDivs(n) {
				  var i;
				  var x = document.getElementsByClassName("slide");
				  if (n > x.length) {slideIndex = 1}
				  if (n < 1) {slideIndex = x.length}
				  for (i = 0; i < x.length; i++) {
				     x[i].style.display = "none";
				  }
				  x[slideIndex-1].style.display = "block";
				}
				</script> 
				</div>
				
</body>
</html>