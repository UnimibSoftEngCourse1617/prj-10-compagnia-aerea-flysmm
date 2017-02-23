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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<div class="ui stackable inverted menu">
		<a class="item">FlySMM</a> <a class="item"> About Us </a> <a
			class="item"> Jobs </a> <a class="item"> Locations </a> <a
			href="./logoutServlet " class="right item"> Log out </a>
	</div>


	<div class="ui middle aligned divided list">
		<div class="item">
			<div class="right floated content">
				<div class="ui button">Use</div>
			</div>
			<div class="content">Lena</div>
		</div>
		
		
		
		<div class="item">
			<div class="right floated content">
				<div class="ui button">Add</div>
			</div>
			<img class="ui avatar image" src="/images/avatar2/small/lindsay.png">
			<div class="content">Lindsay</div>
		</div>
		<div class="item">
			<div class="right floated content">
				<div class="ui button">Add</div>
			</div>
			<img class="ui avatar image" src="/images/avatar2/small/mark.png">
			<div class="content">Mark</div>
		</div>
		<div class="item">
			<div class="right floated content">
				<div class="ui button">Add</div>
			</div>
			<img class="ui avatar image" src="/images/avatar2/small/molly.png">
			<div class="content">Molly</div>
		</div>
	</div>






	<table class="ui celled table">
		<thead>
			<tr>
				<th>idAddress</th>
				<th>street</th>
				<th>street_number</th>
				<th>cap</th>
				<th>city</th>
				<th>country</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${address}" var="address">
				<tr>
					<td>${address.idAddress}</td>
					<td>${address.street}</td>
					<td>${address.street_number}</td>
					<td>${address.cap}</td>
					<td>${address.city}</td>
					<td>${address.country}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>
	
	
	<table class="ui celled table">
		<thead>
			<tr>
				<th>cardNumber</th>
				<th>customer</th>
				<th>cvv</th>
				<th>owner</th>
				<th>expiredDate</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${payment}" var="payment">
				<tr>
					<td>${payment.cardNumber}</td>
					<td>${payment.customer}</td>
					<td>${payment.cvv}</td>
					<td>${payment.owner}</td>
					<td>${payment.expiredDate}</td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot></tfoot>
	</table>
	
	<form action="/addNewPaymentMethod.jsp" name="addPaymentMethod">
		<input type="hidden" name="command" value="NewPayment">
		<input type="submit" name="bntNewPayment" value="Aggiungi">
	</form>
	
	
</body>
</html>