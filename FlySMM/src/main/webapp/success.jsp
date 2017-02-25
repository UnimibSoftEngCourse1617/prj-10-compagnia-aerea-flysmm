<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<font face="Arial" />
<meta charset="UTF-8">
<!-- Inizio sezione per Semantic ui -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/css/semantic.css"
	rel="stylesheet" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/javascript/semantic.js">
	
</script>
<!-- Fine sezione per Semantic ui -->
<title>Success</title>
</head>
<body>
	<div class="ui stackable inverted menu">
		<a href="index.jsp" class="item">FlySMM</a>
		<a class="item"> About Us </a>
		<a class="item"> Jobs </a>
		<a class="item"> Locations </a>

		<%
			if (request.getSession().getAttribute("customer") == null) {
		%>

		<a href="loginPage.html" class="right item"> Login </a>

		<%
			} else {
		%>
		<%
			if (request.getSession().getAttribute("customer").getClass().toString().matches("class customer.FidelityCustomer")){
				%> <a href="homeFidelityCustomer.jsp" class="right item"> Home </a>
	<%}else{ %>
		<a href="homeCustomer.jsp" class="right item"> Home </a><%} %>

		<!-- <a href="./logoutServlet " class="right item"> Home </a> -->
		<a href="./logoutServlet " class="right item"> Log out </a>
		<%
			}
		%>
	</div>
	
	<h1 class="ui center aligned header">
		<img class="ui image " style="margin: 0 auto;"
			src="images/success.png"> Congrats
		<div class="sub header">Your order has been processed, you can now payed!</div>
	</h1>
		
	<div class="ui center aligned green segment">
		<form method="post" action="./GetBook">
			<!--<input class="ui green submit button" type="submit" value="Pay!"> -->
			<button class="ui center aligned red button">
			<i class="dollar icon"></i> Pay Now!
			</button>
			<input type="hidden" name="command" value="GetBook">
		</form>
	</div>

</body>
</html>