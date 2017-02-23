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
		<a class="item">FlySMM</a> <a class="item"> About Us </a> <a
			class="item"> Jobs </a> <a class="item"> Locations </a>
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
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
    <tr><th></th>
    <th></th>
    <th></th>
    <th></th>
    <th>Total Price</th>
    <th>${totalPriceHomeCustomer}</th>
  </tr></tfoot>
	</table>

	<input class="ui red submit button" type="submit" value="Pay">
	<input type="hidden" name="command" value="nnnnnnnnnnn" />
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
					<td><form method="post" name="flightItems" action="./#">
							<input type="submit" class="ui blue button" value="Edit" /> <input
								type="hidden" name="chosen" value="${bookP.bookId}" /> <input
								type="hidden" name="command" value="nnnnnnnnnnn" />
						</form></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>

</body>
</html>
