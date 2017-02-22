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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"
	integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="
	crossorigin="anonymous"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/css/semantic.css"
	rel="stylesheet" />
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.19.3/javascript/semantic.js"></script>

<title>FlySMM</title>
</head>
<body>
	<div class="ui stackable inverted menu">
		<div class="item">FltSMM</div>
		<a class="item"> About Us </a> <a class="item"> Jobs </a> <a
			class="item"> Locations </a> <a class="right item"> Sign up </a>
	</div>
	<table class="ui celled table">
		<thead>
			<tr>
				<th>Flight Code</th>
				<th>From</th>
				<th>Departure Date</th>
				<th>Departure Time</th>
				<th>To</th>
				<th>Arrival Date</th>
				<th>Arrival Time</th>
				<th>Tariff</th>
				<th>Price</th>
				<th>Fidelity Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${flights}" var="flight">

				<tr>
					<td>${flight.idFlight}</td>
					<td>${flight.departureAirport.name}</td>
					<td>${flight.departureDate}</td>
					<td>${flight.departureTime}</td>
					<td>${flight.arrivalAirport.name}</td>
					<td>${flight.arrivalDate}</td>
					<td>${flight.arrivalTime}</td>
					<td>${flight.price.seats.tariff}</td>
					<td>${flight.price.amount}<br></td>
					<td>${flight.price.discountedAmount}</td>
					<td><form method="post" name="flightItems" action="./Gateway">
							<input type="submit" class="ui green button"
								value="Acquista" /> <input type="hidden"
								name="chosen"
								value="${flight.idFlight}-${flight.price.seats.tariff}" /> <input
								type="hidden" name="command" value="Sale" />
						</form></td>
				</tr>

			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>
</body>
</html>