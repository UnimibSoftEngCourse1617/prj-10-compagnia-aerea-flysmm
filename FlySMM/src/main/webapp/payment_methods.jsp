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
<font face="Arial" />
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

		<a href="index.jsp" class="item">FlySMM</a> <a class="item"> About
			Us </a> <a class="item"> Jobs </a> <a class="item"> Locations </a>
		
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
	<form action="./MakePayment" method="post">
		<table class="ui celled table">
			<thead>
				<tr>
					<th>cardNumber</th>
					<th>Nome</th>
					<th>Cognome</th>
					<th>cvv</th>
					<th>owner</th>
					<th>expiredDate</th>
					<th>Usa</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${payment}" var="payment">
					<tr>
						<td>${payment.cardNumber}</td>
						<td>${payment.customer.name}</td>
						<td>${payment.customer.surname}</td>
						<td>${payment.cvv}</td>
						<td>${payment.owner}</td>
						<td>${payment.expiredDate}</td>
						<td><input type="submit" value="Usa" name="invio"> <input
							type="hidden" value="${payment.cardNumber}"></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot></tfoot>
			<input type="hidden" name="command" value="Payment">
		</table>
	</form>

	<form action="./addNewPaymentMethod.jsp" method="post">
		<!-- <input type="hidden" name="command" value="NewPayment">  -->
		<input type="submit" class="ui primary button" name="bntNewPayment" value="Aggiungi Metodo">
	</form>
</body>
</html>