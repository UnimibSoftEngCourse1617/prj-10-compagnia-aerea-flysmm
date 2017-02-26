<%@page import="booking.Book"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.JsonElement"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="sale.Flight"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<font face="Arial"/>
<!-- Inizio sezione per Semantic ui -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/css/semantic.css"
	rel="stylesheet" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/javascript/semantic.js"></script>
<!-- Fine sezione per Semantic ui -->
<title>FlySMM</title>
</head>
<body>
	<div class="ui stackable inverted menu">
		<a href="index.jsp" class="item">FlySMM</a>
		
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

		<!-- <a href="./logoutServlet " class="right item"> Home </a> --> <a
			href="./logoutServlet " class="right item"> Log out </a>

		<%
			}
		%>

	</div>
	<h1 align="center">Book Unpayed</h1>
	<table class="ui celled table">
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Flight Id</th>
				<th>Fiscal code passenger</th>
				<th>Departure Date</th>
				<th>Airplane Id</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listBookUnpayed}" var="bookU">
				<tr>
					<td>${bookU.bookId}</td>
					<td>${bookU.flightId}</td>
					<td>${bookU.documentP}</td>
					<td>${bookU.departureDate}</td>
					<td>${bookU.airplaneId}</td>
					<td>${bookU.totalPrice}</td>
					<td><form method="post" name="flightItems"
							action="./DeleteBook">
							<input type="submit" class="ui red button" value="Delete" /> <input
								type="hidden" name="chosenId" value="${bookU.bookId}" /> <input
								type="hidden" name="chosenF" value="${bookU.flightId}" /> <input
								type="hidden" name="command" value="DeleteBook" />
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<th></th>
				<th></th>
				<th></th>
				<th></th>
				<th>Total Price</th>
				<th>${totalPriceHomeCustomer}</th>
			</tr>
		</tfoot>
	</table>
	<form class="ui form" name="payment" method="post" action="./Payment_options">
		<input class="ui red submit button" type="submit" value="Pay!">
		<input type="hidden" name="command" value="Payment">
	</form>
	<h1 align="center">Book Payed</h1>
	<table class="ui celled table">
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Flight Id</th>
				<th>Fiscal code passenger</th>
				<th>Departure Date</th>
				<th>Airplane Id</th>
				<th>Price</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listBookPayed}" var="bookP">
				<tr>
					<td>${bookP.bookId}</td>
					<td>${bookP.flightId}</td>
					<td>${bookP.documentP}</td>
					<td>${bookP.departureDate}</td>
					<td>${bookP.airplaneId}</td>
					<td>${bookP.totalPrice}</td>
					<td><form method="Post" name="flightItems" action="./changeForm.jsp">
						 <c:set var="IDp" value="${bookP.bookId}" scope="session" />
							<input type="submit" class="ui blue button" value="Edit" /> 
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>

</body>
</html>
