<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<th>Departure Date</th>
				<th>Departure Time</th>
				<th>Arrival Date</th>
				<th>Arrival Time</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${flights}" var="flight">
				<tr>
					<td>${flight.idFlight}</td>
					<td>${flight.departureDate}</td>
					<td>${flight.departureTime}</td>
					<td>${flight.arrivalDate}</td>
					<td>${flight.arrivalTime}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>
</body>
</html>