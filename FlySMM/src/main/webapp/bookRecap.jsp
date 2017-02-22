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
		<a class="item">FlySMM</a> <a class="item"> About Us </a> <a
			class="item"> Jobs </a> <a class="item"> Locations </a>
	</div>
	<table class="ui celled table">
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Flight Id</th>
				<th>Fiscal code passenger</th>
				<th>Departure Date</th>
				<th>Airplane Id</th>
				<th>Total price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listBook}" var="book">
				<tr>
					<td>${book.bookId}</td>
					<td>${book.flightId}</td>
					<td>${book.documentP}</td>
					<td>${book.departureDate}</td>
					<td>${book.airplaneId}</td>
					<td>${book.totalPrice}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>
	<form class="ui form" name="fSearchFly" method="post"
		action="./BookServlet">
		<input class="ui blue submit button" type="submit" value="Book!">
		<input type="hidden" name="command" value="Book" />
	</form>
	
</body>
</html>
